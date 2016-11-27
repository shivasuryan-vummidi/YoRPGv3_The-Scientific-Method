public class Healer extends Character {

    //instance variables for class Healer not in superclass Character
    private String name;
    private int heal;

    //Default constructor
    public Healer() {
	name = "N/A";
	HP = 100;
	strength = 0;
	defense = 0;
	attack = 0;
	heal = 50;	
    }

    //Overloaded Constructor that takes name as String input
    public Healer(String healerName){
	this();
	name = healerName;
    }

    //Takes a character as input and heal its HP
    public void heal(Character a){
	a.HP += heal;
    }
    public String about() { 
	String retStr; 
	retStr = "Healer: The class is able to heal himself as well as attack his opponents.";
	return retStr; 
    } 
        public void specialize() { 
	    
	}
    
    public void normalize() {
    }
}
