package re.kaguya._05mvcboot02.pojo.pojo.dto;

import lombok.Data;

@Data
public class UserInsertDTO {
    private String username;
    private String password;
    private String nickname;
}
