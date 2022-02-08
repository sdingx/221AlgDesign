import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'balancedSums' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static String balancedSums(List<Integer> arr) {
    // Write your code here
    Integer[] array = new Integer[arr.size()];
    arr.toArray(array); // fill the array
    
    // return "" + array.length;
    int sum = 0;
    for (int i=0; i<arr.size(); i++) {
        sum += array[i];
        // int left = 0, right = 0;
        // if (i > 0) {
        //    for (int j=0; j<i; j++) {
        //     left += array[j];
        // } 
        // }
        
        
        // if (i<arr.size()-1) {
        //     for (int k=i+1; k<arr.size(); k++) {
        //     right += array[k];
        // }
        }
    int left = 0, right =0;
    for (int i=0; i<arr.size(); i++) {
        
        if (i>0) {
          left += array[i-1]; 
        }
        int pivot = array[i];
        right = sum - left - pivot;
        if (left==right) {
            return "YES";
        }
    }
        
        // left = addDown(i, arr, 0);
        // right = addUp(i, arr, 0);
    
    return "NO";
    }
    
    // private static int addDown(int n, List<Integer> arr, int sum) {
    //     if (n == 0) {
    //         sum += arr.get(n);
    //         return sum;
    //     }
    //     else {
    //         sum += arr.get(n);
    //         return addDown(n-1, arr, sum);
    //     }
    // }
    
    // private static int addUp(int n, List<Integer> arr, int sum) {
    //     if (n == arr.size()-1) {
    //         sum += arr.get(n);
    //         return sum;
    //     }
    //     else {
    //         sum += arr.get(n);
    //         return addDown(n+1, arr, sum);
    //     }
    // }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                String result = Result.balancedSums(arr);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
