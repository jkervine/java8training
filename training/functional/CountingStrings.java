package functional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class CountingStrings {
	private static List<String> strings = Arrays.asList("foo",
			"bar","ok","anything","content","etc");

	private static List<Optional<String>> ducks = Arrays.asList("Duck, Donald", "Mouse, Mickey", 
			"", "Goofy","", "Black, Pete", "McDuck, Scrooge",
			"Duck, Louie", "Duck, Huey", "Duck,Dewey", "Duck, Daisy",
			"Gander, Gladstone").stream()
			.map(x -> (Optional.of(x))).collect(Collectors.toList());
	
	public static void main(String[] args) {
		double res = strings.stream().mapToDouble(String::length).reduce(0,(a,b) -> a+b);
		System.out.println("All strings are total length of : "+res);
		long items = strings.stream().collect(Collectors.counting());
		System.out.println("Total amount of strings:"+items);
		String foo = strings.stream().collect(Collectors.joining());
		System.out.println("Strings array after joining (): "+foo);
		//----------
		List<Optional<String>> nonEmptyDucks = ducks.stream()
				.filter(x -> { return x.isPresent() && (x.get().length() > 0);})
				.collect(Collectors.toList());
		System.out.println("Original ducks is of length: "+ducks.size());
		System.out.println("Non-empty ducks are :"+nonEmptyDucks.size());
		List<Optional<String>> dStartingDucks = ducks.stream()
				.filter(x -> { return x.isPresent() && x.get().startsWith("D");})
				.collect(Collectors.toList());
		System.out.println("Ducks starting with D, count: "+dStartingDucks.size());
		dStartingDucks.forEach(System.out::println);
		//---------
	}
}
