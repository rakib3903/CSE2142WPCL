import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {
		//Check arguments
		if(args.length == 0) {
			System.out.println("please,press an argument.");
		}
		else if(args[0].equals("a")) {
			System.out.println("Loading data ...");
			try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt")));
			String studentName = bufferedReader.readLine();
			String names[] = studentName.split(",");
			for(String name : names) {
				System.out.println(name);
			}
			} catch (Exception e) {

			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(
							new FileInputStream("students.txt")));
				String studentName = bufferedReader.readLine();
			    String names[] = studentName.split(",");
			    double random = Math.random() * 4;
				int randomValue = (int) random;
				System.out.println(names[randomValue]);
			} catch (Exception e) {

			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");
			try {
				BufferedWriter bufferedWriter = new BufferedWriter(
						new FileWriter("students.txt", true));
			    String substring = args[0].substring(1);
	            Date date = new Date();
				String timeFormate = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(timeFormate);
				String showDate= dateFormat.format(date);
				bufferedWriter.write(", "+substring+"\nList last updated on "+showDate);
				bufferedWriter.close();
			} catch (Exception e) {

			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].contains("?")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String studentName = bufferedReader.readLine();
				String names[] = studentName.split(",");
				boolean truthValue = false;
				String substring = args[0].substring(1);
				for(int idx = 0; idx<names.length && !truthValue; idx++) {
					if(names[idx].equals(substring)) {
						System.out.println("We found it!");
						truthValue = true;
					}
				}
			} catch (Exception e) {

			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].contains("c")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt")));
				String studentName = bufferedReader.readLine();
				char names[] = studentName.toCharArray();
				int count=0;
				for(char name : names) {
					if(name ==',') {
						count = count + 1;
					}
				}
				System.out.println("Total "+(count + 1) +" students found.");
			} catch (Exception e) {

			}
			System.out.println("Data Loaded.");
		}
		else {
			System.out.println("please,press a valid argument.");
		}
	}
}
