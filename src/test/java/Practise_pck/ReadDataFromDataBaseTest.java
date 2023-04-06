package Practise_pck;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.GenericUtilities.DataBaseUtility;
import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDataBaseTest {

	public static void main(String[] args) throws SQLException {
		DataBaseUtility dbu=new DataBaseUtility();
		Connection con=null;
		try {
		//Step 1:Create object for the driver
		Driver driver=new Driver();
		//Step 2:Register the database
		DriverManager.registerDriver(driver);
		//Step 3:Get Connection for the database
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet47","root","root");
		//Step 4:Create Statement
		Statement state = con.createStatement();
		String query="select * from student;";
		//Step 5:Execute Query
		ResultSet result = state.executeQuery(query);
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5));
		}
		}
		catch(Exception e) {
			
		}
		finally {
		//Step 6:Close database connection
        con.close();
	}
	}
	

}
