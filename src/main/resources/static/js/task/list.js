var curPage;
layui.use(['table', 'form'], function () {
  var table = layui.table, form = layui.form;

  tableIns = table.render({
    elem: '#list',
    url: '/api/task/list',
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
      { fixed: 'left', field: 'taskId', title: 'ID', width: 80, unresize: true, sort: true },
      {
        field: 'phone', title: '手机号码', width: 200, align: 'center', templet: function (d) {
          return d.phone ? d.phone : '-';
        }
      },
      {
        field: 'goodsUrl', title: '宝贝链接', width: 100, templet: function (d) {
          return d.goodsUrl ? '<a href="' + d.goodsUrl + '" target="_blank">详情</a>' : '-';
        }
      },
      {
        field: 'taobaoAccount', title: '店铺名称', width: 100, templet: function (d) {
          return d.taobaoAccount ? d.taobaoAccount : '-';
        }
      },
      {
        field: 'tags', title: '搜索入店关键词', width: 160, templet: function (d) {
          return d.tags ? d.tags : '-';
        }
      },
      {
        field: 'remark', title: '任务说明', width: 300, templet: function (d) {
          return d.remark ? d.remark : '-';
        }
      },
      {
        field: 'createTime', title: '发布时间', width: 200, templet: function (d) {
          return d.createTime ? d.createTime : '-';
        }
      },
      {
        field: 'goodsPicUrl', title: '入店图片', width: 100, templet: function (d) {
          return d.goodsPicUrl ? '<a href="' + d.goodsPicUrl + '" target="_blank">详情</a>' : '-';
        }
      },
      {
        field: 'searchPicUrl', title: '搜索截图', width: 100, templet: function (d) {
          return d.searchPicUrl ? '<a href="' + d.searchPicUrl + '" target="_blank">详情</a>' : '-';
        }
      },
      {
        field: 'conditionPicUrl', title: '卡条件截图', width: 100, templet: function (d) {
          return d.conditionPicUrl ? '<a href="' + d.conditionPicUrl + '" target="_blank">详情</a>' : '-';
        }
      },
      {
        field: 'status', title: '状态', width: 80, templet: function (d) {
          return d.status == 2 ? '通过' : d.status == 1 ? '不通过' : d.status == 0 ? '未处理' : '-';
        }
      },
      { fixed: 'right', title: '操作', width: 200, align: 'center', toolbar: '#operate' }
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
        cert(tableIns, data.taskId, 2);
      });
    } else if (obj.event === 'notpass') {
      layer.confirm("确定不通过审核？", function (index) {
        layer.close(index);
        cert(tableIns, data.taskId, 1);
      });
    }
  });
  // 搜索
  form.on('submit(search)', function (data) {
    var phone = $('#phone');
      var taobaoAccount = $('#taobaoAccount')

      tableIns.reload({
        where: {
          phone: phone.val(),
          taobaoAccount: taobaoAccount.val()
        }
      });
    return false;
  });
});

function cert(tableIns, id, status) {
  var params = {};
  params.id = id;
  params.status = status;
  ajaxPost($, 'api/task/cert', params,
    function (response) {
      var msg = status == 2 ? '通过成功' : '不通过成功'
      tableIns.reload({
        page: {
          curr: curPage
        }
      })
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