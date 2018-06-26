(function () {
    function getCommonFields() {
        return {
            eventName: $('#event-name-input').val(),
            duration: $('#duration-input').val(),
            subject: $('#subject-input').val(),
            startTime: $('#event-start-input').val(),
            endTime: $('#event-end-input').val(),
            eventType: $('#event-type-input').val(),
            mailFrom: $('#from-input').val(),
            mailTo: $('#to-input').val(),
        }
    }

    function displaySubmitted(data) {
        var iframeDoc = $('#modal-iframe')[0].contentWindow.document;
        iframeDoc.open();
        iframeDoc.write(data);
        iframeDoc.close();
        console.log($('#to-input').val());
        $('#modal-title').text('The following email is sent to ' + $('#to-input').val());
        $('#submitModal').modal();
    }

    $('#general-submit').on('click', function () {
        $.ajax({
            type: 'POST',
            url: '/general',
            data: JSON.stringify($.extend({}, getCommonFields(), {
                type: 'general',
                description: $('#general-description-input').val(),
                actions: $('#actions-input').val(),
                severity: $('#severity-input').val(),
                impact: $('#impact-input').val(),
                progress: $('#progress-input').val()
            })),
            success: displaySubmitted
        });
    });

    $('#toyota-submit').on('click', function () {
        $.ajax({
            type: 'POST',
            url: '/toyota',
            data: JSON.stringify($.extend({}, getCommonFields(), {
                type: 'toyota',
                description: $('#toyota-description-input').val(),
                reportedBy: $('#reported-by-input').val(),
                environment: $('#environment-input').val(),
                planned: $('#planned-unplanned-input').val(), // requires verification

                outageStart: $('#outage-start-input').val(),
                outageEnd: $('#outage-end-input').val(),

                // outageStart: moment($('#outage-start-input').val()).unix(),
                // outageEnd: moment($('#outage-end-input').val()).unix(),
                outageEta: $('#eta-time-input').val(),
                impacted: $('#affected-input').val(),
                incidentNumber: $('#incident-number-input').val(),
                severity: $('#severity-level-input').val(),
                customerServicesImpacts: $('#customer-services-impact-input').val(),
                dealerServicesImpacts: $('#dealer-services-impact-input').val(),
                cvtBusinessImpacts: $('#cvt-business-impact-input').val(),
                workaroundAvailable: $('#workaround-available-input').val(),
                workaroundDescription: $('#workaround-description-input').val()
            })),
            success: displaySubmitted
        });
    });
})();