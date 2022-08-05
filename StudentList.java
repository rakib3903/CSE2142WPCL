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
			String studentName = readOneLine(readFile(Constant.studentList));
			String names[] = studentName.split(",");
			for(String name : names) {
				System.out.println(name);
			}
			System.out.println(Constant.dataLoaded);
		}
		else if(args[0].equals(Constant.ShowAll1)) {
			System.out.println(Constant.loadData);
			String studentName = readOneLine(readFile(Constant.studentList));
			String names[] = studentName.split(",");
			System.out.println(names[(int) (Math.random() * 4)]);
			System.out.println(Constant.dataLoaded);
		}
		else if(args[0].contains(Constant.showAll2)){
			System.out.println(Constant.loadData);
			try {
				BufferedWriter bufferedWriter = writeFile(Constant.studentList);
				DateFormat dateFormat = new SimpleDateFormat(Constant.dateFormat);
				bufferedWriter.write(Constant.comma + args[0].substring(1) + Constant.listUpdateMessage + dateFormat.format(new Date()));
				bufferedWriter.close();
			}catch (Exception e){

			}
			System.out.println(Constant.dataLoaded);
		}
		else if(args[0].contains(Constant.showAll3)) {
			System.out.println(Constant.loadData);
			String studentName = readOneLine(readFile(Constant.studentList));
			String names[] = studentName.split(Constant.comma1);
			for(int idx = 0; idx < names.length; idx++) {
				if(names[idx].equals(args[0].substring(1))) {
					System.out.println(Constant.foundMessage);
					break;
				}
			}
			System.out.println(Constant.dataLoaded);
		}
		else if(args[0].contains(Constant.showAll4)) {
			System.out.println(Constant.loadData);
			String studentName = readOneLine(readFile(Constant.studentList));
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
