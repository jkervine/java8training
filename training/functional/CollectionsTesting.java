package functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CollectionsTesting {

	final static List <Integer> numbers = Arrays.asList(5,10,15,20,11,16,21,26,25,3);
	final static List<Worker> disneyWorkers =
			Arrays.asList( 
					new Worker("Duck, Donald","1934-05-21"), 
					new Worker("Mouse, Mickey","1928-11-18"), 
					new Worker("Goofy",
							"1932-06-01"), 
							new Worker("Black, Pete",
									"1925-06-01"), 
									new Worker("McDuck, Scrooge",
											"1947-12-01"), 
											new Worker("Duck, Louie",
													"1937-06-01"), 
													new Worker("Duck, Huey",
															"1937-06-01"), 
															new Worker("Duck, Dewey",
																	"1937-06-01"), 
																	new Worker("Duck, Daisy",
																			"1940-06-01"), 
																			new Worker("Duck, Grandma",
																					"1943-06-01"), 
																					new Worker("Gander, Gladstone",
																							"1948-01-01"), 
																							new Worker("Goose, Gus",
																									"1939-05-03"), 
																									new Worker("Pluto",
																											"1930-06-01"), 
																											new Worker("Mouse, Minnie",
																													"1928-11-18"), 
																													new Worker("Horsecollar, Horace",
																															"1929-06-01"), 
																															new Worker("Gearloose, Gyro",
																																	"1952-05-01"), 
																																	new Worker("Helper, Little",
																																			"1956-06-01"), 
																																			new Worker("Beeva, Eega",
																																					"1947-05-01"), 
																																					new Worker("O'Hara, Chief",
																																							"1935-06-01"), 
																																							new Worker("Blot, Phantom",
																																									"1939-05-20") 
					);

	@Test
	public void sortNumbers() {
		List<Integer> newNumbers = numbers;
		Collections.sort(newNumbers, (Integer a, Integer b) -> b.compareTo(a) );
		//newNumbers.stream().forEach(x -> System.out.println(x));
		assertEquals(newNumbers.get(0), (Integer)26); 
		assertEquals(newNumbers.get(numbers.size()-1), (Integer)3); 
	}

	public void addToList(List<Integer> l, Integer x) {
		l.add(x);
	}

	@Test 
	public void collectEvenNumbers() { 
		List<Integer> evenNumbers = new ArrayList<Integer>();
		Consumer<Integer> intConsumer = x -> { evenNumbers.add(x); };
		Stream<Integer> filtered = numbers.stream().filter( x -> x % 2 == 0);
		filtered.forEach(intConsumer);
		assertEquals((Integer)evenNumbers.size(), (Integer)4); 
	} 

	@Test 
	public void createStringOfNumbers() { 
		String result = numbers.stream().map(String::valueOf)
				.reduce("",(String x, String y) -> x+","+y).toString();
		assertEquals((Integer)result.length(), (Integer)28); 
	}

	@Test 
	public void sortWithAnonymousClass() {
		List<Worker> myWorkers;
		myWorkers = disneyWorkers;
		myWorkers.sort(new Comparator<Worker>() {

			@Override
			public int compare(Worker w1, Worker w2) {
				return w1.getName().compareTo(w2.getName()); 
			}

		});
		assertEquals(myWorkers.get(0), new Worker("Beeva, Eega", "1947-05-01")); 
		assertEquals(myWorkers.get(9), new Worker("Gander, Gladstone", "1948-01-01"));
		assertEquals(myWorkers.get(myWorkers.size()-1), new Worker("Pluto", "1930-06-01"));
	}

	@Test 
	public void sortWithLambdaName() {
		List<Worker> myWorkers;
		myWorkers = disneyWorkers;
		myWorkers.stream().sorted((w1, w2) -> w1.getName().compareTo(w2.getName()));
		assertEquals(myWorkers.get(0), new Worker("Beeva, Eega", "1947-05-01")); 
		assertEquals(myWorkers.get(9), new Worker("Gander, Gladstone", "1948-01-01"));
		assertEquals(myWorkers.get(myWorkers.size()-1), new Worker("Pluto", "1930-06-01"));
	}

	@Test 
	public void sortWithLambdaBirthDateOldestFirst() {
		List<Worker> myWorkers;
		myWorkers = disneyWorkers;
		List<Worker> sortedWorkers = myWorkers.stream().sorted((w1, w2) -> w1.getBirthdate()
				.compareTo(w2.getBirthdate())).collect(Collectors.toList());
		assertEquals(sortedWorkers.get(0), new Worker("Black, Pete", "1925-06-01")); 
	}

	@Test 
	public void sortWithLambdaBirthDateOldestLast() {
		List<Worker> myWorkers;
		myWorkers = disneyWorkers;
		List<Worker> sortedWorkers = myWorkers.stream().sorted((w1, w2) -> w2.getBirthdate()
				.compareTo(w1.getBirthdate())).collect(Collectors.toList());
		assertEquals(sortedWorkers.get(0), new Worker("Helper, Little", "1956-06-01")); 
	}
	
	@Test 
	public void sortWithLambdaBirthDateAndName() {
		List<Worker> myWorkers;
		myWorkers = disneyWorkers;
		Comparator<Worker> mycomp = (a,b) -> a.getBirthdate().compareTo(b.getBirthdate());
		Comparator<Worker> mycomp2 = mycomp.thenComparing((a,b) -> a.getName().compareTo(b.getName())).reversed();
		myWorkers.sort(mycomp2);
		myWorkers.forEach(System.out::println);
	}
	
}
