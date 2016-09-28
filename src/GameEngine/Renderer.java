package GameEngine;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Renderer {

	private ArrayList<ImageComponent> images = new ArrayList<ImageComponent>();
	
	private static Renderer thisInstance;
	public static Renderer getInstance() {
		if (thisInstance == null)
			thisInstance = new Renderer();
		return thisInstance;
	}
	
	private Renderer(){
		Window.getInstance();
	}
	
	public void draw(){
		Graphics2D winGraphics = (Graphics2D) Window.getInstance().getGraphics();
		
		for(ImageComponent image : images){
			winGraphics.drawImage(image.getImage(), image.getX(), image.getY(), null);
		}
	}
	
	public void addImageComponent(ImageComponent image){
		images.add(image);
	}
	
	public void clearImageComponents(){
		images.clear();
	}
	
}
