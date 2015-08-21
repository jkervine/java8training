package functional;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Worker {
	private String name; 
	private LocalDate birthdate; 


	public Worker (String n, String str) { 
		name = n; 
		setBirthdate(str); 
	} 


	public String getName(){ 
		return name; 
	} 


	public void setName(String name){ 
		this.name = name; 
	} 


	public LocalDate getBirthdate(){ 
		return birthdate; 
	} 


	public void setBirthdate(int year, int month,
			int day){ 
		birthdate = LocalDate.of(2015, 8, 1); 
	} 


	public void setBirthdate(String dateString) { 
		DateTimeFormatter formatter =
				DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		birthdate = LocalDate.parse(dateString,
				formatter); 
	} 



	public String getAge() { 
		LocalDate today = LocalDate.now(); 
		Period fromBirth = Period.between(birthdate,
				today); 
		return fromBirth.getYears() + " years "
		+ fromBirth.getMonths() + " months " + fromBirth.getDays()
		+ " days";      
	} 




	public String toString() { 
		return name + ", " + birthdate + ",age: " + getAge(); 
	} 




	public boolean equals(Object w) { 
		Worker another = (Worker)w; 
		if (another == null) return false; 


		return (name == another.name) &&
				(birthdate.isEqual(another.birthdate)); 
	}




}
