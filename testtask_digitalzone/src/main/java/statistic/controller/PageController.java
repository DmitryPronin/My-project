package statistic.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import statistic.model.Page;
import statistic.service.PageService;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;


@RestController
public class PageController {

    @Autowired
    private PageService pageService;


    @RequestMapping(value = "/period_visit", method = RequestMethod.GET )
    @ResponseBody
    public Map<String,Integer> getPages(@RequestParam("from") String from,
                                        @RequestParam("to") String to){
        int allVisitors= pageService.findAllInInterval(from,to);
        int uniqVisitors=pageService.findUniqInterval(from,to);
        int countConstant = pageService.findConstant(from,to);
        Map<String,Integer> result = new HashMap<String,Integer>();
        result.put("allVisitors", allVisitors);
        result.put("uniqVisitors", uniqVisitors);
        result.put("countConstant", countConstant);
        return result ;
    }

    @RequestMapping(value = "/visit", method = RequestMethod.POST )
    @ResponseBody
    public Map<String,Integer> getPage(@RequestParam("page_id") Long pageId,
                          @RequestParam("user_id") Long userId){
        Page page = pageService.addPage(pageId,userId);
        int countAllToday = pageService.findAllToday(pageId);
        int countUniqToday =pageService.findUniqToday(pageId);

        Map<String,Integer> result = new HashMap<String,Integer>();
        result.put("countAllToday", countAllToday);
        result.put("countUniqToday", countUniqToday);
        return result;
    }
}
