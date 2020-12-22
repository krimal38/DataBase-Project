package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EmployeeController {

	@FXML
	public TextField Fname, Minit, Lname, ssn, Bdate, Address, Sex, Salary, Dno;

	@FXML
	private Label message;

	private Connection conn;

	@FXML
	public Button closeButton;

	public void EmployeeInformation() throws SQLException, ClassNotFoundException, IOException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu",
				"krimal", "ostoozoo");

		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/EmployeeScreen.fxml"));

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.initModality(Modality.APPLICATION_MODAL);
		primaryStage.show();

		String query = "INSERT into EMPLOYEE (Fname,Minit,Lname,ssn,Bdate,Address,Sex,Salary,Dno) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, Fname.getText());
		ps.setString(2, Minit.getText());
		ps.setString(3, Lname.getText());
		ps.setString(4, ssn.getText());
		ps.setString(5, Bdate.getText());
		ps.setString(6, Address.getText());
		ps.setString(7, Sex.getText());
		ps.setString(8, Salary.getText());
		ps.setString(9, Dno.getText());
		ps.executeUpdate();

		Platform.runLater(() -> {
			try {
				AssignNewEmployee obj = new AssignNewEmployee();

				obj.AssignProject();

			} catch (ClassNotFoundException | SQLException | IOException e) {
				e.printStackTrace();
			}

		});

	}

	@FXML
	public void closeButtonAction() {

		// get a handle to the stage
		Stage stage = (Stage) closeButton.getScene().getWindow();
		// do what you have to do
		stage.close();
	}

}
