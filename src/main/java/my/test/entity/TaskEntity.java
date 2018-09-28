package my.test.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "task", schema = "taskmanager", catalog = "taskmanager")

public class TaskEntity {

    private Date taskDateCreate;
    private String taskName;
    private Integer taskID;
    private String taskDescription;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_CREATE", nullable = true, insertable = true, updatable = true)
    public Date getTaskDateCreate() {
        return taskDateCreate;
    }

    public void setTaskDateCreate(Date taskDateCreate) {
        this.taskDateCreate = taskDateCreate;
    }

    @Basic
    @Column(name = "NAME", nullable = true, length = 60)
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)


    public Integer getTaskID() {
        return taskID;
    }

    public void setTaskID(Integer taskID) {
        this.taskID = taskID;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = true, length = 60)
    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }


    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name ="USER_ID")

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
