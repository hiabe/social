    jQuery.event.add(window, "load", function(){
        var fw = 100;        //fixed width
        var fh = 100;        //fixed height
        var sl = 'img.image_picker_image'; //selector
        $(sl).each(function(){
            var w = $(this).width();
            var h = $(this).height();
            if (w >= h) {
                $(this).width(fw);
            } else {
                $(this).height(fh);
            }
        });
        var sl = 'img.thumbnail-img'; //selector
        $(sl).each(function(){
            var w = $(this).width();
            var h = $(this).height();
            if (w >= h) {
                $(this).width(fw);
            } else {
                $(this).height(fh);
            }
        });

    });