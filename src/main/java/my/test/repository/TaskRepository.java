package my.test.repository;

import my.test.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

    List<TaskEntity> findByTaskName(String taskName);

}
