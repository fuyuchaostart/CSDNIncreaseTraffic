package csdnandcnblogs;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 功能描述:
 *
 * @author fuyuchao
 * DATE 2018/8/29.
 */
public class JsoupGetArticleUrl {
    public JsoupGetArticleUrl() {
    }

    public static List<String> getCsdnBlogsUrl() {
        ArrayList urls = new ArrayList();

        try {
            Document doc = getDoc("https://blog.csdn.net/fycstart");
            Element body = doc.body();
            Pattern compile = Pattern.compile("/fycstart/article/details/\\d{8}$");
            Elements es = body.select("a");
            HashSet<String> set = new HashSet();
            Iterator it = es.iterator();

            while (it.hasNext()) {
                Element e = (Element) it.next();
                if (compile.matcher(e.attr("href")).find()) {
                    set.add(e.attr("href"));
                }
            }

            urls.addAll(set);
        } catch (IOException var8) {
            var8.printStackTrace();
        }

        return urls;
    }

    public static Document getDoc(String url) throws IOException {
        System.out.println(Jsoup.connect("https://blog.csdn.net/fycstart").header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("Accept-Encoding", "gzip, deflate").header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3").header("Cache-Control", "max-age=0").header("Connection", "keep-alive").header("Host", "www.cnblogs.com").header("Referer", "http://www.cnblogs.com/WangHaiMing/").header("Upgrade-Insecure-Requests", "1").header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:55.0) Gecko/20100101 Firefox/55.0").header("Cookie", "_ga=GA1.2.727269871.1498415016").timeout(5000).get().body().text());
        return Jsoup.connect(url).header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("Accept-Encoding", "gzip, deflate").header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3").header("Cache-Control", "max-age=0").header("Connection", "keep-alive").header("Host", "www.cnblogs.com").header("Referer", "http://www.cnblogs.com/WangHaiMing/").header("Upgrade-Insecure-Requests", "1").header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:55.0) Gecko/20100101 Firefox/55.0").header("Cookie", "_ga=GA1.2.727269871.1498415016").timeout(5000).get();
    }
}

