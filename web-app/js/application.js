
$(".joke1, .joke2").click(function(e) {
    e.preventDefault();
    
    var self = $(this);
    var url = self.find('p').attr('rel');

    sendVote(url);
});

function sendVote(url) {
    
    $.ajax({
        type: "POST",
        url: url,
        dataType: 'json',
        success: function(data) {
            var timeout = 1500;
            
            setTimeout(function() {
                window.location.reload();
            }, timeout);
            
            if (data.success) {
                $.knotify.message("Voto contabilizado correctamente", "Ok", timeout);
                
            } else {
                $.knotify.message("Ocurrió un error con el voto", "Error", timeout);
            }
        }
    });
}