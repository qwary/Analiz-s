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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
	import javafx.scene.control.TextField;
	import javafx.scene.control.cell.PropertyValueFactory;
	import javafx.scene.layout.VBox;
	import javafx.stage.Modality;
	import javafx.stage.Stage;
	//import lt.ktu.projektas.events.onLogin;

	public class UserEventsGUI {
		private Stage window;
		private final TableView<Event> table = new TableView<>();
		private final ObservableList<Event> data =
	            FXCollections.observableArrayList();

		private final MainGUI main;
		public UserEventsGUI(MainGUI main){
			this.main = main;
			window = new Stage();
			window.initModality(Modality.APPLICATION_MODAL);
			window.setTitle("My events");
			window.setWidth(800);

			window.setResizable(false);
			
			EventList eventListData = getEvents("ME");
			//table.setEditable(true);
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
			
			TableColumn reaccurCol = new TableColumn("Reaccurence Frequency");
			reaccurCol.setCellValueFactory(
	                new PropertyValueFactory<>("ReaccurenceFrequency"));
			
			TableColumn occurCol = new TableColumn("Last Occurance");
			occurCol.setCellValueFactory(
	                new PropertyValueFactory<>("lastOccurance"));
			
			TableColumn stateCol = new TableColumn("CurrentState");
			stateCol.setCellValueFactory(
	                new PropertyValueFactory<>("state"));
			
			
			
			
			
			table.getColumns().addAll(AuthorCol, nameCol, emailCol, stationCol, creationCol, expirationCol, occurCol, stateCol);
			//data.add(eventData);
			table.setItems(data);
			
			for(int i = 0; i < eventListData.size(); i++)
			{
				data.add(eventListData.getElement(i));
			}
			
		//	submit.setOnAction(new onLogin(this));
		//	username.setMaxWidth(Double.MAX_VALUE);
		//	password.setMaxWidth(Double.MAX_VALUE);
			
		//	submit.setMaxWidth(Double.MAX_VALUE);
			
			final Button deleteButton = new Button("Delete Event");
			deleteButton.setOnAction((ActionEvent e) -> {
				TablePosition pos = table.getSelectionModel().getSelectedCells().get(0);
	        	int row = pos.getRow();
	        	data.remove(row);
	        	
	        	// Item here is the table view type:
	        	Event item = table.getItems().get(row);
	        	//TableColumn col = pos.getTableColumn();

			});
			
			final Button editButton = new Button("Edit Event");
			editButton.setOnAction((ActionEvent e) -> {
				TablePosition pos = table.getSelectionModel().getSelectedCells().get(0);
	        	int row = pos.getRow();
	        	// Item here is the table view type:
	        	Event item = table.getItems().get(row);
	        	//TableColumn col = pos.getTableColumn();
	        	editEventGUI box = new editEventGUI(main, item);
			});
			
			
			VBox box = new VBox(5);
			box.setPadding(new Insets(5, 5, 0, 5));
			box.getChildren().add(table);
			box.getChildren().add(deleteButton);
			box.getChildren().add(editButton);
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
		
		public EventList getEvents(String author)
		{
			EventList temp = new EventList();
			temp.addElement(new Event(author, false, author, author, author, false, author, false, false, 0, author, ""));
			temp.addElement(new Event(author, false, author, author, author, false, author, false, false, 0, author, ""));
			temp.addElement(new Event(author, false, author, author, author, false, author, false, false, 0, author, ""));
			temp.addElement(new Event(author, false, author, author, author, false, author, false, false, 0, author, ""));
			temp.addElement(new Event(author, false, author, author, author, false, author, false, false, 0, author, ""));
			temp.addElement(new Event(author, false, author, author, author, false, author, false, false, 0, author, "1909-09-11"));
			temp.addElement(new Event(author, false, author, author, author, false, author, false, false, 0, author, ""));
			temp.addElement(new Event(author, false, author, author, author, false, author, false, false, 0, author, ""));
			temp.addElement(new Event(author, false, author, author, author, false, author, false, false, 0, author, ""));
			temp.addElement(new Event(author, false, author, author, author, false, author, false, false, 0, author, ""));
			temp.addElement(new Event(author, false, author, author, author, false, author, false, false, 0, author, ""));
			temp.addElement(new Event(author, false, author, author, author, false, author, false, false, 0, author, "1410-05-16"));
			temp.addElement(new Event(author, false, author, author, author, false, author, false, false, 0, author, ""));
			temp.addElement(new Event(author, false, author, author, author, false, author, false, false, 0, author, ""));
			temp.addElement(new Event(author, false, author, author, author, false, author, false, false, 0, author, ""));
			
			return temp;
		}

	}
