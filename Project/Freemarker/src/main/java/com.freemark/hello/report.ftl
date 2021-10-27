<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>测试报告</title>
</head>
<body>
<center>
    <table cellspacing="0" style="margin-top: 10px">
        <tr>
            <th style=" text-align:left;">模板名：</th>
            <th colspan="3" style=" text-align:left;">${testFormwork}</th>
        </tr>
        <tr>
            <td>测试人员：</td>
            <td colspan="3">${testPerson}</td>
        </tr>
        <tr>
            <td>测试类型：</td>
            <td colspan="3">${testType}</td>
        </tr>
        <tr>
            <td>测试日期：</td>
            <td colspan="3">${.now}</td>
        </tr>
        <tr height="30px">
            <td></td>
            <td width="400px"></td>
            <td width="300px"></td>
            <td width="80px"></td>
        </tr>
    </table>
</center>
<center>
    <table border="1" cellspacing="0" width="868px">
        <tr>
            <th colspan="4">测试报告</th>
        </tr>
        <tr style=" text-align:center;">
            <td>序号</td>
            <td width="400px">测试方法</td>
            <td width="80px">结果</td>
            <td width="300px">失败原因</td>
        </tr>
        <#list caseList as case>
            <#if case.failResult=="fail">
                <tr style=" text-align:center;background-color: red;" >
                    <td>${case_index+1}</td>
                    <td>${case.testMethod}</td>
                    <td>${case.result}</td>
                    <td>${case.failResult}</td>
                </tr>
            <#else >
                <tr style=" text-align:center;background-color: green;">
                    <td>${case_index+1}</td>
                    <td>${case.testMethod}</td>
                    <td>${case.result}</td>
                    <td>${case.failResult}</td>
                </tr></#if>
        </#list>
    </table>
</center>
</body>
</html>