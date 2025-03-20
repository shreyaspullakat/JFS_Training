package practice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//select and print whole table
public class Practice4 {

	public static void main(String[] args) {
		String query="SELECT* FROM users;";//use prepared statement ,need not declare the values instead ?
       
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","root");
			System.out.println("connection established...");
			
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
             while(rs.next()){
			
			System.out.println(rs.getInt("user_id")+" "+rs.getString("user_name")+" "+rs.getString("pass"));
             }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
       
	}

}
