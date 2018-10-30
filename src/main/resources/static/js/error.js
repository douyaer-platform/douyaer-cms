var time = 5;
var timeJob;

$(function () {
  redirect();
})

function redirect() {
  if (time == 0) {
    window.location.href = "/index";
  } else {
    $("#error").html('出错了...<span style="color:red;">' + time + 's</span>后回到<a href="/index" style="color: blue; text-decoration: underline;">首页</a>');
    time--;
    timeJob = setTimeout(function () {
      redirect();
    }, 1000)
  }
}