package date;

import java.time.LocalDateTime;

public class DateTesting {

	public static void main(String[] args) {
		LocalDateTime ld = LocalDateTime.now();
		System.out.println("Local datetime now is "+ld.toString());
		LocalDateTime untilYearEnd = LocalDateTime.of(2015, 12, 31, 23, 59);
		while(ld.isBefore(untilYearEnd)) {
			ld = ld.plusDays(1);
			System.out.println("Day after that is "+ld.toString());
		}
		System.out.println("And that's in a new year!");
	}
	
}
