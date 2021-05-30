<#include "parts/_header.ftlh">
<body>
<#include "parts/_navbar.ftlh">
<main>
    <div class="content container">
        <h1>Your shopping cart</h1>
        <table class="cart">
            <thead>
            <tr>
                <th>Image</th>
                <th>Product</th>
                <th>Remove</th>
                <th>Price</th>
            </tr>
            </thead>
            <tbody>
                <#list products as product>
                    <tr>
                        <td>
                            <div style="width: 10rem;">
                                <a href="/products/${product.id}">
                                    <img src="/files/?url=${product.pictureUrl?url}" class="card-img-top" alt=""/>
                                </a>
                            </div>
                        </td>
                        <td>${product.name}</td>
                        <td><a href="/cart/product/remove/${product.id}" style="color: blue">Remove</a></td>
                        <td class="num">${product.price}</td>
                    </tr>
                </#list>
                <tr class="total">
                    <td>Total</td>
                    <td colspan="4"></td>
                    <td class="num"><#if total??>${total}<#else>0.0</#if></td>
                </tr>
            </tbody>
        </table>

    </div>
</main>
</body>
</html>
