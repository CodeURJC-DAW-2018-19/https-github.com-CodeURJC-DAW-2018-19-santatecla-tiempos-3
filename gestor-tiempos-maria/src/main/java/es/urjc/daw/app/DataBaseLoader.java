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
    	//USER
        User user1 =  new User("administrador", "administrador@gmail.com", "1234" , "ROLE_ADMIN");
        User user2 =  new User("Silvia", "silvia@gmail.com", "1234" , "ROLE_STUDENT");
        User user3 =  new User("Miguel", "miguel@gmail.com", "1234" , "ROLE_STUDENT");
        User user4 =  new User("Noelia", "noelia@gmail.com", "1234" , "ROLE_STUDENT");
        if(userRepository.findByEmail("administrador@gmail.com")==null)
        	user1=userRepository.save(user1);
        user1=userRepository.findByEmail("administrador@gmail.com");
        if(userRepository.findByEmail("silvia@gmail.com")==null)
	        user2=userRepository.save(user2);
        user2=userRepository.findByEmail("silvia@gmail.com");
        if(userRepository.findByEmail("miguel@gmail.com")==null)
	        user3=userRepository.save(user3);
        user3=userRepository.findByEmail("miguel@gmail.com");
        if(userRepository.findByEmail("noelia@gmail.com")==null)
	        user4=userRepository.save(user4);
        user4=userRepository.findByEmail("noelia@gmail.com");    
   
        
        
    }
}