package com.hansoma.dao;

import java.sql.Date;
import java.util.List;

import com.hansoma.model.HWXX;

public interface HWXXDAO {
	
	boolean hwxxDelete(int ID);
	
	List<HWXX> hwxxSelect();

	boolean hwxxInsert(int ID, String Name, int Storage, int Price, String Owner, String InDate, String OutDate);

	boolean hwxxAlter(HWXX obj);


	boolean hwxxUpdateStorage(int id, int storage);

	boolean hwxxUpdatePrice(int id, int price);

	boolean hwxxUpdateIndate(int id, String InDate);

	boolean hwxxUpdateOutdate(int id, String OutDate);


}
