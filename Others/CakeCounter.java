import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.lang.Math;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CakeCounter{   
     public static int answer(String s) { 

        // Your code goes here.
        int[] prefixArray = new int[s.length()];
        int[] count = new int[s.length()];
        int sliceCounter = 0;
        int iter = 0;
        int diff = 0;
        boolean flag = true;
        prefixArray = computePrefixArray(s);
        if(s.length() == 1){
            return 1;
        }
        else if(prefixArray[s.length() - 1] == 0){
            return 1;
        }
        if(calcDiff(s.length()-1, prefixArray[s.length()-1]) == 0){
            return s.length();
        }
        iter = s.length() - 1;
        // diff = (s.length()-1) - prefixArray[s.length() - 1];
        while(iter != 0 && flag){
            sliceCounter += 1;
            /*if (prefixArray[iter] == 0) {
                break;
            }*/
            /*if (calcDiff(iter - 1, prefixArray[iter - 1]) == 0) {
                iter = prefixArray[iter - 2];
                continue;
            }*/

            /*if(calcDiff(prefixArray[iter], 1) != prefixArray[iter - 1]){
                // System.out.println("Setting flag to false for: " + iter + ", " + prefixArray[iter]);

                flag = false;
                // sliceCounter--;
            }*/
            if (prefixArray[iter - 1] > prefixArray[iter]) {
                count[calcDiff(iter, prefixArray[iter])]++;
                iter = prefixArray[iter];   
            }
            else{
                count[calcDiff(iter, prefixArray[iter - 1])]++;
                iter = prefixArray[iter - 1];
            }

            
        }
        // sliceCounter += 1;
        // if(flag == false){
        //     return 1;
        // }
        int max = count[0];
        for (int i : count) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    } 
    
    private static int calcDiff(int a, int b){        
        if(b == 0){
            return (a - b + 1);
        }
        else{
            return (a - b);
        }        
    } 
    
    public static int[] computePrefixArray(String s){
        int[] tempArray = new int[s.length()];
        //Arrays.fill(tempArray, 0);
        tempArray[0] = 0;
        int j = 0;
        for(int i = 1; i < s.length();){
            if(s.charAt(i) == s.charAt(j)){
                tempArray[i] = j + 1;
                i++;
                j++;
            }
            else{
                if(j != 0){
                    j = tempArray[j - 1];
                }
                else{
                    tempArray[i] = 0;
                    i++;
                }
            }
        }
        return tempArray;
    }

	public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(answer(s));
    }


	
}