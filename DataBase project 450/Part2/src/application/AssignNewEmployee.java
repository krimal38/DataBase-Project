package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AssignNewEmployee {

	private Connection conn;

	@FXML
	private TextField Pname, Pnumber, Plocation, Dnum, Hours;

	@FXML
	private Label message;

	@FXML
	public Button closeButton;

	EmployeeController obj = new EmployeeController();

	public void AssignProject() throws ClassNotFoundException, SQLException, IOException {
		/*
		 * Class.forName("oracle.jdbc.driver.OracleDriver"); conn =
		 * DriverManager.getConnection(
		 * "jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu",
		 * "krimal", "ostoozoo");
		 * 
		 * Stage primaryStage = new Stage(); Parent root =
		 * FXMLLoader.load(getClass().getResource("/application/AssignProject.fxml"));
		 * 
		 * Scene scene = new Scene(root); primaryStage.setScene(scene);
		 * primaryStage.initModality(Modality.APPLICATION_MODAL); primaryStage.show();
		 * 
		 * String str = Hours.getText();
		 * 
		 * int hours = Integer.parseInt(str); hours += hours;
		 * 
		 * if (hours < 40) { String query =
		 * "INSERT into PROJECT (Pname,Pnumber,Plocation,Dnum) VALUES (?,?,?,?)";
		 * PreparedStatement ps = conn.prepareStatement(query); ps.setString(1,
		 * Pname.getText()); ps.setString(2, Pnumber.getText()); ps.setString(3,
		 * Plocation.getText()); ps.setString(4, Dnum.getText()); ps.executeUpdate();
		 * 
		 * String queryWorks_on =
		 * "INSERT into WORKS_ON (ssn, Pnumber, Hours) VALUES (?,?,?)";
		 * PreparedStatement statement = conn.prepareStatement(queryWorks_on);
		 * statement.setString(1, obj.ssn.getText()); statement.setString(2,
		 * Pnumber.getText()); statement.setString(3, Hours.getText());
		 * statement.executeUpdate();
		 * 
		 * System.out.println("worked!"); } else {
		 * message.setText("Hours should be less than 40"); }
		 */
		message.setText("Hours should be less than 40");
	}

	@FXML
	public void closeButtonAction() {

		// get a handle to the stage
		Stage stage = (Stage) closeButton.getScene().getWindow();
		// do what you have to do
		stage.close();
	}
}
