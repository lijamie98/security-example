$('#event-start, #event-end, #outage-start, #outage-end').datetimepicker({
    defaultDate: Date.now(),
    format: 'YYYY-MM-DD HH:mm:ss'
});

$('#eta-time, #duration').datetimepicker({
    defaultDate: new Date(0).setHours(0, 0, 0),
    format: 'HH:mm:ss'
});