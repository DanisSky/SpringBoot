<#include "parts/_header.ftlh">
<body>
<#include "parts/_navbar.ftlh">
<main>
    <div class="content container">
        <div class="product__detail">
            <div class="product__detail__card">
                <div class="product__detail__card__image">
                    <img src="/files/?url=${product.pictureUrl?url}" alt=""/>
                </div>
                <div class="product__detail__card__about">
                    <h5>${product.name}</h5>
                    <span><a style="text-decoration: none; color: #b9d5fd !important;"
                             href="/products/?id=${category.id}">${category.name}</a></span>

                    <br/>
                    <b>$ ${product.price}</b>
                    <p>
                        ${product.description}
                    </p>
                    <div class="form">
                        <button class="product__detail__btn btn" type="submit">Add to Corzine</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<div id="reviewsList">
    <#list reviews![] as review>
        <div class="comment__container">
            <div class="comment">
                <h6 class="name">${review.accountEmail}</h6>
                <p>${review.text}</p>
            </div>
        </div>
    </#list>
</div>

<form class="w-75 d-flex flex-column justify-content-center mx-auto" id="MyForm">
    <label class="d-block" for="comment">
        <h5>Add comment</h5>
    </label>
    <div class="form-group w-75 d-flex flex-column">
        <textarea class="form-control rounded-0" required id="commentText" rows="5"></textarea>
        <div class="add_comment mt-2">
            <div class="btn btn-secondary" onclick="sendComment()">Send</div>
        </div>
    </div>
</form>
<#include "parts/_footer.ftlh">
<script>
    function renderTable(reviews) {
        let textCOM = '';
        let len = reviews.length;
        for (let i = 0; i < len; i++) {
            let review = reviews[i];
            let {text} = review;
            let {accountEmail} = review
            textCOM += `<div class="comment__container">
            <div class="comment">
                <h6 class="name">` + accountEmail + `</h6>
                <p>` + text + `</p>
            </div>
        </div>`;
        }
        $('#reviewsList').empty().append(textCOM);
    }

    function sendComment() {
        let comment = $('#commentText').val();
        if (comment) {
            $('#commentText').val('');
        }
        let data = {
            text: comment,
            accountEmail: `${user}` ,
            productId: ${product.id},
            stars: ${0}
        };
        $.ajax({
            type: "POST",
            url: "/reviews/",
            data: JSON.stringify(data),
            success: (response) => {
                console.log(response);
            },
            dataType: "json",
            contentType: "application/json"
        }).catch((err) => {
            console.log(err)
        })
    }
</script>
</body>
</html>
