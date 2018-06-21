package com.hansoma.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.hansoma.dao.HWXXDAO;
import com.hansoma.model.HWXX;
import com.hansoma.util.DBUtil;


public class HWXXDAOIMPL implements HWXXDAO{

	public static void main(String[] args) throws ParseException {
		HWXXDAOIMPL impl = new HWXXDAOIMPL();
		List<HWXX> rs = impl.hwxxSelect();
		System.out.println(rs.get(0).getInDate());
		int id = 5;
		String name = "M4A4|Neo-Noir";
		int storage = 12;
		int price = 600;
		String owner = "ScreaM";
		String indate = "2018-01-12";
		//String outdate = "2018-01-23 22:45:56";
		String outdate = null;
		//impl.hwxxInsert(id, name, storage, price, owner, indate, outdate);
		//impl.hwxxUpdateStorage(1, 500);
		impl.hwxxUpdateIndate(1, indate);

	}
	
	// 字符串转java.sql.date
	public static java.sql.Date strToDate(String strDate) {  
        String str = strDate;  
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        java.util.Date d = null;  
        try {  
            d = format.parse(str);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        java.sql.Date date = new java.sql.Date(d.getTime());  
        return date;  
    }  
	
	
	// 查看仓库的详细信息
	@Override
	public List<HWXX> hwxxSelect() {
		List<HWXX> result = null;
		try {
			Connection con = DBUtil.con();
			//创建statement对象执行mysql命令
			Statement statement = con.createStatement();
			//命令语句
			String sql = "select * from HWXX";
			ResultSet rs = statement.executeQuery(sql);
			result = new ArrayList<HWXX>();
			
			// 查找结果并保存
			while (rs.next()) {
				
				// 添加列表中元素
				HWXX h = new HWXX();
				h.setId(rs.getInt("ID"));
				h.setName(rs.getString("Name"));
				h.setStorage(rs.getInt("Storage"));
				h.setPrice(rs.getInt("Price"));
				h.setOwner(rs.getString("Owner"));
				h.setInDate(rs.getDate("InDate"));
				h.setOutDate(rs.getDate("OutDate"));
				result.add(h);
			}
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public boolean hwxxInsert(int ID, String Name, int Storage, int Price, 
			String Owner, String InDate, String OutDate) {
		boolean flag = false;
		try {
			Connection con = DBUtil.con();  
			//创建statement对象执行mysql命令
			Statement statement = con.createStatement();
			//编写命令语句
			String id = Integer.toString(ID);
			String storage = Integer.toString(Storage);
			String price = Integer.toString(Price);
			
			String sql = "insert into HWXX values(" + 
						id + ", '" + Name + "', " + storage + 
						", " + price + ", '" + Owner + "', '" +
						InDate + "'";
			// OutDate 不为空
			if (OutDate!=null) {
				String suffix = ", '" + OutDate + "'";
				sql += suffix;
			}else { // OutDate 为空
				String suffix = ", null" + ")";
				sql += suffix;
			}
			System.out.println(sql);
			
			//执行语句
			statement.execute(sql);
			flag = true;
		}
		catch(Exception e) {
			flag  = false;
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean hwxxDelete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hwxxUpdateStorage(int id, int storage) {
		boolean flag = false;
		try {
			Connection con = DBUtil.con();  
			//创建statement对象执行mysql命令
			Statement statement = con.createStatement();
			String ID = Integer.toString(id);
			String Storage = Integer.toString(storage);
			String sql = "update HWXX set Storage=" + Storage +
							" where ID=" + ID;
			System.out.println(sql);
			statement.execute(sql);
			flag = true;
		}catch(Exception e) {
			flag = false;
			e.printStackTrace();
		}
		
		return flag;
	}
	
	@Override
	public boolean hwxxUpdatePrice (int id, int price) {
		boolean flag = false;
		try {
			Connection con = DBUtil.con();  
			//创建statement对象执行mysql命令
			Statement statement = con.createStatement();
			String ID = Integer.toString(id);
			String Price = Integer.toString(price);
			String sql = "update HWXX set Price=" + Price +
							" where ID=" + ID;
			System.out.println(sql);
			statement.execute(sql);
			flag = true;
		}catch(Exception e) {
			flag = false;
			e.printStackTrace();
		}
		
		return flag;
	}
	
	@Override
	public boolean hwxxUpdateIndate (int id, String InDate) {
		boolean flag = false;
		try {
			Connection con = DBUtil.con();  
			//创建statement对象执行mysql命令
			Statement statement = con.createStatement();
			String ID = Integer.toString(id);
			String sql = "update HWXX set InDate='" + InDate +
							"' where ID=" + ID;
			System.out.println(sql);
			statement.execute(sql);
			flag = true;
		}catch(Exception e) {
			flag = false;
			e.printStackTrace();
		}
		
		return flag;
	}
	
	@Override
	public boolean hwxxUpdateOutdate (int id, String OutDate) {
		boolean flag = false;
		try {
			Connection con = DBUtil.con();  
			//创建statement对象执行mysql命令
			Statement statement = con.createStatement();
			String ID = Integer.toString(id);
			String sql = "update HWXX set OutDate='" + OutDate +
							"' where ID=" + ID;
			System.out.println(sql);
			statement.execute(sql);
			flag = true;
		}catch(Exception e) {
			flag = false;
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean hwxxAlter(HWXX obj) {
		// TODO Auto-generated method stub
		return false;
	}





}
