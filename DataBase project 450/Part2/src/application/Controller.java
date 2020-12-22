package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

	@FXML
	private Label lblStatus;

	@FXML
	private TextField SSN;

	private Connection conn;
	private ArrayList<String> listOfManagerSsn = new ArrayList<>(3); // stores manager ssn

	public void SsnLogin(ActionEvent event) throws SQLException, InterruptedException, IOException {

		try {
			for (int i = 0; i < listOfManagerSsn.size(); i++) {
				listOfManagerSsn.remove(i);
			}

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu",
					"krimal", "ostoozoo");

			Statement statement = conn.createStatement();

			String query = "select ssn from employee, department where ssn = mgrssn";
			ResultSet result = statement.executeQuery(query);

			while (result.next()) {
				listOfManagerSsn.add(result.getString(1));
			}

			/*
			 * The code checks if the manager SSN is valid or not.
			 */
			if (SSN.getText().equals(listOfManagerSsn.get(0)) || SSN.getText().equals(listOfManagerSsn.get(1))
					|| SSN.getText().equals(listOfManagerSsn.get(2))) {

				Platform.runLater(() -> {
					try {
						EmployeeController obj = new EmployeeController();

						obj.EmployeeInformation();

					} catch (ClassNotFoundException | SQLException | IOException e) {
						e.printStackTrace();
					}

				});

			} else {
				lblStatus.setText("Not a manager");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Driver could not be loaded");
		}

	}

	public void assignProject(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("application/AssignProject.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
