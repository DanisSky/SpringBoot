<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
<#include "parts/navbar.ftlh">
<div class="container">
    <div class="row justify-content-center">
        <div class="col-5 ">
            <form action="/signUp" method="post">
                <div class="form-group">
                    <label> Your first name</label>
                    <input name="firstName" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Your last name</label>
                    <input name="lastName" class="form-control">
                </div>
                <div class="form-group">
                    <label>Phone</label>
                    <input name="phone" type="tel" class="form-control" placeholder="Your phone" required>
                </div>
                <div class="form-group">
                    <label>Email</label>
                    <input name="email" type="email" class="form-control" placeholder="Your email"
                           aria-describedby="emailHelp" required>
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone
                        else.</small>
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input name="password" type="password" class="form-control" placeholder="Your password" required>
                </div>
                <button type="submit" class="btn btn-primary" value="Send">Submit</button>
            </form>
        </div>
    </div>
</div>
<section class="py-3" id="footer" style="background-color: rgba(155, 156, 154, 0.774);">
    <div class="container">
        <header>
            <h2>Questions or comments?</h2>
            <p><b>Get in touch:</b></p>
        </header>
        <div class="flex-sm-column flex-md-row row d-flex ">
            <section class="col-6">
                <form action="/feedback"
                      method="post"
                      class="form">
                    <input class="col-9 mb-1"
                           name="name"
                           required
                           placeholder="Name"
                           type="text"/>
                    <input class="col-9 mb-1"
                           name="email"
                           required
                           placeholder="Email"
                           type="text"/>
                    <textarea class="col-9 "
                              name="message"
                              required
                              rows="5"
                              placeholder="Message"></textarea>
                    <div class="col-12">
                        <button type="submit" value="Send"
                                class=" btn btn-secondary form-button-submit button icon solid">Send Message
                        </button>
                    </div>
                </form>
            </section>
            <div class="col-12-sm col-6 ">
                <section>

                    <div class="row">
                        <ul class="icons" style="list-style: none;">
                            <p>some long text about feedback.</p>
                            <li class="icon solid fa-home">
                                1234 Somewhere Road<br/>
                                Russia<br/>
                                Kazan
                            </li>
                            <li class="icon solid fa-phone">
                                8 (000) 000-0000
                            </li>
                            <li class="icon solid fa-envelope">
                                <a href="https://github.com/DanisSky/Site">git@DanisSky</a>
                            </li>
                        </ul>
                    </div>

                </section>
            </div>
        </div>
    </div>
</section>
</body>
</html>