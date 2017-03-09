import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Data_manager {
String info_path = "info.txt";
String Student_path= "Student.txt";
String Teacher_path= "Teacher.txt";
ArrayList<Student> Student_accounts = new ArrayList<Student>();
ArrayList<Teacher> Teacher_accounts = new ArrayList<Teacher>();
MCQ MCQGames = new MCQ();
TF TFGames = new TF();
Map<String, String> mail_pass = new HashMap<String, String>(); 
Map<String, Integer> mail_type = new HashMap<String, Integer>();
Map<String , String> game_path = new HashMap<String , String>();

boolean upload_game(Game ng){
		BufferedWriter sc=null;
		try {
			sc = new BufferedWriter (new FileWriter("Games.txt" , true));
			BufferedReader br =new BufferedReader(new FileReader("Games.txt"));
			if(br.readLine()!=null){
				sc.newLine();
			}
			br.close();
			sc.write(ng.Name);
			sc.newLine();
			sc.write(ng.type);
			sc.newLine();
			sc.write(ng.MinAge + "");
			sc.newLine();
			sc.write(ng.MaxAge + "");
			sc.newLine();
			sc.write(ng.data_path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			sc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	
	return true;
}

void load_data(){
	Scanner sc;
	Account student = new Student();
	try {
		sc = new Scanner (new File(Student_path));
		int i=0;
		while(sc.hasNext()){
			student.setName(sc.nextLine());
			student.setMail(sc.nextLine());
			student.setPassword(sc.nextLine());
			student.setGender(sc.nextLine());
			student.setAge((Integer.parseInt(sc.nextLine())));
			student.setScore(Integer.parseInt(sc.nextLine()));
			Student_accounts.add((Student)student);
		}
		} 
		catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	Account teacher = new Teacher();
	try {
		sc = new Scanner (new File(Teacher_path));
		while(sc.hasNext()){
			teacher.setName(sc.nextLine());
			teacher.setMail(sc.nextLine());
			teacher.setPassword(sc.nextLine());
			teacher.setGender(sc.nextLine());
			teacher.setAge((Integer.parseInt(sc.nextLine())));
			// hena games bta3to - teacher.setScore(Integer.parseInt(sc.nextLine()));
			Teacher_accounts.add((Teacher)teacher);
		}
		} 
		catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	try {
		sc = new Scanner (new File(info_path));
		while(sc.hasNext()){
			String mail = sc.nextLine();
			String password = sc.nextLine();
			int type = Integer.parseInt(sc.nextLine());
			mail_pass.put(mail , password);
			mail_type.put(mail , type);
		}
		} 
		catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	
	try {
		sc = new Scanner (new File("Games.txt"));
		while(sc.hasNext()){
			String name = sc.nextLine();
			String type = sc.nextLine();
			int minage = Integer.parseInt(sc.nextLine());
			int maxage = Integer.parseInt(sc.nextLine());
			String datapath = sc.nextLine();
			game_path.put(name , datapath);
			if(type.equals("MCQ")){
				Game mcqgame = new Game(name ,type , minage , maxage , datapath);
				MCQGames.MCQgames.add(mcqgame);
			}
			else if(type.equals("TF")){
				Game TFgame = new Game(name  , type , minage , maxage , datapath);
				TFGames.TFgames.add(TFgame);
			}
		}
		} 
		catch (FileNotFoundException e) {
		e.printStackTrace();
	}
}

boolean update_data(Account x){

	boolean checkold=false;
	int count=0;
	
	BufferedWriter sc=null;
	if(x.type.equals("student")){
		Scanner sca;
		Account student = new Student();
		try {
			sca = new Scanner (new File(Student_path));
			while(sca.hasNext()){
				student.setName(sca.nextLine());
				student.setMail(sca.nextLine());
				student.setPassword(sca.nextLine());
				student.setGender(sca.nextLine());
				student.setAge((Integer.parseInt(sca.nextLine())));
				student.setScore(Integer.parseInt(sca.nextLine()));
				if(x.mail == student.mail){checkold = true;break;}
				count++;
			}
			} 
			catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if(checkold){
			//hena hktb elly hyt3mlo update bs bs msh 3arf aseek 
			
		}
	try {
		sc = new BufferedWriter (new FileWriter("Student.txt" , true));
		BufferedReader br =new BufferedReader(new FileReader("Student.txt"));
		if(br.readLine()!=null){
			sc.newLine();
		}
		br.close();
		sc.write(x.name);
		sc.newLine();
		sc.write(x.mail);
		sc.newLine();
		sc.write(x.password);
		sc.newLine();
		sc.write(x.gender);
		sc.newLine();
		sc.write(x.age + "");
		sc.newLine();
		sc.write(((Student)x).score  + "");
	} catch (IOException e) {
		e.printStackTrace();
	}
		try {
			sc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	else if(x.type.equals("teacher")){
	try {
		sc = new BufferedWriter (new FileWriter("Teacher.txt" , true));
		BufferedReader br =new BufferedReader(new FileReader("Teacher.txt"));
		if(br.readLine()!=null){
			sc.newLine();
		}
		br.close();
		sc.write(x.name);
		sc.newLine();
		sc.write(x.mail);
		sc.newLine();
		sc.write(x.password);
		sc.newLine();
		sc.write(x.gender);
		sc.newLine();
		sc.write(x.age+"");
		//sc.write(((Teacher)x).created_game); -- games
		//sc.newLine();
	} catch (IOException e) {
		e.printStackTrace();
	}
	try {
		sc.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	try {
		sc = new BufferedWriter (new FileWriter(info_path , true));
		BufferedReader br =new BufferedReader(new FileReader("info.txt"));
		if(br.readLine()!=null){
			sc.newLine();
		}
		br.close();
		sc.write(x.mail);
		sc.newLine();
		sc.write(x.password);
		sc.newLine();
		if(x.type.equals("student")){sc.write("0");}
		if(x.type.equals("teacher")){sc.write("1");}
		if(x.type.equals("admin")){sc.write("2");}

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		sc.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return true;
}

}
