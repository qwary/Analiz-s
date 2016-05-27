package entitys;

public class Station {
	private String location;
	private boolean state;
	private String name;
	private double temperature;
	private double humidity;
	private double windSpeed;
	
	public Station(String location, boolean state, String name, double temperature, double humidity, double windSpeed) {
		super();
		this.location = location;
		this.state = state;
		this.name = name;
		this.temperature = temperature;
		this.humidity = humidity;
		this.windSpeed = windSpeed;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	public double getHumidity() {
		return humidity;
	}
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	public double getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(float windSpeed) {
		this.windSpeed = windSpeed;
	}
}
