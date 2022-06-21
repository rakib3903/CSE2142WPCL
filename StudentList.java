import java.io.*;
import java.text.*;
import java.security.spec.ECFieldF2m;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {
		//Check arguments
		if(args.length == 0) {
			System.out.println("please,press an argument.");
		}
		else if(args[0].equals("a")) {
			System.out.println("Loading data ...");
			BufferedReader bufferedReader = readFile("students.txt");
			String studentName = readOneLine(bufferedReader);
			String names[] = studentName.split(",");
			for(String name : names) {
				System.out.println(name);
			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) {
			System.out.println("Loading data ...");
			BufferedReader bufferedReader = readFile("students.txt");
			String studentName = readOneLine(bufferedReader);
			String names[] = studentName.split(",");
			double random = Math.random() * 4;
			int randomValue = (int) random;
			System.out.println(names[randomValue]);
			System.out.println("Data Loaded.");
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");
			try {
				BufferedWriter bufferedWriter = writeFile("students.txt");
				String substring = args[0].substring(1);
				Date date = new Date();
				String timeFormate = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(timeFormate);
				String showDate = dateFormat.format(date);
				bufferedWriter.write(", " + substring + "\nList last updated on " + showDate);
				bufferedWriter.close();
			}catch (Exception e){

			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].contains("?")) {
			System.out.println("Loading data ...");
			BufferedReader bufferedReader = readFile("students.txt");
			String studentName = readOneLine(bufferedReader);
			String names[] = studentName.split(",");
			boolean truthValue = false;
			String substring = args[0].substring(1);
			for(int idx = 0; idx<names.length && !truthValue; idx++) {
				if(names[idx].equals(substring)) {
					System.out.println("We found it!");
					truthValue = true;
				}
			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].contains("c")) {
			System.out.println("Loading data ...");
			BufferedReader bufferedReader = readFile("students.txt");
			String studentName = readOneLine(bufferedReader);
			char names[] = studentName.toCharArray();
			int count=0;
			for(char name : names) {
				if(name ==',') {
					count = count + 1;
				}
			}
			System.out.println("Total "+(count + 1) +" students found.");
			System.out.println("Data Loaded.");
		}
		else {
			System.out.println("please,press a valid argument.");
		}
	}

	static BufferedReader readFile(String fileName) {
		try {
			return new BufferedReader(
					new InputStreamReader(
							new FileInputStream(fileName)));
		} catch (Exception e) {
			return null;
		}
	}

	static String readOneLine(BufferedReader bufferedReader) {
		try {
			return bufferedReader.readLine();
		} catch (Exception e) {
			return null;
		}
	}

	static BufferedWriter writeFile(String fileName) {
		try {
			return new BufferedWriter(
					new FileWriter(fileName, true));
		} catch (Exception e) {
			return null;
		}
	}
}
