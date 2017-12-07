package start;
import java.util.*;

public class Pokenerds {
	
	@SuppressWarnings({ "unused" })
	public static void main(String[] args) {
		
		/*ArrayList<Attack> grass = new ArrayList<Attack>();
		ArrayList<Attack> fire = new ArrayList<Attack>();
		fire.add(new Attack("Fire punch", 75, 20, 20));
		grass.add(new Attack("vine whip", 10, 35, 35));
		
		 for(int i = 0; i < fire.size(); i++){
			Attack attackInLoopje = fire.get(i);
			System.out.println(attackInLoopje.getNaam());
		}
		*/
		
		Map<String, Attack> normal = new HashMap<String, Attack>();
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
		}
		
		
		//myHashMap.put(pokemon_1,attack_1);
		//System.out.println(myHashMap);
		
		//System.out.println(myHashMap.get(pokemon_1).toString());
		
		/*for(Object Pokemon:myHashMap.keySet()) {
			   System.out.println(Pokemon);
			   System.out.println(myHashMap.get(Pokemon));
			 }*/
		
		/*Scanner input = new Scanner(System.in);
		System.out.println("Your pokemon is:" + pokemon_1.getName() 
		+ "\nThe opponents pokemon is:" + pokemon_2.getName() 
		+ "\nIt's your turn, choose an attack:");
		pokemon_1.printAttacks();
		String aanval_selected = input.nextLine();
	*/
		
		/*System.out.println("Status: player: " + pokemon_1.getHp() + "hp, AI: " + pokemon_2.getHp() + "hp");
		pokemon_1.attack(pokemon_2, 0);
		System.out.println("Status: player: " + pokemon_1.getHp() + "hp, AI: " + pokemon_2.getHp() + "hp");*/
	}

}
