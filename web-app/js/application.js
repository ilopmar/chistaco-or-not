$(document).on("click", "#the-jokes .joke1, #the-jokes .joke2", function(e) {
    e.preventDefault();

    var url = $(this).attr('rel');
    sendPost(url);
});

$(document).on("click", "#refresh", function(e) {
    e.preventDefault();

    var url = $(this).data('url');
    
    sendPost(url);
});

function sendPost(url) {
    $.ajax({
        type: "POST",
        url: url,
        dataType: 'json',
        success: function(data) {
            var timeout = 1000;
            
            if (data.success) {
                if (data.msg) {
                    $.knotify.message(data.msg, "Ok", timeout);
                }
            } else {
                if (data.msg) {
                    $.knotify.message(data.msg, "Error", timeout);
                }
            }

            $('#the-jokes').html(data.html);
        }
    });
}

// $(document).on("click", "#refresh", function(e) {
//     e.preventDefault();

//     var url = $(this).data('url');
    
//     $.ajax({
//         type: "POST",
//         url: url,
//         dataType: 'json',
//         success: function(data) {
//             $('#the-jokes').html(data.html);
//         }
//     });
// });
