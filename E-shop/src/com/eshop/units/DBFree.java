package com.eshop.units;

import com.alibaba.druid.pool.DruidPooledConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 关闭接口工具类
 */
public  class   DBFree {

     public static void free(DruidPooledConnection conn, PreparedStatement ptmt){
          if (conn!=null){
              try {
                  conn.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }

          if (ptmt!=null){
              try {
                  ptmt.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }
     }

     public static void free(DruidPooledConnection conn, PreparedStatement ptmt, ResultSet rs){
         if (conn!=null){
             try {
                 conn.close();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }
         if (ptmt!=null){
             try {
                 ptmt.close();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }
         if (rs!=null){
             try {
                 rs.close();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }
     }
}
