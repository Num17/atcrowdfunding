function init_data() {

    $.ajax({
        url: "/atcrowdfunding/user/get",
        type: "post",
        data: {},
        traditional: true,
        success: function (data) {
            if (data.statusCode === 0) {
                layer.msg(data.message, {time: 1500, icon: 5, shift: 6});
            }

            if (data.statusCode === 1) {
                
            }
        }
    });

}