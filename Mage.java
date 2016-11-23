public class Mage extends Character{
    private String name = "N/A";
    public Mage(){
	HP = 100;
	strength = 40;
	defense = 20;
	attack = 0.4;
	magik = 15;
	category = "mage";
    }
    public Mage(String name1){
	this();
	name = name1;
    }
    public String getName(){
	return name;
    }
    public void specialize(){
	strength = 45;
	magik += 1;
    }
    public void normalize(){
	strength = 40;
    }
    public String about() { 
	String retStr; 
	retStr = "Mage: Uses MAGIK to overwhelm opponents. Only class that uses mana. After mana is consumed, the mage resorts to combat tactics with much lower strength"; 
	return retStr; 
    } 
}
