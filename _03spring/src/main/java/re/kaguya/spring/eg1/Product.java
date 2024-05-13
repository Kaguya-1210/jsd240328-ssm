package re.kaguya.spring.eg1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Product {
    @Value("test")
    private String title;
    @Value("10")
    private int number;

    private String comment;

    @Value("12")
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", number=" + number +
                ", comment='" + comment + '\'' +
                '}';
    }
}
