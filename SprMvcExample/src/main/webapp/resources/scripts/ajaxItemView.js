/**
 * Created by Анатолий on 16.11.2015.
 */
$(document).ready(function(){
    $(".div-item .slider p").click(function(e){
        $.ajax({
        url:$(e.target).attr('ref'),
        type:'GET',
        dataType:'json',
        contentType:'application/json',
        mimeType:'application/json',
        success: function(data){
            $("#item-preview").html(
                '<div class="item-window">' +
                    '<input type="button" class="cancel">'+
                    '<div class="item-info">' +
                        '<div class="item-photo">'+
                        '<img src="'+data['imagePath']+'">'+
                        '</div>' +
                    '<div class="info">'+
                        '<div class="item-name">'+data["name"]+'</div>'+
                        '<div class="item-price">'+data["cost"]+'</div>'+
                        '<div class="description">'+data['description']+'</div>'+
                        '<div class="to-basket">'+
                            '<form>'+
                                '<button data-itemid="'+data['itemId']+'" type="button">В КОРЗИНУ</button>'+
                                '<div class="choose-count">'+
                                    '<input type="button" value="-" class="minus">'+
                                    '<input id="amount" type="number" value="1" step="1" min="1" name="count" class="count">'+
                                    '<input type="button" value="+" class="plus">'+
                                '</div>'+
                            '</form>'+
                        '</div>'+
                    '</div>' +

                    '</div>' +
                '</div>');
            $("#blackout").css('display', 'block');
            $('.cancel').click(function(){
                $("#item-preview").empty();
                $("#blackout").css('display', 'none');
            });
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

        }


        });



    })
});