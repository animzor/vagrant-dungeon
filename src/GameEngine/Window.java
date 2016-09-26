package GameEngine;

import java.awt.BufferCapabilities;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	

	public Window(){
		super("GameEngine");
		
		setSize(640, 480);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		createBufferStrategy(3);
		
	}
	
	private void render(){
		BufferStrategy bs = getBufferStrategy();
		
		if(!bs.contentsLost()){
			bs.show();
		}
	}
	
}
