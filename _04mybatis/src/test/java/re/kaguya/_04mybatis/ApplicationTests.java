package re.kaguya._04mybatis;

import re.kaguya._04mybatis.mapper.CommentMapper;
import re.kaguya._04mybatis.mapper.UserMapper;
import re.kaguya._04mybatis.mapper.WeiboMapper;
import re.kaguya._04mybatis.pojo.entity.Comment;
import re.kaguya._04mybatis.pojo.entity.User;
import re.kaguya._04mybatis.pojo.entity.Weibo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class ApplicationTests {
    // 自动装配
    // userMapper:是UserMapper接口的实现类对象
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    /*
        测试方法：
          1.一定添加@Test注解;
          2.一定是无参无返回值;
     */
    @Test
    void insertUserTest(){
        // 1.准备测试数据
        User user = new User();
        user.setUsername("晶晶");
        user.setPassword("123456");
        user.setNickname("晶晶");
        user.setCreated(new Date());
        // 2.调用方法测试
        userMapper.insertUser(user);
    }

    @Autowired
    private WeiboMapper weiboMapper;

    @Test
    void insertWeiboTest(){
        // 1.准备测试数据
        Weibo weibo = new Weibo();
        weibo.setContent("今天天气真好");
        weibo.setCreated(new Date());
        weibo.setUserId(100L);
        // 2.调用方法测试
        weiboMapper.insertWeibo(weibo);
    }

    @Test
    void deleteWeibo(){
        Long id = 202L;
        weiboMapper.deleteWeibo(id);
    }

    @Test
    void updateWeibo() {
        Weibo w = new Weibo();
        w.setId(203L);
        w.setContent("Test");
        w.setCreated(new Date());
        w.setUserId(101L);
        weiboMapper.updateWeibo(w);
    }

    @Test
    void selectWeibo(){
        Long id = 203L;
        System.out.println(weiboMapper.selectWeibo(id));
    }


    @Test
    void selectAllWeibo() {
        System.out.println(weiboMapper.selectAllWeibo());
    }

    @Test
    void setWeiboTest() {
        System.out.println(weiboMapper.selectWeiboTest(203L));
    }

    @Autowired
    private CommentMapper commentsMapper;

    @Test
    void CommentInsertTest() {
        Comment comment = new Comment();
        comment.setContent("Test");
        comment.setCreated(new Date());
        comment.setUserId(1001L);
        comment.setWeiboId(101L);
        commentsMapper.insert(comment);
    }

    @Test
    void deleteTest() {
        commentsMapper.deleteById(1001L);
    }
    @Test
    void updateTest() {
        Comment comment = new Comment();
        comment.setContent("upTe3242st");
        comment.setUserId(1001L);
        commentsMapper.updateContact(comment);

    }
    @Test
    void selectTest() {
        System.out.println(commentsMapper.selectContent(306L));
    }


    @Test
       void selectTest1() {
        System.out.println(commentsMapper.selectContent1(101L));
    }
}









