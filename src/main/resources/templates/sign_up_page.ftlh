<#include "parts/_header.ftlh">
<body>
<#include "parts/_navbar.ftlh">
<main>
    <div class="content container">


        <div class="login">
            <h1>Register</h1>
            <form action="/signUp" method="post">
                <div class="form__inputs">
                    <div class="login__input">
                        <input type="text" name="email" placeholder="login"/>
                    </div>
                    <div class="login__input">
                        <input type="password" name="password" placeholder="password"/>
                    </div>
                    <div class="login__input">
                        <input type="tel" id="phone" class="phone" name="phoneNumber" placeholder="phone"/>
                    </div>
                </div>
                <#if errors??>
                    <div class="error">All fields requested.</div>
                </#if>
                <input class="login__btn btn" type="submit" value="Register"/>
            </form>
        </div>


    </div>
</main>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.maskedinput/1.4.1/jquery.maskedinput.min.js"></script>

<script type="text/javascript">
    jQuery(function ($) {
        $(".phone").mask("+7(999)999-9999")
    });
</script>
<script src="/js/maskedinput.js"></script>
</body>
</html>
