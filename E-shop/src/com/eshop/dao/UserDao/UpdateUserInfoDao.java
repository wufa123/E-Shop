package com.eshop.dao.UserDao;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.eshop.entity.User;
import com.eshop.units.DBFree;
import com.eshop.units.DBPoolConnection;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUserInfoDao {

    Logger log = Logger.getLogger(UpdateUserInfoDao.class);
    public void updateUserInfo(User user){
        String sql="update user set userName=?,userTrueName=?,userPhone=?,userAddress=? where userId=?";
        log.debug(sql);
        DBPoolConnection dbp = DBPoolConnection.getInstance();
        DruidPooledConnection conn = null;
        PreparedStatement ptmt =null;

        try {
            conn=dbp.getConnection();
            log.debug("conn   "+conn);
            ptmt=conn.prepareStatement(sql);
            ptmt.setObject(1,user.getUserName());
            ptmt.setObject(2,user.getUserTrueName());
            ptmt.setObject(3,user.getUserPhone());
            ptmt.setObject(4,user.getUserAddress());
            ptmt.setObject(5,user.getUserId());
            ptmt.executeUpdate();
            log.debug("the end");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBFree.free(conn,ptmt);
        }
    }
}
