import GameEngine.Engine;


public class GameLauncher {

	public static void main(String[] args) {
		Engine ge = Engine.getInstance();
		ge.initiate();
	}

}
