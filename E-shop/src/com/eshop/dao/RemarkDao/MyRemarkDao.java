package com.eshop.dao.RemarkDao;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.eshop.entity.Remark;
import com.eshop.units.DBFree;
import com.eshop.units.DBPoolConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyRemarkDao {

    public List<Remark> queryMyRemark(int userId){
        List<Remark> list = new ArrayList<Remark>();
        DBPoolConnection dbp = DBPoolConnection.getInstance();
        DruidPooledConnection conn = null;
        PreparedStatement ptmt =null;
        ResultSet rs = null;
        try {
            conn=dbp.getConnection();
            conn.setAutoCommit(false);
            //根据用户id查出所有有关评论
            String remarksql="select * from remark where userId=?;";
            ptmt = conn.prepareStatement(remarksql);
            ptmt.setObject(1,userId);
            rs=ptmt.executeQuery();
            while (rs.next()){
                Remark remark = new Remark();
                remark.setRemarkId(rs.getInt(1));
                remark.setUserId(rs.getInt(2));
                remark.setUserName(rs.getString(3));
                remark.setRemark(rs.getString(4));
                remark.setRemarkLevel(rs.getString(5));
                remark.setRemarTime(rs.getDate(6));
                remark.setOrderId(rs.getInt(7));
//                remark.setGoodsName(rs.getString(8));
//                remark.setStoreName(rs.getString(9));
                list.add(remark);
            }

            //根据订单id去查商品和店铺
            String sql="select goodsName,storeName from orders where orderId=?";
            ptmt=conn.prepareStatement(sql);
            for (int i=0;i<list.size();i++){
                Remark rk=list.get(i);
                ptmt.setObject(1,rk.getOrderId());
                rs = ptmt.executeQuery();
                while(rs.next()){
                    rk.setGoodsName(rs.getString(1));
                    rk.setStoreName(rs.getString(2));
                }
                list.set(i,rk);
            }
           conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            DBFree.free(conn,ptmt,rs);
        }

      return list;
    }

    public void updateRemark(int remarkId, String remark, String remarkLevel){
        String sql="update remark set remark=?,remarkLevel=? where remarkId=?";
        DBPoolConnection dbp = DBPoolConnection.getInstance();
        DruidPooledConnection conn = null;
        PreparedStatement ptmt =null;
        try {
            conn=dbp.getConnection();
            ptmt=conn.prepareStatement(sql);
            ptmt.setObject(1,remark);
            ptmt.setObject(2,remarkLevel);
            ptmt.setObject(3,remarkId);
            ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBFree.free(conn,ptmt);
        }
    }


    public void deleteRemark(int remarkId){
        String sql="delete from remark where remarkId=?";
        DBPoolConnection dbp = DBPoolConnection.getInstance();
        DruidPooledConnection conn = null;
        PreparedStatement ptmt =null;
        try {
            conn=dbp.getConnection();
            ptmt=conn.prepareStatement(sql);
            ptmt.setObject(1,remarkId);
            ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBFree.free(conn,ptmt);
        }
    }
}
