import com.chen.email.ArticleInfoEmail;
import com.chen.pojo.Articleinfo;
import com.chen.pojo.ArticleinfoQueryVo;
import com.chen.service.ArticleinfoService;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.bcel.internal.generic.NEW;
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
    public void testPages() throws Exception{
        ArticleinfoService articleinfoService = (ArticleinfoService)applicationContext.getBean("articleinfoService");
        if(articleinfoService!=null) {
            ArticleinfoQueryVo articleinfoQueryVo = new ArticleinfoQueryVo();
            ArticleInfoEmail email = applicationContext.getBean(ArticleInfoEmail.class);
            email.init("593191130@qq.com");

            System.out.println("page1");
            PageInfo<Articleinfo> pagedResult1 = articleinfoService.queryByPage(articleinfoQueryVo, 1, 15);//null表示查全部
            for(Articleinfo a:pagedResult1.getList()){
                System.out.println(a);
                email.add(a);
            }
            email.send();

//            System.out.println("page2");
//            PageInfo<Articleinfo> pagedResult2 = articleinfoService.queryByPage(articleinfoQueryVo, 2, 15);//null表示查全部
//            for(Articleinfo a:pagedResult2.getList())
//                System.out.println(a);
//            System.out.println("page3");
//            PageInfo<Articleinfo> pagedResult3 = articleinfoService.queryByPage(articleinfoQueryVo, 3, 15);//null表示查全部
//            for(Articleinfo a:pagedResult3.getList())
//                System.out.println(a);
//            System.out.println("page all");
//            PageInfo<Articleinfo> pagedResult = articleinfoService.queryByPage(articleinfoQueryVo, -1, 0);//null表示查全部
//            for(Articleinfo a:pagedResult.getList())
//                System.out.println(a);
        }
        else{
            System.out.println("articleinfoService is null");
        }

    }
}
