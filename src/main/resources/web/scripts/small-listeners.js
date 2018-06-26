$('#common-fields, #toyota-fields, #general-fields').find('.input-group').find('input, select, textarea').on('focus', function() {
    $(this).parent().addClass('active');
}).on('blur', function() {
    $(this).parent().removeClass('active');
});

$('#event-type-input').change(function(ev) {
    console.log($('#event-type-input')[0].selectedIndex);
    switch ($('#event-type-input')[0].selectedIndex) {
        case 0:
            $('#subject-input').val('');
            break;
        case 1:
            $('#subject-input').val('Telenav - Notice of Scheduled Maintenance');
            break;
        case 2:
            $('#subject-input').val('Telenav - Notice of Unscheduled Service Interruption');
            break;
        case 3:
            $('#subject-input').val('Telenav - Notice of Unscheduled Maintenance');
            break;
    }
});