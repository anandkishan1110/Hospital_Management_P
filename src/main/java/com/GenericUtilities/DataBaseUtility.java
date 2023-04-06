package com.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection con=null;
	
	public void connectToDb()throws Throwable{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IpathConstants.DBURL, IpathConstants.DBUSERNAME, IpathConstants.DBPASSWORD);
		
	}
	public void connectToDbTY()throws Throwable{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IpathConstants.DBURL_TY, IpathConstants.DBUSERNAME_TY, IpathConstants.DBPASSWORD_TY);
		
	}
	
	public String executeQueryAndGetData(String query,String exDate,int columnIndex)throws Throwable{
		ResultSet result=con.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			String data=result.getString(columnIndex);
			
			if(data.equalsIgnoreCase(exDate))
			{
				flag=true;
				break;
			}
		}
	
	if(flag)
	{
		System.out.println("data is verified");
		return exDate;
	}
	else {
		System.out.println("data is not updated");
		return "";
	}
	}
	public void closeDB()throws Throwable
	{
		con.close();
		System.out.println("Database connection closed");
	}

}
