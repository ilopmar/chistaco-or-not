$(document).on("click", "#the-jokes .joke1, #the-jokes .joke2", function(e) {
    e.preventDefault();

    var url = $(this).attr('rel');
    sendVote(url);
});

function sendVote(url) {
    $.ajax({
        type: "POST",
        url: url,
        dataType: 'json',
        success: function(data) {
            var timeout = 1000;
            
            if (data.success) {
                $.knotify.message(data.msg, "Ok", timeout);
            } else {
                $.knotify.message(data.msg, "Error", timeout);
            }

            $('#the-jokes').html(data.html);
        }
    });
}