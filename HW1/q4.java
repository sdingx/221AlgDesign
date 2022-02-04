
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;


public class q4 {

    ArrayList<Integer> list;
    long totalTime10Times, timeBegin, timeEnd, avgTime;

    public q4(ArrayList<Integer> list) {
        this.list = list;
    }

    public void determineAlgo(String str, ArrayList<Integer> list, int n) {
        if (str.equals("af")) {
            addFront(list, n);
        }

        if (str.equals("am")) {
            addMid(list, n);
        }

        if (str.equals("ae")) {
            addEnd(list, n);
        }

        if (str.equals("df")) {
            for (int i=0; i<n; i++) {
                list.add(1);
            }
            delFront(list, n);
        }

        if (str.equals("dm")) {
            for (int i=0; i<n; i++) {
                list.add(1);
            }
            delMid(list, n);
        }

        if (str.equals("de")) {
            for (int i=0; i<n; i++) {
                list.add(1);
            }
            delEnd(list, n);
        }

    }

    public long cycle(int n, String str, ArrayList<Integer> list) {
        
        for (int i = 0; i < 10; i++) {
            timeBegin = System.currentTimeMillis();
            determineAlgo(str, list, n);
            timeEnd = System.currentTimeMillis();
            totalTime10Times += (timeEnd - timeBegin);
            list = new ArrayList<>();
        }

        avgTime = totalTime10Times/10;

        return avgTime;
    }

    public void addFront(ArrayList<Integer> list, int n) {
        for (int i=0; i<n; i++) {
            list.add(0, 1);
        }
    }

    public void addEnd(ArrayList<Integer> list, int n) {
        for (int i=0; i<n; i++) {
            list.add(1);
        }
    }

    public void addMid(ArrayList<Integer> list, int n) {
        for (int i=0; i<n; i++) {
            list.add(list.size()/2, 1);
        }
    }

    public void delFront(ArrayList<Integer> list, int n) {
        for (int i=0; i<n; i++) {
            list.remove(0);
        }
    }

    public void delMid(ArrayList<Integer> list, int n) {
        for (int i=0; i<n; i++) {
            list.remove(list.size()/2);
        }
    }

    public void delEnd(ArrayList<Integer> list, int n) {
        for (int i=0; i<n; i++) {
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter algorithm to use:");
        // String strForAlg = sc.nextLine();
        // System.out.println("Enter number of repetition:");
        // int rep = Integer.valueOf(sc.nextLine());
        String[] alg = {"af", "am", "ae", "df", "dm", "de"};
        String[] newAlg = {"ae", "de"};
        int[] nrep = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};

        
        // System.out.println("alg: " + strForAlg + ". rep: " + rep);
        System.out.println("loop begin.");

        for (int i: nrep) {
            for (String algName: newAlg) {
                ArrayList<Integer> list = new ArrayList<>();
                q4 sol = new q4(list);
                System.out.println("Computation started.");
                long time = sol.cycle(i, algName, list);
                System.out.println("list size: " + list.size());

                System.out.println("Computation ended. " + "alg: " + algName + ". rep: " + i + ". Total time: " + time + " milliseconds.");
            }
        }
        
    }

}
