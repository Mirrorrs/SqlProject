package com.hansoma.dao;

import java.util.List;

import com.hansoma.model.TH;

public interface THDAO {

	boolean thInsert(int ID, String Name, int Storage, int Price, 
				String Owner, String Date, String Type);
	List<TH> thSelect();
}
