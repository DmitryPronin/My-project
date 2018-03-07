package statistic.service;

import statistic.model.Page;

import java.util.List;

public interface PageService{
    Page getPage(String id);
    List<Page> getAll();

    Page addPage(Long pageId, Long userId);

    int findAllToday(Long page_id);
    int findUniqToday(Long oage_id);

    int findAllInInterval(String from, String to);

    int findUniqInterval(String from, String to);

    int findConstant(String from, String to);
}
