package consecutiveprimessum;

import java.util.ArrayList;
import java.util.List;

public class LargestConsecutivePrimesSum {
	private int endIndex;
	private boolean[] numberIsPrime;
	private Integer[] primes;
	
	public LargestConsecutivePrimesSum(int number) {
		endIndex = number;
		numberIsPrime = new boolean[number+1];
		
		calculateAllPrimesUpToIndex(number);
	}
	
	public List<Integer> getLargestConsecutivePrimeSum() {
		List<Integer> largestSum = null;
		for (int i = 0; i < primes.length; i++) {
			List<Integer> curSum = getLargestConsecutivePrimeSumForStartIndex(i);
			if (largestSum == null || curSum.size() > largestSum.size()) {
				largestSum = curSum;
			}
		}
		return largestSum;
	}
	
	private List<Integer> getLargestConsecutivePrimeSumForStartIndex(int startIndex) {
		List<Integer> largestSeries = new ArrayList<Integer>();
		List<Integer> curSeries = new ArrayList<Integer>();
		
		int sum = 0;
		int curIndex = startIndex;
		
		while (sum < primes[primes.length-1] && curIndex < primes.length) {
			sum += primes[curIndex];
			curSeries.add(primes[curIndex]);
			curIndex++;
			
			if (sum >= numberIsPrime.length) {
				break;
			}
			
			if (numberIsPrime[sum]) {
				copyEntries(curSeries, largestSeries);
			}
		}
		
		return largestSeries;
	}
	
	private void copyEntries(List<Integer> source, List<Integer> destination) {
		for (int i = destination.size(); i < source.size(); i++) {
			destination.add(source.get(i));
		}
	}
	
	private void calculateAllPrimesUpToIndex(int index) {
		List<Integer> primesList = new ArrayList<Integer>();
		
		for (int i = 2; i <= index; i++) {
			if (isPrime(i)) {
				primesList.add(i);
				numberIsPrime[i] = true;
			}
		}
		
		primes = primesList.toArray(new Integer [primesList.size()]);
	}
	
	private boolean isPrime(int number) {
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
