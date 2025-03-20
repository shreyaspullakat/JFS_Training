package practice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//insert
public class Practice1 {

	public static void main(String[] args) {
		String query="INSERT INTO users(user_name,gmail,pass) VALUES(?,?,?);";//use prepared statement ,need not declare the values instead ?
       
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","root");
			System.out.println("connection established...");
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, "koushikar");
			ps.setString(2, "koushikar@gmail.com");
			ps.setString(3, "kodbcfjwey@2415");
			
		  int rows=	ps.executeUpdate();
			System.out.println(rows+"rows affected");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
       
	}

}
