
$( document ).ready(function() {
    $('#preloader').hide();
    $('#loading').hide();
    $('.slide').slick({
        infinite: true,
        slidesToShow: 3,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 6000
    });
    fillSlick();
});

function fillSlick() {
        $.ajax({
            type: "GET",
            url: "/api/get_previous",
            dataType: "text",
            beforeSend: function () {
                $('#loading').show();
            },
            complete: function () {
                $('#loading').hide();
            },
            success: function (result) {
                result = JSON.parse(result);
                if (result[0]!== undefined) $('#sl0').show().html('<span>'+result[0].username+'</span>' +
                    '<br> <span>'+result[0].answer+'</span>').show();
                if (result[1]!== undefined) $('#sl1').show().html('<span>'+result[1].username+'</span>' +
                    '<br> <span>'+result[1].answer+'</span>').show();
                if (result[2]!== undefined) $('#sl2').show().html('<span>'+result[2].username+'</span>' +
                    '<br> <span>'+result[2].answer+'</span>').show();
                if (result[3]!== undefined) $('#sl3').show().html('<span>'+result[3].username+'</span>' +
                    '<br> <span>'+result[3].answer+'</span>').show();
                if (result[4]!== undefined) $('#sl4').show().html('<span>'+result[4].username+'</span>' +
                    '<br> <span>'+result[4].answer+'</span>').show();
                console.log(result);
            },
            error: function (result) {
                alert('Ошибка при выполнении запроса');
            }
        }).done((msg) => {
            console.log(msg)
        })
}


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
            beforeSend: function() { $('#loading').show(); },
            complete: function() { $('#loading').hide(); },
            success: function(result) {
                result = JSON.parse(result);
                result.prob = result.prob*100;
                result.prob = Number(result.prob)
                if (result.answer === false){
                    $('#result').show().html('<span>Данный аккаунт не является ботом с вероятностью '+result.prob.toFixed(2)+'%</span>').show();
                }
                else {
                    $('#result').show().html('<span>Данный аккаунт является ботом с вероятностью '+result.prob.toFixed(2)+'%</span>').show();
                }
                console.log(result.answer === false)
                console.log(result);
            },
            error: function(result) {
                alert('Ошибка при выполнении запроса');
            }
        }).done((msg) => {
            console.log(msg)
        })
    })
});