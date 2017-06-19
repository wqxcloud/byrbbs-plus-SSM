/**
 * Created by ryder on 2017/6/15.
 */

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//只有文本的邮件
public class TestJavaxMail {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();

        props.setProperty("mail.transport.protocol", "smtp");//规范规定的参数
        props.setProperty("mail.host", "smtp.126.com");//这里使用万网的邮箱主机
        props.setProperty("mail.smtp.auth", "true");//请求认证，不认证有可能发不出去邮件。
        props.setProperty("mail.debug","true"); //开启debug调试

        Session session = Session.getInstance(props);
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress("chenxiaoyu12345@126.com"));
        message.setRecipients(Message.RecipientType.TO, "593191130@qq.com");
        message.setSubject("邮件测试");
        message.setSentDate(new Date());
        message.setContent("<h1>测试正文</h1><h2>测试正文</h2>", "text/html;charset=UTF-8");
        message.saveChanges();

        Transport tp = session.getTransport("smtp");

        //邮箱账号密码
        tp.connect("chenxiaoyu12345", "1qazxcvfr432");
        tp.sendMessage(message, message.getAllRecipients());
        tp.close();
    }
}
