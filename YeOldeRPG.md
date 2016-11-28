                            Ye Olde RPG by The Scientific Method (Edwin Mok, Eugene Thomas, and Shiva Vummidi)

FEATURE ADDITIONS: 

1. Boss: If you're a Grade-A Fighter and the Monster Class is no match for you, the Boss class is an enhanced version of the Monster Class
as each of the Monster's attributes (HP, attack multiplier, defense, strength) are augmented by a hefty margin. Intimidatingly powerful, 
every fighter from here to Ye Olde California quakes in their Ye Olde Boots at the sight of a Boss. 

2. Healer: Ever died? If you have, it would have been nice to have a handy healer by your side! Lacking strength, defense, and attack, but 
making up for it with a heart of gold, the healer is equipped with its own heal method that adds to a given character's HP. This is addition
is a life-saver, literally. 

3. TBM: The man. The myth. The legend. This is the strongest of all possible fighters, given the highest HP, Strength, Defense, and Attack 
statistics out of all fighters. In addition, TBM is given an extra attribute: an instakill counter equipped with toInstaKill and instaKillAdd. 
The point of the instaKill counter is to manage the amount of "instaKills" a TBM instance has. With instaKill > 0, a TBM instance has the 
luxury to automatically kill a monster or boss by setting their HP to 0. The method instaKillAdd() allows a TBM instance to increase their 
instaKill counter by 1 at the expense of half of their HP, strength, attack, and defense. TBM is the man to beat. 

CODE RESTRUCTURINGS: 

1. The Damage Problem: Because the algorithm for attacking a Character x is strength * attack - x.defense, there is an opportunity for 
x.defense to be greater than the product of strength and attack, therefore a Character would be dealing negative damage. Because this is 
illogical, we got around this by setting any damage values less than 0 to 0. 

2. Abstract Art: 

INSTRUCTIONS: 

1. Upon entering "$ java YoRPG", select difficulty. 1 = Easy. 2 = Moderate. 3 = Hard. 
2. Choose to play as one of four classes: Mage, Rogue, Warrior, or TBM. 
3. Select your character's name, then choose the names for your accompanying Healer and TBM.
4. Selectively choose whether you wish to continue your attack or resist. If you attack, you may Math.Random()ly recieve an instakill 
from your TBM or a boost from your Healer. 
5. Slay as many monsters as you can. 
