package my.test.intf;

import my.test.entity.TaskEntity;

import java.util.List;

public interface UserService {


    List<TaskEntity> findByTaskName(String taskName);
  //  List<TaskEntity> findAll(String taskName);
    TaskEntity save(TaskEntity taskEntity);
   TaskEntity delete(Integer id);
    TaskEntity findById(Integer id);


    List<TaskEntity> findAll();
}
