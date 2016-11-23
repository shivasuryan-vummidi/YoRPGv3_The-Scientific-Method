// The Sceintific Method: Edwin Mok, Eugene Thomas, and Shiva Vummidi
// APCS1 pd3
// HW30 -- Ye Olde Role Playing Game
// 2016-11-16

public class Warrior extends Character{ 

 // ------------ PRIVATE INSTANCES ------------ // 
    //in superclass
    /*            private String name; 
                private int HP; 
                private int strength; 
                private int defense; 
                private double attack; 
    */
    // defualt constructor 
    private String name;
    public Warrior() { 

	name = "N/A";
	HP = 150; 
        strength = 100; 
	defense = 40; 
	attack = .4; 
    } 

    // overloaded constructor with the String input for name 

    public Warrior (String name1) { 

	this(); 
	name = name1;

    }

    // Returns true if the HP is above 0 (showing the Warrior is still alive).
    // Returns false otherwise (showing the Warrior is dead RIP). 
    //Already in superclass
    /* public boolean isAlive () { 
	
	return HP > 0; 

	} */

    /* ===========================================

      Getter methods can be used to make private
      accesible for limited use within other classes.
      In this case, the getter method getDefense() will 
      be used to return the private instance defense
      of class Monster within the class Warrior. 

    ========================================== */
    //Already in superclass
    /*
    public int getDefense () { 

	return defense; 
	} */

    // The getter method for the instance variable name. 
    
    public String getName () { 
	
	return name; 

    }  

    // The getter method for the instance variable HP.
    //Already in superclass
    /*
    public int getHP () { 
	
	return HP;
    } 
    */
    // Decreases the HP of a Warrior by the inputted integer val. 
    //Already in superclass
    /*
    public void lowerHP (int val) { 

	HP -= val; 

    } 
    */
    /* -------------------------------------------

       This method simulates the Warrior's attack
       and returns the damage done by the attack. 

       damage = (strength)(attack) - (defense of monster) 

       ------------------------------------------*/ 

    //Already in superclass

    /*
    public int attack (Monster mon) { 

	int damage; 
	damage = (int)(strength * attack - mon.getDefense()); 
        return damage;  

    } 
    */

    // Simulates a special attack which results in a decrease of defense and an increase in attack. 

    public void specialize () { 

	defense -= 10; 
	attack += .1; 

    } 

    // Simulates a normal attack which results in the resetting of both defense and attack. 

    public void normalize() { 

	defense = 40; 
	attack = .4; 

    } 

    public String about() { 
	String retStr; 
	retStr = "Warrior: The perfect balance of HP, strength, defense, and attack rating. \n--Rogue: The best assassin ever, with medium strength and a very high attack rating, but sacrifices defense."; 
	return retStr; 
    } 

    public static void main (String[] args) { 

        // To test within the class Warrior you must initialize both a monster and a warrior.	
	Monster Mew = new Monster(); 
	Warrior TBM = new Warrior();  
	System.out.println(TBM.isAlive()); // true 
	System.out.println(TBM.getDefense()); // 40
	System.out.println(TBM.getName()); // N/A
	TBM.lowerHP(10); 
	System.out.println(TBM.HP); // 140 
	TBM.attack(Mew); 
	TBM.specialize(); 
	System.out.println(TBM.defense); // 30
	System.out.println(TBM.attack); // .3
	TBM.normalize(); 
	System.out.println(TBM.defense); // 40
	System.out.println(TBM.attack); // .4 

    } 

} 
