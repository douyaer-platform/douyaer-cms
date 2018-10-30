package com.douyaer.cms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.douyaer.cms.model.Menu;
import com.douyaer.cms.model.Response;
import com.douyaer.cms.pojo.Admin;
// import com.douyaer.cms.redis.RedisClient;
import com.douyaer.cms.service.AdminService;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    // @Autowired
    // private RedisClient redisClient;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Response test() {
        // redisClient.cleanCache();
        return Response.success();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response login(@RequestParam("name") String name, @RequestParam("password") String password, HttpServletRequest request) {
        // 用户是否存在
        Admin admin = this.adminService.getAdminByName(name);
        if (admin == null) {
            return Response.error("该用户不存在，请您联系管理员");
        }
        // 用户登录
        try {
            // 1、 封装用户名、密码、是否记住我到token令牌对象 [支持记住我]
            AuthenticationToken token = new UsernamePasswordToken(name, DigestUtils.md5Hex(password));
            // 2、 Subject调用login
            Subject subject = SecurityUtils.getSubject();
            // 在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            // 每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            // 所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            subject.login(token);
            request.getSession().setAttribute("admin", admin);
            return Response.success();
        } catch (UnknownAccountException uae) {
            logger.error("用户登录，用户验证未通过：未知用户！admin=" + admin.getName(), uae);
            return Response.error("该用户不存在，请您联系管理员");
        } catch (IncorrectCredentialsException ice) {
            // 获取输错次数
            logger.error("用户登录，用户验证未通过：错误的凭证，密码输入错误！admin=" + admin.getName(), ice);
            return Response.error("用户名或密码不正确");
        } catch (LockedAccountException lae) {
            logger.error("用户登录，用户验证未通过：账户已锁定！admin=" + admin.getName(), lae);
            return Response.error("账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            logger.error("用户登录，用户验证未通过：错误次数大于5次,账户已锁定！admin=" + admin.getName(), eae);
            return Response.error("用户名或密码错误次数大于5次,账户已锁定!");
            // 这里结合了，另一种密码输错限制的实现，基于redis或mysql的实现；也可以直接使用RetryLimitHashedCredentialsMatcher限制5次
        } catch (AuthenticationException ae) {
            // 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            logger.error("用户登录，用户验证未通过：认证异常，异常信息如下！admin=" + admin.getName(), ae);
            return Response.error("用户名或密码不正确");
        } catch (Exception e) {
            logger.error("用户登录，用户验证未通过：操作异常，异常信息如下！admin=" + admin.getName(), e);
            return Response.error("用户登录失败，请您稍后再试");
        }
    }

    // 测试接口
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public Response updatePassword(@RequestParam("password") String password, @RequestParam("newPassword") String newPassword, HttpServletRequest request) {
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        if (admin == null) {
            return Response.error("用户不存在");
        }
        if (!DigestUtils.md5Hex(password).equals(admin.getPassword())) {
            return Response.error("旧密码错误");
        }
        admin.setPassword(DigestUtils.md5Hex(newPassword));
        adminService.updateAdmin(admin);
        return Response.success();
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public Response menu() {
        List<Menu> data = new ArrayList<Menu>();
        // 一级菜单
        data.add(new Menu(1, 0, "刷手管理", "/"));
        data.add(new Menu(2, 1, "认证审核", "/brushhand/certList"));
        data.add(new Menu(3, 1, "刷手列表", "/brushhand/list"));
        // 一级菜单
        data.add(new Menu(4, 0, "商家管理", "/"));
        data.add(new Menu(5, 4, "认证审核", "/business/certList"));
        data.add(new Menu(6, 4, "商家列表", "/business/list"));
        // 一级菜单
        data.add(new Menu(7, 0, "任务管理", "/"));
        data.add(new Menu(8, 7, "任务列表", "/task/list"));
        // 一级菜单
        data.add(new Menu(9, 0, "订单管理", "/"));
        data.add(new Menu(10, 9, "订单列表", "/order/list"));
        // 一级菜单
        data.add(new Menu(11, 0, "好友关系管理", "/"));
        data.add(new Menu(12, 11, "邀请好友关系列表", "/invite/list"));
        // 一级菜单
        data.add(new Menu(13, 0, "充值", "/"));
        data.add(new Menu(14, 13, "手动充值", "/deposit/add"));
        data.add(new Menu(15, 13, "充值记录", "/deposit/list"));
        // 一级菜单
        data.add(new Menu(16, 0, "提现", "/"));
        data.add(new Menu(17, 16, "手动提现", "/withdraw/add"));
        data.add(new Menu(18, 16, "提现记录", "/withdraw/list"));
        // 一级菜单
        data.add(new Menu(19, 0, "交易明细", "/"));
        data.add(new Menu(20, 19, "交易流水", "/coin/list"));
        // 一级菜单
        data.add(new Menu(21, 0, "消息通知管理", "/"));
        data.add(new Menu(22, 21, "消息通知", "/notice/edit"));
        // 一级菜单
        data.add(new Menu(23, 0, "投诉管理", "/"));
        data.add(new Menu(24, 23, "投诉列表", "/complaint/list"));
        return Response.success(data);
    }

}