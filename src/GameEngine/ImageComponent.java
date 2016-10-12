package GameEngine;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class ImageComponent extends Component {
	
	private Resource<BufferedImage> image;
	private int x;
	private int y;
	
	public ImageComponent(Resource<BufferedImage> image, int x, int y){
		this.image = image;
		this.x = x;
		this.y = y;
	}
	
	public Resource<BufferedImage> getImage(){
		return this.image;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
}
