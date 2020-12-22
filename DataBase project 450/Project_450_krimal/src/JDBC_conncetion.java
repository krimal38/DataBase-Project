import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_conncetion {

	private Connection conn;

	public void initiateConncetion() throws SQLException, IOException {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException x) {
			System.out.println("Driver could not be loaded");
		}

		conn = DriverManager.getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu",
				"krimal", "ostoozoo");

	}

	/*
	 * Part 1:- Question number 1
	 */
	public void part1() throws SQLException {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu",
					"krimal", "ostoozoo");

			Statement statement = conn.createStatement();

			String query = "select lname, ssn  from employee, department where dno = dnumber AND Dname = 'Research'";
			ResultSet result = statement.executeQuery(query);

			// to read the query
			while (result.next()) {

				System.out.println(result.getString("lname") + " " + result.getString("ssn"));

			}
			conn.close();

		} catch (ClassNotFoundException e) {
			System.out.println("Driver could not be loaded" + e);
		}
	}

	/*
	 * Part 1 :- Question number 2
	 */
	public void part1_number2() throws SQLException {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu",
					"krimal", "ostoozoo");

			Statement statement = conn.createStatement();

			String query = "select lname, ssn, hours  from works_on, dept_locations, employee, project where pno = pnumber and dnum = dnumber and essn = ssn and dlocation = 'Houston' and Pname = 'ProductZ'";

			ResultSet result = statement.executeQuery(query);

			while (result.next()) {
				System.out.println(result.getString(1) + " " + result.getString(2) + " " + result.getString(3));
			}
			conn.close();

		} catch (ClassNotFoundException e) {
			System.out.println("Driver could not be loaded" + e);
		}

	}

	/*
	 * public void part2() throws SQLException { Scanner scn = new
	 * Scanner(System.in);
	 * 
	 * ArrayList<String> SSN_List = new ArrayList<>(); ArrayList<Integer> list = new
	 * ArrayList<>(); int counter = 0;
	 * 
	 * try {
	 * 
	 * Class.forName("oracle.jdbc.driver.OracleDriver"); conn =
	 * DriverManager.getConnection(
	 * "jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu",
	 * "krimal", "ostoozoo");
	 * 
	 * Statement statement = conn.createStatement();
	 * 
	 * // user input System.out.println("Enter SSN:"); long ssn_input =
	 * scn.nextInt();
	 * 
	 * String query = "select ssn from employee, department where ssn = mgrssn";
	 * ResultSet result = statement.executeQuery(query);
	 * 
	 * while (result.next()) { list.add(result.getInt(1)); }
	 * 
	 * if (list.get(1) == ssn_input || list.get(2) == ssn_input || list.get(3) ==
	 * ssn_input) {
	 * 
	 * System.out.println("Enter Fname"); String Fname = scn.next();
	 * 
	 * System.out.println("Enter Minit"); String Minit = scn.next();
	 * 
	 * System.out.println("Enter Lname"); String Lname = scn.next();
	 * 
	 * System.out.println("Enter Ssn"); String Ssn = scn.next();
	 * 
	 * System.out.println("Enter Bdate"); String Bdate = scn.next();
	 * 
	 * System.out.println("Enter Address"); String Address = scn.nextLine();
	 * 
	 * System.out.println("Enter Sex"); String Sex = scn.next();
	 * 
	 * System.out.println("Enter Salary"); String Salary = scn.next();
	 * 
	 * System.out.println("Enter Super_ssn"); String Super_ssn = scn.next();
	 * 
	 * System.out.println("Enter Dno"); String Dno = scn.next();
	 * 
	 * // check if the employee is already in the system. /* String querySSN =
	 * "select ssn from employee"; ResultSet result_SsnQuery =
	 * statement.executeQuery(querySSN);
	 * 
	 * while(result_SsnQuery.next()) { SSN_List.add(result.getString(1)); }
	 */

	/*
	 * statement.executeUpdate("insert into employee value('" + Fname + "', '" +
	 * Minit + "', '" + Lname + "', '" + Ssn + "', '" + Bdate + "', '" + Address +
	 * "', '" + Sex + "', '" + Salary + "', '" + Super_ssn + "', '" + Dno + "')");
	 * 
	 * } else { System.out.println("Not manager SSN"); System.exit(0); }
	 * 
	 * } catch (ClassNotFoundException e) {
	 * System.out.println("Driver could not be loaded" + e); } }
	 */

}
