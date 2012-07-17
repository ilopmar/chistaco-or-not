
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
            window.location.reload();
        }
    });
}