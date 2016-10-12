package GameEngine;

import java.util.ArrayList;

public class Engine {

	private ArrayList<GameObject> gameObjects;
	private boolean running;
	Renderer ren = Renderer.getInstance();
	
	private static Engine thisInstance;
	public static Engine getInstance() {
		if (thisInstance == null)
			thisInstance = new Engine();
		return thisInstance;
	}
	
	private Engine(){
		gameObjects = new ArrayList<GameObject>();
	}
	
	public void initiate(){
		running = true;
		Thread loop = new Thread()
	      {
	         public void run()
	         {
	            gameLoop();
	         }
	      };
	      loop.start();
	}
	
	private void gameLoop(){
		
		long lastTime = System.currentTimeMillis();
		
		while(running){
			
			long currentTime = System.currentTimeMillis();
			long dt = lastTime - currentTime;
			lastTime = currentTime;
			
			ren.draw();
		}
	}
	
	private void update(float dt){
		
	}
	
	public void addGameObject(GameObject go){
		gameObjects.add(go);
		
		for(Component comp : go.getComponents()){
			if(comp instanceof ImageComponent){
				Renderer.getInstance().addImageComponent(((ImageComponent) comp));
			} else if(comp instanceof SoundClip){
				SoundManager.getInstance().addSound((SoundClip) comp);
			}
		}
	}
	
	
}
