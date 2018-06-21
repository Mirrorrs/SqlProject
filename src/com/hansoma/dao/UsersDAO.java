package com.hansoma.dao;

import java.util.List;

import com.hansoma.model.Users;

public interface UsersDAO {
	
	boolean UsersInsert();
	
	boolean UsersDelete();
	
	List<Users> UsersSelect();
	
	List<Users> getData(String tableName);
	
	boolean insertIntoTable(String tablename, int Id, String userName, String Password);
	
	boolean deleteFromTable(String tableName, String Id);
	
	boolean UsersAlter();

}
