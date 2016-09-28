package GameEngine;

public class Engine {

	private static Engine thisInstance;
	public static Engine getInstance() {
		if (thisInstance == null)
			thisInstance = new Engine();
		return thisInstance;
	}
	
	private Engine(){
		
	}
	
	public void initiate(){
		Renderer ren = Renderer.getInstance();
		
	}
	
	private void mainLoop(){
		
	}
	
	private void update(float dt){
		
	}
	
	
	
}
