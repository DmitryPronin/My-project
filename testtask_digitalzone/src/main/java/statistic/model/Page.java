package statistic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "page")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Page {


    @Column(name = "page_id")
    private Long pageId;

    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "time_visit")
    private LocalDateTime timeVisit;

}
