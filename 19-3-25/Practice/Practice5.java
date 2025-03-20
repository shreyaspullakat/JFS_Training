package practice;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//select and print whole table
public class Practice5 {

	public static void main(String[] args) {
		String query="SELECT* FROM users;";//use prepared statement ,need not declare the values instead ?
       
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","root");
			System.out.println("connection established...");
			
			DatabaseMetaData metainfo=con.getMetaData();
			
			System.out.println(metainfo.getDriverName());
			System.out.println(metainfo.getDriverVersion());
			System.out.println(metainfo.getUserName());
			System.out.println(metainfo.getDatabaseProductName());
			System.out.println(metainfo.getDatabaseProductVersion());
			
			
			
             
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
       
	}
}

