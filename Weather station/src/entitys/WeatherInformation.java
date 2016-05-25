package entitys;

import java.sql.Date;

public class WeatherInformation {
	String date;
	String station;
	double temperature;
	double humidity;
	double windSpeed;
	
	public WeatherInformation(String date, String station, double temperature, double humidity, double windSpeed) {
		super();
		this.date = date;
		this.station = station;
		this.temperature = temperature;
		this.humidity = humidity;
		this.windSpeed = windSpeed;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public double getHumidity() {
		return humidity;
	}
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	public double getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}
}
