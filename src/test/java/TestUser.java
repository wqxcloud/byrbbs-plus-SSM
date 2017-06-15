import com.chen.mapper.T_userMapper;
import com.chen.pojo.T_user;
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
        T_userMapper t_userMapper = (T_userMapper) applicationContext.getBean("t_userMapper");
        T_user t_user = t_userMapper.findUserByUsername("chen");
        System.out.println(t_user);
        System.out.println(t_userMapper.findRoles("bbb"));
        System.out.println(t_userMapper.findPermissions("chen"));
    }
}
