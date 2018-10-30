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
    url: '/api/withdraw/list',
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
      { fixed: 'left', field: 'id', title: '充值流水ID', width: 120, unresize: true, sort: true },
      {
        field: 'userId', title: '商家/刷手ID', width: 100, templet: function (d) {
          return d.userId ? d.userId : '-';
        }
      },
      {
        field: 'phone', title: '手机号码', width: 120, templet: function (d) {
          return d.phone ? d.phone : '-';
        }
      },
      {
        field: 'realName', title: '姓名', width: 100, templet: function (d) {
          return d.realName ? d.realName : '-';
        }
      },
      {
        field: 'code', title: '提现码', width: 120, templet: function (d) {
          return d.id ? d.id : '-';
        }
      },
      {
        field: 'totalFee', title: '提现金额', width: 100, templet: function (d) {
          return d.totalFee ? d.totalFee : '-';
        }
      },
      {
        field: 'wechatName', title: '微信名', width: 200, templet: function (d) {
          return d.wechatName ? d.wechatName : '-';
        }
      },
      {
        field: 'ctime', title: '提现时间', width: 200, templet: function (d) {
          return d.ctime ? d.ctime : '-';
        }
      },
      {
        field: 'status', title: '状态', width: 80, templet: function (d) {
          return d.status == 0 ? '未完成' : d.status == 1 ? '已完成' : '-';
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
    if (obj.event === 'confirm') {
      layer.confirm("是否确认已转账？", function (index) {
        layer.close(index);
        confirm(tableIns, data);
      });
    }
  });
  // 搜索
  form.on('submit(search)', function (data) {
    var phone = $('#phone');
    var start = $('#start');
    var end = $('#end');

    tableIns.reload({
      where: {
        phone: phone.val(),
        start: start.val(),
        end: end.val()
      }
    });
    return false;
  });
});

function confirm(tableIns, params) {
  ajaxPost($, 'api/withdraw/confirm', params,
    function (response) {
      tableIns.reload({
        page: {
          curr: curPage
        }
      });
      layer.confirm('已转账，确认提现成功', function (index) {
        layer.close(index);
      });
    },
    function (response) {
      if (response.msg) {
        layer.msg(response.msg);
      } else {
        layer.msg('已转账，确认提现失败');
      }
    }
  );
}