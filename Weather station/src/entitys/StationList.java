package entitys;

import java.util.ArrayList;

public class StationList {
	ArrayList<Station> elements = new ArrayList<>();
	
	public StationList() {
		
	}

	public StationList(ArrayList<Station> elements) {
		super();
		this.elements = elements;
	}

	public ArrayList<Station> getElements() {
		return elements;
	}

	public void setElements(ArrayList<Station> elements) {
		this.elements = elements;
	}
	
	public void addElement(Station el) {
		elements.add(el);
	}
	
	public Station getElement(int i){
		
		return elements.get(i);
	}
	
	public int size()
	{
		return elements.size();
	}
	
}
