package start;


public class Pokemon {
	
	private String naam;
	private int offence;
	private int defence;
	private int level;
	private int xp;
	private int hp;
	private Attack[] attacks;
	
	public Pokemon(String naam, int offence, int defence, int level, int xp, int hp, Attack[] attacks) {
		this.naam = naam;
		this.offence = offence;
		this.defence = defence;
		this.level = level;
		this.xp = xp;
		this.hp = hp;
		this.attacks = attacks;		
	}
	
	public String getName() {
		return naam;
	}
	
	public int getHp() {
		return hp;
	}
	
	
	public Attack[] getAttacks() {
		return attacks;
		/*for(Attack attack : attacks){
			return attack.getNaam();
		}
		for(int i = 0; i < attacks.length; i++){
			return  attacks[i].getNaam();
		}
		return "OK";
		*/
	}
	
	public void hurt(int damage) {
		hp = hp - damage;
	}
	
	public String attack(Pokemon pokemon, int getal) {
		pokemon.hurt( attacks[getal].getPower() );
		return naam + " used " + attacks[getal].getNaam();
	}
}
