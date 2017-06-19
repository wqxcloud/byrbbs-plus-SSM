import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

import java.net.URL;

/**
 * Created by ryder on 2017/6/16.
 *
 */
public class TestCommonsMail {
    public static void main(String[] args) throws Exception{
        HtmlEmail email = new HtmlEmail();
        email.setHostName("smtp.126.com");
        email.setSmtpPort(25);
        email.setAuthenticator(new DefaultAuthenticator("chenxiaoyu12345","1qazxcvfr432"));
        email.setSSLOnConnect(true);
        email.addTo("593191130@qq.com", "我的QQ邮箱");
        email.setFrom("chenxiaoyu12345@126.com", "我的126邮箱");
        email.setSubject("Test email with inline image");
        email.setCharset("UTF-8");
        // set the html message
        String a = "【字符串】";
        email.setHtmlMsg("<html>\n" +
                "<body>\n" +
                "\n" +
                "<table border=\"1\">\n" +
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

        // set the alternative message
        email.setTextMsg("Your email client does not support HTML messages");

        // send the email
        email.send();
    }
}

