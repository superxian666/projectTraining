package com.firewolf.apitest_platform.service;

public class HttpClientUtils {
    /**
     * 存放  post get的请求的方法。
     * */
	 static CloseableHttpClient httpClient = null;
    static CloseableHttpResponse respone = null;

    public static String doPost(String url, JSONObject para) {
        httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        post.addHeader("Content-Type", "application/json");
        HttpEntity data;
        String content = null;
        try {
            data = new StringEntity(para.toString());
            post.setEntity(data);
            respone = httpClient.execute(post);
            HttpEntity entity = respone.getEntity();
            content = EntityUtils.toString(entity, "utf-8");
            EntityUtils.consume(entity);
            respone.close();
            httpClient.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return content;
    }

    public static String doPostByForm(String url, List<NameValuePair> data) throws Exception {
        httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        post.addHeader("Content-Type", "application/x-www-form-urlencoded");
        post.setEntity(new UrlEncodedFormEntity(data));
        respone = httpClient.execute(post);
        HttpEntity entity = respone.getEntity();
        String content = EntityUtils.toString(entity, "utf-8");
        respone.close();
        httpClient.close();
        return content;
    }

    public static String doPost(String url, JSONObject para, CookieStore cookie) throws Exception {
        RequestConfig config = RequestConfig.custom().
                setCookieSpec(StandardCookieSpec.STRICT).build();
        httpClient = HttpClients.custom().
                setDefaultRequestConfig(config)
                .setDefaultCookieStore((org.apache.http.client.CookieStore) cookie).build();
        HttpPost post = new HttpPost(url);
        post.addHeader("Content-Type", "application/json");
        HttpEntity data = new StringEntity(para.toString());
        post.setEntity(data);
        CloseableHttpResponse respone = httpClient.execute(post);
        HttpEntity entity = respone.getEntity();
        String content = EntityUtils.toString(entity, "utf-8");
        EntityUtils.consume(entity);
        respone.close();
        httpClient.close();
        return content;
    }
}
