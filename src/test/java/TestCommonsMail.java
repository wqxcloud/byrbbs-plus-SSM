import com.chen.email.ArticleInfoEmail;
import com.chen.pojo.Articleinfo;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.URL;
import java.util.Date;

/**
 * Created by ryder on 2017/6/16.
 *
 */
public class TestCommonsMail {
    public void test_self() throws Exception{
        HtmlEmail email = new HtmlEmail();
        email.setHostName("smtp.126.com");
        email.setSmtpPort(25);
        email.setAuthenticator(new DefaultAuthenticator("chenxiaoyu12345","1qazxcvfr432"));
        email.setSSLOnConnect(true);
        email.setFrom("chenxiaoyu12345@126.com", "我的126邮箱");
        email.setCharset("UTF-8");
        // set the alternative message
        email.setTextMsg("Your email client does not support HTML messages");



        email.addTo("593191130@qq.com", "我的QQ邮箱");
        email.setSubject("Test email with inline image");
        // set the html message
        String a = "【字符串】";
        email.setHtmlMsg("<html>\n" +
                "<body>\n" +
                "\n" +
                "<table border=\"1\" style=\"border-collapse: collapse\">\n" +
                "  <tr>\n" +
                "    <th>Month月份</th>\n" +
                "    <th>Savings</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>January</td>\n" +
                "    <td>$100</td>\n" +
                "  </tr>\n" +
                "<tr>\n" +
                "    <td>January</td>\n" +
                "    <td>$100</td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "\n" +
                "</body>\n" +
                "</html>"+a+"</html>");
        // send the email
        email.send();
    }
    @Test
    public void test_getBean() throws Exception{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        HtmlEmail htmlEmail = applicationContext.getBean(HtmlEmail.class);
        htmlEmail.addTo("593191130@qq.com", "我的QQ邮箱");
        htmlEmail.setSubject("Test email with inline image");
        // set the html message
        String a = "【字符串】";
        htmlEmail.setHtmlMsg("<html>\n" +
                "<body>\n" +
                "\n" +
                "<table border=\"1\" style=\"border-collapse: collapse\">\n" +
                "  <tr>\n" +
                "    <th>Month月份</th>\n" +
                "    <th>Savings</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>January</td>\n" +
                "    <td>$100</td>\n" +
                "  </tr>\n" +
                "<tr>\n" +
                "    <td>January</td>\n" +
                "    <td>$100</td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "\n" +
                "</body>\n" +
                "</html>"+a+"</html>");
        htmlEmail.send();
    }

    @Test
    public void test_emal_module() throws Exception{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ArticleInfoEmail email1 = applicationContext.getBean(ArticleInfoEmail.class);
        ArticleInfoEmail email2 = applicationContext.getBean(ArticleInfoEmail.class);
        if(email1==email2)
            System.out.println("相同");
        else
            System.out.println("不同");

        HtmlEmail email3 = applicationContext.getBean(HtmlEmail.class);
        HtmlEmail email4 = applicationContext.getBean(HtmlEmail.class);
        if(email3==email4)
            System.out.println("相同");
        else
            System.out.println("不同");
    }

    @Test
    public void test_emal_object() throws Exception {
        Articleinfo articleinfo = new Articleinfo(1,"section","title","titleurl",new Date(),100,"author");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ArticleInfoEmail email = applicationContext.getBean(ArticleInfoEmail.class);
        email.init("593191130@qq.com");
        email.add(articleinfo);
        email.send();
    }
}

