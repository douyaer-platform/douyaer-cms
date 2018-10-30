var curPage;
layui.use(['table', 'form'], function () {
  var table = layui.table, form = layui.form;

  tableIns = table.render({
    elem: '#list',
    url: '/api/invite/list',
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
      {
        fixed: 'left', field: 'descUserId', title: '被邀请人ID', width: 100, templet: function (d) {
          return d.descUserId ? d.descUserId : '-';
        }
      },
      {
        field: 'descRealName', title: '被邀请人姓名', width: 120, templet: function (d) {
          return d.descRealName ? d.descRealName : '-';
        }
      },
      {
        field: 'descPhone', title: '被邀请人手机', width: 120, templet: function (d) {
          return d.descPhone ? d.descPhone : '-';
        }
      },
      {
        field: 'descTaobaoAccount', title: '被邀请人淘宝账号', width: 200, templet: function (d) {
          return d.descTaobaoAccount ? d.descTaobaoAccount : '-';
        }
      },
      {
        field: 'userId', title: '邀请人ID', width: 100, templet: function (d) {
          return d.userId ? d.userId : '-';
        }
      },
      {
        field: 'realName', title: '邀请人姓名', width: 120, templet: function (d) {
          return d.realName ? d.realName : '-';
        }
      },
      {
        field: 'phone', title: '邀请人手机', width: 120, templet: function (d) {
          return d.phone ? d.phone : '-';
        }
      },
      {
        field: 'orderCount', title: '完成订单数', width: 100, templet: function (d) {
          return d.orderCount;
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
    var descPhone = $('#descPhone');
    var taobaoAccount = $('#taobaoAccount');

    tableIns.reload({
      where: {
        phone: phone.val(),
        descPhone: descPhone.val(),
        taobaoAccount: taobaoAccount.val()
      }
    });
    return false;
  });
});