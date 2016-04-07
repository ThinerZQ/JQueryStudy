
package com.zq.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SqlHelper {

	private static Connection ct =null;
	private static Statement sm =null;
	private static ResultSet rs =null;
	//连接数据库
	public static Connection getConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/any","root","193746");
		return ct;
	}
	//关闭连接
	public  static void closeResource(Connection ct,PreparedStatement ps,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ct!=null){
			try {
				ct.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
