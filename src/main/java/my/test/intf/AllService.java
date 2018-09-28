package my.test.intf;

import my.test.entity.TaskEntity;
import my.test.entity.UserEntity;

import java.util.List;

public interface AllService {


    List<TaskEntity> findByTaskName(String taskName);
    //  List<TaskEntity> findAll(String taskName);
    TaskEntity saveTask(TaskEntity taskEntity);
    TaskEntity deleteTask(Integer id);
    TaskEntity findTaskById(Integer id);
UserEntity findUserById(Integer id);
List <UserEntity> findAllUser();
    List<TaskEntity> findAllTask();
}
