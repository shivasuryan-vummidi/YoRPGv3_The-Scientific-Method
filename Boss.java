public class Boss extends Character{
    public Boss(){
	HP = 500;
	strength = (int)(Math.random() * 90 + 20);
	defense = 30;
	attack = 1.2;
    }
    public void normalize(){

    }
    public void specialize(){

    }
    public String about(){
	String retStr;
	retStr = "BOSS: The ruler of the monsters and the antichrist to TBM. He will not give an inch and will fight TBM to the death. He is nearly impossible to kill";
	return retStr;
    }
}
