$(document).ready(function(){
    onResize();
    function onResize(e){
        if($("#mainWrap").width()<1160){
            $("#categoriesList").css("display","block").width("650px").css({marginLeft:'auto', marginRight:'auto'});
            $("#categoriesList .kind-wrap").css("display","inline-block").width('300px');
            $("#itemsWrap, .item-window").css({display:'block', marginLeft:'auto', marginRight:'auto', float:'none'})
        } else {
            $("#categoriesList").css("display","inline-block").width("240px").css({margin:'0px'});
            $("#categoriesList .kind-wrap").css("display","block").width('210px');
            $("#itemsWrap, .item-window").css({display:'inline-block', marginLeft:'auto', marginRight:'auto', float:'right'})
        }
    }
    $(window).resize(onResize);
});