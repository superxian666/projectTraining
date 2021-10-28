reportNG的配置与使用

1. 首先安装testng 

2. 下载reportng jar包     http://pan.baidu.com/s/1i3KdlQH   不需要文件夹，只需要其中的jar文件

3. 引入google guice       http://pan.baidu.com/s/1pJkFezT  

4. 共提取到三个文件：guice-3.0.jar      reportng-1.1.4.jar     velocity-dep-1.4.jar （也可以下载我上传的项目中的文件）

5. 将三个.jar文件 添加到project      build path 

6. 新建testng.xml的文件

   ```
   <listeners>
           	<listener class-name="org.uncommons.reportng.HTMLReporter" />
           	<listener class-name="org.uncommons.reportng.JUnitXMLReporter"/>
    </listeners>
   ```

   

   ```
   <?xml version="1.0" encoding="UTF-8"?>
   <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
   <suite name="Suite" verbose="1">
   //在此处添加以下四行<listeners>配置
   	<listeners>
           	<listener class-name="org.uncommons.reportng.HTMLReporter" />
           	<listener class-name="org.uncommons.reportng.JUnitXMLReporter"/>
           </listeners>
       
     	<test thread-count="5" name="Test">
       	<classes>
         		<class name="demo.Demo"/>
       	</classes>
     	</test> <!-- Test -->  
   </suite> <!-- Suite -->
   
   ```

    

7. 右键 testng.xml    选择Run  As  ——> TestNg Suite  运行

8. 可以在本地的test-output/html文件目录下查看测试报告 (不要eclipse找路径)![1635391241290](C:\Users\dell\Pictures\移动端测试\reportNG.PNG)

9. 运行成功（如果有错误的测试方法，左侧有红色叉号提示）