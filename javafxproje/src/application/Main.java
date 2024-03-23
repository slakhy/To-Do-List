package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import taskSerializer.TaskSerializer;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private static Scene scene;
	private static SampleController appController;
	@Override
	public void start(Stage primaryStage)throws IOException {
		scene=new Scene(loadFXML("Sample"));
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	@Override
	public void stop() throws IOException {
		TaskSerializer.serialize(appController.takeTasks());
	}
	
	
	private Parent loadFXML(String fxml) throws IOException{
		FXMLLoader fxmlLoader=new FXMLLoader(Main.class.getResource("/application/"+fxml+".fxml"));
		Parent parent =fxmlLoader.load();
		appController=fxmlLoader.getController();
		return parent;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
