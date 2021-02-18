<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <title>Document</title>
    <script src="/static/js/carInfo.js"></script>
    <link rel="stylesheet" type="text/css" href="/static/css/carInfo.css">
</head>
<body>
<#include "parts/navbar.ftlh">

<div class="container">
    <header class="d-flex flex-wrap justify-content-center mt-5">
        <div class="car__image">
            <img src="/file?id=${carDto.fileId}"
                 alt="car"/>
        </div>
        <div class="car__title ml-5">

            <h1>The <br>
                ${carDto.mark}
                <br>
                ${carDto.model}
                <br></h1>

        </div>
    </header>
    <div class="car__about">
            <span>
            ${carDto.description}

            </span>
    </div>
    <div class="line my-5"></div>

    <div class="comments w-75 mx-auto" id="commentsList">
        <#list carDto.commentDtos as comment>
            <div class="comment">
                <h3>${comment.userDto.firstName} </h3>
                <div class="comment-text">${comment.text}</div>
            </div>

        </#list>
    </div>


    <form class="w-75 d-flex flex-column justify-content-center mx-auto" id="MyForm">
        <label class="d-block" for="comment">
            <h5>Add comment</h5>
        </label>
        <div class="form-group w-75 d-flex flex-column">
            <textarea class="form-control rounded-0" id="comment" rows="5"></textarea>
            <div class="add_comment mt-2">
                <div class="btn btn-secondary" onclick="sendComment(${carDto.id})">submit</div>
            </div>
        </div>
    </form>


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
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
        crossorigin="anonymous"></script>
</body>
</html>