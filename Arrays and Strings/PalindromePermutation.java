import java.util.Scanner;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class PalindromePermutation{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		System.out.println(checkPalindrome(s.toLowerCase().toCharArray()));
	}

	private static boolean checkPalindrome(char[] temp){
		boolean flag = false;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < temp.length; i++) {
			if(temp[i] != ' '){
				// System.out.println(temp[i] + " ");
				map.put(temp[i], (map.getOrDefault(temp[i], 0) + 1));	
			}			
		}
		for (char c : map.keySet()) {
			// System.out.println(c +", " + map.get(c));
			if (map.get(c) > 2){
				return false;
			}
			if (map.get(c) == 1) {
				flag = !flag;
				if(flag == false)
					return false;
			}
		}
		return true;
	}
}