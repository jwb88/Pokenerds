package start;
import java.util.*;

public class Pokenerds {
	
	@SuppressWarnings({ "unused" })
	public static void main(String[] args) {
		
		ArrayList<Attack> grass = new ArrayList<Attack>();
		ArrayList<Attack> fire = new ArrayList<Attack>();
		fire.add(new Attack("Fire punch", 75, 20, 20));
		grass.add(new Attack("vine whip", 10, 35, 35));
		
		for(int i = 0; i < fire.size(); i++){
			Attack attackInLoopje = fire.get(i);
			System.out.println(attackInLoopje.getNaam());
		}
		
		
		Pokemon pokemon_1 = new Pokemon("lullo", 8,8,8,8);
		
		
	}

}
