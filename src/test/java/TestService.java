import com.chen.pojo.Articleinfo;
import com.chen.service.ArticleinfoService;
import com.chen.util.PagedResult;
import org.junit.Before;
import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by ryder on 2017/5/24.
 */

public class TestService {
    private ApplicationContext applicationContext;
    @Before
    public void init(){
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testPages(){
        ArticleinfoService articleinfoService = (ArticleinfoService)applicationContext.getBean("articleinfoService");
        if(articleinfoService!=null) {
//            List<Articleinfo>  articleinfos = articleinfoService.getAll();
            PagedResult<Articleinfo> pagedResult = articleinfoService.queryByPage("ousness", 2, 10);//null表示查全部
            System.out.println(pagedResult.getPageSize());
            for(Articleinfo a:pagedResult.getDataList())
                System.out.println(a);
        }
        else{
            System.out.println("articleinfoService is null");
        }

    }
}
