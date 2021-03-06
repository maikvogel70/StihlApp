package stihlonlinedb.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import stihlonlinedb.db.DBConnection;

/**
 * 
 * Hauptklasse zum Start der FX-Anwendung
 *
 */
public class Main extends Application implements ICommonProps {

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle(PRODUCT_TITLE);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Startet die Applikation
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		DBConnection.openDbConnection();
		launch(args);
	}

	@Override
	public void stop() throws Exception {
		DBConnection.closeConnection();
		super.stop();
	}

}
