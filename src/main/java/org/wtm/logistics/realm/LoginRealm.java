package org.wtm.logistics.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import org.wtm.logistics.model.Role;
import org.wtm.logistics.model.User;
import org.wtm.logistics.service.LoginService;

import java.util.HashSet;
import java.util.Set;

public class LoginRealm extends AuthorizingRealm {
    @Autowired
    LoginService loginService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user =(User) SecurityUtils.getSubject().getSession().getAttribute("user");
        Set<String> roles = new HashSet<String>();
        Role role = user.getRole();
        roles.add(role.getRolename());
        return new SimpleAuthorizationInfo(roles);
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String account =(String) authenticationToken.getPrincipal();
        User user=loginService.getUserByAccount(account);
        System.out.println(user.getPassword());
        if(user==null){
            System.out.println("null");
            throw new UnknownAccountException("账号不存在");
        }
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("user",user);
         ByteSource salts = ByteSource.Util.bytes(user.getAccount());
        return new SimpleAuthenticationInfo(user.getAccount(),user.getPassword(),salts,getName());
    }
}
