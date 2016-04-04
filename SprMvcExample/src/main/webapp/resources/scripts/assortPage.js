/**
 * Created by Анатолий on 11.11.2015.
 */
$(document).ready(function(){
    $(".item").hover(function(e){
        $(".slider", this).slideToggle(150)
    });
    function getUrlParams()
    {
        var vars = [], hash;
        var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
        for(var i = 0; i < hashes.length; i++)
        {
            hash = hashes[i].split('=');
            vars.push(hash[0]);
            vars[hash[0]] = hash[1];
        }
        return vars;
    }
    var URLparams=getUrlParams();
    if(URLparams["sortMethod"]!=null){
        $("#sort-select [value='"+URLparams["sortMethod"]+"']").attr("selected", "selected");
    }
    $("#sort-select").change(function(){
        var selected=$("#sort-select option:selected").val();
        window.location.search="sortMethod="+selected;
    })
});