import GameEngine.Engine;
import GameEngine.ResourceLoader;


public class GameLauncher {

	public static void main(String[] args) {
		Engine ge = Engine.getInstance();
		ge.initiate();
		ResourceLoader.getInstance().getImage("background.png");
	}

}
