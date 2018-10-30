var curPage;
layui.use(['laydate', 'table', 'form'], function () {
  var table = layui.table, laydate = layui.laydate, form = layui.form;

  laydate.render({
    elem: '#start',
    type: 'date'
  });
  laydate.render({
    elem: '#end',
    type: 'date'
  });

  tableIns = table.render({
    elem: '#list',
    url: '/api/coin/list',
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
      { fixed: 'left', field: 'id', title: '交易流水ID', width: 120, unresize: true, sort: true },
      {
        field: 'userId', title: '商家/刷手ID', width: 120, templet: function (d) {
          return d.userId ? d.userId : '-';
        }
      },
      {
        field: 'eventId', title: '订单编号', width: 120, templet: function (d) {
          return d.eventId ? d.eventId : '-';
        }
      },
      {
        field: 'phone', title: '手机', width: 120, templet: function (d) {
          return d.phone ? d.phone : '-';
        }
      },
      {
        field: 'count', title: '金额', width: 100, templet: function (d) {
          return d.count ? d.count : '-';
        }
      },
      {
        field: 'accountBalance', title: '余额', width: 100, templet: function (d) {
          return d.accountBalance ? d.accountBalance : '-';
        }
      },
      {
        field: 'comment', title: '备注', width: 200, templet: function (d) {
          return d.comment ? d.comment : '-';
        }
      },
      {
        field: 'ctime', title: '时间', width: 200, templet: function (d) {
          return d.ctime ? d.ctime : '-';
        }
      },
      // { fixed: 'right', title: '操作', width: 120, align: 'center', toolbar: '#operate' }
    ]],
    done: function (res, curr, count) {
      //res即为：data当前页数据、count为数据总长度、curr为当前页
      curPage = curr;
    }
  });
  //监听工具条
  table.on('tool(list)', function (obj) {
    var data = obj.data;
    if (obj.event === '') {

    }
  });
  // 搜索
  form.on('submit(search)', function (data) {
    var phone = $('#phone');
    var id = $('#id');
    var start = $('#start');
    var end = $('#end');

    tableIns.reload({
      where: {
        phone: phone.val(),
        id: id.val(),
        start: start.val(),
        end: end.val()
      }
    });
    return false;
  });
});