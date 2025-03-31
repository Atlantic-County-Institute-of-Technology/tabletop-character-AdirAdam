import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;

public class Main {

    public static void main(String[] args) {
        System.out.println();
        characterTemplate player = new characterTemplate("Adir", 3);
        player.addFeat("Chopped");
        System.out.println(player + "\n");

        Barbs barbarian = new Barbs("Googy", 6);
        System.out.println(barbarian + "\n");

        Wizard wizard1 = new Wizard("Harry", 1);
        System.out.println(wizard1 + "\n");

    }

    static class characterTemplate {
        protected String Name;
        protected int STR,DEX,CON,INT,WIS,CHA,LVL,HP,AC;
        ArrayList<String> feats;


        public characterTemplate() {
            this.Name = "Player";
            this.STR = this.DEX = this.CON = this.INT = this.WIS = this.CHA = this.HP = this.AC = 10;
            this.LVL = 1;
            this.feats = new ArrayList<String>();
        }

        public characterTemplate(String name, int level) {
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

        private int rollAbilityScore() {
            Random dice = new Random();
            int[] rolls = new int[4];

            for (int i=0; i < 4; i++) {
                rolls[i] = dice.nextInt(1,7);
            }

            int[] sortedArray = bubbleSort(rolls);

            int sum = 0;

            for (int i = sortedArray.length-1; i >= 1; i--) {
                sum += sortedArray[i];
            }

            return sum;
        }

        public static int[] bubbleSort(int[] array) {       // Defines the bubblesort class
            int arrLength = array.length;            // Gets the array's length

            for (int i=0; i<arrLength-1; i++) {      // Outer loop for n iterations
                for (int j=0; j<arrLength-i-1;j++) {         // Outer loop with n-1 iterations
                    if (array[j] > array[j+1]) {     // Checks if the first number is greater than the next, then swaps them
                        int tempLetter = array[j];
                        array[j] = array[j+1];
                        array[j+1]=tempLetter;
                    }
                }
            }
            return array;       // Returns the sorted Array
        }

        public int getAbilityModifier(int score) {
            return (score - 10) / 2;
        }

        protected void calculateAC() {
            AC = 10 + getAbilityModifier(DEX);
        }

        protected void calculateHP() {
            int conMod = getAbilityModifier(CON);
            if (LVL == 1) {
                HP = 10 + conMod;
            }
            else {
                HP = 10 + conMod + (LVL-1) * (6+conMod);
            }
        }

        public void levelUp() {
            LVL++;
            calculateHP();
            calculateAC();
        }

        public void addFeat(String feat) {
            feats.add(feat);
        }

        @Override
        public String toString() {
            return Name + " (Level " + LVL + ")" + "\nHP: " + HP + " | AC: " + AC +
                    "\nSTR: " + STR + " | DEX: " + DEX + " | CON: " + CON +
                    "\nINT: " + INT + " | WIS: " + WIS + " | CHA: " + CHA +
                    "\nFeats: " + feats;
        }

    }

    static class Barbs extends characterTemplate {
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

    static class Bards extends characterTemplate {
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

    static class Cleric extends characterTemplate {
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

    static class Druid extends characterTemplate {
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

    static class Fighter extends characterTemplate {
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

    static class Monk extends characterTemplate {
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

    static class Paladin extends characterTemplate {
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

    static class Ranger extends characterTemplate {
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

    static class Rogue extends characterTemplate {
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

    static class Sorcerer extends characterTemplate {
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

    static class Warlock extends characterTemplate {
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

    static class Wizard extends characterTemplate {
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
