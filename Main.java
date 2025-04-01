// Adir Adam 4.1.2025 TTC D&D Project FINAL

import java.util.ArrayList;         // Imports the arraylist for feats
import java.util.Random;            // Imports random for dice

public class Main {

    public static void main(String[] args) {        // Main function, verifies that the classes works, makes me, a barbarian, and a wizard
        System.out.println();
        characterTemplate player = new characterTemplate("Adir", 3);
        player.addFeat("Chopped");
        System.out.println(player + "\n");

        Barbs barbarian = new Barbs("Googy", 6);
        System.out.println(barbarian + "\n");

        Wizard wizard1 = new Wizard("Harry", 1);
        System.out.println(wizard1 + "\n");

    }

    static class characterTemplate {    // Superclass for creating a character
        protected String Name;          // Name of the character or person
        protected int STR,DEX,CON,INT,WIS,CHA,LVL,HP,AC;    // Character Stats
        ArrayList<String> feats;        // Special "feats" of said character


        public characterTemplate() {    // Default Character
            this.Name = "Player";
            this.STR = this.DEX = this.CON = this.INT = this.WIS = this.CHA = this.HP = this.AC = 10;
            this.LVL = 1;
            this.feats = new ArrayList<String>();
        }

        public characterTemplate(String name, int level) {  // Custom Character with random stats and no feats and a custom name and level
            this.Name = name;
            this.LVL = level;
            this.feats = new ArrayList<String>();
            this.STR = rollAbilityScore();
            this.DEX = rollAbilityScore();
            this.CON = rollAbilityScore();
            this.INT = rollAbilityScore();
            this.WIS = rollAbilityScore();
            this.CHA = rollAbilityScore();
            this.HP = rollAbilityScore();
            this.AC = rollAbilityScore();
        }

        private int rollAbilityScore() {        // Function that rolls the ability score
            Random dice = new Random();
            int[] rolls = new int[4];

            for (int i=0; i < 4; i++) {         // Generates the 4 dice rolls
                rolls[i] = dice.nextInt(1,7);
            }

            int[] sortedArray = bubbleSort(rolls);      // Makes a new array which is the sorted version of the rolls

            int sum = 0;

            for (int i = sortedArray.length-1; i >= 1; i--) {       // Then uses the last 3 integers and its sum for stats calculation
                sum += sortedArray[i];
            }

            return sum;
        }

        public static int[] bubbleSort(int[] array) {               // Defines the bubblesort class
            int arrLength = array.length;               // Gets the array's length

            for (int i=0; i<arrLength-1; i++) {         // Outer loop for n iterations
                for (int j=0; j<arrLength-i-1;j++) {                // Outer loop with n-1 iterations
                    if (array[j] > array[j+1]) {        // Checks if the first number is greater than the next, then swaps them
                        int tempLetter = array[j];
                        array[j] = array[j+1];
                        array[j+1]=tempLetter;
                    }
                }
            }
            return array;               // Returns the sorted Array
        }

        public int getAbilityModifier(int score) {      // Ability Modifier method
            return (score - 10) / 2;
        }

        protected void calculateAC() {                  // Calculates the armor class of a character
            AC = 10 + getAbilityModifier(DEX);
        }

        protected void calculateHP() {                  // Calculates the HP of a character based on level
            int conMod = getAbilityModifier(CON);
            if (LVL == 1) {
                HP = 10 + conMod;
            }
            else {
                HP = 10 + conMod + (LVL-1) * (6+conMod);
            }
        }

        public void levelUp() {        // Handles a level up for a character
            LVL++;
            calculateHP();
            calculateAC();
        }

        public void addFeat(String feat) {              // Allows the program to add "feats" to characters
            feats.add(feat);
        }

        @Override
        public String toString() {   // Overrides the "toString" built in class and replaces it with a custom user stats panel
            return Name + " (Level " + LVL + ")" + "\nHP: " + HP + " | AC: " + AC +
                    "\nSTR: " + STR + " | DEX: " + DEX + " | CON: " + CON +
                    "\nINT: " + INT + " | WIS: " + WIS + " | CHA: " + CHA +
                    "\nFeats: " + feats;
        }

    }

