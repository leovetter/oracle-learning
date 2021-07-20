package oracle.builder;

import java.util.Comparator;

public class AgeCompare implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		int result = p1.getAge().compareTo(p2.getAge());
		
		if(result > 0) return 1;
		if(result < 0) return -1;
		return 0;	
	}
}
