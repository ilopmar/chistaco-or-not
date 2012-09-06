
$(".joke1, .joke2").click(function(e) {
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
            
            setTimeout(function() {
                window.location.reload();
            }, timeout);
            
            if (data.success) {
                $.knotify.message(data.msg, "Ok", timeout);
            } else {
                $.knotify.message(data.msg, "Error", timeout);
            }
        }
    });
}