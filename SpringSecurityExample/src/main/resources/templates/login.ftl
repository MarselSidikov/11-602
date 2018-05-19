<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Логин</title>
</head>
<body>
<#if error??>
    <h1>Неверный логин или пароль</h1>
</#if>
<div class="login-form">
    <form action="/login" method="post">
        <label for="login">Ваш логин:</label>
        <input id="login" name="login">
        <br>
        <label for="password">Ваш пароль:</label>
        <input id="password" type="password" name="password">
        <label for="remember-me">Запомнить меня</label>
        <input type="checkbox" name="remember-me" id="remember-me">
        <br>
        <input type="submit" value="Login">
    </form>
</div>
</body>
</html>