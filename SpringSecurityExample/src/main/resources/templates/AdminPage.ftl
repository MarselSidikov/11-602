<!doctype html>
<html lang="ru">
<head>
    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Страница админа</title>
</head>
<body>
<script>
    function sendLoginForTempPassword(login) {
        $.ajax({
            type: "POST",
            url: "/admin/as_user",
            data: {
                login: login
            },
            success: function (result) {
                alert(result)
            }
        })
    }
</script>
<h1>Введите логин пользователя для получения временного пароля</h1>
<div class="login-form">
    <input type="text" id="user_login" name="login" placeholder="Логин пользователя">
    <button onclick="sendLoginForTempPassword(document.getElementById('user_login').value)">Отправить</button>
</div>
</body>
</html>