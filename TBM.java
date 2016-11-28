

public class TBM extends Character { 

    public String name; 
    public int instaKill; 


    // Default constructor 

    TBM() { 

	name = "TBM: Supreme Overload"; 
	HP = 200; 
	strength = 100; 
	defense = 50; 
	attack = 1.5; 
        category = "TBM"; 
	instaKill = 2; 
    }


    // Overloaded Constructor with name input 

    TBM (String nAme) { 
	this(); 
	name = nAme; 
    }
 
    // Takes a character input and automatically kills them, as long as you have an instaKill in your arsenal still. 

    public void toInstaKill (Character a) { 
	if (instaKill == 0) {HP /= 2; defense /= 2; strength /= 2; attack /= 2;} 
	else {a.HP = 0; instaKill -= 1;} 
    } 


    // Sacrifies HP, defense, attack, and strength for an instakill 

    public void instaKilladd () { 
	strength /= 2; 
	HP /= 2;
	defense /= 2;
	attack /= 2; 
	instaKill += 1;
    } 
    
    public void normalize () { 
	defense = 50; 
	attack = 1.5; 
    } 

    public void specialize() { 
	defense -= 10; 
	attack -= .2; 
    } 

    public String about() { 
	String retStr; 
	retStr = "TBM: An Star Trek Martian redshirt class with a high amount of strength and attack rating, and has the same defense as a Warrior. He is the best class ever, I mean come on. HE IS VIRTUALLY A GOD!!!"; 
	return retStr; 
    } 
    // Main method 

    public static void main (String[] args) { 
	TBM tophs = new TBM("hi"); 
	System.out.println(tophs.name);
	System.out.println(tophs.instaKill); // 2
	System.out.println(tophs.HP); // 200 
	System.out.println(tophs.defense); // 50
	System.out.println(tophs.attack); // 1.5
	System.out.println(tophs.strength); // 100
	tophs.instaKilladd(); 
	System.out.println(tophs.instaKill); // 3
	System.out.println(tophs.HP); // 100 
	System.out.println(tophs.defense); // 25
	System.out.println(tophs.attack); // 0.75
	System.out.println(tophs.strength); // 50
    } 


    
    




}
