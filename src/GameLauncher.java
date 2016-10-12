import java.awt.image.BufferedImage;

import GameEngine.Engine;
import GameEngine.GameObject;
import GameEngine.ImageComponent;
import GameEngine.Resource;
import GameEngine.ResourceLoader;

	
public class GameLauncher {
	
	public static void main(String[] args) {
		
		Engine ge = Engine.getInstance();
		ResourceLoader loader = ResourceLoader.getInstance();
		
		GameObject go = new GameObject();
		Resource<BufferedImage> img = loader.getImage("background.png");
		ImageComponent comp = new ImageComponent(img, 0, 0);
		go.addComponent(comp);
		
		ge.addGameObject(go);
		ge.initiate();
	}

}
