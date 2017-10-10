import java.lang.Math.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class TripleStairs{
	public static int stepCount(int n, int[] mem){
		if(n < 0){
			return 0;
		}
		if (mem[n] != -1) {
			return mem[n];
		}		
		else if((n == 0) || (n == 1)){
			return 1;
		}
		else{
			mem[n] = stepCount(n - 1, mem) + stepCount(n - 2, mem) + stepCount(n - 3, mem);
			return mem[n];
		}
	}

	public static int dpStepCount(int n, int[] mem){
		mem[1] = 1;
		mem[2] = 2;
		mem[3] = 4;
		for (int i = 4; i <= n; i++) {
			mem[i] = mem[i - 1] + mem[i - 2] + mem[i - 3];
		}
		return mem[n];
	}

	public static void main(String[] args) {
		int n;				
		System.out.println("Enter the step value");
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int[] mem = new int[n + 1];
		Arrays.fill(mem, -1);
		System.out.println(dpStepCount(n, mem));
	}
}