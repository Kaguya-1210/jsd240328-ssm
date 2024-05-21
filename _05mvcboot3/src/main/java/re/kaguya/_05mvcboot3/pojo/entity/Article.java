package re.kaguya._05mvcboot3.pojo.entity;

import lombok.Data;

@Data
public class Article {
    private Long id;
    private String title;
    private String content;
    private Long userId;
}
