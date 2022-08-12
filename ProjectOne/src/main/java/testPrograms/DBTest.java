package testPrograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DBTest {

	public static void main(String[] args) throws SQLException {
		
//		Driver driver = new Driver();
//		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teachers_info", "root", "root");
		Statement stmt = con.createStatement();
		
		String query = "insert into teachers(first_name, last_name, address) values('shyam','kumar','bangalore');";
		
		stmt.executeUpdate(query);
		
		query = "select * from teachers";
		
		ResultSet res = stmt.executeQuery(query);
		
		while(res.next())
		{
			System.out.println(res.getInt(1) + " " + res.getString(2) + " " + res.getString(3) + " " + res.getString(4));
		}
		
		con.close();
		
	}

}
