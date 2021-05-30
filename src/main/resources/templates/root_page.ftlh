<#include "parts/_header.ftlh">
<sbody>
    <#include "parts/_navbar.ftlh">

    <main>
        <div class="content container">
            <div class="product" id="tabs">
                <div class="product__cat">
                    <h3>Categories</h3>

                    <form class="form-inline">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" id='product_name' aria-label="Search">
                        <div class="btn btn-outline-success my-2 my-sm-0"  onclick="searchProd()">Search</div>
                    </form>

                    <ul>
                        <li><a style="color: white" href="/products/">All</a></li>
                        <#list categories as category>
                            <li><a style="color: white"  href="/products/?id=${category.id}">${category.name}</a></li>
                        </#list>
                    </ul>
                </div>

                <div class="product__list">

                    <h1><#if category??>
                            ${category.name}
                        <#else >
                            Products
                        </#if></h1>

                    <div class="product__cards" id="product_list">
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
    <#include "parts/_footer.ftlh">
    <script>
        function renderTable(data) {
            console.log(data)
            let textCOM = '';
            let len = data['products'].length;
            for (let i = 0; i < len; i++) {
                let product = data['products'][i];
                let {name} = product;
                let {price} = product;
                let {pictureUrl} = product;
                let {id} = product;
                textCOM = ` <div class="product__card" id="product__card">
                                <div class="product__card__image">
                                    <img
                                            src="/files/?url=`+encodeURI(pictureUrl)+`"
                                            class="card-img-top"
                                    />
                                </div>
                                <div class="product__card__body">
                                    <a class="card-title" href="/products/`+id+`">`+name+`</a>
                                    <p class="card-text">$`+price+`</p>
                                </div>
                            </div>`
            }
            $('#product_list').empty().append(textCOM);
        }

        function searchProd() {
            let text = $('#product_name').val();
            if (text) {
                $('#product_name').val('');
            }
            $.ajax({
                type: "GET",
                url: "/products/search?page=0&size=20&q=" + text+ "&sort=name&direction=DESC",
                success: (response) => {
                    console.log(response);
                    renderTable(response);
                },
                dataType: "json",
                contentType: "application/json"
            }).catch((err) => {
                console.log(err)
            })
        }
    </script>
</sbody>
</html>
