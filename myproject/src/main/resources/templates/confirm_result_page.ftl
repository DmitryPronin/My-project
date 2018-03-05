<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fresh Look</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/main.css">

</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Fresh Look</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="../registration_page.ftl">Registration</a></li>
                <li><a href="#">About</a></li>
                <li><a href="#">Examples</a></li>
                <li><a href="#">F.A.Q.</a></li>
            </ul>
        </div>
    </div>
</div>
<br/><br/>
<div class="container">
<#if model.result == true>
    <h1 style="color: #0f0f0f">Вы успешно подтвердили почту</h1>
    <h1 style="color: #0f0f0f">перейдите по ссылке для входа на сайт</h1> <a href="../login.ftl">Enter</a>
<#else>
    <h1 style="color: #0f0f0f">Ссылка не верна, либо истекло время жизни</h1>
</#if>
</div>
<footer class="container-fluid text-center" style=" position: relative; top: 100%;">
    <p>
        Supertext
    </p>
</footer>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="../js/bootstrap.js"></script>
<!--<script src="../js/main.js"></script-->

</body>

</html>

