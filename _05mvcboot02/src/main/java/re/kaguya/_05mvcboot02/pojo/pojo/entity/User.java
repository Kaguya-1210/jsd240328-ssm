package re.kaguya._05mvcboot02.pojo.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private Date created;
}
