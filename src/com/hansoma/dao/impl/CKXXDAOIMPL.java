package com.hansoma.dao.impl;

import com.hansoma.dao.CKXXDAO;
import com.hansoma.model.CKXX;
import com.hansoma.util.DBUtil;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class CKXXDAOIMPL implements CKXXDAO{

	public static void main(String[] args) {
		CKXXDAOIMPL impl = new CKXXDAOIMPL();
		List<CKXX> rs = impl.ckxxSelect();
		System.out.println(rs.get(0).getStorage());
	}
	
	// 获取CKXX类的所有属性， 保存在字典中。
	public HashMap<String, String> generateInfo(CKXX ck) {
		HashMap<String, String> info = new HashMap<String, String>();
		info.put("id", ck.getId());
		info.put("storage", ck.getStorage());
		return info;
	}
	
	
	@Override
	public boolean ckxxInsert() {
		return false;
	}

	@Override
	public boolean ckxxDelete() {
		// TODO Auto-generated method stub
		return false;
	}

	// 查看所有仓库的信息
	@Override
	public List<CKXX> ckxxSelect() {
		List<CKXX> result = null;
		try {
			Connection con = DBUtil.con();
			//创建statement对象执行mysql命令
			Statement statement = con.createStatement();
			//命令语句
			String sql = "select * from CKXX";
			ResultSet rs = statement.executeQuery(sql);
			result = new ArrayList<CKXX>();
			
			// 查找结果并保存
			while (rs.next()) {
				
				// 添加列表中元素
				CKXX c = new CKXX();
				c.setId(rs.getInt("ID"));
				c.setStorage(rs.getInt("Storage"));
				result.add(c);
			}
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public boolean ckxxAlter() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
