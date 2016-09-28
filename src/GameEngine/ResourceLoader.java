package GameEngine;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.Clip;

public class ResourceLoader {
	
	private final String resourceFolder = "resources/";
	
	private Map<String, Resource<BufferedImage>> images = new HashMap<String, Resource<BufferedImage>>();
	private Map<String, Resource<Clip>> sounds = new HashMap<String, Resource<Clip>>();
	
	private static ResourceLoader thisInstance;
	public static ResourceLoader getInstance() {
		if (thisInstance == null)
			thisInstance = new ResourceLoader();
		return thisInstance;
	}
	
	private ResourceLoader(){
		
	}
	
	public void load(){
		
	}
	
}
	
	