package com.sean.util;

import com.sean.entity.Page;
import com.sean.service.impl.HttpClientDownloadService;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @program: spiders
 * @description: page util
 * @author: Sean
 * @create: 2020-03-15 16:00
 **/
public class PageDownloadUtil {

    public static String getPageContent(String url){
        HttpClientBuilder httpClientBuilder = HttpClients.custom();
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        HttpGet request = new HttpGet(url);
        String content = null;
        try {
            CloseableHttpResponse response = closeableHttpClient.execute(request);
            HttpEntity entity = response.getEntity();
            content = EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    /**
     * @Description: test class
     * @Method_Name:main
     *  @param args
     * @return void
     * @Creation Date:2020/3/15
     * @Author Sean
     */
    public static void main(String[] args) {
        String url = "https://v.youku.com/v_show/id_XNDUzNDMyMTk4OA==.html?spm=a2hcb.12528442.m_4422_c_11052.d_3&scm=20140719.manual.4422.video_XNDUzNDMyMTk4OA%3D%3D";
        HttpClientDownloadService downloadService = new HttpClientDownloadService();
        Page page = downloadService.download(url);
        System.out.println(page.getContent());
    }
}
