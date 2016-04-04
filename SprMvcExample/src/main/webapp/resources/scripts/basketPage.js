$(document).ready(function(){
    onResize();
    function onResize(e){
        if($("#mainWrap").width()<1160){
            $("#basket").css({marginLeft:'auto', marginRight:'auto', display:'block', border:'none'});
            $("#order-form").css({'float': 'none', marginLeft:'auto', marginRight:'auto', display:'block'})

        } else {
            $("#basket").css({marginLeft:'0px', marginRight:'30px', display:'inline-block', borderRight:'1px solid gray'});
            $("#order-form").css({'float': 'right', marginLeft:'0px', marginRight:'0px', display:'block'})
        }
    }
    $(window).resize(onResize);

    $(".choose-count .minus").click(function(){
        var amount=$(this).parent(".choose-count").find(".count");
        if(amount.val()>1) amount.val(amount.val()-1)

    });
    $(".choose-count .plus").click(function(){
        var amount=$(this).parent(".choose-count").find(".count");
        amount.val(parseInt(amount.val())+1)
    });
    $(".choose-count [type='button']").click(function(ev){
        $.ajax({
            url: "/addToBasket",
            type: 'GET',
            dataType: 'json',
            contentType: 'application/json',
            mimeType: 'application/json',
            data: ({
                itemId: $(ev.target).attr('data-itemid'),
                amount: $(ev.target).attr('class')=='plus'?1:-1
            }),
            success: function (data) {
                location.reload()
            }
        })
    });
    $(".delete").click(function(e) {
        $.ajax({
            url: "/deleteFromBasket",
            type: 'GET',
            dataType: 'json',
            contentType: 'application/json',
            mimeType: 'application/json',
            data: ({
                itemId: $(e.target).attr('data-itemid')
            }),
            success: function (data) {
                location.reload()
            }
        })
    });
});
