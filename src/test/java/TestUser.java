import com.chen.mapper.UserMapper;
import com.chen.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ryder on 2017/6/14.
 *
 */
public class TestUser {
    private ApplicationContext applicationContext;

    @Before
    public void init(){
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testGetInfoById() throws Exception{
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        User user = userMapper.findUserByUsername("chen");
        System.out.println(user);
        System.out.println(userMapper.findRoles("bbb"));
        System.out.println(userMapper.findPermissions("chen"));
    }
}
