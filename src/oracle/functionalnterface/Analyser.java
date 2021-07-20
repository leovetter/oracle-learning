package oracle.functionalnterface;

public class Analyser {

	public static void searchArr(String[] strList, String searchStr, StringAnalyser analyzer) {
		
		for(String currentStr : strList) {
			if(analyzer.analyse(currentStr, searchStr)) {
				System.out.println("Match: " + currentStr);
			}
		}
	}
}
