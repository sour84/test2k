package my.test.orm;

import my.test.entity.TaskEntity;
import my.test.entity.UserEntity;
import my.test.intf.AllService;

import my.test.repository.TaskRepository;
import my.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional (value = "seaTxManager")
public class TaskServiceImpl implements AllService {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public List<TaskEntity> findByTaskName(String taskName) {
        return taskRepository.findByTaskName(taskName);
    }

    public List<TaskEntity> findAllTask() {
        return taskRepository.findAll();
    }

    public TaskEntity saveTask(TaskEntity taskEntity) {
        return taskRepository.save(taskEntity);
    }

    @Override
    public TaskEntity deleteTask(Integer id) {
        TaskEntity taskEntity = taskRepository.findById(id).get();
        taskRepository.delete(taskEntity);
        return taskEntity;
    }

    @Override
    public TaskEntity findTaskById(Integer id) {

        return taskRepository.findById(id).get();

    }

    public List<UserEntity> findAllUser() {
        return userRepository.findAll();
    }
    @Override
    public UserEntity findUserById(Integer id) {

        return userRepository.findById(id).get();

    }
//    private Sort sortByIdAsc() {
//        return new Sort(Sort.Direction.ASC, "firstName");
//    }
}

