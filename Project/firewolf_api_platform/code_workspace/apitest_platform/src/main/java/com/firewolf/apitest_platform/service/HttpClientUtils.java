
package com.firewolf.apitest_platform.service;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class HttpClientUtils {
    static CloseableHttpClient httpClient = null;
    static CloseableHttpResponse response = null;
    static String Url = null;
    private CookieStore store;
    /**
     * 存放post方法
     * */

    /**
     * 存放get方法
     */

    //    get的无参请求
    public static String getOnly(String url) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        response = client.execute(get);
        HttpEntity responseEntity = response.getEntity();
        String result = EntityUtils.toString(responseEntity, "utf-8");
        EntityUtils.consume(responseEntity);
        response.close();
        client.close();
        return result;
    }


    public static String doPost(String url, JSONObject para) throws IOException, ParseException {
        //1、初始化HttpClient对象
        httpClient = HttpClients.createDefault();
        //2.初始化httppost对象
        HttpPost post = new HttpPost(url);
        //3、设置Header属性
        post.setHeader("Content-Type", "application/json");
        //4、设置请求体
        HttpEntity user1 = new StringEntity(para.toString());
        post.setEntity(user1);
        //5、执行请求
        response = httpClient.execute(post);
        //6、获得响应体
        HttpEntity response_entity = response.getEntity();
        //7、获得响应正文（字符串）
        String result = EntityUtils.toString(response_entity);

        //8、释放资源
        EntityUtils.consume(response_entity);
        //9、断开连接
        response.close();
        httpClient.close();
        return result;

    }

    public static String doPost(String url, List<NameValuePair> data) throws Exception {
        //1、初始化HttpClient对象
        httpClient = HttpClients.createDefault();
        //2.初始化httppost对象
        HttpPost post = new HttpPost(url);
        //3、设置Header属性
        post.addHeader("Content-Type", "application/x-www-form-urlencoded");
        //4、设置请求体
        post.setEntity(new UrlEncodedFormEntity(data));
        //5、执行请求
        response = httpClient.execute(post);
        //6、获得响应体
        HttpEntity response_entity = response.getEntity();
        //7、获得响应正文（字符串）
        String content = EntityUtils.toString(response_entity, "utf-8");
        //8、释放资源
        EntityUtils.consume(response_entity);
        //9、断开连接;
        response.close();
        httpClient.close();
        return content;
    }

    public static String doPost(String url, JSONObject para, CookieStore cookie) throws Exception {
        //1、初始化HttpClient对象
        RequestConfig config = RequestConfig.custom().
                setCookieSpec(CookieSpecs.STANDARD).build();
        httpClient = HttpClients.custom().
                setDefaultRequestConfig(config)
                .setDefaultCookieStore(cookie).build();
        //2.初始化httppost对象
        HttpPost post = new HttpPost(url);
        //3、设置Header属性
        post.addHeader("Content-Type", "application/json");
        //4、设置请求体
        HttpEntity data = new StringEntity(para.toString());
        //5、执行请求
        post.setEntity(data);
        //6、获得响应体
        CloseableHttpResponse respone = httpClient.execute(post);
        HttpEntity entity = respone.getEntity();
        //7、获得响应正文（字符串）
        String content = EntityUtils.toString(entity, "utf-8");
        //8、释放资源
        EntityUtils.consume(entity);
        //9、断开连接;
        respone.close();
        httpClient.close();
        return content;
    }


}
