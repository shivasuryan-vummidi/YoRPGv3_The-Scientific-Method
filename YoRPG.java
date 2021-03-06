// The Scientific Method: Edwin Mok, Eugene Thomas, Shiva Vummidi
// APCS1 pd3
// HW30 -- Ye Olde Role Playing Game
// 2016-11-16


/*=============================================
  class YoRPG -- Driver file for Ye Olde Role Playing Game.
  Simulates monster encounters of a wandering adventurer.
  Required classes: Warrior, Monster
  =============================================*/

import java.io.*;
import java.util.*;

public class YoRPG
{
    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

    //change this constant to set number of encounters in a game
    public final static int MAX_ENCOUNTERS = 20;

    //each round, a Warrior and a Monster will be instantiated...
    private Character pat;   //Is it man or woman?
    private Monster smaug; //Friendly generic monster name?
    private Healer angel;
    private Mage wiz;
    private Rogue assassin;
    private TBM god;

    private int moveCount;
    private boolean gameOver;
    private int difficulty;

    private InputStreamReader isr;
    private BufferedReader in;

    private int level = 0;
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
    public YoRPG()
    {
	moveCount = 0;
	gameOver = false;
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
	newGame();
    }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~

    /*=============================================
      void newGame() -- gathers info to begin a new game
      pre:  
      post: according to user input, modifies instance var for difficulty 
      and instantiates a Warrior
      =============================================*/
    public void newGame()
    {
	String s;
	String name = "";
	int type = 3;
	s = "~~~ Welcome to Ye Olde RPG! ~~~\n";

	s += "\nChoose your difficulty: \n";
	s += "\t1: Easy\n";
	s += "\t2: Not so easy\n";
	s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
	s += "Selection: ";
	System.out.print( s );

	try {
	    difficulty = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e ) { }

	s = "Player, please pick a class: \n";
	s += "\t1: Mage\n";
	s += "\t2: Rogue\n";
	s += "\t3: Warrior\n";
	s += "\t4: TBM\n";
	s += "Selection: ";
	System.out.print(s);

	try {
	    type = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e) { }
	

	s = "Intrepid player, what doth thy call thyself? (State your name): ";
	System.out.print( s );

	try {
	    name = in.readLine();
	}
	catch ( IOException e ) { }

	//instantiate the player's character
	/*if (type == 1){
	    pat = new Mage( name ); 
	}
	else if (type == 2){
	    pat = new Rogue( name );
	}
	else if (type == 4){
	    pat = new TBM (name);
	}
	else {
	    pat = new Warrior( name );
	    }*/
	//A more compact version of else ifs
	switch (type){
	case 1:
	    pat = new Mage(name);
	    break;
	case 2:
	    pat = new Rogue(name);
	    break;
	case 4:
	    pat = new TBM(name);
	    break;
	default:
	    pat = new Warrior(name);
	    break;
	}
	angel = new Healer();

	s = "What shall thee name thy wiz? (State your Mage's name): ";
	System.out.print ( s );

	try {
	    name = in.readLine();
	}
	catch ( IOException e ) { }

	wiz = new Mage( name );

	assassin = new Rogue();

	s = "What shall thee name thy god? (State your TBM's name): ";
	System.out.print ( s );

	try {
	    name = in.readLine();
	}
	catch ( IOException e ) { }

	god = new TBM ( name );

    }//end newGame()


