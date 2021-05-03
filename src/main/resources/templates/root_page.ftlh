<#include "parts/_header.ftlh">
<body>
<#include "parts/_navbar.ftlh">

<main>
    <div class="content container">
        <div class="product" id="tabs">
            <div class="product__cat">
                <h3>Categories</h3>
                <ul>
                    <li><a href="/products/">All</a></li>
                    <#list categories as category>
                        <li><a href="/products/?id=${category.id}">${category.name}</a></li>
                    </#list>
                </ul>
            </div>

            <div class="product__list">
                <h1><#if category??>
                        ${category.name}
                    <#else >
                        Products
                    </#if></h1>

                <div class="product__cards">
                    <#list products as prod>
                        <div class="product__card" id="product__card">
                            <div class="product__card__image">
                                <img
                                        src="/files/?url=${prod.pictureUrl?url}"
                                        class="card-img-top"
                                />
                            </div>
                            <div class="product__card__body">
                                <a class="card-title" href="/products/${prod.id}">${prod.name}</a>
                                <p class="card-text">$${prod.price}</p>
                            </div>
                        </div>
                    </#list>
                </div>

            </div>

        </div>
    </div>
</main>

</body>
</html>
