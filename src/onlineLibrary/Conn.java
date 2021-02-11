package onlineLibrary;
import java.sql.*;
public class Conn {

	Connection c;
	Statement s;
	
	public Conn() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");	//Registering the Driver class
			//Creating connection 
			c= DriverManager.getConnection("jdbc:mysql:///projectLibrary?autoReconnect=true&useSSL=false","root","hitesh20");
			//Creating statement
			s=c.createStatement();
	
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
