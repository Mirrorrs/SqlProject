package com.hansoma.dao;

import java.util.List;

import com.hansoma.model.CKXX;

public interface CKXXDAO {
	
	boolean ckxxInsert();

	boolean ckxxDelete();
	
	List<CKXX> ckxxSelect();
	
	boolean ckxxAlter();
	
}
