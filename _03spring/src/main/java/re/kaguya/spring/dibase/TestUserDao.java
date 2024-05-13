package re.kaguya.spring.dibase;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestUserDao {

    @Value("jdbc:mysql://localhost:3306")
    private String url;
    @Value("root")
    private String username;
    @Value(" ")
    private String password;


    @Override
    public String toString() {
        return "TestUserDao{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
