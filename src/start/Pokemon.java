package start;

public class Pokemon {
	
	String naam;
	int offence;
	int defence;
	int level;
	int xp;
	
	public Pokemon(String naam, int offence, int defence, int level, int xp) {
		this.naam = naam;
		this.offence = offence;
		this.defence = defence;
		this.level = level;
		this.xp = xp;
		
	}
	
	public String getNaam(){
		return naam;
	}
}
