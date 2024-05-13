package re.kaguya.spring.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class UserCache {
    @Qualifier(value = "AAAA")
    @Autowired
    private Cache cache;

}
