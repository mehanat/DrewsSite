$(document).ready(function(){
    var attributes=window.location.pathname.split("/");
    var category1=attributes[2]=="all"?"all-col":attributes[2];
    var category2=attributes[3]=="all"?"all-in":attributes[3];

    $(".kind-wrap #"+category1).prop("checked", true);
    $(".kind-wrap #"+category2).prop("checked", true);



    $("#categoriesList label").click(function(e){

        if(attributes[1]=="item"){
            var ctgr1="all";
            var ctgr2="all";

            if($(e.target).parent("label").prev().attr("name")=="color"){
                ctgr1=$(e.target).parent("label").attr("for")=="all-col"?"all":$(e.target).parent("label").attr("for")
            } else
            if ($(e.target).parent("label").prev().attr("name")=="filling"){
                ctgr2=$(e.target).parent("label").attr("for")=="all-in"?"all":$(e.target).parent("label").attr("for")
            }
            window.location.replace("http://localhost:8888/assortment-types/"+ctgr1+"/"+ctgr2);
        }
        else {
            $(this).prev().prop("checked", true);

            var ctgr1 = $(".kind-wrap input:checked")[0].getAttribute('id') == "all-col" ? "all" : $(".kind-wrap input:checked")[0].getAttribute('id');
            var ctgr2 = $(".kind-wrap input:checked")[1].getAttribute('id') == "all-in" ? "all" : $(".kind-wrap input:checked")[1].getAttribute('id');

            window.location.replace("http://localhost:8888/assortment-types/" + ctgr1 + "/" + ctgr2);
        }
    });

});

