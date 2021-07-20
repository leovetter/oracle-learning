package oracle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;

import oracle.builder.AgeCompare;
import oracle.builder.Person;
import oracle.functionalnterface.Analyser;
import oracle.functionalnterface.StringAnalyser;
import oracle.io.ByteStreamCopyTest;
import oracle.ssl.Client;

public class OracleLearning {

	public static void main(String[] args) {	
		
//		testCopyFile();
//		testFunctionalInterface();
//		testPredicate();
//		testSsl();
//		testSetSortComparator();
		testListSortComparator();
	}
	
	public static void testCopyFile() {
		
		ByteStreamCopyTest copyTest = new ByteStreamCopyTest();
		copyTest.byteChanelCopyTest();
	}
	
	public static void testFunctionalInterface() {


	
		String[] strList = {"banane", "orange", "kiwi", "melon", "pasteque"};
		String searchStr = "wi";
		
		StringAnalyser contains = (t, s) -> t.contains(s);
		StringAnalyser startsWith = (t, s) -> t.startsWith(s);
		
		Analyser.searchArr(strList, searchStr, contains);
		Analyser.searchArr(strList, searchStr, startsWith);
	}
	
	public static List<Person> useBuilder() {
		
		Person person1 = Person.builder()
							.setId(1)
							.setAge(23)
							.setEmail("builder@pattern.com")
							.setLocation("Lyon")
							.setName("Maya")
							.build();
		
		Person person2 = Person.builder()
				.setId(2)
				.setAge(67)
				.setEmail("builder@pattern.com")
				.setLocation("Paris")
				.setName("Yse")
				.build();
		
		Person person3 = Person.builder()
				.setId(3)
				.setAge(34)
				.setEmail("builder@pattern.com")
				.setLocation("Bordeaux")
				.setName("Adrien")
				.build();
		
		return Arrays.asList( person1, person2, person3);
	}
	
	public static void testPredicate() {
		
		List<Person> persons = useBuilder();
		
		Predicate<Person> allPersons = p -> p.getAge() > 23 && p.getAge() < 65;
		
		persons.stream().filter(allPersons).forEach(Person::printPerson);
	}
	
	public static void testSsl() {
		
		Client client = new Client();
		client.runClient();
	}
	
	public static void testSetSortComparator() {
		
		Person person1 = Person.builder()
				.setId(1)
				.setAge(23)
				.setEmail("builder@pattern.com")
				.setLocation("Lyon")
				.setName("Maya")
				.build();

		Person person2 = Person.builder()
			.setId(2)
			.setAge(67)
			.setEmail("builder@pattern.com")
			.setLocation("Paris")
			.setName("Yse")
			.build();
		
		Person person3 = Person.builder()
			.setId(3)
			.setAge(34)
			.setEmail("builder@pattern.com")
			.setLocation("Bordeaux")
			.setName("Adrien")
			.build();
		
		Set<Person> personSet = new TreeSet<>();
		personSet.add(person1);
		personSet.add(person2);
		personSet.add(person3);
		
		personSet.forEach(p -> System.out.println(p));
	}
	
	public static void testListSortComparator() {
		
		List<Person> persons = useBuilder();
		Collections.sort(persons);
		
		persons.forEach(p -> System.out.println(p));
		
		AgeCompare ageCompare = new AgeCompare();
		Collections.sort(persons, ageCompare);
		
		persons.forEach(p -> System.out.println(p));
	}
}
