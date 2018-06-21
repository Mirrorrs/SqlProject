package com.hansoma.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hansoma.util.DBUtil;
import com.hansoma.dao.UsersDAO;
import com.hansoma.model.Users;

public class UsersDAOIMPL implements UsersDAO{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// 查看所有用户的信息
	@Override
	public List<Users> UsersSelect() {
		List<Users> result = null;
		try {
			Connection con = DBUtil.con();
			//创建statement对象执行mysql命令
			Statement statement = con.createStatement();
			//命令语句
			String sql = "select * from Users";
			ResultSet rs = statement.executeQuery(sql);
			result = new ArrayList<Users>();
			
			// 查找结果并保存
			while (rs.next()) {
				
				// 添加列表中元素
				Users u = new Users();
				u.setId(rs.getInt("id"));
				u.setUserName(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				result.add(u);
			}
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public boolean UsersInsert() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean UsersDelete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean UsersAlter() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Users> getData(String tableName) {
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

	@Override
	public boolean insertIntoTable(String tablename, int Id, String userName, String Password) {
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

	@Override
	public boolean deleteFromTable(String tableName, String Id) {
		boolean flag = false;
		try {
			Connection con = DBUtil.con();
			//创建statement对象执行mysql命令
			Statement statement = con.createStatement();
			//命令语句
			String sql = "delete from " + tableName
					+ " where id = " + "'" + Id + "'";
			statement.execute(sql);
			flag = true;
			
		}catch(Exception e) {
			flag = false;
		}
		return flag;
	}

}
