package com.firewolf.apitest_platform.service;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;

@Service
public class HttpClientUtils {
    /**
     * 存放post方法
     * */

    /**
     * 存放get方法
     *
     * */

//    public static String get2(String url) throws URISyntaxException, IOException {
//        CloseableHttpClient client = HttpClients.createDefault();
//        URIBuilder uriBuilder=new URIBuilder(url);
//        HttpGet get=new HttpGet(uriBuilder.build());
//        CloseableHttpResponse response = client.execute(get);
//        if(response.getStatusLine().getStatusCode()==200){
//            HttpEntity httpEntity=response.getEntity();
//            String content=EntityUtils.toString(httpEntity,"utf8");
//            EntityUtils.consume(httpEntity);
//            response.close();
//            client.close();
//            return content;
//        }
//
//        return url;
//    }
    //    get的无参请求
    public String getOnly(String url) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse response = client.execute(get);
        HttpEntity responseEntity = response.getEntity();
        String result = EntityUtils.toString(responseEntity, "utf-8");
        EntityUtils.consume(responseEntity);
        response.close();
        client.close();
        return result;
    }

}
