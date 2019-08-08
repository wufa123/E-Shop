package com.eshop.service;

import com.eshop.entity.User;

/**
 * 更新用户接口
 */
public interface UpdateUserService {
    /**
     * 检查用户名
     * @param userName
     * @return
     */
    public int checkUserName(String userName);

    /**
     * 更新用户信息
     * @param user
     */
        public void updateUserInfo(User user);

        public void updateUserPwd(String newPwd,int userId);
}
