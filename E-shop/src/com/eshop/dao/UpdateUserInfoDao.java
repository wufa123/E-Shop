package com.eshop.dao;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.eshop.entity.User;
import com.eshop.units.DBFree;
import com.eshop.units.DBPoolConnection;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class UpdateUserInfoDao {

    Logger log = Logger.getLogger(UpdateUserInfoDao.class);

    /**
     * 检查用户名
     * @param userName
     * @return
     */
    public int checkUserName(String userName){
        int sum=-1;
        String sql="select userId from user where userName=?";
        DBPoolConnection dbp = DBPoolConnection.getInstance();
        DruidPooledConnection conn = null;
        PreparedStatement ptmt =null;
        ResultSet rs=null;
        try {
            conn=dbp.getConnection();
            ptmt=conn.prepareStatement(sql);
            ptmt.setObject(1,userName);
            rs=ptmt.executeQuery();
log.debug(userName);


            while (rs.next()){
                log.debug("读取rs+++++++");
                sum=rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBFree.free(conn,ptmt,rs);
        }
        return sum;
    }


    /**
     * 更新用户信息
     * @param user
     */
    public void updateUserInfo(User user){
        String sql="update user set userName=?,userTrueName=?,userPhone=?,userAddress=? where userId=?";

        DBPoolConnection dbp = DBPoolConnection.getInstance();
        DruidPooledConnection conn = null;
        PreparedStatement ptmt =null;

        try {
            conn=dbp.getConnection();

            ptmt=conn.prepareStatement(sql);
            ptmt.setObject(1,user.getUserName());
            ptmt.setObject(2,user.getUserTrueName());
            ptmt.setObject(3,user.getUserPhone());
            ptmt.setObject(4,user.getUserAddress());
            ptmt.setObject(5,user.getUserId());
            ptmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBFree.free(conn,ptmt);
        }
    }

    public void updateUserPwd(String newPwd,int userId){
        String sql="update user set userPassword=? where userId=?";
        DBPoolConnection dbp = DBPoolConnection.getInstance();
        DruidPooledConnection conn = null;
        PreparedStatement ptmt =null;

        try {
            conn=dbp.getConnection();
            ptmt=conn.prepareStatement(sql);
            ptmt.setObject(1,newPwd);
            ptmt.setObject(2,userId);
            ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBFree.free(conn,ptmt);
        }

    }
}
