package com.douyaer.cms.shiro;

import com.douyaer.cms.dao.AdminMapper;
import com.douyaer.cms.pojo.Admin;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 授予角色和权限
     * 
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 授权
        logger.debug("授予角色和权限");
        // 添加权限 和 角色信息
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 获取当前登陆用户
        // Subject subject = SecurityUtils.getSubject();
        // Admin admin = (Admin) subject.getPrincipal();
        authorizationInfo.addRole("*");
        authorizationInfo.addStringPermission("*");
        return authorizationInfo;
    }

    /**
     * 登录认证
     * 
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        // UsernamePasswordToken用于存放提交的登录信息
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        logger.info("用户登录认证：验证当前Subject时获取到token为："
                + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
        String username = token.getUsername();
        // 调用数据层
        Admin admin = adminMapper.getAdminByName(username);

        logger.debug("用户登录认证！用户信息user：" + admin);
        if (admin == null) {
            // 用户不存在
            return null;
        } else {
            // 密码存在
            // 第一个参数 ，登陆后，需要在session保存数据
            // 第二个参数，查询到密码(加密规则要和自定义的HashedCredentialsMatcher中的HashAlgorithmName散列算法一致)
            // 第三个参数 ，realm名字
            return new SimpleAuthenticationInfo(admin, DigestUtils.md5Hex(admin.getPassword()), getName());
        }
    }

    /**
     * 设置认证加密方式
     */
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher md5CredentialsMatcher = new HashedCredentialsMatcher();
        md5CredentialsMatcher.setHashAlgorithmName("MD5");
        // md5CredentialsMatcher.setHashIterations(ShiroKit.hashIterations);
        super.setCredentialsMatcher(md5CredentialsMatcher);
    }

}
