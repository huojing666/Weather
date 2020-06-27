
$(function(){
    $("#selectCityId").change(function(){
        var cityId = $("#selectCityId").val();
        var url = '/report/bycityId/?cityId='+ cityId;
        window.location.href = url;
    })
});