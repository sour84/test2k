package my.test.orm;

//import org.osgi.service.useradmin.User;

import my.test.entity.TaskEntity;
import my.test.entity.UserEntity;
import my.test.intf.AllService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.web.servlet.ModelAndView;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


/**
 * Created for JavaStudy.ru on 28.02.2016.
 */
@ManagedBean
@ViewScoped
@Controller
public class TaskController {
    @Autowired
    private AllService allService;


    @RequestMapping(value = "/queryFindAllUsersJPA",method = RequestMethod.GET)
    public ModelAndView queryFindAllUsersJPA() {
        List<TaskEntity> taskEntities = allService.findAllTask();
        return new ModelAndView("/orm/person", "resultTask", taskEntities);

    }
    @RequestMapping(value = "/newContact", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        //TaskEntity taskEntity = new TaskEntity();
        model.addObject("taskEntity", new TaskEntity());
        List<UserEntity> userEntities = allService.findAllUser();
       // model.addObject("contactEntity", taskEntity);
        model.addObject("users", userEntities);
        model.setViewName("/orm/new-employee");
        return model;
    }

    @RequestMapping(value = "/saveContact",method = RequestMethod.GET)
    public ModelAndView saveEmployee(@ModelAttribute TaskEntity taskEntity, HttpServletRequest request) {
        int userID = Integer.parseInt(request.getParameter("userEntity.userID"));
        UserEntity userEntity = allService.findUserById(userID);
        taskEntity.setUserEntity(userEntity);
        allService.saveTask(taskEntity);
        return queryFindAllUsersJPA();
    }

    @RequestMapping(value = "/deleteContact", method=RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) {
        int contactId = Integer.parseInt(request.getParameter("id"));
        allService.deleteTask(contactId);
        return queryFindAllUsersJPA();
    }

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public ModelAndView editArticle(@RequestParam("id") int taskID, ModelAndView model) {

            TaskEntity taskEntity = allService.findTaskById(taskID);
            model.addObject("taskEntity", taskEntity);
        List<UserEntity> userEntities = allService.findAllUser();
        model.addObject("users", userEntities);
        model.setViewName("/orm/new-employee");
        return model;
    }

    public ModelAndView FindAllUsers() {
        List<UserEntity> userEntities = allService.findAllUser();
        return new ModelAndView("/orm/new-employee", "resultUser", userEntities);
    }

}