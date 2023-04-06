package Practise_pck;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class UpdateDataFromDB {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		int result=0;
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet47","root","root");
			Statement state = con.createStatement();
			String query="insert into student values('Kava','6','BTM','4months','JDN');";
			result=state.executeUpdate(query);
		}
		catch(Exception e) {
			
		}
		finally {
			if(result==1) {
				System.out.println("data updated");
			}
			else {
				System.err.println("data not updated");
			}
			con.close();
		}
		

	}

}
