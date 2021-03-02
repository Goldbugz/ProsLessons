//Written by Damien King in conjunction with Kaelin Dupree
//allows for the user to enter in a string of characters, finds all possible permutations and searches an english dictionary for possible words

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Jumble {
    public static void main (String args[]){
        Scanner in = new Scanner(System.in);
        char list[];
		String input = args[0];
		
		//creates array list for character objects and strings for the permutations
        ArrayList<ListItem> set = new ArrayList<ListItem>();
        ArrayList<String> permutations = new ArrayList<String>();
        ListItem creator = new ListItem('a',1);

       //puts the input into a character array
        permutations.add(args[0]);
       list = input.toCharArray();

		//finds the factorial of the length of the input for the possible number of permutations
        long factorial = 1;
        for(int i = 1; i <= list.length; ++i)
        {
            factorial = factorial * i;
        }

		//creates ListItem objects and places them into an array
            for (int z = 0; z < list.length; z++) {
                set.add(creator.createItem(list[z], z));
            }

		//loops through and finds every possible permutation
        for(int x = 0; x < factorial-1; x++) {

            int n = list.length - 1;
            int j = n - 1;


			
            while (set.get(j).getPlace() > set.get(j + 1).getPlace()) {
                j = j - 1;
            }

           
            int k = n;

            while (set.get(j).getPlace() > set.get(k).getPlace()) {
                k = k - 1;
            }
            ListItem temp = set.get(j);
            set.set(j, set.get(k));
            set.set(k, temp);

            int r = n;
            int s = j + 1;

            while (r > s) {
                ListItem temp2 = set.get(r);
                set.set(r, set.get(s));
                set.set(s, temp2);

                r = r - 1;
                s = s + 1;
            }

            String perm ="";

            for (int i = 0; set.size() > i; i++) {
                perm = perm + set.get(i).getCh();
            }
            permutations.add(perm);

        }


		//accesses dictionary file
        try{
            int length = permutations.get(0).length();
            //System.out.println(length);
            File f = new File("dictionary.txt");
            Scanner fin = new Scanner(f);

            System.out.println("Possible English Words: ");

			//loops through the entire dictionary and stores each word into a string
            while(fin.hasNextLine()){
                String word = fin.nextLine();
				//checks if the word is equal to the length of the permutations and continues looping if not to save time
                if(word.length() == length){
                    for(int e = 0; e < permutations.size(); e++){
                        if(permutations.get(e).equals(word)){
                            //exits out of the loop if word is found to save time
                            e = permutations.size();
                            //prints out word
                            System.out.println(word);
                        }


                    }
                }
            }

        }

//catch statement for accessing file.
        catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
    }
}
