import java.util.ArrayList;
import java.util.Random;

public class Main {

    class characterTemplate {
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
            Random dice = new Random();
            this.Name = name;
            this.LVL = level;
            this.feats = new ArrayList<String>();
            String[] statsAvailable = {"STR","DEX","CON","INT","WIS","CHA"};
            for (int i=0; i < 6; i++) {
                int[] rolledDice = {dice.nextInt(1,6), dice.nextInt(1,6), dice.nextInt(1,6), dice.nextInt(1,6)};
                int[] sortedRolledDice = bubbleSort(rolledDice);

                for (int j=sortedRolledDice.length-1; j > 1; j--) {

                }


            }



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






    }
}
