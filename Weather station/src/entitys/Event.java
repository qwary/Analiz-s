package entitys;

public class Event {
	private String name;
	private String description;
	private String author;
	private String observationStation;
	private String creationDate;
	private String expirationDate;
	
	
	
	public Event(String name, String description, String author, String observationStation, String creationDate, String expirationDate) {
		super();
		this.name = name;
		this.description = description;
		this.author = author;
		this.observationStation = observationStation;
		this.creationDate = creationDate;
		this.expirationDate = expirationDate;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getObservationStation() {
		return observationStation;
	}
	public void setObservationStation(String observationStation) {
		this.observationStation = observationStation;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
}
