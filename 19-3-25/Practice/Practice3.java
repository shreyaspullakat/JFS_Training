package practice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//update name,mail,pass using user id
public class Practice3 {

	public static void main(String[] args) {
		String query="UPDATE users SET user_name=?,gmail=?,pass=? WHERE user_id=?;";//use prepared statement ,need not declare the values instead ?
       
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","root");
			System.out.println("connection established...");
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(4,1000);
			ps.setString(1,"koushikar");
			ps.setString(2, "koushikar@gmail.com");
			ps.setString(3, "pass_koushikr@123");
			
		  int rows=	ps.executeUpdate();
			System.out.println(rows+"rows affected");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
       
	}

}
