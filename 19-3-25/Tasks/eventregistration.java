package task;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class eventregistration {

	public static void main(String[] args) {
		String query="INSERT INTO eventusers (college_name,event_name,team_name,member1_name,member2_name,mail) VALUES(?,?,?,?,?,?)";
        System.out.println("welcome to event registration form");
        Scanner input=new Scanner(System.in);

        try {
		Connection con=	DriverManager.getConnection("jdbc:mysql://localhost:3306/ eventregistration","root","root");
		System.out.println("connection established...");
		PreparedStatement ps=con.prepareStatement(query);
		System.out.println("chooose one option");
		System.out.println("1.registartion for new user");
		System.out.println("2.edit registration");
		System.out.println("3.delete registration");
		int out=input.nextInt();
		switch(out){
		case 1:
			System.out.println("Enter college name:");
       		String collegename=input.next();
		  ps.setString(1,collegename);
		
		System.out.println("Enter event name:");
   		String eventname=input.next();
	    ps.setString(2,eventname);
	    
	    System.out.println("Enter team name:");
   		String teamname=input.next();
	    ps.setString(3,teamname);
	    
	    
	    System.out.println("Enter member 1 name:");
   		String mem1name=input.next();
	    ps.setString(4,mem1name);
	    
	    System.out.println("Enter member 2 name (if any):");
   		String mem2name=input.next();
	    ps.setString(5,mem2name);
	    
	    System.out.println("Enter mail:");
   		String gmail=input.next();
	    ps.setString(6,gmail);
	
	    System.out.println("registratin successful");
	    ps.executeUpdate();
		 break;	
		case 2:
			System.out.print("Enter the Mail : ");
			String mail =input.next();
			
			String query1 = "SELECT * FROM eventusers WHERE mail = '" + mail + "';";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query1);
			
			if(rs.next()) {
				String team_name = rs.getString("team_name");
				
				System.out.print("Enter team name : ");
				String teamnamedummy = input.next();
				
				if(team_name.equals(teamnamedummy)) {
					System.out.println("verified ,user found!!" + rs.getString("team_name"));
					System.out.print("what do you want to change? : ");
					
					System.out.println("chooose one number");
					System.out.println("1-collegename");
					System.out.println("2-eventname");
					System.out.println("3-member1 name");
					System.out.println("4-member2 name");
					System.out.println("5-team name");
					int edit=input.nextInt();
					switch(edit){
					case 1:
						String query2="UPDATE eventusers SET college_name=? WHERE mail=?;";
						System.out.print("enter correct college name : ");
						String college_name=input.next();
						PreparedStatement Ps=con.prepareStatement(query2);
						Ps.setString(1,college_name );
						Ps.setString(2, mail);
						System.out.print("successfully changed ");
						 Ps.executeUpdate();
						break;
					case 2:
						String query3="UPDATE eventusers SET event_name=? WHERE mail=?;";
						System.out.print("enter correct event name : ");
						String event_name=input.next();
						PreparedStatement ps1=con.prepareStatement(query3);
						ps1.setString(1,event_name );
						ps1.setString(2, mail);
						System.out.print("successfully changed ");
						 ps1.executeUpdate();
						break;
					case 3:
						String query4="UPDATE eventusers SET member1_name=? WHERE mail=?;";
						System.out.print("enter correct member1 name : ");
						String mem1_name=input.next();
						PreparedStatement ps2=con.prepareStatement(query4);
						ps2.setString(1,mem1_name );
						ps2.setString(2, mail);
						System.out.print("successfully changed ");
						 ps2.executeUpdate();
						break;
					case 4:
						String query5="UPDATE eventusers SET member2_name=? WHERE mail=?;";
						System.out.print("enter correct membebr2 name : ");
						String mem2_name=input.next();
						PreparedStatement ps3=con.prepareStatement(query5);
						ps3.setString(1,mem2_name );
						ps3.setString(2, mail);
						System.out.print("successfully changed ");
						 ps3.executeUpdate();
						break;
					case 5:
						String query6="UPDATE eventusers SET team_name=? WHERE mail=?;";
						System.out.print("enter correct team name : ");
						String team_names=input.next();
						PreparedStatement ps4=con.prepareStatement(query6);
						ps4.setString(1,team_names );
						ps4.setString(2, mail);
						 ps4.executeUpdate();
						System.out.print("successfully changed ");
						
						break;
						
					}
				}
				else {
					System.out.println("register first to edit ");
				}
			}
			else {
				System.out.println("User not found...");
				
			}
		
			break;
		case 3:
			System.out.println("Enter the Mail : ");
			String mails =input.next();
			
			String querys = "SELECT * FROM eventusers WHERE mail = '" + mails + "';";
			Statement st1 = con.createStatement();
			ResultSet rs1 = st1.executeQuery(querys);
			
			if(rs1.next()) {
				String team_name = rs1.getString("team_name");
				
				System.out.print("Enter team name : ");
				String teamnamedummy = input.next();
				
				if(team_name.equals(teamnamedummy)) {
					System.out.println("verified ,user found!!" + rs1.getString("team_name"));
				}
				System.out.println("do you really want to delete");
				String ans=input.next();
				if(ans.equals("yes")){
			String queryd="DELETE FROM eventusers WHERE mail=?;";
			PreparedStatement pss=con.prepareStatement(queryd);
			pss.setString(1,mails);
			System.out.print("successfully deleted ");
		    pss.executeUpdate();
				}else{
					break;
				}
			break;
		}
	
        }
        }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
