import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class KMPAlgorithm{

	private static int[] buildCharacterFrequency(String searchString){
		int length = searchString.length();
		int j = 0;
		int i = j + 1;
		int[] frequecyArr = new int[length];
		Arrays.fill(frequecyArr, 0);
		while (i < length) {
			if (searchString.charAt(i) == searchString.charAt(j)) {
				frequecyArr[i] = j + 1;
				j++;
				i++;
			}
			else{
				if (j != 0) {
					j = frequecyArr[j - 1];
				}
				else{
					i++;
				}
			}
		}
		return frequecyArr;
	}

	public static boolean substringSearch(String text, String subString){
		int[] frequecyArr = buildCharacterFrequency(subString);		
		int j = 0;
		int i = 0;
		int textLength = text.length();
		int subLength = subString.length();
		while (i < textLength) {			
			if (text.charAt(i) == subString.charAt(j)) {
				i++;
				j++;
				if(j == subLength) return true;
			}
			else if(j != 0){
				j = frequecyArr[j - 1];
			}
			else{
				i++;
			}
		}
		return false;
	}


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.next();
		String substring = scanner.next();
		System.out.println("The substring is present in text: " + substringSearch(text, substring));
	}
}