
$(function parseInfo() {
    $('body').on('click', '#parse', function () {
        // let username = $(this).data("username");
        let username = $("#username").val();
        console.log(username);
        $.ajax({
            type: "POST",
            url: "/api/parse_user/",
            dataType: "text",
            data: {
                username: username,
            },
            success: function(result) {
                alert('ok');
            },
            error: function(result) {
                alert('error');
            }
        }).done((msg) => {
            console.log(msg)
        })
    })
});