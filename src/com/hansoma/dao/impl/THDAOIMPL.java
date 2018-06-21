package com.hansoma.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hansoma.dao.*;
import com.hansoma.model.TH;
import com.hansoma.util.DBUtil;


public class THDAOIMPL implements THDAO{

	@Override
	public boolean thInsert(int ID, String Name, int Storage, int Price, String Owner, 
							String Date, String Type) {
		boolean flag = false;
		try {
			Connection con = DBUtil.con();
			// 创建statement 对象执行mysql命令
			Statement statement = con.createStatement();
			// 编写命令语句
			String id = Integer.toString(ID);
			String storage = Integer.toString(Storage);
			String price = Integer.toString(Price);
			
			String sql = "insert into REG values(" + id + ", '" +
						Name + "', " + storage + ", " + price +
						", '" + Owner + "', '" + Date + "', '" + Type +"')";
			System.out.println(sql);
			
			// 执行语句
			statement.execute(sql);
			flag = true;
		} catch(Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args) {
		int ID = 2;
		String Name = "GLOCK18|Moonrise";
		int Storage = 2;
		int Price = 12;
		String Owner = "S1mple";
		String Date = "2018-6-6";
		String Type = "Out";
		THDAOIMPL impl = new THDAOIMPL();
		impl.thInsert(ID, Name, Storage, Price, Owner, Date, Type);
		
	}

	@Override
	public List<TH> thSelect() {
		List<TH> result = null;
		try {
			Connection con = DBUtil.con();
			// 创建statement对象执行mysql语句
			Statement statement = con.createStatement();
			// 命令语句
			String sql = "select * from REG";
			ResultSet rs = statement.executeQuery(sql);
			result = new ArrayList<TH>();
			
			// 查找结果并保存
			while (rs.next()) {
				// 添加表中元素
				TH t = new TH();
				t.setID(rs.getInt("ID"));
				t.setStorage(rs.getInt("Storage"));
				t.setName(rs.getString("Name"));
				t.setDate(rs.getString("Date"));
				t.setOwner(rs.getString("Owner"));
				t.setType(rs.getString("Type"));
				t.setPrice(rs.getInt("Price"));
				result.add(t);
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
























