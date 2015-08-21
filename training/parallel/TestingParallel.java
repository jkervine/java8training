package parallel;

import java.util.stream.IntStream;

public class TestingParallel {
	
	private static final int N = 2000000000;
	
	public static void main(String [] args) {
		IntStream intp = IntStream.range(1, N);
		long startTimeP = System.nanoTime();
		int sum = intp.parallel().sum();
		long endTimeP = System.nanoTime();
		System.out.println("Parallel sum: "+(endTimeP - startTimeP) / 1000);
		IntStream ints = IntStream.range(1, N);
		long startTimeS = System.nanoTime();
		int sumS = ints.sum();
		long endTimeS = System.nanoTime();
		System.out.println("Sequential sum: "+(endTimeS - startTimeS) / 1000);
		IntStream intp2 = IntStream.range(1, N);
		long startTimeP2 = System.nanoTime();
		int sum2 = intp2.parallel().sum();
		long endTimeP2 = System.nanoTime();
		System.out.println("Parallel sum: "+(endTimeP2 - startTimeP2) / 1000);
		IntStream ints2 = IntStream.range(1, N);
		long startTimeS2 = System.nanoTime();
		int sumS2 = ints2.sum();
		long endTimeS2 = System.nanoTime();
		System.out.println("Sequential sum: "+(endTimeS2 - startTimeS2) / 1000);
	}

}
