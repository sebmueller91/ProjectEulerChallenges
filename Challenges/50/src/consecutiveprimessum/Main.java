
package consecutiveprimessum;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		LargestConsecutivePrimesSum largestConsecutivePrimeSum = new LargestConsecutivePrimesSum(1000000);
		List<Integer> largestSum = largestConsecutivePrimeSum.getLargestConsecutivePrimeSum();
		
		printConsecutiveSum(largestSum);
	}
	
	private static void printConsecutiveSum(List<Integer> sum) {
		if (sum == null) {
			return;
		}
		
		for (int i = 0; i < sum.size(); i++) {
			System.out.print(sum.get(i) + " ");
			if (i < sum.size()-1) {
				System.out.print("+ ");
			}
		}
		System.out.print("= " + sumOfList(sum));
	}
	
	private static int sumOfList(List<Integer> list) {
		int sum = 0; 
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		return sum;
	}
}
