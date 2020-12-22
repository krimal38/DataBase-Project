import java.io.IOException;
import java.sql.SQLException;

public class project_450 {

	public static void main(String[] args) throws SQLException, IOException {

		JDBC_conncetion obj = new JDBC_conncetion();
		obj.initiateConncetion();

		obj.part1_number2();
	}

}
