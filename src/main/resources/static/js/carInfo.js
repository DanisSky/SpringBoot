function renderTable(comments) {
    let textCOM = '';
    $('#commentsList').empty();
    let len = comments.length;
    for (let i = 0; i < len; i++) {
        let comment = comments[i];
        let {text} = comment;
        let {userDto: {firstName}} = comment;
        let {userDto: {lastName}} = comment;
        textCOM += '<div class="comment">' + '<h3>' + firstName + ' ' + lastName + '</h3>' +
            '<div class="comment-text">' + text + '</div>' + '</div>';
    }
    $('#commentsList').append(textCOM);
}
function sendComment(carId) {
    let comment = $('#comment').val();
    if (comment) {
        $('#comment').val('');
    }
    let data = {
        id: carId,
        text: comment,
    };
    $.ajax({
        type: "POST",
        data: JSON.stringify(data),
        success: (response) => {
            console.log(response);
            renderTable(response);
        },
        dataType: "json",
        contentType: "application/json"
    }).catch((err)=>{console.log(err)})
}
