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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        user.setUsername("Kaguya");
        user.setPassword("123456");
        user.setNickname("Kaguya");
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
        weibo.setUserId(1010L);
        // 2.调用方法测试
        weiboMapper.insertWeibo(weibo);
    }

    @Test
    void deleteWeibo(){
        Long id = 1010L;
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
        System.out.println(weiboMapper.selectWeiboTest(101L));
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

    @Test
    void upWeibo() {
        Weibo w = new Weibo();
        w.setId(203L);
        w.setContent("upTest");
        w.setCreated(new Date());
        w.setUserId(10086L);
        int i = weiboMapper.dynamicUpdateWeibo(w);
        if (i != 0) {
            System.out.println("修改完毕");
        }
    }

    @Test
    void arrayDeleteWeibo() {
        Long[] a = {203L, 204L, 205L};
        weiboMapper.deleteByIds(a);
    }
    @Test
    void arrayDeleteWeibo1() {
        List<Long> longs = new ArrayList<>();
        longs.add(206L);
        longs.add(207L);
        weiboMapper.deleteByIds1(longs);
    }

    @Test
    void selectWeiboCount() {
        System.out.println(weiboMapper.selectWeiboVo1ById1(200L));
    }

    @Test
    void selectResultVoTest1() {
        System.out.println(weiboMapper.selectWeiboVo1ById1(200L));
    }

    @Test
    void testSelectWeiBoVo2ById1(){
        System.out.println(weiboMapper.selectWeiboVO2ById2(100L));
    }

    @Test
    void commentWeiboTest() {
        System.out.println(weiboMapper.selectWeiboComment(200L));
    }

    @Test
    void commentWeiboTestList() {
        System.out.println(weiboMapper.selectWeiboVO4BybId4(200L));
    }


}









