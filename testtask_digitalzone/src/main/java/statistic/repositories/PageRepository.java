package statistic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import statistic.model.Page;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public interface PageRepository extends JpaRepository <Page, Long>{
    Page findOne(Long id);
    List<Page> findAll();
    List<Page> findAllByPageId(Long id);
    List<Page> findAllByTimeVisitBetween(LocalDateTime from,LocalDateTime to);
    List<Page> findAllByUserId(Long id);
}
