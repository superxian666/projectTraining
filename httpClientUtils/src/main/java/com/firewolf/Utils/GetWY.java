package com.firewolf.Utils;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class GetWY {
////    get的无参请求
//    @Test
//    public void get1() throws IOException {
//        //创建httpclient对象
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        //创建请求方法的实例， 并指定请求url
//        HttpGet httpget=new HttpGet("http://49.232.71.217:9999/");
//        //获取http响应状态码
//        CloseableHttpResponse response=httpClient.execute(httpget);
//        HttpEntity entity=response.getEntity();
//        //接收响应头
//        String content= EntityUtils.toString(entity, "utf-8");
//        System.out.println(httpget.getURI());
//        System.out.println(content);
//        httpClient.close();
//    }
//
////    get的有参请求
//    @Test
//    public void get2() throws IOException, URISyntaxException {
//        //创建httpclient对象
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//        nameValuePairs.add(new BasicNameValuePair("keys", "java"));
//        String str = EntityUtils.toString(new UrlEncodedFormEntity(nameValuePairs,
//                Consts.UTF_8));
//        HttpGet httpGet = new HttpGet("http://yun.itheima.com/search?keys=java"+"?"+str);
//        CloseableHttpResponse response=httpClient.execute(httpGet);
//        HttpEntity entity=response.getEntity();
//        //接收响应头
//        String content=EntityUtils.toString(entity, "utf-8");
//        System.out.println(content);
//        httpClient.close();
//    }
//
////    带参数的get
//    @Test
//    public void get3() throws URISyntaxException {
//        //1.创建HttpClient对象
//        CloseableHttpClient httpClient= HttpClients.createDefault();
//        //创建URLBuilder
//        URIBuilder uriBuilder=new URIBuilder("http://yun.itheima.com/search");
//        //设置参数
//        uriBuilder.setParameter("keys","java");
//        //2.创建HttpGet对象，设置URL地址
//        HttpGet httpGet=new HttpGet(uriBuilder.build());
//        System.out.println("发送请求的信息："+httpGet);
//        //使用httpClient发起响应获取repsonse
//        CloseableHttpResponse response=null;
//        try {
//            response=httpClient.execute(httpGet);
//            //4.解析响应，获取数据
//            //判断状态码是否是200
//            if(response.getStatusLine().getStatusCode()==200){
//                HttpEntity httpEntity=response.getEntity();
//                String content=EntityUtils.toString(httpEntity,"utf8");
//                System.out.println(content);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                response.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                httpClient.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    //    get的有参请求
    public static String get2(String url) throws URISyntaxException, IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        URIBuilder uriBuilder=new URIBuilder(url);
        HttpGet get=new HttpGet(uriBuilder.build());
        CloseableHttpResponse response = client.execute(get);
        if(response.getStatusLine().getStatusCode()==200){
            HttpEntity httpEntity=response.getEntity();
            String content=EntityUtils.toString(httpEntity,"utf8");
            EntityUtils.consume(httpEntity);
            response.close();
            client.close();
            return content;
        }

        return url;
    }
    //    get的无参请求
    public static String get1(String url) throws IOException {
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
