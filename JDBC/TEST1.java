import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TEST1 {

	public static void main(String[] args) {
	     //step 1. register the driver
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://192.168.10.150:3306/dac32";
			
			//step 2. connect to the database
			Connection con=DriverManager.getConnection(url,"dac32","welcome");
			if(con!=null) {
				System.out.println("Connection Done !!!");
			}
			else {
				System.out.println("COnnection Failed!!");
			}
			 ///step 3. create connection
			 
			  Statement st=con.createStatement();
			  
			 //step 4. execute query
			  
			  ResultSet rs=st.executeQuery("select * from emp where sal>4000;");
			  while(rs.next()) {
				  System.out.println("Id : "+rs.getInt(1)+", Name : "+rs.getString(2)+", Salary : "+rs.getInt(7));
			  }
			  st.executeUpdate("insert into student values(1001,'Shamim','Ahmed','2000-07-15','Shamim@yahoomail.com')");
			  System.out.println("Added !!!");
		} catch (SQLException e) {
		
			System.out.println(e.getMessage());
		}
  
	}

}
