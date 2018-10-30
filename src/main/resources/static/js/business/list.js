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
    url: '/api/business/list',
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
      { fixed: 'left', field: 'userId', title: 'ID', width: 80, unresize: true, sort: true },
      {
        field: 'realName', title: '姓名', width: 100, templet: function (d) {
          return d.realName ? d.realName : '-';
        }
      },
      {
        field: 'identifyNo', title: '身份证', width: 200, templet: function (d) {
          return d.identifyNo ? d.identifyNo : '-';
        }
      },
      {
        field: 'phone', title: '手机号码', width: 120, templet: function (d) {
          return d.phone ? d.phone : '-';
        }
      },
      {
        field: 'taobaoAccount', title: '淘宝账号', width: 200, templet: function (d) {
          return d.taobaoAccount ? d.taobaoAccount : '-';
        }
      },
      {
        field: 'alitm', title: '旺旺名', width: 200, templet: function (d) {
          return d.alitm ? d.alitm : '-';
        }
      },
      {
        field: 'storeUrl', title: '店铺链接', width: 100, templet: function (d) {
          return d.storeUrl ? '<a href="' + d.storeUrl + '" target="_blank">详情</a>' : '-';
        }
      },
      {
        field: 'coin', title: '可用金币/冻结金币', width: 160, templet: function (d) {
          return d.coin + '/' + d.freezeCoin;
        }
      },
      {
        field: 'integral', title: '积分', width: 100, templet: function (d) {
          return d.integral ? d.integral : '-';
        }
      },
      {
        field: 'createTime', title: '注册时间', width: 200, templet: function (d) {
          return d.createTime ? d.createTime : '-';
        }
      },
      {
        field: 'status', title: '状态', width: 80, templet: function (d) {
          return d.status == 0 ? '正常' : d.status == 1 ? '已拉黑' : '-';
        }
      },
      { fixed: 'right', title: '操作', width: 260, align: 'center', toolbar: '#operate' }
    ]],
    done: function (res, curr, count) {
      //res即为：data当前页数据、count为数据总长度、curr为当前页
      curPage = curr;
    }
  });
  //监听工具条
  table.on('tool(list)', function (obj) {
    var data = obj.data;
    if (obj.event === 'blacklist') {
      layer.confirm("是否加入黑名单？", function (index) {
        layer.close(index);
        blacklist(tableIns, data.userId);
      });
    } else if (obj.event === 'notblacklist') {
      layer.confirm("是否取消黑名单？", function (index) {
        layer.close(index);
        notblacklist(tableIns, data.userId);
      });
    } else if (obj.event === 'addIntegral') {
      layer.open({
        type: 1,
        btn: ["确定", "取消"],
        title: '为' + data.phone + '增加积分',
        skin: 'layui-layer-prompt',
        content: "<div><input id='integral' type='text' class='layui-layer-input' value='' placeholder='请输入增加的积分（整数）'></div>",
        yes: function (index, layeropen) {
          var integral = $(layeropen).find("input[id='integral']").val();
          if (parseInt(integral) != integral || integral.indexOf(".") != -1) {
            layer.confirm("请输入整数？", function (index) {
              layer.close(index);
            });
            return;
          }
          integral = parseInt(integral);
          if (integral <= 0) {
            layer.confirm("请输入大于0的整数？", function (index) {
              layer.close(index);
            });
            return;
          }
          layer.close(index);
          addIntegral(data.userId, integral);
        }
      });
    } else if (obj.event === 'removeIntegral') {
      layer.open({
        type: 1,
        btn: ["确定", "取消"],
        title: '为' + data.phone + '减扣积分',
        skin: 'layui-layer-prompt',
        content: "<div><input id='integral' type='text' class='layui-layer-input' value='' placeholder='请输入减扣的积分（整数）'></div>",
        yes: function (index, layeropen) {
          var integral = $(layeropen).find("input[id='integral']").val();
          if (parseInt(integral) != integral || integral.indexOf(".") != -1) {
            layer.confirm("请输入整数？", function (index) {
              layer.close(index);
            });
            return;
          }
          integral = parseInt(integral);
          if (integral <= 0) {
            layer.confirm("请输入大于0的整数？", function (index) {
              layer.close(index);
            });
            return;
          }
          layer.close(index);
          removeIntegral(data.userId, integral);
        }
      });
    }
  });
  // 搜索
  form.on('submit(search)', function (data) {
    var phone = $('#phone');
    var alitm = $('#alitm');
    var start = $('#start');
    var end = $('#end');

    tableIns.reload({
      where: {
        phone: phone.val(),
        alitm: alitm.val(),
        start: start.val(),
        end: end.val()
      }
    });
    return false;
  });
});

function blacklist(tableIns, id) {
  var params = {};
  params.id = id;
  ajaxPost($, 'api/business/blacklist', params,
    function (response) {
      tableIns.reload({
        page: {
          curr: curPage
        }
      });
      layer.confirm('加入黑名单成功', function (index) {
        layer.close(index);
      });
    },
    function (response) {
      layer.confirm('加入黑名单失败', function (index) {
        layer.close(index);
      });
    }
  );
}

function notblacklist(tableIns, id) {
  var params = {};
  params.id = id;
  ajaxPost($, 'api/business/notblacklist', params,
    function (response) {
      tableIns.reload({
        page: {
          curr: curPage
        }
      });
      layer.confirm('取消黑名单成功', function (index) {
        layer.close(index);
      });
    },
    function (response) {
      layer.confirm('取消黑名单失败', function (index) {
        layer.close(index);
      });
    }
  );
}

function addIntegral(id, integral) {
  var params = {};
  params.id = id;
  params.integral = integral;
  ajaxPost($, 'api/business/addIntegral', params,
    function (response) {
      layer.confirm('增加积分成功', function (index) {
        layer.close(index);
      });
    },
    function (response) {
      layer.confirm('增加积分失败', function (index) {
        layer.close(index);
      });
    }
  );
}

function removeIntegral(id, integral) {
  var params = {};
  params.id = id;
  params.integral = integral;
  ajaxPost($, 'api/business/removeIntegral', params,
    function (response) {
      layer.confirm('减扣积分成功', function (index) {
        layer.close(index);
      });
    },
    function (response) {
      layer.confirm('减扣积分失败', function (index) {
        layer.close(index);
      });
    }
  );
}