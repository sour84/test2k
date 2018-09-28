package my.test.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "user", schema = "taskmanager", catalog = "taskmanager")

public class UserEntity {


    private Integer userID;
    private String userFIO;


    @Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }
    @Basic
    @Column(name = "FIO", nullable = true, length = 60)
    public String getUserFIO() {
        return userFIO;
    }

    public void setUserFIO(String userFIO) {
        this.userFIO = userFIO;
    }



    private List<TaskEntity> taskEntities;

    @OneToMany(targetEntity=TaskEntity.class, mappedBy="userEntity", fetch=FetchType.EAGER)
    public List<TaskEntity> getTaskEntities() {
        return taskEntities;
    }

    public void setTaskEntities(List<TaskEntity> taskEntities) {
        this.taskEntities = taskEntities;
    }
    //
//
//    private Set<TaskEntity> taskEntities = new HashSet<TaskEntity>();
//
//    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
//    public Set<TaskEntity> getContactTelDetails() {
//        return this.taskEntities;
//    }
//
//    public void setContactTelDetails(Set<ContactTelDetailEntity> contactTelDetails) {
//        this.contactTelDetails = contactTelDetails;
//    }
//
//
//
//
//
//
//    @OneToMany(cascade=CascadeType.ALL,mappedBy="userEntity")
//    private Set<TaskEntity> taskEntities;


}
