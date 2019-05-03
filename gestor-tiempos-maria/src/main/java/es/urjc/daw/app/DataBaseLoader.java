package es.urjc.daw.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.urjc.daw.app.user.User;
import es.urjc.daw.app.user.UserRepository;

import javax.annotation.PostConstruct;


@Component
public class DataBaseLoader {
	
    @Autowired private UserRepository userRepository;
   /* @Autowired private IntervalRepository intervalRepository;
    @Autowired private EventRepository eventRepository;*/


    @PostConstruct
    public void init(){
        //INICIALIZACIÓN USERS
        User[] users = {
            new User("administrador", "administrador@gmail.com", "1234" , "ROLE_ADMIN"),
            new User("Silvia", "silvia@gmail.com", "1234" , "ROLE_STUDENT"),
            new User("Miguel", "miguel@gmail.com", "1234" , "ROLE_STUDENT"),
            new User("Noelia", "noelia@gmail.com", "1234" , "ROLE_STUDENT")
        };
        for (int i=0; i<users.length;i++){
            if(userRepository.findByEmail(users[i].getEmail())==null) {
                userRepository.save(users[i]);
            }
        } 
    }
}