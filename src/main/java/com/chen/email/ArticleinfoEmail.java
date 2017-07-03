package com.chen.email;

import com.chen.pojo.Articleinfo;
import com.chen.pojo.SectionName;
import com.chen.service.SectionNameService;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * Created by ryder on 2017/7/1.
 *
 */

public class ArticleinfoEmail {
    @Resource
    private HtmlEmail htmlEmail;
    @Resource
    private SectionNameService sectionNameService;
    private Map<String,SectionName>  sectionUrlToName;
    private SimpleDateFormat dateFormater = new SimpleDateFormat("MM-dd HH:mm");
    private StringBuffer htmlMsg = new StringBuffer(
            "<html><body><table border=\"1\" style=\"border-collapse: collapse\">" +
                    "<tr><th noWrap>板块</th><th noWrap>标题</th><th noWrap>发帖人</th><th noWrap>发布时间</th><th noWrap>链接</th></tr>");

    public void init(String emailTo){
        try {
            htmlEmail.setFrom("chenxiaoyu12345@126.com", "byrbbs-plus");
            htmlEmail.setSubject("新帖推送");
            htmlEmail.addTo(emailTo);
            sectionUrlToName = sectionNameService.UrlToNameMap();
        }
        catch (Exception e){
            //todo:邮件失败的log
            e.printStackTrace();
        }

    }
    public void add(Articleinfo articleinfo){
        if(articleinfo==null)
            return;
        htmlMsg.append("<tr>");

        htmlMsg.append("<td noWrap>");
        htmlMsg.append(sectionUrlToName.get(articleinfo.getSection_url()).getSection_name());
        htmlMsg.append("</td>");

        htmlMsg.append("<td>");
        htmlMsg.append(articleinfo.getArticle_title());
        htmlMsg.append("</td>");

        htmlMsg.append("<td noWrap align=\"center\">");
        htmlMsg.append(articleinfo.getArticle_author());
        htmlMsg.append("</td>");

        htmlMsg.append("<td noWrap align=\"center\">");
        htmlMsg.append(dateFormater.format(articleinfo.getArticle_createtime()));
        htmlMsg.append("</td>");

        htmlMsg.append("<td noWrap align=\"center\"><a href=\"");
        htmlMsg.append(articleinfo.getArticle_url());
        htmlMsg.append("\">");
        htmlMsg.append("link");
        htmlMsg.append("</a></td>");

        htmlMsg.append("</tr>");
    }
    public void send(){
        htmlMsg.append("</table></body></html>");
        try {
            htmlEmail.setHtmlMsg(htmlMsg.toString());
            htmlEmail.send();
        }
        catch (Exception e){
            //todo:邮件失败的log
            e.printStackTrace();
        }

    }
}
