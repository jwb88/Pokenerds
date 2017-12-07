package start;

public class Attack {
	
	private String naam;
	private int power;
	private int pp;
	private int maxpp;
	
	public Attack(String naam, int power, int pp, int maxpp){
		this.naam = naam;
		this.power = power;
		this.pp = pp;
		this.maxpp = maxpp;
	}
	
	public String getNaam() {
		return this.naam;
	}
	
	public int getPower() {
		return this.power;
	}
	
	public int getpp() {
		return this.pp;
	}
	
	public int getMaxpp() {
		return this.maxpp;
	}	
	
}
