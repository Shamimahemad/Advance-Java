import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {

		try {
			Scanner sc = new Scanner(System.in);
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mysql://192.168.10.150:3306/dac32";

			Connection con = DriverManager.getConnection(url, "dac32", "welcome");
			if (con != null) {
				System.out.println("Connection Done !!!");
			} else {
				System.out.println("COnnection Failed!!");
			}

			Statement st = con.createStatement();
			int choice = 0;
			do {
				System.out.println(
						"1.Show all Student\n2.Add New Student\n3.Serach by Name\n4.Search by ID\n5.delete by ID\n6.Update student details");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					ResultSet rs = st.executeQuery("select * from student;");
					while (rs.next()) {
						System.out.println("Id : " + rs.getInt(1) + ", Name : " + rs.getString(2) + ", last name: "
								+ rs.getString(3) + ", date of Birth: " + rs.getString(4) + ", Email: "
								+ rs.getString(5));
					}
					break;
				case 2:
					System.out.println("Enter ID : ");
					int id = sc.nextInt();
					System.out.println("Enter Name First");
					String nf = sc.next();
					System.out.println("Enter Name Last");
					String nl = sc.next();
					System.out.println("Enter Date in Format yyyy-MM-dd");
					String date = sc.next();
					System.out.println("Enter Email");
					String email = sc.next();
					String query = "insert into student values(" + id + ",'" + nf + "','" + nl + "','" + date + "','"
							+ email + "')";
					System.out.println(query);
					st.executeUpdate(query);
					System.out.println("Added !!!");
					break;
				case 3:
					System.out.println("Enter Name First");
					nf = sc.next();

					ResultSet rs2 = st.executeQuery("select * from student where namefirst='" + nf + "'");
					if (!rs2.next()) {
						System.out.println("Aisa koi student nahi hai...");
						break;
					}
					ResultSet rs1 = st.executeQuery("select * from student where namefirst='" + nf + "'");
					while (rs1.next()) {
						System.out.println("Id : " + rs1.getInt(1) + ", Name : " + rs1.getString(2) + ", last name: "
								+ rs1.getString(3) + ", date of Birth: " + rs1.getString(4) + ", Email: "
								+ rs1.getString(5));
					}

					break;
				case 4:
					System.out.println("Enter ID");
					id = sc.nextInt();

					rs2 = st.executeQuery("select * from student where ID='" + id + "'");
					if (!rs2.next()) {
						System.out.println("Aisa koi student nahi hai...");
						break;
					}
					rs1 = st.executeQuery("select * from student where ID='" + id + "'");
					while (rs1.next()) {
						System.out.println("Id : " + rs1.getInt(1) + ", Name : " + rs1.getString(2) + ", last name: "
								+ rs1.getString(3) + ", date of Birth: " + rs1.getString(4) + ", Email: "
								+ rs1.getString(5));
					}

					break;
				case 5:
					System.out.println("Enter ID");
					id = sc.nextInt();

					st.executeUpdate("delete from student where ID='" + id + "'");
					System.out.println("student removed ....");
					break;
				case 6:
					System.out.println("Enter ID");
					id = sc.nextInt();
					System.out.println("what you want to update..\n1.First Name\n2.Last Name\n3.Date of Birth\4.Email");
					int ch = sc.nextInt();

					switch (ch) {
					case 1:
						System.out.println("Enter Name First");
						nf = sc.next();
						st.executeUpdate("update student set namefirst='"+nf+"' where ID='" + id + "'");
						System.out.println("name udated ....");
						break;
					case 2:
						System.out.println("Enter Name Last");
						nl = sc.next();
						st.executeUpdate("update student set namelast='"+nl+"' where ID='" + id + "'");
						System.out.println("last name udated ....");
						break;
					case 3:
						System.out.println("Enter Date in Format yyyy-MM-dd");
						date = sc.next();
						st.executeUpdate("update student set dob='"+date+"' where ID='" + id + "'");
						System.out.println("DOB udated ....");
						break;
					case 4:
						System.out.println("Enter Email");
						email = sc.next();
						
						st.executeUpdate("update student set emailID='"+email+"' where ID='" + id + "'");
						System.out.println("email udated ....");
						break;
					}
					break;
				}

			} while (choice != 0);

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

	}
}
