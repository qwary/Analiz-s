	package gui;




	import java.io.ByteArrayInputStream;
	import java.nio.charset.StandardCharsets;

import entitys.Event;

//import javax.ws.rs.BadRequestException;
	//import javax.ws.rs.InternalServerErrorException;

	import javafx.event.ActionEvent;
	import javafx.event.EventHandler;
	import javafx.geometry.Insets;
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.scene.control.Label;
	import javafx.scene.control.PasswordField;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TextField;
	import javafx.scene.layout.VBox;
	import javafx.stage.Modality;
	import javafx.stage.Stage;
	//import lt.ktu.projektas.events.onLogin;

	public class editEventGUI {
		private Stage window;
		private TextField author;
		private TextField name;
		private TextField decription;
		private TextField Station;
		private TextField ExpirationDate;
		private TextField reaccurenceFrequency;
		private final MainGUI main;
		public editEventGUI(MainGUI main, Event target){
			this.main = main;
			window = new Stage();
			window.initModality(Modality.APPLICATION_MODAL);
			window.setTitle("Edit");
			window.setWidth(300);

			window.setResizable(false);
			
			TextField author = new TextField();
			TextField decription = new TextField();
			TextField Station = new TextField();
			TextField ExpirationDate = new TextField();
			TextField reaccurenceFrequency = new TextField();
			
			Label authorTitle = new Label("Author:");
			Label descriptionTitle = new Label("Description:");
			Label stationTitle = new Label("Station:");
			Label expirationTitle = new Label("Expiration Date:");
			Label frequencyTitle = new Label("Reaccurence Frequency:");
			Button submit = new Button("Save changes");
			
		//	submit.setOnAction(new onLogin(this));
			submit.setMaxWidth(Double.MAX_VALUE);
			
			submit.setOnAction((ActionEvent e) -> {
				
				window.close();
			});
			
			VBox box = new VBox(5);
			box.setPadding(new Insets(5, 5, 0, 5));
			box.getChildren().addAll(authorTitle, author, descriptionTitle, decription, stationTitle, Station,
					expirationTitle, ExpirationDate, frequencyTitle, reaccurenceFrequency, submit
					);
			Scene scene = new Scene(box);
			window.setScene(scene);
			window.showAndWait();
		}
		public MainGUI getMain(){
			return main;
		}
		public void close(){
			window.close();
		}

	}
