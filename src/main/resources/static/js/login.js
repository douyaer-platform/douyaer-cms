layui.use(['form', 'layer', 'jquery'], function() {
    var form = layui.form;
    var layer = layui.layer;
    $ = layui.jquery;
    form.on("submit(login)", function (data) {
      login(data.field);
      return false;
    });
    var path = window.location.href;
});

function login(params) {
  ajaxPost($, 'api/admin/login', params,
    function (response) {
      window.location.href = "/index";
    },
    function (response) {
      $("#password").val("");
      layer.confirm(response.msg, function(index) {
        layer.close(index);
      })
    }
  );
}