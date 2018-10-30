var curPage;

layui.use(['table', 'form'], function () {
  var table = layui.table, form = layui.form;

  tableIns = table.render({
    elem: '#list',
    url: '/api/brushhand/certList',
    method: 'get', //默认：get请求
    cellMinWidth: 80,
    page: true,
    loading: true,
    request: {
      pageName: 'page', //页码的参数名称，默认：page
      limitName: 'limit' //每页数据量的参数名，默认：limit
    },
    response: {  //数据格式：{data: [], count: 99, code: 0}
      statusName: 'code', //数据状态的字段名称，默认：code
      statusCode: 0, //成功的状态码，默认：0
      countName: 'total', //数据总数的字段名称，默认：count
      dataName: 'data' //数据列表的字段名称，默认：data
    },
    cols: [[
      { fixed: 'left', field: 'id', title: 'ID', width: 80, unresize: true, sort: true },
      {
        field: 'phone', title: '手机号码', width: 200, align: 'center', templet: function (d) {
          return d.phone ? d.phone : '-';
        }
      },
      {
        field: 'sex', title: '性别', width: 80, align: 'center', templet: function (d) {
          return d.sex ? (d.sex == 'male' ? '男' : '女') : '-';
        }
      },
      {
        field: 'ip', title: 'IP', width: 100, templet: function (d) {
          return d.ip ? d.ip : '-';
        }
      },
      {
        field: 'address', title: '收货地址', width: 200, templet: function (d) {
          return d.address ? d.address : '-';
        }
      },
      {
        field: 'taobaoAccount', title: '淘宝账号', width: 200, templet: function (d) {
          return d.taobaoAccount ? d.taobaoAccount : '-';
        }
      },
      {
        field: 'ipScreenshotUrl', title: 'IP地址截图', width: 100, templet: function (d) {
          return d.ipScreenshotUrl ? '<a href="' + d.ipScreenshotUrl + '" target="_blank">详情</a>' : '-';
        }
      },
      {
        field: 'taobaoScreenshotUrl', title: '我的淘宝页面截图', width: 160, templet: function (d) {
          return d.taobaoScreenshotUrl ? '<a href="' + d.taobaoScreenshotUrl + '" target="_blank">详情</a>' : '-';
        }
      },
      {
        field: 'alipayScreenshotUrl', title: '支付宝截图', width: 100, templet: function (d) {
          return d.alipayScreenshotUrl ? '<a href="' + d.alipayScreenshotUrl + '" target="_blank">详情</a>' : '-';
        }
      },
      {
        field: 'createTime', title: '发起时间', width: 200, templet: function (d) {
          return d.createTime ? d.createTime : '-';
        }
      },
      {
        field: 'status', title: '状态', width: 80, templet: function (d) {
          return d.status == 2 ? '通过' : d.status == 1 ? '不通过' : d.status == 0 ? '未处理' : '-';
        }
      },
      { fixed: 'right', title: '操作', width: 160, align: 'center', toolbar: '#operate' }
    ]],
    done: function (res, curr, count) {
      //res即为：data当前页数据、count为数据总长度、curr为当前页
      curPage = curr;
    }
  });
  //监听工具条
  table.on('tool(list)', function (obj) {
    var data = obj.data;
    if (obj.event === 'pass') {
      layer.confirm("确定通过审核？", function (index) {
        layer.close(index);
        cert(tableIns, data.id, 2);
      });
    } else if (obj.event === 'notpass') {
      layer.confirm("确定不通过审核？", function (index) {
        layer.close(index);
        cert(tableIns, data.id, 1);
      });
    }
  });
  // 搜索
  form.on('submit(search)', function (data) {
    var phone = $('#phone');

    tableIns.reload({
      where: {
        phone: phone.val()
      }
    });
    return false;
  });
});

function cert(tableIns, id, status) {
  var params = {};
  params.id = id;
  params.status = status;
  ajaxPost($, 'api/brushhand/cert', params,
    function (response) {
      var msg = status == 2 ? '通过成功' : '不通过成功'
      tableIns.reload({
        page: {
          curr: curPage
        }
      });
      layer.confirm(msg, function (index) {
        layer.close(index);
      });
    },
    function (response) {
      var msg = status == 2 ? '通过失败' : '不通过失败'
      layer.confirm(msg, function (index) {
        layer.close(index);
      });
    }
  );
}