package GameEngine;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Renderer {

	private ArrayList<ImageComponent> images = new ArrayList<ImageComponent>();
	Window win = new Window();
	
	public Renderer(){
	}
	
	public void draw(){
		Graphics2D winGraphics = (Graphics2D) win.getGraphics();
	}
	
	public void addImageComponent(ImageComponent image){
		images.add(image);
	}
	
	public void clearImageComponents(){
		images.clear();
	}
	
}
