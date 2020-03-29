package org.wtm.logistics.utils;

import org.apache.shiro.SecurityUtils;
import org.wtm.logistics.model.User;

public class UserUtils {

    public  static User getCurrentUser(){
        return (User) SecurityUtils.getSubject().getSession().getAttribute("user");
    }
}
