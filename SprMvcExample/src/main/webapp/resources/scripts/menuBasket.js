
$(document).ready(function(){
    $("#menuLine .menu-icon:last-child").hover(function(e){
        $.ajax({
            url:'/getBasket',
            type:'GET',
            dataType:'json',
            contentType:'application/json',
            mimeType:'application/json',
            success: function(map){
                $(".menu-icon:last-child #basket-list").empty();
                $.each(map, function(item, info){
                    $(".menu-icon:last-child #basket-list").append("<div><span class='basket-item-name'>"+item+"</span> <span class='basket-item-count'>" + info['amount']+" шт.</span></div>").slideDown(200);
                });

            }

        });



    }, function(){
        $(".menu-icon:last-child #basket-list").empty().slideUp(200)
    })
});