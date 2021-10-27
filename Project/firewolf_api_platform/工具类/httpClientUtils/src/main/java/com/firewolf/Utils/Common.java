package com.firewolf;

import com.alibaba.fastjson.JSONObject;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.cookie.BasicCookieStore;
import org.apache.hc.client5.http.cookie.CookieStore;
import org.apache.hc.client5.http.cookie.StandardCookieSpec;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.IOException;
import java.util.Map;

public class Common {
    // 把map类型转换为String,并用&加以拼接
    public static String mapToString(Map<String, Object> para) {
        StringBuilder sBuilder = new StringBuilder();
        String content = null;
        int size = para.size();
        for (Map.Entry<String, Object> entry : para.entrySet()) {
            sBuilder.append(entry.getKey() + "=" + entry.getValue());
            size--;
            if (size >= 1) {
                sBuilder.append("&");
            }
        }
        return sBuilder.toString();
    }
    public static CookieStore getCookie(String url, String u_name, String password) throws Exception, IOException {
        JSONObject user = new JSONObject();
        user.put("phoneArea", "86");
        user.put("phoneNumber", u_name);
        user.put("password", password);

        //创建带自定义Cookie的Client
        RequestConfig config = RequestConfig.custom().setCookieSpec(StandardCookieSpec.STRICT).build();

        CookieStore cookie = new BasicCookieStore();

        CloseableHttpClient client = HttpClients.
                custom().
                setDefaultRequestConfig(config).
                setDefaultCookieStore(cookie)
                .build();

        String loginurl = url;
        HttpPost post = new HttpPost(loginurl);
        //设置请求体
        HttpEntity userEntity = new StringEntity(user.toString());
        post.setHeader("Content-Type", "application/json");
        post.setEntity(userEntity);
        CloseableHttpResponse response = client.execute(post);
        HttpEntity responseEntity = response.getEntity();
        String result = EntityUtils.toString(responseEntity, "UTF-8");
        System.out.println(result);
        EntityUtils.consume(responseEntity);
        response.close();
        client.close();

        return cookie;


    }

}
