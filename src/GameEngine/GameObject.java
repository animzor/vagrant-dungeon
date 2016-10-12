package GameEngine;

import java.util.ArrayList;

public class GameObject {

	private ArrayList<Component> components;
	
	public GameObject(){
		components = new ArrayList<Component>();
	}
	
	public void addComponent(Component comp){
		components.add(comp);
	}

	public ArrayList<Component> getComponents() {
		return components;
	}
	
}
