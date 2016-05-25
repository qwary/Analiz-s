package gui;

	import java.io.ByteArrayInputStream;
	import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import entitys.WeatherInformation;
import extfx.scene.chart.DateAxis;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

//import javax.ws.rs.BadRequestException;
	//import javax.ws.rs.InternalServerErrorException;

	import javafx.event.ActionEvent;
	import javafx.event.EventHandler;
	import javafx.geometry.Insets;
	import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
	import javafx.scene.control.Label;
	import javafx.scene.control.PasswordField;
	import javafx.scene.control.TextField;
	import javafx.scene.layout.VBox;
	import javafx.stage.Modality;
	import javafx.stage.Stage;
	//import lt.ktu.projektas.events.onLogin;

	public class StatisticsGUI {
		private Stage window;
		private TextField username;
		private PasswordField password;
		private final MainGUI main;
		public StatisticsGUI(MainGUI main, String target, LocalDate Begin, LocalDate End){
			this.main = main;
			window = new Stage();
			window.initModality(Modality.APPLICATION_MODAL);
			window.setTitle(target + "Graph");
			window.setResizable(false);
			
			ArrayList<WeatherInformation> data = getWeatherData(target, Begin, End);
			
			
			
			
			
			ObservableList<XYChart.Series<Date, Number>> series = FXCollections.observableArrayList();
			 
			ObservableList<XYChart.Data<Date, Number>> series1Data = FXCollections.observableArrayList();
			//series1Data.add(new XYChart.Data<Date, Number>(new GregorianCalendar(2012, 11, 15).getTime(), 2));
			//series1Data.add(new XYChart.Data<Date, Number>(new GregorianCalendar(2014, 5, 3).getTime(), 4));
			double stat = 0;
			for(int i = 0; i < data.size(); i++)
			{
				switch(target){
					case "temperature":  stat = data.get(i).getTemperature();
                break;
					case "humidity":  stat = data.get(i).getHumidity();
                break;
					case "wind Speed":  stat = data.get(i).getWindSpeed();
                break;
				}
				String date = data.get(i).getDate();
				int year = Integer.parseInt(date.substring(0, date.indexOf('-')));
				int month = Integer.parseInt(date.substring(date.indexOf('-')+1, date.lastIndexOf('-')));
				int day = Integer.parseInt(date.substring(date.lastIndexOf('-')+1, date.length()));
				series1Data.add(new XYChart.Data<Date, Number>(new GregorianCalendar(year, month, day).getTime(), stat));
			}
			 
			series.add(new XYChart.Series<>("Series1", series1Data));
			 
			NumberAxis numberAxis = new NumberAxis();
			DateAxis dateAxis = new DateAxis();
			LineChart<Date, Number> lineChart = new LineChart<>(dateAxis, numberAxis, series);
			
			
			
			
			
			 //defining the axes
//	        final NumberAxis xAxis = new NumberAxis();
//	        final NumberAxis yAxis = new NumberAxis();
//	        xAxis.setLabel("Number of Month");
//	        //creating the chart
//	        final LineChart<Number,Number> lineChart = 
//	                new LineChart<Number,Number>(xAxis,yAxis);
//	                
//	        lineChart.setTitle(target+"    "+Begin+"  "+End);
//	        //defining a series
//	        XYChart.Series series = new XYChart.Series();
//	        series.setName(target);
	        //populating the series with data
//	        series.getData().add(new XYChart.Data(1, 23));
//	        series.getData().add(new XYChart.Data(2, 14));
//	        series.getData().add(new XYChart.Data(3.5, 15));
//	        series.getData().add(new XYChart.Data(4, 24));
//	        series.getData().add(new XYChart.Data(5, 34));
//	        series.getData().add(new XYChart.Data(6, 36));
//	        series.getData().add(new XYChart.Data(7, 22));
//	        series.getData().add(new XYChart.Data(8, 45));
//	        series.getData().add(new XYChart.Data(9, 43));
//	        series.getData().add(new XYChart.Data(10, 600));
//	        series.getData().add(new XYChart.Data(11, 29));
//	        series.getData().add(new XYChart.Data(12, 25));
	        
	        Scene scene  = new Scene(lineChart,800,600);
//	        lineChart.getData().add(series);
			

			
			VBox box = new VBox(5);
			box.setPadding(new Insets(5, 5, 0, 5));
			//Scene scene = new Scene(box);
			window.setScene(scene);
			window.showAndWait();
		}
		
		public ArrayList<WeatherInformation> getWeatherData(String target, LocalDate Begin, LocalDate End)    {
		    ArrayList<WeatherInformation> data = new ArrayList<WeatherInformation>();
		    
		    data.add(new WeatherInformation("2016-04-26", "Kauno", 15, 30, 3.7));
		    data.add(new WeatherInformation("2016-04-25", "Kauno", 14, 30, 3.8));
		    data.add(new WeatherInformation("2016-04-24", "Kauno", 18, 30, 3.9));
		    data.add(new WeatherInformation("2016-04-23", "Kauno", 16, 30, 4.8));
		    data.add(new WeatherInformation("2016-04-22", "Kauno", 12, 30, 7.9));
		    data.add(new WeatherInformation("2016-04-21", "Kauno", 5, 30, 8.9));
		    data.add(new WeatherInformation("2016-04-10", "Kauno", 0, 30, 8.9));
		    data.add(new WeatherInformation("2016-04-02", "Kauno", -2, 30, 8.9));
		    data.add(new WeatherInformation("2016-03-20", "Kauno", -4, 30, 8.5));
		    data.add(new WeatherInformation("2016-03-15", "Kauno", -16, 30, 8.2));
		    data.add(new WeatherInformation("2016-03-10", "Kauno", -25, 30, 7.2));
		    data.add(new WeatherInformation("2016-03-01", "Kauno", -33, 30, 4.2));
		    data.add(new WeatherInformation("2016-01-20", "Kauno", -33, 30, 2.2));
		    return(data);
		 }
		
		
		public MainGUI getMain(){
			return main;
		}
		public void close(){
			window.close();
		}

	}
