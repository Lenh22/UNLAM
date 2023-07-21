function getApi (){
    $.ajax({
        url: 'https://...',
        type: 'GET',
        success: functionAction
    });
}
function setApi(){
    $.ajax({
        url: 'https://...',
        type: 'PUT',
        success: function () {
            toastr.success("Mensaje Exitoso");
        },
        error:function () {
            toastr.error("Mensaje error");
        }

    });
}
