<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>验证码测试</title>
    <style>
        *{margin: 0 auto;}
        img{vertical-align: middle;}
        input{vertical-align: middle;}
        div{width: 350px;height: 100px;}
    </style>
</head>
<body>
    <div>
    <h1>自定义验证码</h1>
    <form action="/login" method="post">
        <img src="/validate" alt="" width="80" height="30">
        <input type="text" name="validate" value=""/>
        <input type="submit" value="验证">
    </form>
     <h3> ${msg}</h3>
    </div>
</body>
</html>
