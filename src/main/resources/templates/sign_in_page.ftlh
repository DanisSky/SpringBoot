<!DOCTYPE html>
<html lang="ru">
<head>
    <title>title</title>
    <link rel="stylesheet" href="/static/css/main.css"/>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
            crossorigin="anonymous"
    />
    <link rel="preconnect" href="https://fonts.gstatic.com"/>
    <link
            href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700;900&display=swap"
            rel="stylesheet"
    />
</head>
<body>
<nav class="navbar navbar-light px-5">
    <div class="container">
        <span class="user__nav__brand">MyShop</span>
        <div class="user__nav">
            <div class="user__nav__name">
                <span>Welcome</span>
                <b>Name</b>
            </div>
            <div class="user__nav__links d-flex">
                <a href="active">My profile</a>
                <a href="">Logout</a>
                <a href="">Log-in</a>
            </div>
        </div>
    </div>
</nav>
<main>
    <div class="content container">


        <div class="login">
            <h1>Log-in</h1>
            <form action="/signIn" method="post">
                <div class="form__inputs">
                    <div class="login__input">
                        <input type="text" name="email" placeholder="login"/>
                    </div>
                    <div class="login__input">
                        <input type="password" name="password" placeholder="password"/>
                    </div>
                </div>
                <div class="error">All fields requested.</div>
                <input class="login__btn btn" type="submit" value="submit"/>
            </form>
        </div>


    </div>
</main>
</body>
</html>
