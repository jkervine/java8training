import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class CountingStuff {

	private static List<Double> values = Arrays.asList(4.8,7.0,9.1,10.9,13.0,15.0,17.0,19.2);
	
	public static void main(String [] args) {
		double avg = values.stream().reduce(new Double(0), (a,b) -> (a+b)).doubleValue() / values.stream().count();
		System.out.println("Average for reduce is "+avg);
		DoubleStream ds = values.stream().mapToDouble(Double::valueOf);
		OptionalDouble od = ds.average();
		if(od.isPresent()) {
			System.out.println("Average with doublestream avg is :"+od.getAsDouble());
		} else {
			System.out.println("Result not available.");
		}
		DoubleSummaryStatistics stats = values.stream().collect(Collectors.summarizingDouble(Double::valueOf));
		System.out.println("Average with summaryStatistics: "+stats.getAverage());
		// test other stats methods aswell:
		System.out.println("Summ.stats count: "+stats.getCount());
		System.out.println("Summ.stats max: "+stats.getMax());
		System.out.println("Summ.stats min: "+stats.getMin());
		System.out.println("Summ.stats sum: "+stats.getSum());
		
	}
	
}
