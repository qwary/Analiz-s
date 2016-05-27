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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
//import lt.ktu.projektas.events.onLogin;

public class StationsGUI {
	Image image = new Image("lietuva.png");
	
	private Stage window;
	private final TableView<Station> table = new TableView<>();
	private final ObservableList<Station> data =
            FXCollections.observableArrayList();
	

	private final MainGUI main;
	public StationsGUI(MainGUI main){
		
		
		ImageView iv1 = new ImageView();
	    iv1.setImage(image);
	    
	    Canvas canvas = new Canvas(600, 400);
	    GraphicsContext gc = canvas.getGraphicsContext2D();
       // drawShapes(gc, 0, 0);
	    
		this.main = main;
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Event");
		window.setWidth(650);

		window.setResizable(false);
		
	//	username = new TextField();
		//password = new PasswordField();
		
		table.setEditable(true);
		TableColumn locNameCol = new TableColumn("Location");
		locNameCol.setCellValueFactory(
                new PropertyValueFactory<>("location"));
		
		TableColumn nameNameCol = new TableColumn("Name");
		nameNameCol.setCellValueFactory(
                new PropertyValueFactory<>("name"));
		
		TableColumn tempCol = new TableColumn("Temperature");
		tempCol.setCellValueFactory(
                new PropertyValueFactory<>("temperature"));
		
		TableColumn humCol = new TableColumn("Humidity");
		humCol.setCellValueFactory(
                new PropertyValueFactory<>("humidity"));
		
		TableColumn speedCol = new TableColumn("Wind speed");
		speedCol.setCellValueFactory(
                new PropertyValueFactory<>("windSpeed"));
		
		
		table.getColumns().addAll(locNameCol, nameNameCol, tempCol, humCol, speedCol);
		//data.add(eventData);
		StationList st = getStations();
		for(int i = 0; i < st.size(); i++){
			data.add(st.getElement(i));
		}
		table.setItems(data);
		
		locNameCol.setPrefWidth(100);
		nameNameCol.setPrefWidth(200);
		tempCol.setPrefWidth(100);
		humCol.setPrefWidth(100);
		speedCol.setPrefWidth(100);
		
	//	submit.setOnAction(new onLogin(this));
	//	username.setMaxWidth(Double.MAX_VALUE);
	//	password.setMaxWidth(Double.MAX_VALUE);
		
	//	submit.setMaxWidth(Double.MAX_VALUE);
		
		final Button addButton = new Button("Location");
		addButton.setOnAction((ActionEvent e) -> {
			//gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()));
			TablePosition pos = table.getSelectionModel().getSelectedCells().get(0);
        	int row = pos.getRow();
        	Station item = table.getItems().get(row);
        	String loc = item.getLocation();
        	String latitudeS = loc.substring(0, loc.indexOf(':'));
        	String longitudeS = loc.substring(loc.indexOf(':')+1, loc.length());
        	double latitudeD = Double.parseDouble(latitudeS);
        	double longitudeD = Double.parseDouble(longitudeS);
        	//int latitude = cordToInt(latitudeS);//(int) (latitudeD * 100);
        	//int longitude = cordToInt(longitudeS);//(int) (longitudeD * 100);
        	int latitude = (int) (latitudeD * 100);
        	int longitude = (int) (longitudeD * 100);
			drawShapes(gc, latitude, longitude);
		});
		
		VBox box = new VBox(5);
		box.setPadding(new Insets(5, 5, 0, 5));
		box.getChildren().add(table);
		//box.getChildren().add(iv1);
		box.getChildren().add(addButton);
		box.getChildren().add(canvas);
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
	
	public StationList getStations()
	{
		StationList temp = new StationList();
		temp.addElement(new Station("54.62:25.07", true, "Vilniaus Stotis", 30, 50, 8.6));
		temp.addElement(new Station("55.34:24.47", true, "Ukmergës Stotis", 40, 50, 8.6));
		temp.addElement(new Station("54.89:23.93", true, "Kauno Stotis", 60, 50, 8.6));
		return temp;
	}
	
	private void drawShapes(GraphicsContext gc, int y, int x) {
		System.out.println("X   "+x);
		System.out.println("Y   "+y);
		Image image = new Image("lietuva.png");
		gc.clearRect(0, 0, 600, 400);
		gc.drawImage(image, 0, 0);
		gc.setFill(Color.GREEN);
       // gc.setStroke(Color.BLUE);
      //  gc.strokeOval(x- 1110, 3558 - y, 10, 10);
        gc.strokeOval(x - 2120, 5717 - y, 10, 10);
	}
	
	private int cordToInt(String x)
	{
		int rez = 0;
		String start = x.substring(0, x.indexOf('.'));
		String end = x.substring(x.indexOf('.')+1, x.length());
	//	int foo = Integer.parseInt("1234");
		int startInt = Integer.parseInt(start);
		int endInt = Integer.parseInt(end);
		rez = startInt * 60 + endInt;
		return rez;
	}
	

}