public abstract class Character{
    //Protected instance vars can be accessed ONLY by this class and by its subclasses.
    protected int HP;
    protected int strength;
    protected int defense;
    protected double attack;
    protected int magik;
    protected String name;
    protected String category;
    abstract void normalize(); 
    abstract void specialize(); 
    abstract String about();

    public Character(){
	HP = 50;
	strength = 20;
	defense = 10;
	attack = 0.2; 
	magik = 0;
	category = "";
    }
    public boolean isAlive(){
	return HP > 0;
    }
    public int getDefense(){
	return defense;
    }
    public String getName(){
	return name;
    }
    public int lowerHP(int damage){
	HP -= damage;
	return HP;
    }
    public int getHP(){
	return HP;
    }
    public int attack(Character a){
	int damage;
	if(magik > 0){
	    damage = (int)((10 * attack * strength) - a.defense);
	    magik -= 5;
	    if(magik < 0){
		magik = 0;
	    }
	}
	else{
	    damage = (int)((strength * attack) - a.defense);
	    if(category == "mage"){
		magik += 1;
	    }
	}
	a.lowerHP(damage);
	return damage;
    }

    public static void main(String[] args){
        
    }
}
