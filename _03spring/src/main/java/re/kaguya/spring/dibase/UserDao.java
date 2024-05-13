package re.kaguya.spring.dibase;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Value("jdbc:mysql://localhost:3306/tedu")
    private String url;
    @Value("root")
    private String username;
    private String password;

    @Value(" ")
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDao{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
