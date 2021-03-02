//written by Damien King in conjunction with Kaelin Dupree
//takes an input n and r and outputs all possible combinations given those values

import java.util.ArrayList;
import java.util.Scanner;
public class combo {
        public static void main(String args[]){
        Scanner in = new Scanner(System.in);

		//sets int n and r from inputs from the command line
		int n = Integer.parseInt(args[0]);
		int r = Integer.parseInt(args[1]);
      
        String set ="{";

        //creates an array list to store the combinations in
        ArrayList<Integer> combo = new ArrayList<Integer>();

		//creates an int set to print out the original input set correctly formatted
        for(int i = 1; i <= n; i++){
            if (i!= 1) set = set + " ";
            combo.add(i);
            set = set+ i;
        }
        set = set + "}";

       System.out.println("The " + n+ "-combinations from the set of " + set + " are: ");

//long loops is the ammount of iterations the loop must go through to create all possible combinations
long loops = factorial(n)/factorial(r)*factorial(n-r);
int i = r;
//algorithm given in lab instructions
for(int g = 0; g < loops; g++) {
    i = r;
	
        while (combo.get(i) > n - r + i) {
            i = i - 1;
        }
        combo.set(i, combo.get(i) + 1);
        for (int j = i + 1; j <= r; j++) {
            combo.set(j, combo.get(i) + j - i);
        }

        String com = "{";
        for (int f = 0; f < r; f++) {
            if (f != 0) com = com + " ";
            com = com + combo.get(f);
        }
        com = com + "}";
        System.out.println(com);
}
      


    }
	
	//method for calculating factorials
	//takes in a number calculates the factorial and returns the value
    public static long factorial(int num){
        long factorial = 1;
        for(int i = 1; i <= num; i++)
        {
            factorial = factorial * i;
        }
        return factorial;
    }

}
