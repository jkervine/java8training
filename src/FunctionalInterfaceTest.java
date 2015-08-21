import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FunctionalInterfaceTest {

	@Test 
    public void usingFunctionInterface() { 
        Function<String, String> convertFunction = // TODO: Convert uppercase
        s -> s.toUpperCase(); 
        String r3 = convertFunction.apply("Test"); 
        assertEquals(r3, (String)"TEST");
    }   


	private String produceString() {
		return new String("Supplier");
	}
	
    @Test 
    public void usingSupplier() { 
        Supplier<String> supplier = this::produceString;
        String r1 = supplier.get(); 
        assertEquals(r1, (String)"Supplier");  
    } 


    @Test 
    public void usingConsumer() { 
        Consumer<String> consumer = x -> {
        	System.out.println("From consumer:" + x.toUpperCase()); 
        };
        consumer.accept("Consumer"); 
    } 


    @Test 
    public void usingPredicate() {    
        Predicate<Integer> predicate = (x -> x > 10);
//TODO: Write predicate to test if number is greater than 10
        Boolean r1 = predicate.test(new Integer(20)); 
        Boolean r2 = predicate.test(new Integer(5 )); 
        assertEquals(r1, (Boolean)true);        
        assertEquals(r2, (Boolean)false);       
    }
    
    @Test
    public void testStream() {
    	List<String> names = new ArrayList<String>();
    	names.add("Jemina");
    	names.add("Jetro");
    	names.add("Martti");
    	Stream<String> namesStream = names.stream();
    	System.out.println("Stream count: "+namesStream.count());
    	Consumer<String> consumer = x -> {
        	System.out.println("From consumer:" + x.toUpperCase()); 
        };
    	names.stream().forEach(consumer);
    	
    }
}
	

