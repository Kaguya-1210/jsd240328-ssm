package re.kaguya.spring.eg2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class CommentMapper {
    @Qualifier(value = "m1")
    @Autowired
    private MapperImpl1 mapper;

    @Override
    public String toString() {
        return "CommentMapper{" +
                "mapper=" + mapper +
                '}';
    }
}
