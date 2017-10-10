import java.util.Scanner;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class IsUnique{
	public static void main (String[] args){
		System.out.println("Enter a string");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();		
		boolean flag = true;
		char prev = '\0';
		String result = mergeSort(s, 0, s.length() - 1);
		for (char c : result.toCharArray()) {
			if(prev == c){
				flag = false;
				break;
			}
			prev = c;
		}		

		System.out.println(flag? "Unique" : "Duplicate");
	}

	private static String mergeSort(String temp, int start, int end){
		if(end == start)
			return temp.substring(start, end + 1);

		int mid = (start + end)/2;
		String a = mergeSort(temp, start, mid);
		String b = mergeSort(temp, mid + 1, end);
		// System.out.println(a + ", " + b);
		return merge(a, b);
	}

	private static String merge(String a, String b){
		int i = 0, j = 0; 
		StringBuilder sb = new StringBuilder();
		if(a.length() > 0 && b.length() > 0){
			while(i < a.length() && j < b.length()){
				if ((int) a.charAt(i) < (int) b.charAt(j)) {
					sb.append(a.charAt(i));
					i++;
				}	
				else {
					sb.append(b.charAt(j));
					j++;
				}
			}			
		
			while(i < a.length()){
				sb.append(a.charAt(i));
				i++;
			}
			while(j < b.length()){
				sb.append(b.charAt(j));
				j++;
			}
		}
		// System.out.println("Merged: " + a + " " + b + "->" + sb.toString());
		return sb.toString();
	}
}


