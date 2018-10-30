var ROOT_PATH = '';

//封装jquery的ajax方法
var ajaxReq = function ($) {
  var url, params, _fun, _failFun, methodType;
  var args = arguments[1];
  url = args[1];
  if (typeof args[2] === 'object' || typeof args[2] === 'string') {
    params = args[2];
    _fun = args[3];
    _failFun = args[4];
  } else {
    params = {};
    _fun = args[2];
    _failFun = args[3];
  }
  methodType = arguments[2];
  $.ajax({
    url: ROOT_PATH + "/" + url,
    type: methodType,
    data: params,
    dataType: 'json',
    timeout: 30000,
    success: function (response) {
      if (response.code == 0) {
        _fun(response);
      } else {
        if (_failFun) {
          _failFun(response);
        } else if (typeof layui !== 'undefined' && layui.layer) {
          layui.layer.msg(response.msg || '系统异常');
        }
        return false;
      }
    },
    error: function (response) {
      // 处理302跳转
      if (response.status == 200) {
        top.location.reload();
      } else {
        if (typeof layui !== 'undefined' && layui.layer) {
          layui.layer.msg('系统异常');
        }
      }
    }
  });
};
var ajaxGet = function ($) {
  ajaxReq($, arguments, 'get');
};
var ajaxPost = function ($) {
  ajaxReq($, arguments, 'post');
};

function GetRequest() {
  var url = location.search; //获取url中"?"符后的字串
  var theRequest = {};
  if (url.indexOf("?") !== -1) {
    var str = url.substr(1);
    var strArr = str.split("&");
    for (var i = 0; i < strArr.length; i++) {
      theRequest[strArr[i].split("=")[0]] = decodeURI(strArr[i].split("=")[1]);
    }
  }
  return theRequest;
}

//填充表单
function FillForm($, $form, obj) {
  var key, value, tagName, type, arr;
  for (var x in obj) {
    key = x;
    value = obj[x];

    if (value === null || value === '') {
      continue;
    }

    $form.find("[name='" + key + "']").each(function () {
      tagName = $(this)[0].tagName;
      type = $(this).attr('type');
      if (tagName === 'INPUT') {
        if (type === 'radio') {
          $(this).attr('checked', $(this).val() == value);
        } else if (type === 'checkbox') {
          if (typeof value === 'string') {
            arr = value.split(';');
            for (var i = 0; i < arr.length; i++) {
              if ($(this).val() === arr[i]) {
                $(this).attr('checked', true);
                break;
              }
            }
          } else {
            $(this).attr('checked', $(this).val() == value);
          }

        } else {
          $(this).val(value);
        }
      } else if (tagName === 'SELECT' || tagName === 'TEXTAREA') {
        $(this).val(value);
      }
    });
  }
}

//扩展Date的format方法
Date.prototype.format = function (format) {
  var o = {
    "M+": this.getMonth() + 1,
    "d+": this.getDate(),
    "h+": this.getHours(),
    "m+": this.getMinutes(),
    "s+": this.getSeconds(),
    "q+": Math.floor((this.getMonth() + 3) / 3),
    "S": this.getMilliseconds()
  }
  if (/(y+)/.test(format)) {
    format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
  }
  for (var k in o) {
    if (new RegExp("(" + k + ")").test(format)) {
      format = format.replace(RegExp.$1, RegExp.$1.length === 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
    }
  }
  return format;
};

function FormatDate(dataStr) {
  return new Date(Number(dataStr)).format("yyyy-MM-dd");
}
function FormatDate2(dataStr) {
  return new Date(Number(dataStr)).format("yyyy-MM-dd hh:mm");
}
function FormatDate3(dataStr) {
  return new Date(Number(dataStr)).format("yyyy-MM-dd hh:mm:ss");
}

/**
 * 取值 为null时返回''
 */
function nvl(obj) {
  return (obj === null || obj === '') ? '' : obj;
}