/**
 * Created by Анатолий on 06.11.2015.
 */
$(document).ready(function(){
    onResize();
    function onResize(e){
        if($("#mainWrap").width()>1160){
            $("ul li").width("19%")
        } else $("ul li").width("24%")
    }
    $(window).resize(onResize);


    photos=$("#photos>img");
    currentPhoto=photos.size();

    photos.each(function(){
        var switches=$("#switches");
        switches.append("<div class='switch' />");
        switches.width($(".switch").size()*26);
        switches.css("right", 500-photos.size()*15);
    });


    $("#switches .switch").click(function(e){
            alert("!!");
            this.addClass("currentPhoto");
    });


    $("#switches>.switch:nth-child("+photos.size()+")").addClass("currentPhoto");
    setInterval(presentPhotos, 3000);

    function presentPhotos(){
        nextPhoto=currentPhoto==1?photos.size():currentPhoto-1;
        $("#switches>.switch:nth-child("+nextPhoto+")").addClass("currentPhoto");
        $("#switches>.switch:nth-child("+currentPhoto+")").removeClass("currentPhoto");
        $("#photos>img:nth-child("+currentPhoto+")").fadeOut(1000);
        $("#photos>img:nth-child("+nextPhoto+")").fadeIn(1000);

        currentPhoto=currentPhoto>1?currentPhoto-1:photos.size();
    }
    $(".photo-category").hover(function(){
        $(".white-layer", this).animate({opacity: 0.4}, 300);
        $(this).animate({"background-size": "500px"}, 300)
    }, function(){
        $(".white-layer", this).animate({opacity: 0}, 300);
        $(this).animate({"background-size": "400px"}, 300)
    })
});