package statistic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import statistic.model.Page;
import statistic.repositories.PageRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class PageServiceImpl implements PageService {

    @Autowired
    private PageRepository pageRepository;

    @Override
    public Page getPage(String id) {
        Page page = pageRepository.findOne(Long.parseLong(id));
        return page;
    }

    @Override
    public List<Page> getAll() {
        List<Page> pages = pageRepository.findAll();
        return pages;

    }

    @Override
    public Page addPage(Long pageId, Long userId) {
        Page page = Page.builder()
                .pageId(pageId)
                .userId(userId)
                .timeVisit(LocalDateTime.now())
                .build();
        pageRepository.save(page);
        return page;
    }

    @Override
    public int findAllToday(Long pageId) {
        List<Page> tempPages = pageRepository.findAllByPageId(pageId);
        List<Page> pages = tempPages.stream()
                //.filter(page -> page_id == page.getPageId())
                .filter(page -> LocalDateTime.now().toLocalDate().isEqual(page.getTimeVisit().toLocalDate()))
                .collect(Collectors.toList());
        return pages.size();
    }

    @Override
    public int findUniqToday(Long pageId) {
        List<Page> tempPages = pageRepository.findAllByPageId(pageId);
        List<Page> pages = tempPages.stream()
                //.filter(page -> pageId == page.getPageId())
                .filter(page -> LocalDateTime.now().toLocalDate().isEqual(page.getTimeVisit().toLocalDate()))
                .filter(distinctByKey(page -> page.getUserId()))
                .collect(Collectors.toList());
        return pages.size();

    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }


    @Override
    public int findAllInInterval(String from,String to) {
        LocalDateTime fromDate = LocalDate.parse(from).atStartOfDay();
        LocalDateTime toDate = LocalDate.parse(to).atTime(LocalTime.MAX);
        List<Page> temp = pageRepository.findAllByTimeVisitBetween(fromDate,toDate);
        return temp.size();
    }

    @Override
    public int findUniqInterval(String from, String to) {
        LocalDateTime fromDate = LocalDate.parse(from).atStartOfDay();
        LocalDateTime toDate = LocalDate.parse(to).atTime(LocalTime.MAX);
        List<Page> temp = pageRepository.findAllByTimeVisitBetween(fromDate,toDate);
        List<Page> pages = temp
                .stream()
                .filter(distinctByKey(page -> page.getUserId()))
                .collect(Collectors.toList());
        return pages.size();
    }

    @Override
    public int findConstant(String from, String to) {
        LocalDateTime fromDate = LocalDate.parse(from).atStartOfDay();
        LocalDateTime toDate = LocalDate.parse(to).atTime(LocalTime.MAX);
        List<Page> temp = pageRepository.findAllByTimeVisitBetween(fromDate,toDate);
        List<Page> userList = temp
                .stream()
                .filter(distinctByKey(page -> page.getUserId()))
                .collect(Collectors.toList());
        int countConstant=0;
        for (Page page: userList){
            List<Page> constantList = pageRepository.findAllByUserId(page.getUserId())
                    .stream()
                    .filter(distinctByKey(page1 -> page1.getPageId() ))
                    .collect(Collectors.toList());
            if (constantList.size()>=10){
                countConstant++;
            }

        }
        return countConstant;
    }


}
