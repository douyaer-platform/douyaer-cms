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
    url: '/api/order/list',
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
      { fixed: 'left', field: 'orderId', title: '订单编号', width: 100, unresize: true, sort: true },
      {
        field: 'userId', title: '刷手ID', width: 100, align: 'center', templet: function (d) {
          return d.userId ? d.userId : '-';
        }
      },
      {
        field: 'phone', title: '刷手手机号码', width: 120, align: 'center', templet: function (d) {
          return d.phone ? d.phone : '-';
        }
      },
      {
        field: 'busUserId', title: '商家ID', width: 100, align: 'center', templet: function (d) {
          return d.busUserId ? d.busUserId : '-';
        }
      },
      {
        field: 'busPhone', title: '商家手机号码', width: 120, align: 'center', templet: function (d) {
          return d.busPhone ? d.busPhone : '-';
        }
      },
      {
        field: 'busTaobaoAccount', title: '商家店铺', width: 100, templet: function (d) {
          return d.busTaobaoAccount ? d.busTaobaoAccount : '-';
        }
      },
      {
        field: 'goodsUrl', title: '宝贝链接', width: 100, templet: function (d) {
          return d.goodsUrl ? '<a href="' + d.goodsUrl + '" target="_blank">详情</a>' : '-';
        }
      },
      {
        field: 'goodsPrice', title: '订单垫付金额', width: 120, templet: function (d) {
          return d.goodsPrice;
        }
      },
      {
        field: 'orderPrice', title: '订单收益', width: 120, templet: function (d) {
          return d.orderPrice - d.goodsPrice - 2;
        }
      },
      {
        field: 'createTime', title: '时间', width: 200, templet: function (d) {
          return d.createTime ? d.createTime : '-无';
        }
      },
      {
        field: 'status', title: '状态', width: 80, templet: function (d) {
          return d.status == -1 ? '已取消' : d.status == 0 ? '待完成' : d.status == 1 ? '待商家发布评价' : d.status == 2 ? '待刷手评价' : d.status == 3 ? '待放款' : d.status == 4 ? '已结束' : '-无';
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
    if (obj.event === 'detail') {
      var width = parseInt($(document).width() * 0.8) + 'px';
      var height = parseInt($(document).height() * 0.8) + 'px';

      $("#storeName").text(data.storeName ? data.storeName : '-');
      $("#goodsUrl").html(data.goodsUrl ? '<a href="' + data.goodsUrl + '" target="_blank">详情</a>' : '-');
      $("#goodsPicUrl").html(data.goodsPicUrl ? '<a href="' + data.goodsPicUrl + '" target="_blank">详情</a>' : '-');
      $("#taskSearchPicUrl").html(data.taskSearchPicUrl ? '<a href="' + data.taskSearchPicUrl + '" target="_blank">详情</a>' : '-');
      $("#conditionPicUrl").html(data.conditionPicUrl ? '<a href="' + data.conditionPicUrl + '" target="_blank">详情</a>' : '-');
      $("#goodsPrice").text(data.goodsPrice ? data.goodsUrl : '-');
      $("#tags").text(data.tags ? data.tags : '-');
      $("#buyBackType").text(data.buyBackType == 0 ? '无需回购' : data.buyBackType == 1 ? '加入收藏后3-5天内回购' : data.buyBackType == 2 ? '关注店铺后6-10天内回购' : '-');
      $("#needAlitm").text(data.needAlitm == 0 ? '不需要' : data.needAlitm == 1 ? '需要' : '-');

      $("#phoneDetail").text(data.phone ? data.phone : '-');
      $("#taobaoAccount").text(data.taobaoAccount ? data.taobaoAccount : '-');
      $("#busPhoneDetail").text(data.busPhone ? data.busPhone : '-');
      $("#busTaobaoAccount").text(data.busTaobaoAccount ? data.busTaobaoAccount : '-');

      $("#createTime").text(data.createTime ? data.createTime : '-');
      $("#submitOrderTime").text(data.submitOrderTime ? data.submitOrderTime : '-');
      $("#businessRemarkTime").text(data.businessRemarkTime ? data.businessRemarkTime : '-');
      $("#brushhandRemarkTime").text(data.brushhandRemarkTime ? data.brushhandRemarkTime : '-');
      $("#sendMoneyTime").text(data.sendMoneyTime ? data.sendMoneyTime : '-');

      data.ipScreenshotUrl ? $('#img_ipScreenshotUrl').attr('src', data.ipScreenshotUrl).show() : $('#img_ipScreenshotUrl').hide();
      $("#ipScreenshotUrl").html(data.ipScreenshotUrl ? '<a href="' + data.ipScreenshotUrl + '" target="_blank">IP地址图</a>' : '<a href="#" style="text-decoration:line-through">IP地址图</a>');
      data.searchPicUrl ? $('#img_searchPicUrl').attr('src', data.searchPicUrl).show() : $('#img_searchPicUrl').hide();
      $("#searchPicUrl").html(data.searchPicUrl ? '<a href="' + data.searchPicUrl + '" target="_blank">搜索图</a>' : '<a href="#" style="text-decoration:line-through">搜索图</a>');
      data.comparePicUrl1 ? $('#img_comparePicUrl1').attr('src', data.comparePicUrl1).show() : $('#img_comparePicUrl1').hide();
      $("#comparePicUrl1").html(data.comparePicUrl1 ? '<a href="' + data.comparePicUrl1 + '" target="_blank">对比图一</a>' : '<a href="#" style="text-decoration:line-through">对比图一</a>');
      data.comparePicUrl2 ? $('#img_comparePicUrl2').attr('src', data.comparePicUrl2).show() : $('#img_comparePicUrl2').hide();
      $("#comparePicUrl2").html(data.comparePicUrl2 ? '<a href="' + data.comparePicUrl2 + '" target="_blank">对比图二</a>' : '<a href="#" style="text-decoration:line-through">对比图二</a>');
      data.comparePicUrl3 ? $('#img_comparePicUrl3').attr('src', data.comparePicUrl3).show() : $('#img_comparePicUrl3').hide();
      $("#comparePicUrl3").html(data.comparePicUrl3 ? '<a href="' + data.comparePicUrl3 + '" target="_blank">对比图三</a>' : '<a href="#" style="text-decoration:line-through">对比图三</a>');
      data.enterStoreUrl ? $('#img_enterStoreUrl').attr('src', data.enterStoreUrl).show() : $('#img_enterStoreUrl').hide();
      $("#enterStoreUrl").html(data.enterStoreUrl ? '<a href="' + data.enterStoreUrl + '" target="_blank">入店图</a>' : '<a href="#" style="text-decoration:line-through">入店图</a>');
      data.favoriteAttentionEntershopUrl ? $('#img_favoriteAttentionEntershopUrl').attr('src', data.favoriteAttentionEntershopUrl).show() : $('#img_favoriteAttentionEntershopUrl').hide();
      $("#favoriteAttentionEntershopUrl").html(data.favoriteAttentionEntershopUrl ? '<a href="' + data.favoriteAttentionEntershopUrl + '" target="_blank">关注店铺图</a>' : '<a href="#" style="text-decoration:line-through">关注店铺图</a>');
      data.favoriteAttentionUrl ? $('#img_favoriteAttentionUrl').attr('src', data.favoriteAttentionUrl).show() : $('#img_favoriteAttentionUrl').hide();
      $("#favoriteAttentionUrl").html(data.favoriteAttentionUrl ? '<a href="' + data.favoriteAttentionUrl + '" target="_blank">收藏宝贝图</a>' : '<a href="#" style="text-decoration:line-through">收藏宝贝图</a>');
      data.viewRemarkUrl ? $('#img_viewRemarkUrl').attr('src', data.viewRemarkUrl).show() : $('#img_viewRemarkUrl').hide();
      $("#viewRemarkUrl").html(data.viewRemarkUrl ? '<a href="' + data.viewRemarkUrl + '" target="_blank">查看评论图</a>' : '<a href="#" style="text-decoration:line-through">查看评论图</a>');
      data.viewBuyershowUrl ? $('#img_viewBuyershowUrl').attr('src', data.viewBuyershowUrl).show() : $('#img_viewBuyershowUrl').hide();
      $("#viewBuyershowUrl").html(data.viewBuyershowUrl ? '<a href="' + data.viewBuyershowUrl + '" target="_blank">查看买家秀图</a>' : '<a href="#" style="text-decoration:line-through">查看买家秀图</a>');
      data.detailPageUrl ? $('#img_detailPageUrl').attr('src', data.detailPageUrl).show() : $('#img_detailPageUrl').hide();
      $("#detailPageUrl").html(data.detailPageUrl ? '<a href="' + data.detailPageUrl + '" target="_blank">详情页面图</a>' : '<a href="#" style="text-decoration:line-through">详情页面图</a>');
      data.detailPageBottomUrl ? $('#img_detailPageBottomUrl').attr('src', data.detailPageBottomUrl).show() : $('#img_detailPageBottomUrl').hide();
      $("#detailPageBottomUrl").html(data.detailPageBottomUrl ? '<a href="' + data.detailPageBottomUrl + '" target="_blank">详情页面底部图</a>' : '<a href="#" style="text-decoration:line-through">详情页面底部图</a>');
      data.homePageUrl ? $('#img_homePageUrl').attr('src', data.homePageUrl).show() : $('#img_homePageUrl').hide();
      $("#homePageUrl").html(data.homePageUrl ? '<a href="' + data.homePageUrl + '" target="_blank">首页查看图</a>' : '<a href="#" style="text-decoration:line-through">首页查看图</a>');
      data.viewAllGoodsUrl ? $('#img_viewAllGoodsUrl').attr('src', data.viewAllGoodsUrl).show() : $('#img_viewAllGoodsUrl').hide();
      $("#viewAllGoodsUrl").html(data.viewAllGoodsUrl ? '<a href="' + data.viewAllGoodsUrl + '" target="_blank">查看所有宝贝图</a>' : '<a href="#" style="text-decoration:line-through">查看所有宝贝图</a>');
      data.viewOtherGoodsUrl ? $('#img_viewOtherGoodsUrl').attr('src', data.viewOtherGoodsUrl).show() : $('#img_viewOtherGoodsUrl').hide();
      $("#viewOtherGoodsUrl").html(data.viewOtherGoodsUrl ? '<a href="' + data.viewOtherGoodsUrl + '" target="_blank">查看其它宝贝图</a>' : '<a href="#" style="text-decoration:line-through">查看其它宝贝图</a>');
      data.chatUrl ? $('#img_chatUrl').attr('src', data.chatUrl).show() : $('#img_chatUrl').hide();
      $("#chatUrl").html(data.chatUrl ? '<a href="' + data.chatUrl + '" target="_blank">咨询图</a>' : '<a href="#" style="text-decoration:line-through">咨询图</a>');
      data.buyGoodsUrl ? $('#img_buyGoodsUrl').attr('src', data.buyGoodsUrl).show() : $('#img_buyGoodsUrl').hide();
      $("#buyGoodsUrl").html(data.buyGoodsUrl ? '<a href="' + data.buyGoodsUrl + '" target="_blank">拍下宝贝图</a>' : '<a href="#" style="text-decoration:line-through">拍下宝贝图</a>');
      data.finishOrderUrl ? $('#img_finishOrderUrl').attr('src', data.finishOrderUrl).show() : $('#img_finishOrderUrl').hide();
      $("#finishOrderUrl").html(data.finishOrderUrl ? '<a href="' + data.finishOrderUrl + '" target="_blank">完成订单图</a>' : '<a href="#" style="text-decoration:line-through">完成订单图</a>');
      data.backBuyImg1 ? $('#img_backBuyImg1').attr('src', data.backBuyImg1).show() : $('#img_backBuyImg1').hide();
      $("#backBuyImg1").html(data.backBuyImg1 ? '<a href="' + data.backBuyImg1 + '" target="_blank">回购图1</a>' : '<a href="#" style="text-decoration:line-through">回购图1</a>');
      data.backBuyImg2 ? $('#img_backBuyImg2').attr('src', data.backBuyImg2).show() : $('#img_backBuyImg2').hide();
      $("#backBuyImg2").html(data.backBuyImg2 ? '<a href="' + data.backBuyImg2 + '" target="_blank">回购图2</a>' : '<a href="#" style="text-decoration:line-through">回购图2</a>');
      data.backBuyImg3 ? $('#img_backBuyImg3').attr('src', data.backBuyImg3).show() : $('#img_backBuyImg3').hide();
      $("#backBuyImg3").html(data.backBuyImg3 ? '<a href="' + data.backBuyImg3 + '" target="_blank">回购图3</a>' : '<a href="#" style="text-decoration:line-through">回购图3</a>');
      data.backBuyImg4 ? $('#img_backBuyImg4').attr('src', data.backBuyImg4).show() : $('#img_backBuyImg4').hide();
      $("#backBuyImg4").html(data.backBuyImg4 ? '<a href="' + data.backBuyImg4 + '" target="_blank">回购图4</a>' : '<a href="#" style="text-decoration:line-through">回购图4</a>');
      data.backBuyImg5 ? $('#img_backBuyImg5').attr('src', data.backBuyImg5).show() : $('#img_backBuyImg5').hide();
      $("#backBuyImg5").html(data.backBuyImg5 ? '<a href="' + data.backBuyImg5 + '" target="_blank">回购图5</a>' : '<a href="#" style="text-decoration:line-through">回购图5</a>');

      $("#businessRemarkDes").text(data.businessRemarkDes ? '商家评论：' + data.businessRemarkDes : '商家评论：-');
      data.buyershowUrl1 ? $('#img_buyershowUrl1').attr('src', data.buyershowUrl1).show() : $('#img_buyershowUrl1').hide();
      $("#buyershowUrl1").html(data.buyershowUrl1 ? '<a href="' + data.buyershowUrl1 + '" target="_blank">买家秀图1</a>' : '<a href="#" style="text-decoration:line-through">买家秀图1</a>');
      data.buyershowUrl2 ? $('#img_buyershowUrl2').attr('src', data.buyershowUrl2).show() : $('#img_buyershowUrl2').hide();
      $("#buyershowUrl2").html(data.buyershowUrl2 ? '<a href="' + data.buyershowUrl2 + '" target="_blank">买家秀图2</a>' : '<a href="#" style="text-decoration:line-through">买家秀图2</a>');
      data.buyershowUrl3 ? $('#img_buyershowUrl3').attr('src', data.buyershowUrl3).show() : $('#img_buyershowUrl3').hide();
      $("#buyershowUrl3").html(data.buyershowUrl3 ? '<a href="' + data.buyershowUrl3 + '" target="_blank">买家秀图3</a>' : '<a href="#" style="text-decoration:line-through">买家秀图3</a>');

      data.finishRemarkUrl ? $('#img_finishRemarkUrl').attr('src', data.finishRemarkUrl).show() : $('#img_finishRemarkUrl').hide();
      $("#finishRemarkUrl").html(data.finishRemarkUrl ? '<a href="' + data.finishRemarkUrl + '" target="_blank">完成评论截图</a>' : '<a href="#" style="text-decoration:line-through">完成评论截图</a>');

      layer.open({
        type: 1,
        title: '订单编号：' + data.orderId + '的详情',
        area: [width, height],
        skin: 'layui-layer-prompt',
        content: $('#detail').html(),
        scrollbar: true
      });
    } else if (obj.event === 'cancel') {
      console.log("cancel")
      layer.confirm("确定取消订单？", function (index) {
        layer.close(index);
        cancel(tableIns, data.orderId);
      });
    }
  });
  // 搜索
  form.on('submit(search)', function (data) {
    var phone = $('#phone');
    var busPhone = $('#busPhone');
    var orderId = $('#orderId');
    var status = $('#status');
    var start = $('#start');
    var end = $('#end');

    tableIns.reload({
      where: {
        phone: phone.val(),
        busPhone: busPhone.val(),
        orderId: orderId.val(),
        status: status.val(),
        start: start.val(),
        end: end.val()
      }
    });
    return false;
  });
});

function cancel(tableIns, orderId) {
  var params = {};
  params.orderId = orderId;
  ajaxPost($, 'api/order/cancel', params,
    function (response) {
      var msg = '取消成功';
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
      var msg = response.msg
      layer.confirm(msg, function (index) {
        layer.close(index);
      });
    }
  );
}