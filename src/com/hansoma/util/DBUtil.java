package com.hansoma.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.hansoma.model.Users;

public class DBUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(DBUtil.con() != null) {
			System.out.println("Success.");
		}else {
			System.out.println("Failure.");
		}
		

	}
	
	public static final String driver = "com.mysql.jdbc.Driver";
	public static final String url = "jdbc:mysql://mty1998.top:3306/proj?characterEncoding=utf8&useSSL=true";
//	public static final String url = "jdbc:mysql://localhost:3306/users";
	
	public static final String userName = "root";
	public static final String Pass = "123456";
	
	
	static {
		//加载驱动
		try {
			Class.forName(driver);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	//获取连接
	public static Connection con(){
		try {
			return DriverManager.getConnection(url,userName,Pass);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//关闭连接
	public static void closeCon(ResultSet rs,PreparedStatement pstmt,Connection con) {
		
		//结果集不为空就关闭
		try {
			if(rs != null) {
				rs.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//关闭预编译对象
		try {
			if(pstmt != null) {
				pstmt.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//关闭结果集对象
		try {
			if(con != null) {
				con.close();
			} 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//get data from database users
	public static List<Users> getData(String tableName) {
		List<Users> result = null;
		
		try {
			Connection con = DBUtil.con();
			//创建statement对象执行mysql命令
			Statement statement = con.createStatement();
			//命令语句
			String sql = "select * from " + tableName;
			//result对象用于存储结果
			ResultSet rs = statement.executeQuery(sql);
			result = new ArrayList<Users>();
			
			//查找结果
			while(rs.next()) {
				
				//表中元素
				int id = 0;
				String userName = null;
				String password = null;
				Users gt = new Users();

				//获取id,userName和password
				id = rs.getInt("id");
				gt.setId(id);
				userName = rs.getString("username");
				gt.setUserName(userName);
				password = rs.getString("password");
				gt.setPassword(password);
				result.add(gt);
			}
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	//insert into table
	public static boolean insertIntoTable(String tablename, int Id, String userName, String Password) {
		boolean flag = false;
		try {
			Connection con = DBUtil.con();
			//创建statement对象执行mysql命令
			Statement statement = con.createStatement();
			//命令语句
			String sql = "insert into " + tablename
						+ " values(" + String.valueOf(Id) + ",'" 
						+ userName + "','" + Password + "')";
			statement.execute(sql);
			flag = true;		
		}catch(Exception e) {
			flag = false;
			//e.printStackTrace();
		}
		return flag;
	}

	//delete from table
	public static boolean deleteFromTable(String tablename,String ID) {
		boolean flag = false;
		try {
			Connection con = DBUtil.con();
			//创建statement对象执行mysql命令
			Statement statement = con.createStatement();
			//命令语句
			String sql = "delete from " + tablename
					+ " where id = " + "'" + ID + "'";
			statement.execute(sql);
			flag = true;
			
		}catch(Exception e) {
			flag = false;
		}
		return flag;
	}

	
	
}
