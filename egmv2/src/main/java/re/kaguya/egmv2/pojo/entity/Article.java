package re.kaguya.egmv2.pojo.entity;

import lombok.Data;

@Data
public class Article {
    private Long id;
    private String title;
    private String content;
    private Long userId;
}
