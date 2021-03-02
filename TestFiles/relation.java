//written by Damien King in collaboration with Kaelin Dupree
//takes in an domain size and ordered pairs and returns info on those ordered pairs

import java.util.Scanner;
public class relation {
    public static void main(String args[]){
        //Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        //int n = Integer.parseInt(in.next());
		int n = Integer.parseInt(args[0]);
        int graph[][] = new int[n][n];

        System.out.println("Enter pairs below separated by space.  Enter 0 0 when done.");

        boolean check = true;
        while(check == true){
            String temp = in2.nextLine();
            String tempA [] = temp.split(" ");
            if(Integer.parseInt(tempA[0]) == 0 && Integer.parseInt(tempA[1]) == 0)
                check = false;
            if(check != false) graph[Integer.parseInt(tempA[0])-1][Integer.parseInt(tempA[1])-1] = 1;
        }


        for(int i = 1; i < n+1; i ++){
            for(int j = 1; j <n+1; j++){
                System.out.print("[" + graph[j-1][i-1]+"]");
            }
            System.out.println();
        }

        System.out.println();

        isReflexive(n, graph);
        isAntiReflexive(n,graph);
        isSymmetric(n,graph);
        isAntiSymmetric(n,graph);
        isTransitive(n, graph);
    }

    public static void isReflexive(int n, int graph[][]){
        int i;
        boolean check = true;
        for(i = 0; i < n; i++){
            if (graph[i][i] != 1) check = false;
        }
        if (check == true) System.out.println("Reflexive          Yes");
        else System.out.println("Reflexive          No");
    }

    public static void isAntiReflexive(int n, int graph[][]){
        int i;
        boolean check = true;
        for(i = 0; i < n; i++){
            if (graph[i][i] != 0) check = false;
        }

        if (check == true) System.out.println("AntiReflexive       Yes");
        else System.out.println("AntiReflexive      No");
    }

    public static void isSymmetric(int n, int graph[][]){
        boolean check = true;
        for(int i = n; i > 0; i --){
            for(int j = 1; j <n+1; j++){
               if(graph[j-1][i-1] == 1) {
                   if (graph[i-1][j-1] != 1) check = false;
               }
            }
        }
        if(check ==true) System.out.println("Symmetric          Yes");
        else System.out.println("Symmetric          No");
    }

    public static void isAntiSymmetric(int n, int graph[][]){
        boolean check = true;
        for(int i = n; i > 0; i --){
            for(int j = 1; j <n+1; j++){
                if(graph[j-1][i-1] == 1) {
                    if (graph[i-1][j-1] == 1) check = false;
                }
            }
        }
        if(check ==true) System.out.println("AntiSymmetric      Yes");
        else System.out.println("AntiSymmetric      No");
    }

    public static void isTransitive(int n, int graph[][]){
        boolean check = false;
        for(int i = 0; i <n ; i ++){
            for(int j = 1; j <n; j++){
                if(graph[i][j] == 1) {
                    for(int q =0; q < n; q++){
                        if (graph[j][q] == 1 && graph[i][q] == 1) check = true;
                        else check = false;
                        i = n -1;
                    }
                }
            }
        }
        if(check == true) System.out.println("Transitive         Yes");
        else System.out.println("Transitive         No");
    }
}
