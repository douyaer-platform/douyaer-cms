layui.use('form', function () {
  var form = layui.form;
  
  detail();

  form.on('submit(edit)', function (data) {
    layer.confirm("确定保存？", function (index) {
      edit(data.field);
      layer.close(index);
    });
    return false;
  });
});

function detail() {
  ajaxGet($, 'api/notice/detail',
    function (response) {
      $('#content').val(response.data);
    },
    function (response) {
      layer.msg('获取消息内容失败'); 
    }
  );
}

function edit(params) {
  ajaxPost($, 'api/notice/edit', params,
    function (response) {
      layer.msg('保存成功'); 
    },
    function (response) {
      layer.msg('保存失败'); 
    }
  );
}