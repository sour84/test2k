package my.test.repository;

import my.test.entity.TaskEntity;
import my.test.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    List<UserEntity> findByUserFIO(String userFIO);

}