    static class Barbs extends characterTemplate {      // Creates a barbarian character out of the character template and adds corresponding elements
        public Barbs(String name, int level) {
            super(name,level);
            STR += 2;
            CON += 1;
            feats.add("Rage");
            feats.add("Unarmored Defense");
            calculateHP();
            calculateAC();
        }

    }

    static class Bards extends characterTemplate {      // Creates a bard character out of the character template and adds corresponding elements
        public Bards(String name, int level) {
            super(name,level);
            CHA += 2;
            DEX += 1;
            feats.add("Inspiration");
            feats.add("Jack of all Trades");
            calculateHP();
            calculateAC();
        }

    }

    static class Cleric extends characterTemplate {      // Creates a cleric character out of the character template and adds corresponding elements
        public Cleric(String name, int level) {
            super(name,level);
            WIS += 2;
            CON += 1;
            feats.add("Channel Divinity");
            feats.add("Turn Undead");
            calculateHP();
            calculateAC();
        }

    }

    static class Druid extends characterTemplate {      // Creates a druid character out of the character template and adds corresponding elements
        public Druid(String name, int level) {
            super(name,level);
            WIS += 2;
            CON += 1;
            feats.add("Wild Shape");
            feats.add("Commune w/ Nature");
            calculateHP();
            calculateAC();
        }

    }

    static class Fighter extends characterTemplate {      // Creates a fighter character out of the character template and adds corresponding elements
        public Fighter(String name, int level) {
            super(name,level);
            DEX += 2;
            CON += 1;
            feats.add("Channel Divinity");
            feats.add("Turn Undead");
            calculateHP();
            calculateAC();
        }

    }

    static class Monk extends characterTemplate {      // Creates a monk character out of the character template and adds corresponding elements
        public Monk(String name, int level) {
            super(name,level);
            DEX += 2;
            WIS += 1;
            feats.add("Unarmored Movement");
            feats.add("Stunning Strike");
            calculateHP();
            calculateAC();
        }

    }

    static class Paladin extends characterTemplate {      // Creates a paladin character out of the character template and adds corresponding elements
        public Paladin(String name, int level) {
            super(name,level);
            STR += 2;
            CHA += 1;
            feats.add("Divine Smite");
            feats.add("Aura of Protection");
            calculateHP();
            calculateAC();
        }
    }

    static class Ranger extends characterTemplate {      // Creates a ranger character out of the character template and adds corresponding elements
        public Ranger(String name, int level) {
            super(name,level);
            DEX += 2;
            WIS += 1;
            feats.add("Favored Enemy");
            feats.add("Surefooted");
            calculateHP();
            calculateAC();
        }

    }

    static class Rogue extends characterTemplate {      // Creates a rogue character out of the character template and adds corresponding elements
        public Rogue(String name, int level) {
            super(name,level);
            DEX += 2;
            INT += 1;
            feats.add("Sneak Attack");
            feats.add("Uncanny Dodge");
            calculateHP();
            calculateAC();
        }

    }

    static class Sorcerer extends characterTemplate {      // Creates a sorcerer character out of the character template and adds corresponding elements
        public Sorcerer(String name, int level) {
            super(name,level);
            CHA += 2;
            CON += 1;
            feats.add("Wild Magic");
            feats.add("Flexible Spellcasting");
            calculateHP();
            calculateAC();
        }
    }

    static class Warlock extends characterTemplate {      // Creates a warlock character out of the character template and adds corresponding elements
        public Warlock(String name, int level) {
            super(name,level);
            CHA += 2;
            CON += 1;
            feats.add("Eldrich Patron");
            feats.add("Pact Magic");
            calculateHP();
            calculateAC();
        }

    }

    static class Wizard extends characterTemplate {      // Creates a wizard character out of the character template and adds corresponding elements
        public Wizard(String name, int level) {
            super(name,level);
            INT += 2;
            CON += 1;
            feats.add("Arcane Recovery");
            feats.add("Spell Mastery");
            calculateHP();
            calculateAC();
        }

    }
}
