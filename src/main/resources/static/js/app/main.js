var main = {
    init : function() {
        var _this = this;
        $('#btn-save').on('click', function() {
          _this.save();
        });

    },
    save: function() {
        var data = {
            title: $('#title').val(),
            content: $('#content').val(),
            author: $('#author').val(),
        };

        $.ajax( {
            type: 'POST',
            url: '/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert("성공");
            location.reload();
        }).fail(function(err) {
            alert(err);
        })
    },
}

main.init();