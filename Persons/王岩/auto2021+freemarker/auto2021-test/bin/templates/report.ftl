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
            <th style=" text-align:left;">mode:</th>
            <th colspan="3" style=" text-align:left;">${testFormwork}</th>
        </tr>
        <tr>
            <td>test person:</td>
            <td colspan="3">${testPerson}</td>
        </tr>
        <tr>
            <td>test type:</td>
            <td colspan="3">${testType}</td>
        </tr>
        <tr>
            <td>test date:</td>
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
            <th colspan="4">Test Report</th>
        </tr>
        <tr style=" text-align:center;">
            <td>No.</td>
            <td width="400px">Test Method</td>
            <td width="80px">Result</td>
            <td width="300px">Reason</td>
        </tr>
        <#list caseList as case>
            <#if case.result=="FAIL">
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