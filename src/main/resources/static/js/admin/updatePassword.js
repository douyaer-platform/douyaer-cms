layui.use('form', function () {
  var form = layui.form;

  form.on('submit(save)', function (data) {
    if (data.field.newPassword != data.field.confirmPassword) {
      layer.confirm("新密码与确认密码不一致", function (index) {
        layer.close(index);
      });
      return false;
    }

    layer.confirm("确定修改？", function (index) {
      save(data.field);
      layer.close(index);
    });
    return false;
  });

  //自定义验证规则
  form.verify({
    pwd: [/(.+){6,12}$/, '密码必须6到12位']
  });
});

function save(params) {
  ajaxPost($, 'api/admin/updatePassword', params,
    function (response) {
      layer.confirm('修改成功', function (index) {
        layer.close(index);
      });
    },
    function (response) {
      layer.confirm('修改失败:' + response.msg, function (index) {
        layer.close(index);
      });
    }
  );
}