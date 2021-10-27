package com.firewolf;

import com.firewolf.Utils.GetWY;
import org.apache.http.client.utils.URIBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class TestWY {
    @Test
    public void test1() throws IOException {
        String url="http://49.232.71.217:9999/";
        String result= GetWY.get1(url);
        System.out.println(result);
    }
    @Test
    public void test2() throws URISyntaxException, IOException {
        String url="http://yun.itheima.com/search";
        URIBuilder uriBuilder=new URIBuilder(url);
        uriBuilder.setParameter("keys","java");
        String result=GetWY.get2(url);
        System.out.println(result);
    }
}
