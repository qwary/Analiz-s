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
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
//import lt.ktu.projektas.events.onLogin;

public class SearchEventGUI {
	
	private Stage window;
	private final TableView<Event> table = new TableView<>();
	private final ObservableList<Event> data =
            FXCollections.observableArrayList();
	
	private TextField input;
	

	private final MainGUI main;
	public SearchEventGUI(MainGUI main){
		
	    input = new TextField();
	    input.setMaxWidth(Double.MAX_VALUE);
	    
	    
	    
	    Canvas canvas = new Canvas(600, 400);
	    GraphicsContext gc = canvas.getGraphicsContext2D();
       // drawShapes(gc, 0, 0);
	    
		this.main = main;
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Search for Event");
		window.setWidth(650);

		window.setResizable(false);
		
	//	username = new TextField();
		//password = new PasswordField();
		
		//table.setEditable(true);
		
		TableColumn Author = new TableColumn("Author");
		Author.setCellValueFactory(
                new PropertyValueFactory<>("author"));
		
		TableColumn Name = new TableColumn("Name");
		Name.setCellValueFactory(
                new PropertyValueFactory<>("name"));
		
		TableColumn description = new TableColumn("Description");
		description.setCellValueFactory(
                new PropertyValueFactory<>("description"));
		
		
		table.getColumns().addAll(Author, Name, description);
		//data.add(eventData);
		//EventList st = getStations();
//		for(int i = 0; i < st.size(); i++){
//			data.add(st.getElement(i));
//		}
//		table.setItems(data);
		
		Author.setPrefWidth(100);
		Name.setPrefWidth(200);
		description.setPrefWidth(100);

		

		
		final Button SearchButton = new Button("Search");
		SearchButton.setOnAction((ActionEvent e) -> {
			//gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()));
			//TablePosition pos = table.getSelectionModel().getSelectedCells().get(0);
        	//int row = pos.getRow();
        	//Event item = table.getItems().get(row);
			String textFieldValue = input.getText();
			System.out.println("input: "+ textFieldValue);
			data.clear();
			EventList eve = getEvents(textFieldValue);
			for(int i = 0; i < eve.size(); i++)
			{
				data.add(eve.getElement(i));
			}
			
		});
		
		final Button MoreInfoButton = new Button("Read More...");
		MoreInfoButton.setOnAction((ActionEvent e) -> {
			TablePosition pos = table.getSelectionModel().getSelectedCells().get(0);
        	int row = pos.getRow();

        	// Item here is the table view type:
        	Event item = table.getItems().get(row);
        	System.out.println("WE NEED DATA: "+ item.getAuthor());
        	System.out.println("WE NEED DATA: "+ item.getName());
        	System.out.println("WE NEED DATA: "+ item.getDescription());
        	//TableColumn col = pos.getTableColumn();
        	EventViewGUI box = new EventViewGUI(main, item);

		});
		
		table.setItems(data);
		VBox box = new VBox(5);
		box.setPadding(new Insets(5, 5, 0, 5));
		box.getChildren().add(input);
		box.getChildren().add(SearchButton);
		box.getChildren().add(table);
		//box.getChildren().add(iv1);
		box.getChildren().add(MoreInfoButton);
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
		temp.addElement(new Event(author, author, author, author, author, author));
		temp.addElement(new Event(author, author, author, author, author, author));
		temp.addElement(new Event(author, author, author, author, author, author));
		temp.addElement(new Event(author, author, author, author, author, author));
		temp.addElement(new Event(author, author, author, author, author, author));
		temp.addElement(new Event(author, author, author, author, author, author));
		temp.addElement(new Event(author, author, author, author, author, author));
		temp.addElement(new Event(author, author, author, author, author, author));
		temp.addElement(new Event(author, author, author, author, author, author));
		temp.addElement(new Event(author, author, author, author, author, author));
		temp.addElement(new Event(author, author, author, author, author, author));
		temp.addElement(new Event(author, author, author, author, author, author));
		temp.addElement(new Event(author, author, author, author, author, author));
		temp.addElement(new Event(author, author, author, author, author, author));
		temp.addElement(new Event(author, author, author, author, author, author));
		
		return temp;
	}
	
	
	

}