package re.kaguya.spring.dibase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Value("dawa")
    private String name;
    @Autowired
    private UserDao userDao;


    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                ", userDao=" + userDao +
                '}';
    }

    @Autowired
    public UserService() {
    }

    @Autowired
    public String getName() {
        return name;
    }
}
