package com.harry.spring.Constants;

public class SQLConstants {
	
	public static final String INSERT_RECORD = "insert into Employee values(?,?,?,?)";
	
	public static final String SELECT_RECORDS = "select * from Employee";
	
	public static final String UPDATE_RECORDS = "update Employee set age =?, dept=?,name=? where id=?";
	
	public static final String SELECT_RECORD_USING_ID = "select * from Employee where id=?";
	
	public static final String DELETE_RECORDS = "delete from employee where id=?";

}
