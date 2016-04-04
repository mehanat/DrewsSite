/**
 * Created by Анатолий on 24.11.2015.
 */
$(document).ready(function(){
    var amount=$("#amount");
    $(".item-window .to-basket button").click(function(ev){
        if(amount.val()>0) {
            amount.css("border", "none");
            $.ajax({
                url: "/addToBasket",
                type: 'GET',
                dataType: 'json',
                contentType: 'application/json',
                mimeType: 'application/json',
                data: ({
                    itemId: $(ev.target).attr('data-itemid'),
                    amount: $("#amount").val()
                }),
                success: function (data2) {
                    var priceLabel = $("#final-cost span");
                    var cost = data2['totalCost'];
                    priceLabel.html(cost);
                    $(".item-window").append("<div id='success'>Товар успешно добавлен в корзину!</div>");
                    $("#success").fadeOut(2000)

                }
            })
        } else{
            amount.css("border", "1px solid red")
        }
    });

    $(".choose-count .minus").click(function(){
        if(amount.val()>1) amount.val(amount.val()-1)
    });
    $(".choose-count .plus").click(function(){
        amount.val(parseInt(amount.val())+1)
    });
    $("#more-info .info-title").click(function(){
        $("#more-info .selected-title").removeClass("selected-title");
        $(this).addClass("selected-title")
    });
    $("#more-info .features").click(function(){
        $("#more-info #comment-window").css("display", "none");
        $("#more-info #info-window").slideToggle(200);
    });
    $("#more-info .comments").click(function(){
        $("#more-info #info-window").css("display", "none");
        $("#more-info #comment-window").slideToggle(200);

        $.ajax({
            url: "/item/"+window.location.pathname.split("/")[2]+"/getComments",
            type: 'GET',
            dataType: 'json',
            contentType: 'application/json',
            mimeType: 'application/json',
            success:function(data){

                data.forEach(function(comment){
                    var date=new Date(comment["date"]);
                    $("#comments-list").append('<div class="comment">'+
                    '<p class="title"><span>'+comment["authorName"]+', </span><span>'+date.getDay()+'.'+date.getMonth()+'.'+date.getFullYear()+'</span></p>'+
                    '<p class="text">'+comment["text"]+'</p>'+
                    '</div>')
                })
            }
        })
    })
});