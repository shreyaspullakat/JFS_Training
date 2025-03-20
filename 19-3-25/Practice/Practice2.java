package practice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//delete
public class Practice2 {

	public static void main(String[] args) {
		String query="DELETE FROM users WHERE user_id=?;";//use prepared statement ,need not declare the values instead ?
       
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","root");
			System.out.println("connection established...");
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,1006);
			
		  int rows=	ps.executeUpdate();
			System.out.println(rows+"rows affected");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
       
	}

}
