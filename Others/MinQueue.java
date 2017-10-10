import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.lang.Math;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class MinQueue{	
	public static class PriorityQueueImp{
		// private int i;
		private int[] A;
		// private int key;
		private int heapSize;
		private int ArrSize;

		PriorityQueueImp(int ArrSize){
			A = new int[ArrSize];
			heapSize = 0;
		} 

		public void addKey(int key){
			int i;
			heapSize += 1;
			i = heapSize - 1;
			A[i] = 10000;
			heapDecreaseKey(i, key);
		}

		public void heapDecreaseKey(int i, int key){
			if (key < A[i]) {
				A[i] = key;
				while(i > 0 && A[(i-1)/2] > A[i]){
					// swap(A[i], A[parent(i)]);
					int temp = A[i];
					A[i] = A[(i-1)/2];
					A[(i-1)/2] = temp;
					i = (i - 1)/2;
				}
			}
		}

		public int extractMin(){
			if (heapSize > 0) {
				int min = A[0];
				A[0] = A[heapSize - 1];
				heapSize--;
				minHeapify(0);
				return min;
			}
			return -1;
		}

		public void minHeapify(int i){
			int left = 2*i + 1;
			int right = 2*i + 2;
			int min;
			if (left < heapSize && A[left] < A[i]) {
				min = left;
			}
			else{
				min = i;
			}
			if (right < heapSize && A[right] < A[min]) {
				min = right;
			}
			if (min != i) {
				int temp = A[i];
				A[i] = A[min];
				A[min] = temp;
				minHeapify(min);
			}
		}
	}

	public static void main(String[] args){
		PriorityQueueImp pq = new PriorityQueueImp(6);
		pq.addKey(20);
		pq.addKey(10);
		pq.addKey(5);
		pq.addKey(5);
		pq.addKey(4);
		pq.addKey(3);
		System.out.println("Queue Elements");
		for (int i : pq.A) {
			System.out.println(i);
		}
		System.out.println("Min Element: " + pq.extractMin());
		System.out.println("Queue Elements");
		for (int i = 0; i < pq.heapSize; i++) {
			System.out.println(pq.A[i]);
		}
	}
}