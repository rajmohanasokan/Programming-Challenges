import java.util.*;
import java.util.Arrays;
import java.util.Scanner;

public class ManacherAlgorithm {
    private static StringBuilder longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        sb.append("@#");
        for(int i = 0; i < s.length(); i++){
            sb.append(s.charAt(i));
            sb.append("#");
        }
        sb.append("$");

        int left = 0, right = 0, centre = 0, palinIndex = 0;
        int[] palinArray = new int[sb.length()];
        Arrays.fill(palinArray, 0);
        // System.out.println(sb);
        for (int i = 1; i < sb.length() - 1; i++){
            int mirror = 2*centre - i;

            if(i < right){
                palinArray[i] = Math.min(right-i, palinArray[mirror]);
            }

            while(sb.charAt(i - 1 - palinArray[i]) == sb.charAt(i + 1 + palinArray[i])){
                palinArray[i]++;
            }

            if (i + palinArray[i] > right) {
                centre = i;
                right = i + palinArray[i];                
            }

            if(palinArray[palinIndex] < palinArray[centre]){
                palinIndex = centre;
            }
        } 

        // System.out.println("Centre at " + centre + "; Length " + palinIndex);
        int startIndex = (palinIndex - palinArray[palinIndex])/2;
        int endIndex = (palinIndex + palinArray[palinIndex])/2; 
        // System.out.println("Start Index " + startIndex + "; End Index " + endIndex);
        for (int i = startIndex; i < endIndex ; i++) {
            result.append(s.charAt(i));
        }

        // System.out.println(result);
        return result;
    }

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(longestPalindrome(s));
    }
}