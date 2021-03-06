package ru.itpark.probro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itpark.probro.forms.ScheduleForm;
import ru.itpark.probro.models.Schedules;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ScheduleRepository extends JpaRepository <Schedules, Long> {
    List<Schedules> findAll();



}
