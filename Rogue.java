public class Rogue extends Character { 

   Rogue() { 

	HP = 125; 
	strength = 50; 
	defense = 25; 
	attack = 1; 
        category = "Rogue"; 
    }

    public void normalize() { 
	defense = 25; 
	attack = 1; 
    } 

    public void specialize() { 
	defense -= 10; 
	attack += 1; 
    } 
    
    public String about() { 
	String retStr; 
	retStr = "Rogue: The best assassin ever, with medium strength and a very high attack rating, but sacrifices defense.";
	return retStr; 
    } 
    public static void main (String[] args) { 
	Rogue a = new Rogue(); 
	System.out.println(a.HP); 
	System.out.println(a.strength);
	System.out.println(a.defense);
	System.out.println(a.attack);
	System.out.println(a.category);
    } 
}
