(function () {

    function populate(accounts) {
        var $accounts = $('#accounts');

        for (var i = 0; i < accounts.length; i++) {
            var account = accounts[i];
            $accounts.append(`<div class="account" data-value="${account.email}">${account.name}</div>`);
            // $accounts.append(`<div class="form-check account"><input class="form-check-input" value="${account.email}" type="checkbox" id="${account.email}"><label class="form-check-label" for="${account.email}">${account.name}</label></div>`);
        }

        $('.account').on('click', function () {
            var $this = $(this);
            $this.toggleClass('selected');

            var selectedAccounts = [];
            $accounts.find('.account').each(function (index, element) {
                var $account = $(element);
                if ($account.prev().length !== 0)
                    if ($account.prev().hasClass('selected'))
                        $account.css({
                            borderTopLeftRadius: 0,
                            borderTopRightRadius: 0
                        });
                    else
                        $account.css({
                            borderTopLeftRadius: 8,
                            borderTopRightRadius: 8
                        });

                if ($account.next().length !== 0)
                    if ($account.next().hasClass('selected'))
                        $account.css({
                            borderBottomLeftRadius: 0,
                            borderBottomRightRadius: 0
                        });
                    else
                        $account.css({
                            borderBottomLeftRadius: 8,
                            borderBottomRightRadius: 8
                        });

                if ($account.hasClass('selected'))
                    selectedAccounts.push(element.getAttribute('data-value'));
                else
                    $account.css({
                        borderRadius: 8
                    })
            });

            $('#to-input').val(selectedAccounts.join(', '));
        });
    }

    $.ajax({
        dataType: 'json',
        url: 'account-data.json',
        success: function (data) {
            populate(data.accounts);
        }
    });
})();