package entitys;

public class Event {
	private String name;
	private boolean sendEmail;
	private String creationDate;
	private String expirationDate;
	private String author;
	private boolean isPublic;
	private String observationStation;
	private boolean isGlobal;
	private boolean isReacuring;
	private int ReaccurenceFrequency;
	private String description;
	private String lastOccurance;
	private boolean state;
	
	
	




	public Event(String name, boolean sendEmail, String creationDate, String expirationDate, String author,
			boolean isPublic, String observationStation, boolean isGlobal, boolean isReacuring,
			int reaccurenceFrequency, String description, String lastOccurance) {
		super();
		this.name = name;
		this.sendEmail = sendEmail;
		this.creationDate = creationDate;
		this.expirationDate = expirationDate;
		this.author = author;
		this.isPublic = isPublic;
		this.observationStation = observationStation;
		this.isGlobal = isGlobal;
		this.isReacuring = isReacuring;
		ReaccurenceFrequency = reaccurenceFrequency;
		this.description = description;
		this.lastOccurance = lastOccurance;
		this.state = false;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public boolean isSendEmail() {
		return sendEmail;
	}



	public void setSendEmail(boolean sendEmail) {
		this.sendEmail = sendEmail;
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



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public boolean isPublic() {
		return isPublic;
	}



	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}



	public String getObservationStation() {
		return observationStation;
	}



	public void setObservationStation(String observationStation) {
		this.observationStation = observationStation;
	}



	public boolean isGlobal() {
		return isGlobal;
	}



	public void setGlobal(boolean isGlobal) {
		this.isGlobal = isGlobal;
	}



	public boolean isReacuring() {
		return isReacuring;
	}



	public void setReacuring(boolean isReacuring) {
		this.isReacuring = isReacuring;
	}



	public int getReaccurenceFrequency() {
		return ReaccurenceFrequency;
	}



	public void setReaccurenceFrequency(int reaccurenceFrequency) {
		ReaccurenceFrequency = reaccurenceFrequency;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getLastOccurance() {
		return lastOccurance;
	}



	public void setLastOccurance(String lastOccurance) {
		this.lastOccurance = lastOccurance;
	}



	public boolean getState() {
		return state;
	}



	public void setState(boolean state) {
		this.state = state;
	}


}
