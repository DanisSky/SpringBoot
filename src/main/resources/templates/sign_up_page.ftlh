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
                        <input type="number" name="phoneNumber" placeholder="phone"/>
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
</body>
</html>
