package start;
import java.util.Random;
import java.util.Scanner;

public class Battle {
	
	int turn = 0;
	
	//private Random turnStart, om te bepalen wie er begint;
	Random rn = new Random();
	int range = 1 - 0 + 1;
	int turnStart =  rn.nextInt(range) + 0;
	
	private Pokemon pokemon_speler;
	private Pokemon pokemon_AI;
	private GUI gui;
	
	
	public Battle(Pokemon pokemon_speler, Pokemon pokemon_AI, GUI gui){
		this.pokemon_speler = pokemon_speler;
		this.pokemon_AI = pokemon_AI;	
		this.gui = gui;
	}
	
	/*public void start(){
		// Very nice
		gui.changeMessage("The battle is about to begin. It's " + pokemon_speler.getName() +
				" against " + pokemon_AI.getName() + "\nStatus:\n" + pokemon_speler.getName() + "'s hp: " 
				+ pokemon_speler.getHp() + " " + pokemon_AI.getName() + "'s hp: " + pokemon_AI.getHp());
		
		if((turn + turnStart) % 2 == 0){
			gui.changeMessage(pokemon_speler.getName() + " may begin to attack");
		}
		else {
			gui.changeMessage(pokemon_AI.getName() + " may begin to attack");
		}
	}
	
	public void nextTurn(){		
		if((turn + turnStart) % 2 == 0){ // turn = beurt, turnStart = wie er begint
			// Beurt Speler
			Attack[] attacks = pokemon_speler.getAttacks();
			gui.changeMessage("It is " + pokemon_speler.getName() + "'s turn. \nYou can choose the following attacks:");
			for(int i = 0; i < attacks.length; i++){
				gui.changeMessage(" - " + attacks[i].getNaam());
			}
			gui.changeButtons("Fire punch", "Tackle");
			Scanner input = new Scanner(System.in);
			String aanval_selected = input.nextLine();
			String attackMsg = "";
			
			if(aanval_selected.equals("Tackle")){
				attackMsg = pokemon_speler.attack(pokemon_AI, 1);
			}
			if(aanval_selected.equals("Fire punch")){
				gui.changeMessage("Fire punch wordt uitgevoerd");
				attackMsg = pokemon_speler.attack(pokemon_AI, 0);
			}
			gui.changeMessage(attackMsg);
			
		}
		else {
			// Beurt AI
			Attack[] attacks = pokemon_AI.getAttacks();
			gui.changeMessage("It is " + pokemon_AI.getName() + "'s turn");
			String attackMsg = pokemon_AI.attack(pokemon_speler, (int)Math.random()*attacks.length); //Math.random() = 0.0 t/m 1.0
			gui.changeMessage(attackMsg);
		}

		String statusMsg = "Status: " + pokemon_speler.getName() + "'s hp: " 
				+ pokemon_speler.getHp() + " " + pokemon_AI.getName() + "'s hp: " + pokemon_AI.getHp();
		gui.changeMessage(statusMsg);
		
		turn ++;	// Na elke beurt gaat turn omhoog
	}*/



}
