$(function() {


    var slide_2 = 10;
    var slide_3 = 3;
    var slide_4 = 4;
    var slide_5 = 23;
    var slide_6 = 75;
    var slide_7 = 4;
    var slide_8 = 1;
    var slide_range = 22 + ' - ' + 40;

    $("#slider-range-min2").slider({
        range: "min",
        value: 22,
        min: 1,
        max: 50,
        change: function(event, ui) {
            $("#roiform input[name=projects]").val(ui.value);
        } ,
        slide: function(event, ui) {
            slide_2 = ui.value;
            $("#slider-range-min2 span.tooltip input").val(slide_2);
            var new_left = $('#slider-range-min2 a.ui-slider-handle').css('left');
            $("#slider-range-min2 span.tooltip").css('left', new_left);
            $("#slider-range-min2 span.tooltip").css('marginLeft', '-2.8em');
        }
    });

    $('#slider-range-min2 a').hover(function() {
        var tooltip = $(this).parent().find('span.tooltip');
        $("#slider-range-min2 span.tooltip input").val(slide_2);
        var new_left = $('#slider-range-min2 a.ui-slider-handle').css('left');
        $(tooltip).css('left', new_left);
        $(tooltip).css('marginLeft', '-2.8em');
        $(tooltip).show();
    }, function() {
        var tooltip = $(this).parent().find('span.tooltip');
        $(tooltip).hide();
    });


    $("#slider-range-min4").slider({
        range: "min",
        value: 80,
        min: 40,
        max: 120,
        step: 40,
        change: function(event, ui) {
            $("#roiform input[name=projectsize]").val(ui.value);
        } ,
        slide: function(event, ui) {
            $("#amount").val('$' + ui.value);
        }
    });

    $("#slider-range-min5").slider({
        range: "min",
        value: 2,
        min: 1,
        max: 3,
        step: 1,
        change: function(event, ui) {
            $("#roiform input[name=complexity]").val(ui.value);
        } ,
        slide: function(event, ui) {
            $("#amount").val('$' + ui.value);
        }
    });

    $("#slider-range-min6").slider({
        range: "min",
        value: 75,
        min: 50,
        max: 200,
        change: function(event, ui) {
            $("#roiform input[name=hourlyrate]").val(ui.value);
        } ,
        slide: function(event, ui) {
            slide_6 = ui.value;
            $("#slider-range-min6 span.tooltip input").val(slide_6);
            var new_left = $('#slider-range-min6 a.ui-slider-handle').css('left');
            $("#slider-range-min6 span.tooltip").css('left', new_left);
            $("#slider-range-min6 span.tooltip").css('marginLeft', '-2.8em');
        }
    });

    $('#slider-range-min6 a').hover(function() {
        var tooltip = $(this).parent().find('span.tooltip');
        $("#slider-range-min6 span.tooltip input").val(slide_6);
        var new_left = $('#slider-range-min6 a.ui-slider-handle').css('left');
        $(tooltip).css('left', new_left);
        $(tooltip).css('marginLeft', '-2.8em');
        $(tooltip).show();
    }, function() {
        var tooltip = $(this).parent().find('span.tooltip');
        $(tooltip).hide();
    });


    $("#slider-range").slider({
        range: true,
        min: 0,
        max: 50,
        values: [22, 40],
        slide: function(event, ui) {
            slide_range = ui.values[0] + ' - ' + ui.values[1];
            $("#slider-range span.tooltip input").val(slide_range);
            var new_left = $('#slider-range a.ui-slider-handle').css('left');
            $("#slider-range span.tooltip").css('left', new_left);
            $("#slider-range span.tooltip").css('marginLeft', '-2.8em');
        }
    });


    $('#slider-range a').hover(function() {
        var tooltip = $(this).parent().find('span.tooltip');
        $("#slider-range span.tooltip input").val(slide_range);
        var new_left = $('#slider-range a.ui-slider-handle').css('left');
        $(tooltip).css('left', new_left);
        $(tooltip).css('marginLeft', '-2.8em');
        $(tooltip).show();
    }, function() {
        var tooltip = $(this).parent().find('span.tooltip');
        $(tooltip).hide();
    });

    if ($.browser.msie && $.browser.version == "6.0") {
        DD_belatedPNG.fix('span.tooltip');
        DD_belatedPNG.fix('.ui-state-default', '.ui-widget-content .ui-state-default', '.ui-widget-header .ui-state-default');
        DD_belatedPNG.fix('.pop-up-holder');
        DD_belatedPNG.fix('.calculating');

    }

    $("#roiform input[name=projects]").val($("#slider-range-min2").slider("value"));
    $("#roiform input[name=projectsize]").val($("#slider-range-min4").slider("value"));
    $("#roiform input[name=complexity]").val($("#slider-range-min5").slider("value"));
    $("#roiform input[name=hourlyrate]").val($("#slider-range-min6").slider("value"));
    $("#roiform input[name=cloud]").val($("#slider-range-min8").slider("value"));

})