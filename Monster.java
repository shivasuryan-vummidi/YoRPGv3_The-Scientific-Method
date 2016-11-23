// The Scientific Method: Edwin Mok, Eugene Thomas, and Shiva Vummidi 
// APCS1 pd3 
// 2016-11-17
// HW30 -- Ye Old Role Playing Game 

public class Monster extends Character { 


    public static void main (String[] args) {
	Monster Mew = new Monster();
	System.out.println(Mew.isAlive());
	System.out.println(Mew.getDefense());
	//	System.out.println(getName());
	System.out.println(Mew.HP);
	Mew.lowerHP(40);
	System.out.println(Mew.HP);
	//	System.out.println();
    } 

    public Monster() { 
	
	HP = 150; 
	strength = (int) (Math.random()*45 + 20);
	defense = 20; 
	attack = 1; 

    }
    //getting rid of the default constructor helps
    /*   public Monster(String nAme){
	this();
	name = nAme;
	}*/

    //Already in superclass
    /*public boolean isAlive () { 
	
	return HP > 0; 

	}
    */
	//Already in superclass
    public int getDefense(){
	return defense;
    }
    //Already in superclass
    /* public int getHP() { 
	return HP; 
	} */
//Already in superclass
    /*public void lowerHP(int x){
	HP -= x;
	}*/
    //Already in superclass
    /*public int attack(Warrior war){
	int damage;
	damage = (int) ((strength * attack) - war.getDefense()); 
	return damage; 
	}*/
    
    public String about () { 
	String retStr; 
	retStr = "MONSTER: The most menacing of all the characters. Anonymous and deadly! Gotta slay 'em all!"; 
	return retStr; 
    } 

    public void specialize() { 
        
    }
    
    public void normalize() {
	
    } } 
