package gui;




import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import entitys.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

//import javax.ws.rs.BadRequestException;
//import javax.ws.rs.InternalServerErrorException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
//import lt.ktu.projektas.events.onLogin;

public class EventViewGUI {
	private Stage window;
	private final TableView<Event> table = new TableView<>();
	private final ObservableList<Event> data =
            FXCollections.observableArrayList();

	private final MainGUI main;
	public EventViewGUI(MainGUI main, Event eventData){
		this.main = main;
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Event");
		window.setWidth(800);

		window.setResizable(false);
		
	//	username = new TextField();
		//password = new PasswordField();
		
		TableColumn AuthorCol = new TableColumn("Author");
		AuthorCol.setCellValueFactory(
                new PropertyValueFactory<>("author"));
		
		TableColumn nameCol = new TableColumn("Name");
		nameCol.setCellValueFactory(
                new PropertyValueFactory<>("name"));
		
		TableColumn emailCol = new TableColumn("Description");
		emailCol.setCellValueFactory(
                new PropertyValueFactory<>("description"));
		
		TableColumn stationCol = new TableColumn("Station");
		stationCol.setCellValueFactory(
                new PropertyValueFactory<>("observationStation"));
		
		TableColumn creationCol = new TableColumn("Creation Date");
		creationCol.setCellValueFactory(
                new PropertyValueFactory<>("creationDate"));
		
		TableColumn expirationCol = new TableColumn("Expiration Date");
		expirationCol.setCellValueFactory(
                new PropertyValueFactory<>("expirationDate"));
		
		TableColumn occurCol = new TableColumn("Last Occurance");
		occurCol.setCellValueFactory(
                new PropertyValueFactory<>("occurance"));
		
		table.getColumns().addAll(AuthorCol, nameCol, emailCol, stationCol, creationCol, expirationCol, occurCol);
		data.add(eventData);
		table.setItems(data);
		
	//	submit.setOnAction(new onLogin(this));
	//	username.setMaxWidth(Double.MAX_VALUE);
	//	password.setMaxWidth(Double.MAX_VALUE);
		
	//	submit.setMaxWidth(Double.MAX_VALUE);
		
		VBox box = new VBox(5);
		box.setPadding(new Insets(5, 5, 0, 5));
		box.getChildren().add(table);
	//	box.getChildren().addAll(usernameTitle, username, passwordTitle, password, submit);
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
