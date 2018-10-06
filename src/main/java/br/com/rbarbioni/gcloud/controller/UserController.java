package br.com.rbarbioni.gcloud.controller;

import br.com.rbarbioni.gcloud.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;

/**
 * Created by renan on 27/05/17.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    private final static Logger logger = Logger.LoggerFactory(UserController.class); 

    private List<User> users = new ArrayList<>();

    public UserController(){
        for (int i = 0; i < 10; i++) {
            users.add(new User("user" + i, "user" + i + "@email.com"));
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAll (){
        logger.info("Getting {} Users", users.size());
        return this.users;
    }

}
