function order_number(value, row, index) {
    //获取每页显示的数量
    var pageSize = $('#tb_users').bootstrapTable('getOptions').pageSize;
    //获取当前是第几页
    var pageNumber = $('#tb_users').bootstrapTable('getOptions').pageNumber;
    //返回序号，注意index是从0开始的，所以要加上1
    return pageSize * (pageNumber - 1) + index + 1;
}

function operate() {

    var roleStr = "<button type='button' class='btn btn-success btn-xs'><i class=' glyphicon glyphicon-check'></i></button>";
    var editStr = "<button type='button' class='btn btn-primary btn-xs'><i class=' glyphicon glyphicon-pencil'></i></button>";
    var removeStr = "<button type='button' class='btn btn-danger btn-xs'><i class=' glyphicon glyphicon-remove'></i></button>";
    return roleStr + editStr + removeStr;
}

function init_data() {

    init_user_info();
    // initList(1, 10);

}

//初始化右上角登录名
function init_user_info() {
    $.ajax({
        url: "/atcrowdfunding/user/info",
        type: "post",
        data: {},
        success: function (data) {
            if (data.statusCode === 0) {
                layer.msg("系统错误，请稍后再试!", {time: 1500, icon: 5, shift: 6});
            }

            if (data.statusCode === 1) {

                $("button:first span:first").text(data.data.username);
            }
        }
    });
}

function delete_user(account_array) {

    $.ajax({
        url: "/atcrowdfunding/user/delete",
        type: "post",
        data: {"accounts": account_array},
        traditional: true, //当传递js数组时，防止jQuery的深度序列化参数对象
        success: function (data) {
            if (data.statusCode === 0) {
                layer.msg("系统错误，请稍后再试!", {time: 1500, icon: 5, shift: 6});
            }

            if (data.statusCode === 1) {
                $("#tb_users").bootstrapTable("refresh", {
                    silent: true //静态刷新
                });
            }
        }
    });
}
