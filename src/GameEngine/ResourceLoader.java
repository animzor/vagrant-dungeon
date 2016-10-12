package GameEngine;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;

public class ResourceLoader {
	
	
	private final String resourceFolder = "src/resources/";
	
	private Map<String, BufferedImage> images = new HashMap<String, BufferedImage>();
	private Map<String, Clip> sounds = new HashMap<String, Clip>();
	
	private static ResourceLoader thisInstance;
	public static ResourceLoader getInstance() {
		if (thisInstance == null)
			thisInstance = new ResourceLoader();
		return thisInstance;
	}
	
	private ResourceLoader(){
	}
	
	public BufferedImage getImage(String name) {

        BufferedImage image = images.get(name);
        if(image != null){
        	return image;
        }
        try{
        	
        	File sourceimage = new File(resourceFolder + name);
        	image = ImageIO.read(sourceimage);
        	images.put(name, image);
        	
        } catch(IOException e){
        	System.out.println("Could not find image " + name + ": " + e.getMessage());
        }

        return image;

    }
	
	public Clip getSound(String name) {
		
		Clip sound = sounds.get(name);
		if(sound != null){
        	return sound;
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
			sound = (Clip) AudioSystem.getLine(info);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		
		return sound;
		
	}
	
	//load an array of images
	public BufferedImage[] getImages(String[] imageNames) {
		BufferedImage[] imageArray = new BufferedImage[imageNames.length];
		for (int i = 0; i < imageNames.length; i++) {
			imageArray[i] = getImage(imageNames[i]);
		}
		return imageArray;
	}
}