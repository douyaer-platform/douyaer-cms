layui.use('form', function () {
  var form = layui.form;
  form.on('submit(add)', function (data) {
    layer.confirm("确定充值？", function (index) {
      add(data.field);
      layer.close(index);
    });
    return false;
  });
});

function add(params) {
  ajaxPost($, 'api/deposit/add', params,
    function (response) {
      layer.msg('充值成功');
    },
    function (response) {
      if (response.msg) {
        layer.msg(response.msg);
      } else {
        layer.msg('充值失败');
      }
    }
  );
}