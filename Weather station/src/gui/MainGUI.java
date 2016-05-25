package gui;


import java.util.ArrayList;

import entitys.Event;
import entitys.EventList;

//import javax.ws.rs.client.Client;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class MainGUI extends Application{
	Stage stage;

	//FormTabPane tabs;
	Tab tab1, tab2;
	GridPane pane;
	//FormList formList;
	
	//static private FormActions formActions;
	//private Client client;
	//User currentUser;
	
	private MenuBar menuBar;
	private Menu menuUser;
	private Menu menuTools;
	private Menu menuUserTab;
	private Menu menuStatistics;
	private MenuItem menuUserLogout;
	private MenuItem menuUserLogin;
	private MenuItem menuUserRegister;
	private MenuItem menuCreate;
	private MenuItem menuSearch;
	private MenuItem menuStationList;
	private MenuItem menuViewUserEvents;
	private MenuItem menuCreateStatistic;
	
	private final TableView<Event> table = new TableView<>();
	private final ObservableList<Event> data =
            FXCollections.observableArrayList(new Event("Petras", "Apr", "TEST", "Station", "1991-04-05", "1999-08-14"));
	
	
	public static void main(String[] args){
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
	
		
		RowConstraints row1;
		row1 = new RowConstraints();
		row1.setPercentHeight(100);
		ColumnConstraints col1 = new ColumnConstraints();
	    col1.setPercentWidth(25);
	    ColumnConstraints col2 = new ColumnConstraints();
	    col2.setPercentWidth(75);
	    
	    pane = new GridPane();
	    pane.getColumnConstraints().addAll(col1, col2);
	    pane.getRowConstraints().add(row1);
	    pane.setHgap(10);
	 //   tabs = new FormTabPane();


//		formList = new FormList(this);
//		formList.setPrefWidth(150);
//		formList.setMaxHeight(Double.MAX_VALUE);
//		tabs.setMaxWidth(Double.MAX_VALUE);
//		tabs.setMaxHeight(Double.MAX_VALUE);
//		pane.add(formList,0, 0);
//	    pane.add(tabs, 1, 0);

	//	pane.getStyleClass().add("warp");
	//	pane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		menuBar = new MenuBar();
		menuUser = new Menu("User");
		menuUserLogout = new MenuItem("Logout");
	//	menuUserLogout.setOnAction(new onLogout(this));
		menuUserLogin = new MenuItem("Login");
		menuUserLogin.setOnAction(e -> {
			LoginGUI box = new LoginGUI(this);
		});
		
		menuUserRegister = new MenuItem("Register");
		menuUserRegister.setOnAction(e -> {
			RegisterGUI box = new RegisterGUI();
		});		
		
		menuTools = new Menu("Tools");
		menuCreate = new MenuItem("Create");
		menuCreate.setOnAction(e -> {
	//		CreateFormGUI box = new CreateFormGUI(this);
		});
		
		menuSearch = new MenuItem("Stations");
		menuSearch.setOnAction(e -> {
			SearchEventGUI box = new SearchEventGUI(this);
		});
		
		menuStationList = new MenuItem("Stations list");
		menuStationList.setOnAction(e -> {
					StationsGUI box = new StationsGUI(this);
		});
		
		menuUserTab = new Menu("User");
		menuCreate = new MenuItem("Create Event");
		menuCreate.setOnAction(e -> {
					//StationsGUI box = new StationsGUI(this);
		});
		menuViewUserEvents = new MenuItem("My Events");
		menuViewUserEvents.setOnAction(e -> {
					//StationsGUI box = new StationsGUI(this);
		});
		
		menuStatistics = new Menu("Statistics");
		menuCreateStatistic = new MenuItem("Generate Statistics");
		
		menuStatistics.getItems().addAll(menuCreateStatistic);
		menuUserTab.getItems().addAll(menuCreate, menuViewUserEvents);
		menuUser.getItems().addAll(menuUserLogin, menuUserRegister);
		menuTools.getItems().addAll(menuSearch, menuStationList);
		menuBar.getMenus().addAll(menuUser, menuTools, menuStatistics, menuUserTab);	//	Form pub[] = new Form[20];
	//	Form priv[] = new Form[20];
		
		
		
		//table.setEditable(true);
		TableColumn firstNameCol = new TableColumn("Author");
		firstNameCol.setCellValueFactory(
                new PropertyValueFactory<>("author"));
		
		TableColumn lastNameCol = new TableColumn("Name");
		lastNameCol.setCellValueFactory(
                new PropertyValueFactory<>("name"));
		
		TableColumn emailCol = new TableColumn("Description");
		emailCol.setCellValueFactory(
                new PropertyValueFactory<>("description"));
		
//		TableColumn stationCol = new TableColumn("Station");
//		emailCol.setCellValueFactory(
//                new PropertyValueFactory<>("observationStation"));
//		
//		TableColumn creationCol = new TableColumn("Creation Date");
//		emailCol.setCellValueFactory(
//                new PropertyValueFactory<>("creationDate"));
//		
//		TableColumn expirationCol = new TableColumn("Expiration Date");
//		emailCol.setCellValueFactory(
//                new PropertyValueFactory<>("expirationDate"));
		

		table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
//		table.getColumn(3).setMinWidth(0);
//		table.getSelectionModel().getColumn(4).setMinWidth(0);
//		table.getColumn(5).setMinWidth(0);
		table.setItems(data);
		
		EventList testData = new EventList();
		Event test1 = new Event("Test Name1", "Test description1", "Test1", "Station1", "1991-04-05", "1999-08-14");
		Event test2 = new Event("Test Name2", "Test description2", "Test2", "Station2", "1991-04-05", "1999-08-14");
		Event test3 = new Event("Test Name3", "Test description3", "Test3", "Station3", "1991-04-05", "1999-08-14");
		Event test4 = new Event("Test Name4", "Test description4", "Test4", "Station4", "1991-04-05", "1999-08-14");
		Event test5 = new Event("Test Name5", "Test description5", "Test5", "Station5", "1991-04-05", "1999-08-14");
		testData.addElement(test1);
		testData.addElement(test2);
		testData.addElement(test3);
		testData.addElement(test4);
		testData.addElement(test5);
		
		for(int i = 0; i < testData.size(); i++)
		{
			data.add(testData.getElement(i));
		}
		
		final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
        	TablePosition pos = table.getSelectionModel().getSelectedCells().get(0);
        	int row = pos.getRow();

        	// Item here is the table view type:
        	Event item = table.getItems().get(row);
        	System.out.println("WE NEED DATA: "+ item.getAuthor());
        	System.out.println("WE NEED DATA: "+ item.getName());
        	System.out.println("WE NEED DATA: "+ item.getDescription());
        	//TableColumn col = pos.getTableColumn();
        	EventViewGUI box = new EventViewGUI(this, item);

        });
		
		
		
		VBox all = new VBox();
		all.getChildren().add(menuBar);
		all.getChildren().add(pane);
		all.getChildren().add(table);
		all.getChildren().add(addButton);
		all.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		Scene scene = new Scene(all, 600, 500);

		stage.setScene(scene);
		stage.setMinWidth(600);
		stage.setMinHeight(500);
		
		//scene.getStylesheets().add("style.css");
		stage.setTitle("Projektas");
		stage.show();
		
		this.stage = stage;
		}
	}
