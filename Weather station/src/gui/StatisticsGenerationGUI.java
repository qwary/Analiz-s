package gui;

	import java.io.ByteArrayInputStream;
	import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;

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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
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

	public class StatisticsGenerationGUI {
		
		private TextField inputB;
		private TextField inputE;
		
		private Stage window;
		private final TableView<Event> table = new TableView<>();
		private final ObservableList<Event> data =
	            FXCollections.observableArrayList();
		
		private TextField input;
		

		private final MainGUI main;
		public StatisticsGenerationGUI(MainGUI main){
			
			inputB = new TextField();
		    inputB.setMaxWidth(Double.MAX_VALUE);
		    inputE = new TextField();
		    inputE.setMaxWidth(Double.MAX_VALUE);
		    
		    Label labelBegin = new Label("Enter begining date (YYYY-MM-DD):");
			Label labelEnd = new Label("Enter ending date (YYYY-MM-DD):");
			
			ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList(
				    "temperature", "humidity", "wind Speed")
			);
			cb.getSelectionModel().selectFirst();
		    Canvas canvas = new Canvas(600, 400);
		    GraphicsContext gc = canvas.getGraphicsContext2D();
	       // drawShapes(gc, 0, 0);
		    
			this.main = main;
			window = new Stage();
			window.initModality(Modality.APPLICATION_MODAL);
			window.setTitle("Generate Statistic");
			window.setWidth(650);

			window.setResizable(false);
			
		
//			});
			final Button generateButton = new Button("Search");
			generateButton.setOnAction((ActionEvent e) -> {
				DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				//System.out.println(dateBegin);
				String Begin = inputB.getText();
				String End = inputE.getText();
				String Selection = (String) cb.getValue();
				System.out.println("SELECTION " + Selection + "    Begin " + Begin + "        End!"+End);
				LocalDate dateB = LocalDate.parse(Begin, formatter2);
				LocalDate dateE = LocalDate.parse(End, formatter2);
				if(dateB.isBefore(dateE))
				{
					System.out.println("Begi nwins!");
				}	else {
					System.out.println("END wins!");
				}
				StatisticsGUI box = new StatisticsGUI(main, Selection, dateB, dateE);
			});
			
			table.setItems(data);
			VBox box = new VBox(5);
			box.setPadding(new Insets(5, 5, 0, 5));
			box.getChildren().add(cb);
			box.getChildren().add(labelBegin);
			box.getChildren().add(inputB);
			box.getChildren().add(labelEnd);
			box.getChildren().add(inputE);
			box.getChildren().add(generateButton);
			//box.getChildren().add(iv1);
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
