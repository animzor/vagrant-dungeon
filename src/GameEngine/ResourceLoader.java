package GameEngine;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;

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
	
	public Resource<BufferedImage> getImage(String name) {

        Resource<BufferedImage> resource = images.get(name);
        if(resource != null){
        	return resource;
        }
        try{
        	
        	File sourceimage = new File(resourceFolder + name);
        	BufferedImage image = ImageIO.read(sourceimage);
        	resource = new Resource<BufferedImage>(image, name);
        	images.put(name, resource);
        	return resource;
        	
        } catch(IOException e){
        	System.out.println("Could not find image " + name + ": " + e.getMessage());
        }

        return null;

    }
	
	public Resource<Clip> getSound(String name) {
		
		Resource<Clip> resource = sounds.get(name);
		if(resource != null){
        	return resource;
        }
		
		File file = new File(resourceFolder + name);
		
		AudioInputStream audioStream = null;
		try {
			audioStream = AudioSystem.getAudioInputStream(file);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		AudioFormat format = audioStream.getFormat();
		
		DataLine.Info info = new DataLine.Info(Clip.class, format);
		
		try {
			Clip sound = (Clip) AudioSystem.getLine(info);
			resource = new Resource<Clip>(sound, name);
			return resource;
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	//load an array of images
//	public Resource<BufferedImage>[] getImages(String[] imageNames) {
//		Resource<BufferedImage>[] imageArray = new Resource<BufferedImage>[imageNames.length];
//		for (int i = 0; i < imageNames.length; i++) {
//			imageArray[i] = getImage(imageNames[i]);
//		}
//		return imageArray;
//	}
}