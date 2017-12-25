package start;
import java.util.*;

public class Pokenerds {
	
	@SuppressWarnings({ "unused" })
	public static void main(String[] args) {
				
		Game game = new Game();
		game.start();
		
		
		/*Map<String, Attack> normal = new HashMap<String, Attack>();
		normal.put("Tackle", new Attack("Tackle", 10, 20, 20));
		
		Map<String, Attack> fire = new HashMap<String, Attack>();
		fire.put("Fire punch", new Attack("Fire punch", 75, 20, 20));
		
		Map<String, Attack> water = new HashMap<String, Attack>();
		water.put("Water gun", new Attack("Water gun", 30, 20, 20));
		
		Pokemon pokemon_1 = new Pokemon("Charmander", 8,8,8,8,90, new Attack[] {
				fire.get("Fire punch"),
				normal.get("Tackle")
		});
		Pokemon pokemon_2 = new Pokemon("Squirtle", 8,8,8,8,100, new Attack[] {
				water.get("Water gun"),
				normal.get("Tackle")
		});
		
		GUI gui = new GUI();
		
		Battle battle1 = new Battle(pokemon_1, pokemon_2, gui); // Mooi hoor
		battle1.start();
		// Als de hp nog steeds groter dan 0 is, voor beide pokemon kan er nog steeds een 
		//nextTurn plaatsvinden,Maar dan moet de hp van een pokemon niet in de min kunnen 
		//gaan volgensmij
		 
		while(pokemon_1.getHp() > 0 && pokemon_2.getHp() > 0 ){
			battle1.nextTurn();
		}*/
	}

}
