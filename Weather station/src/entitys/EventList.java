package entitys;

import java.util.ArrayList;

public class EventList {
	ArrayList<Event> elements = new ArrayList<>();
	
	public EventList() {
		
	}

	public EventList(ArrayList<Event> elements) {
		super();
		this.elements = elements;
	}

	public ArrayList<Event> getElements() {
		return elements;
	}

	public void setElements(ArrayList<Event> elements) {
		this.elements = elements;
	}
	
	public void addElement(Event el) {
		elements.add(el);
	}
	
	public Event getElement(int i){
		
		return elements.get(i);
	}
	
	public int size()
	{
		return elements.size();
	}
	
}
