<!doctype html>
<html lang="en">
<head>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
            crossorigin="anonymous"
    />
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script
            src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
            crossorigin="anonymous"></script>
    <title>Admin</title>
</head>
<body>
<div>
    <div class="mb-3">
        <input  id="name" class="form-control" type="text" name="name" placeholder="name"/>
    </div>
    <div class="mb-3">
        <input id="description" class="form-control" type="text" name="description" placeholder="description"/>
    </div>
    <div class="mb-3">
        <input id="price" class="form-control" type="number" step="0.01" name="price" placeholder="price"/>
    </div>
    <div class="mb-3">
        <input id="pictureUrl" class="form-control" type="text" name="pictureUrl" placeholder="pictureUrl"/>
    </div>
    <div class="mb-3">
        <input id="category" class="form-control" type="text" name="category" placeholder="category"/>
    </div>
    <button onclick="sendProduct()" class="btn btn-primary">Submit</button>
</div>
</body>
<script>
    function sendProduct() {
        let name = $('#name').val();
        let description = $('#description').val();
        let price = $('#price').val();
        let pictureUrl = $('#pictureUrl').val();
        let category = $('#category').val();
        let data = {
            name : name,
            description : description,
            price: price,
            pictureUrl: pictureUrl,
            category : category
        };
        $.ajax({
            type: "POST",
            url: "/products/",
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
            success: (response) => {
                window.location.href = "/admin/products/add";
            },
        })
    }
</script>
</html>