
function validatorEmail(value) {
    // 正则验证格式
    var reg = "/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/";
    return RegExp(reg).test(value);
}

function add_user(form_data) {

    $.ajax({
        url: "/atcrowdfunding/user/add",
        type: "post",
        data: form_data,
        traditional: true,
        success: function (data) {
            if (data.statusCode === 0) {
                layer.msg(data.message, {time: 1500, icon: 5, shift: 6});
            }

            if (data.statusCode === 1) {
                window.location.href = "user.html";
            }
        }
    });

}