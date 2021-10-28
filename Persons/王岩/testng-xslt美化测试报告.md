# estng-xslt美化测试报告
在使用testNG自动化框架执行测试用例后，会自动生成HTML的测试报告，但是过于简单，信息展示极少，也没有图表说明，所有我们使用testNG-xslt进行美化。

1. 下载testng-xslt-1.1.2压缩包
http://pan.baidu.com/s/1jIvgop4

2. 下载好了压缩包后，解压，并把 lib 文件下的saxon-8.7.jar 和 SaxonLiason.jar 拷贝到项目的test-output下的lib文件夹下（没有则新建）

![image-20211028103444286](C:\Users\wanglele\AppData\Roaming\Typora\typora-user-images\image-20211028103444286.png)

3. 把 解压后的文件夹的/src/main/resources/下的testng-results.xsl 放到项目的test-out文件夹下

   ![image-20211028103620243](C:\Users\wanglele\AppData\Roaming\Typora\typora-user-images\image-20211028103620243.png)
4. 点击自己的项目右键New-File，创建一个build.xml文件，在xml文件进行配置
+  {name} ：自己的项目名字
+  {in}：对应的是testng生成报告的xml的本机路径
+  {style}：对应的是testng生成报告的xsl的本机路径
+  {out}：是要用testNG-xslt生成报告的文件名和路径
+  {expression}：是要用testNG-xslt生成报告的路径
+  {out}设置测试报告输出时，最好生成一个新的html（即index1.html）文件来展示测试报告
```xml
<?xml version="1.0" encoding="UTF-8"?>
 
<project name="自己的项目名字" basedir=".">
    <property name="lib.dir" value="lib"/>
 
    <path id="test.classpath">
        <!-- adding the saxon jar to your classpath -->
      <fileset dir="${lib.dir}" includes="*.jar"/>
    </path>
 
    <target name="transform">
        <property name="dir" value=""/>
 
        <!-- <mkdir dir="C:\Softwareengineering\java\ecplice\jiekouceshi\SandTestNg\test-output/"/> -->
 
        <xslt in="C:\Softwareengineering\java\ecplice\jiekouceshi\SandTestNg\test-output\testng-results.xml"
              style="C:\Softwareengineering\java\ecplice\jiekouceshi\SandTestNg\test-output\testng-results.xsl"
              out="C:\Softwareengineering\java\ecplice\jiekouceshi\SandTestNg\test-output\index1.html"
              classpathref="test.classpath" processor="SaxonLiaison">
            <param name="testNgXslt.outputDir" expression="C:\Softwareengineering\java\ecplice\jiekouceshi\SandTestNg\test-output" />
        </xslt>
    </target>
</project>
```
4. 这里呢，基本配置都好了，在Eclipse选择项目，点击window-Show View-Other，打开Ant文件夹，选择Ant，OK；会加载出项目的Ant构建

![image-20211028110712626](C:\Users\wanglele\AppData\Roaming\Typora\typora-user-images\image-20211028110712626.png)

5. 打开build.xml文件点击右键，选择第二个Ant Build...，勾选transform，点击run，构建完成。刷新项目查看生成新的报告文件

   ![image-20211028111205647](C:\Users\wanglele\AppData\Roaming\Typora\typora-user-images\image-20211028111205647.png)走到这一步，那么恭喜，testng重写完成

   点击test-output文件下的index1.html就可以看到美美的测试报告了

![image-20211028110811019](C:\Users\wanglele\AppData\Roaming\Typora\typora-user-images\image-20211028110811019.png)

index.html是没有美化之前的报告

![image-20211028111108870](C:\Users\wanglele\AppData\Roaming\Typora\typora-user-images\image-20211028111108870.png)

index1.html是美化后的

![image-20211028111057767](C:\Users\wanglele\AppData\Roaming\Typora\typora-user-images\image-20211028111057767.png)