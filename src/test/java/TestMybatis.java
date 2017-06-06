import com.chen.mapper.ArticleinfoMapper;
import com.chen.pojo.Articleinfo;
import com.chen.pojo.ArticleinfoQueryVo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ryder on 2017/5/22.
 */
public class TestMybatis {
    private ApplicationContext applicationContext;

    @Before
    public void init(){
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

//    @Test
//    public void testGetInfoById() throws Exception{
//        ArticleinfoMapper articleinfoMapper = (ArticleinfoMapper)applicationContext.getBean("articleinfoMapper");
//        Articleinfo articleinfo = articleinfoMapper.findArticleinfoById(1);
//        System.out.println(articleinfo);
//    }

    @Test
    public void testGetInfosByQueryVo() throws Exception{
        ArticleinfoMapper articleinfoMapper = (ArticleinfoMapper)applicationContext.getBean("articleinfoMapper");
        ArticleinfoQueryVo articleinfoQueryVo = new ArticleinfoQueryVo();

//        //指定单一值
//        articleinfoQueryVo.setArticle_author("nuanyangyang");
//
        //与的关系，字符串匹配
        List<String> titles = new LinkedList<String>();
        titles.add("Java");
        titles.add("特性");
        articleinfoQueryVo.setArticle_titles(titles);
//
//        //或的关系，字符串值相等比较
//        List<String> section = new LinkedList<String>();
//        section.add("/board/Test");
//        section.add("/board/Security");
//        section.add("/board/Java");
//        articleinfoQueryVo.setSection_names(section);

        articleinfoQueryVo.setArticle_createtime_type(3);

        List<Articleinfo> articleinfos = articleinfoMapper.findArticleinfosByArticleinfoQueryVo(articleinfoQueryVo);
        for(Articleinfo articleinfo:articleinfos)
            System.out.println(articleinfo);
    }

//    @Test
//    public void testGetAll() throws Exception {
//        ArticleinfoMapper articleinfoMapper = (ArticleinfoMapper) applicationContext.getBean("articleinfoMapper");
//        List<Articleinfo> articleinfos = articleinfoMapper.getAll();
//        for (Articleinfo articleinfo:articleinfos)
//            System.out.println(articleinfo);
//    }
}
