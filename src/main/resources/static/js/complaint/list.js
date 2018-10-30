var curPage;

layui.use(['table', 'form'], function () {
  var table = layui.table, form = layui.form;

  tableIns = table.render({
    elem: '#list',
    url: '/api/complaint/list',
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
      { field: 'complaintUserId', title: '刷手ID/商家ID', width: 150, unresize: true, sort: true },
      { field: 'orderId', title: '订单ID', width: 100 },
      { field: 'phone', title: '手机号码', width: 120 },
      {
        field: 'ctime', title: '投诉时间', width: 200, templet: function (d) {
          return d.ctime ? d.ctime : '-';
        }
      },
      {
        field: 'status', title: '状态', width: 80, templet: function (d) {
          return d.status == 0 ? '未处理' : d.status == 1 ? '已处理' : '-';
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
    if (obj.event === 'handle') {
      layer.confirm("是否处理？", function (index) {
        layer.close(index);
        handle(tableIns, data.id)
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

function handle(tableIns, id) {
  var params = {};
  params.id = id;
  ajaxPost($, 'api/complaint/handle', params,
    function (response) {
      tableIns.reload({
        page: {
          curr: curPage
        }
      });
      layer.confirm('处理投诉成功', function (index) {
        layer.close(index);
      });
    },
    function (response) {
      layer.confirm('处理投诉失败', function (index) {
        layer.close(index);
      });
    }
  );
}