package ru.itpark.probro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itpark.probro.forms.NamesForm;
import ru.itpark.probro.forms.UpdateForm;
import ru.itpark.probro.models.FileInfo;
import ru.itpark.probro.models.Schedules;
import ru.itpark.probro.models.User;
import ru.itpark.probro.models.enums.Role;
import ru.itpark.probro.repositories.FilesInfoRepository;
import ru.itpark.probro.repositories.ScheduleRepository;
import ru.itpark.probro.repositories.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UsersServiceImpl implements UsersService {


    @Autowired
    private UserRepository usersRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private FilesInfoRepository filesInfoRepository;

    @PersistenceContext
    private EntityManager entityManager;




    @Override
    public List<User> getAll() {
        List<User> users = usersRepository.findAll();
        return users;
    }

    @Override
    public List<User> getUsersByRole(Role role, LocalDate date) {
        List<User> users = usersRepository.findAllByRole(role);
//        for (User user:users){
//            List <Schedules> schedulesTemp = user.getSchedules()
//                    .stream()
//                    .filter(schedules -> date.equals(schedules.getDateTime().toLocalDate()))
//                    .sorted((o1, o2) -> o1.getDateTime().toLocalTime().compareTo(o2.getDateTime().toLocalTime()))
//                    .collect(Collectors.toList());
//            user.setSchedules(schedulesTemp);
//        }
        Query query = entityManager.createNativeQuery( "SELECT * FROM schedules s WHERE\n" +
                        "  cast(date_time as date) = ? ORDER BY (s.master_id, date_time);",
                Schedules.class);
        Date date2 = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
        query.setParameter(1, date2, TemporalType.DATE);
        List<User> userList = query.getResultList();
        List<Schedules> schedules = query.getResultList();

        for (User user:users){
            List<Schedules> tempSchedules = schedules
                    .stream()
                    .filter(schedules2->user.getId().equals(schedules2.getMaster().getId()))
                    .sorted((o1, o2) -> o1.getDateTime().toLocalTime().compareTo(o2.getDateTime().toLocalTime()))
                    .collect(Collectors.toList());
            user.setSchedules(tempSchedules);
        }
        return users;
    }




    @Override
    public User getUser(Long userId) {
        return usersRepository.findOne(userId);
    }

    @Override
    public User update(Long userId, UpdateForm form) {
        User user = usersRepository.findOne(userId);
        form.update(user);//обновление основных полей
        FileInfo fileInfo = filesInfoRepository.findOneByUserId(user.getId());
        user.setAvatarUrl(fileInfo.getWeburl());
        usersRepository.save(user);
        return  user;
    }


}