    /*=============================================
      boolean playTurn -- simulates a round of combat
      pre:  Warrior pat has been initialized
      post: Returns true if player wins (monster dies).
      Returns false if monster wins (player dies).
      =============================================*/
    public boolean playTurn()
    {
	int i = 1;
	int d1, d2, d3;

	if ( Math.random() >= ( difficulty / 3.0 ) )
	    System.out.println( "\nNothing to see here. Move along!" );
	else if ( level == 4){
	    System.out.println( "\nPlayer, congrats! Thee has't arrived at the boss level!" );
	    Boss boss = new Boss();
	    while ( boss.isAlive() && pat.isAlive() ){	   
		// Give user the option of using a special attack:
		// If you land a hit, you incur greater damage,
		// ...but if you get hit, you take more damage.
		try {
		    System.out.println( "\nDo you feel lucky?" );
		    System.out.println( "\t1: Nay.\n\t2: Aye!" );
		    i = Integer.parseInt( in.readLine() );
		}
		catch ( IOException e ) { }

		if ( i == 2 )
		    pat.specialize();
		else
		    pat.normalize();

		d1 = pat.attack( boss );
		d2 = boss.attack( pat );
		if(d1 <= 0){
		    d1 = 0;
		}
		if(d2 <= 0){
		    d2 = 0;
		}
		System.out.println( "\n" + pat.getName() + " dealt " + d1 +
				    " points of damage.");

		System.out.println( "\n" + "Ye Boss smacked " + pat.getName() +
				    " for " + d2 + " points of damage.");
	    }//end while

	    //option 1: you & the Boss perish
	    if ( !boss.isAlive() && !pat.isAlive() ) {
		System.out.println( "'Twas an epic battle, to be sure... " + 
				    "You cut ye Boss down, but " +
				    "with its dying breath ye olde Boss. " +
				    "laid a fatal blow upon thy skull." );
		return false;
	    }
	    //option 2: you slay the Boss and wins the game
	    else if ( !boss.isAlive() ) {
		System.out.println( "HuzzaaH! Ye Boss hath been slain! Thee has't won the game!" );
		return false;
	    }
	    //option 3: the Boss slays you
	    else if ( !pat.isAlive() ) {
		System.out.println( "Ye olde self hath expired. You got dead." );
		return false;
	    }
	}
	else {
	    System.out.println( "\nLo, yonder monster approacheth!" );

	    smaug = new Monster();

	    while( smaug.isAlive() && pat.isAlive() ) {

		// Give user the option of using a special attack:
		// If you land a hit, you incur greater damage,
		// ...but if you get hit, you take more damage.
		try {
		    System.out.println( "\nDo you feel lucky?" );
		    System.out.println( "\t1: Nay.\n\t2: Aye!" );
		    i = Integer.parseInt( in.readLine() );
		}
		catch ( IOException e ) { }

		int luckyDraw = (int) (Math.random() * 20);
		if (luckyDraw < 10 && i == 2){
		    pat.specialize();
		    angel.heal(pat);
		    System.out.println( "Congratulations, thee has't been did heal by the Healer. (Healer heals you by 50 points.)");
		}
		else if ( i == 2 && luckyDraw == 15){
		    pat.specialize();
		    System.out.println("Oh no! Thee angered the god!");
		    god.toInstaKill(pat);
		}
		else if ( i == 2 )
		    pat.specialize();
		else if (i == 1 && luckyDraw < 10){
		    pat.normalize();
		    d3 =  wiz.attack(pat);
		    System.out.println("\n" + "Oh no! The wizard hast been did summon! The wizard smacked " + pat.getName() + " for " + d3 + " points of damage.");
		}
		else if (i == 1 && luckyDraw < 15){
		    pat.normalize();
		    d3 = assassin.attack(pat);
		    System.out.println("\n"+"The assassin sneaked up behind " + pat.getName() + " and damaged " + pat.getName() + " for " + d3 + " points of damage.");
		}
		else
		    pat.normalize();

		d1 = pat.attack( smaug );
		d2 = smaug.attack( pat );

		if (d1 < 0){
		    d1 = 0;
		}
		if (d2 < 0){
		    d2 = 0;
		}

		System.out.println( "\n" + pat.getName() + " dealt " + d1 +
				    " points of damage.");

		System.out.println( "\n" + "Ye Olde Monster smacked " + pat.getName() +
				    " for " + d2 + " points of damage.");
	    }//end while

	    //option 1: you & the monster perish
	    if ( !smaug.isAlive() && !pat.isAlive() ) {
		System.out.println( "'Twas an epic battle, to be sure... " + 
				    "You cut ye olde monster down, but " +
				    "with its dying breath ye olde monster. " +
				    "laid a fatal blow upon thy skull." );
		return false;
	    }
	    //option 2: you slay the beast
	    else if ( !smaug.isAlive() ) {
		System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
		level += 1;
		return true;
	    }
	    //option 3: the beast slays you
	    else if ( !pat.isAlive() ) {
		System.out.println( "Ye olde self hath expired. You got dead." );
		return false;
	    }
	}//end else

	return true;
    }//end playTurn()
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    public static void main( String[] args )
    {
	//As usual, move the begin-comment bar down as you progressively 
	//test each new bit of functionality...


	//loading...
	YoRPG game = new YoRPG();

	int encounters = 0;

	while( encounters < MAX_ENCOUNTERS ) {
	    if ( !game.playTurn() )
		break;
	    encounters++;
	    System.out.println();
	}

	System.out.println( "Thy game doth be over." );
        
    }//end main

}//end class YoRPG

