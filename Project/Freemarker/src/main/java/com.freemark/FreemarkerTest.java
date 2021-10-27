package com.freemark.hello;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class FreemarkerTest {
    private static final String TEMPLATE_PATH = "src/main/java/com/freemark/hello/templates";
    private static final String CLASS_PATH = "src/main/java/com/freemark/hello";
    Configuration configuration = new Configuration();
    Writer out = null;
    Map dataMap = new HashMap<String, Object>();
    List<Case> caseList = new ArrayList<>();
    public void setDetails(String testFormwork,String testPerson,String testType){
        try {
            // step2 获取模版路径
            configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
            // step3 创建数据模型
            dataMap.put("caseList",caseList);
            dataMap.put("testPerson",testPerson);
            dataMap.put("testType",testType);
            dataMap.put("testFormwork",testFormwork);
            // step4 加载模版文件
            Template template = configuration.getTemplate("report.ftl");
            // step5 生成数据
            File docFile = new File(CLASS_PATH + "\\" + "report.html");
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            // step6 输出文件
            template.process(dataMap, out);
            System.out.println("report.html 文件创建成功 !");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    public void setCase(String testMethod,String result,String failReason){
        caseList.add(new Case(testMethod,result,failReason));
//        caseList.add(new Case("12345","12345","1234"));
    }
}
