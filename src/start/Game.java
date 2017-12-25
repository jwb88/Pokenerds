package start;

import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;

public class Game implements Runnable {
	
	private boolean running = false;
	private Thread thread;
	private int fps = 60;
	private int nanoSecond = 1000000000;
	private GUI gui;
	private int counter = 0;
	private Pokemon pokemon_speler;
	private Pokemon pokemon_AI;
	
	private void init() {
		System.out.println("init");
		gui = new GUI("Pokemon game", 640, 480, this);
		gui.loadContent();
		
		HashMap<String, Attack> normal = new HashMap<String, Attack>();
		normal.put("Tackle", new Attack("Tackle", 10, 20, 20));
		
		HashMap<String, Attack> fire = new HashMap<String, Attack>();
		fire.put("Fire punch", new Attack("Fire punch", 75, 20, 20));
		
		HashMap<String, Attack> water = new HashMap<String, Attack>();
		water.put("Water gun", new Attack("Water gun", 30, 20, 20));
		
		pokemon_speler = new Pokemon("Bulba", 20, 25, 5, 0, 100, new Attack[] {
				water.get("Water gun"),
				normal.get("Tackle")
		});
		
		pokemon_AI = new Pokemon("Charmander", 20, 25, 5, 0, 100, new Attack[] {
				fire.get("Fire punch"),
				normal.get("Tackle")
		});
	}
	
	
	
	// 60 keer per seconde
	private void update() {
		if((counter) % 2 == 0){
			gui.update("What should \n" + pokemon_speler.getName() + " do? ");
		} else {
			gui.update("De AI is aan de beurt xD" + counter);
		}
	}
	
	public void optellen() {
		counter++;
	}
	
	public void run() {
		init();
		
		double timePerTick = nanoSecond / fps; // 1sec in Nanosec / fps
		double delta = 0;
		long now = 0;
		long lastTime = System.nanoTime();
		
		while(running == true) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			lastTime = now;
			
			if(delta >= 1) {
				update();
				delta--;
			}
		}
		
		stop();
	}
	
	public synchronized void start() {
		
		if(running == false) {
			running = true;
			thread = new Thread(this);
			thread.start();
		}
		
	}
	
	public synchronized void stop(){
		
		if(running == true) {
			
			try {
				thread.join();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}		
	}

}
