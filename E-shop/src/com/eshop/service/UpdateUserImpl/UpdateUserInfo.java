package com.eshop.service.UpdateUserImpl;

import com.eshop.dao.UserDao.UpdateUserInfoDao;
import com.eshop.entity.User;
import com.eshop.service.UpdateUserService;

/**
 * 更新用户信息
 */
public class UpdateUserInfo implements UpdateUserService {
    @Override
    public void updateUserInfo(User user) {
        UpdateUserInfoDao uinfo = new UpdateUserInfoDao();
        uinfo.updateUserInfo(user);

    }
}
