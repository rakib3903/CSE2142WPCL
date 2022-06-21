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
		else if(args[0].equals(Constant.showAll)) {
			System.out.println(Constant.loadData);
			BufferedReader bufferedReader = readFile(Constant.studentList);
			String studentName = readOneLine(bufferedReader);
			String names[] = studentName.split(",");
			for(String name : names) {
				System.out.println(name);
			}
			System.out.println(Constant.dataLoaded);
		}
		else if(args[0].equals(Constant.ShowAll1)) {
			System.out.println(Constant.loadData);
			BufferedReader bufferedReader = readFile(Constant.studentList);
			String studentName = readOneLine(bufferedReader);
			String names[] = studentName.split(",");
			double random = Math.random() * 4;
			int randomValue = (int) random;
			System.out.println(names[randomValue]);
			System.out.println(Constant.dataLoaded);
		}
		else if(args[0].contains(Constant.showAll2)){
			System.out.println(Constant.loadData);
			try {
				BufferedWriter bufferedWriter = writeFile(Constant.studentList);
				String substring = args[0].substring(1);
				Date date = new Date();
				String timeFormate = Constant.dateFormat;
				DateFormat dateFormat = new SimpleDateFormat(timeFormate);
				String showDate = dateFormat.format(date);
				bufferedWriter.write(Constant.comma + substring + Constant.listUpdateMessage + showDate);
				bufferedWriter.close();
			}catch (Exception e){

			}
			System.out.println(Constant.dataLoaded);
		}
		else if(args[0].contains(Constant.showAll3)) {
			System.out.println(Constant.loadData);
			BufferedReader bufferedReader = readFile(Constant.studentList);
			String studentName = readOneLine(bufferedReader);
			String names[] = studentName.split(Constant.comma1);
			boolean truthValue = false;
			String substring = args[0].substring(1);
			for(int idx = 0; idx<names.length && !truthValue; idx++) {
				if(names[idx].equals(substring)) {
					System.out.println(Constant.foundMessage);
					truthValue = true;
				}
			}
			System.out.println(Constant.dataLoaded);
		}
		else if(args[0].contains(Constant.showAll4)) {
			System.out.println(Constant.loadData);
			BufferedReader bufferedReader = readFile(Constant.studentList);
			String studentName = readOneLine(bufferedReader);
			char names[] = studentName.toCharArray();
			int count=0;
			for(char name : names) {
				if(name == ',') {
					count = count + 1;
				}
			}
			System.out.println((count + 1) + Constant.wordFoundMessage);
			System.out.println(Constant.dataLoaded);
		}
		else {
			System.out.println(Constant.warningMessage);
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
