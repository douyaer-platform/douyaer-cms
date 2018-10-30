layui.use('form', function () {
  var form = layui.form;
  form.on('submit(add)', function (data) {
    layer.confirm("确定提现？", function (index) {
      add(data.field);
      layer.close(index);
    });
    return false;
  });
});

function add(params) {
  ajaxPost($, 'api/withdraw/add', params,
    function (response) {
      layer.msg('提现成功');
    },
    function (response) {
      if (response.msg) {
        layer.msg(response.msg);
      } else {
        layer.msg('提现失败');
      }
    }
  );
}