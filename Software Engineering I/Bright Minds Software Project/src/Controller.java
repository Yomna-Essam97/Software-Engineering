import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
	public static ArrayList<Student> data = new ArrayList<>();
	public static ArrayList<Teacher> tdata = new ArrayList<>();
	public static Game obj ; 
	public static ArrayList<Game> gdata = new ArrayList<>();
	public static int ind = 0 ;
	public static Game g;
	
void Register ( String name, int age , String gender , String nationality , String email , String username , String password , String verificationcode){

	try {
		
		FileWriter stream = new FileWriter("Teacher DB.txt");
		BufferedWriter out = new BufferedWriter(stream);
		out.write(name+" "+age+" "+gender+" "+nationality+" "+email+" "+username+" "+password+" "+verificationcode+"\n");
		Teacher t = new Teacher (name,age,gender,nationality,email,username,password, verificationcode);
		tdata.add(t);
		out.close();

} 
catch(Exception ex) {}
	System.out.println("Register done successfully");
	
	
}

void Register ( String name, int age , String gender , String nationality , String email , String username , String password){

	try {
	
		FileWriter stream = new FileWriter("Students DB.txt");
		BufferedWriter out = new BufferedWriter(stream);
		out.write(name+" "+age+" "+gender+" "+nationality+" "+email+" "+username+" "+password+" "+"\n");
		Student s = new Student(name,age,gender,nationality,email,username,password);
		data.add(s);
		out.close();

}
catch(Exception ex) {}
	System.out.println("Register done successfully");

}

void LogIn(String username , String password ) throws FileNotFoundException{

	
		if (ValidateDetails(username,password)){
			System.out.println("Log in successfull");
		}
		else{
			System.out.println("Not Valid user name or password");
		}
	
}

boolean ValidateDetails(String userName, String password) throws FileNotFoundException {
	System.out.println("Student or Teacher");
	Scanner s = new Scanner(System.in);
	String type = s.nextLine();
	if (type.equals("Student")){
	Scanner f;
	f = new Scanner ( new File("Students DB.txt"));
	while(f.hasNext()) {
		String search = f.nextLine();
		if(search.contains(userName)&&search.contains(password)){
			
			f.close();
			return true;
		}
		}
	}
	else if(type.equals("Teacher")) {
		Scanner f;
		f = new Scanner ( new File("Teacher DB.txt"));
		while(f.hasNext()) {
			String search = f.nextLine();
			if(search.contains(userName)&&search.contains(password)){
				
				f.close();
				return true;
			}
			}
	}

	return false;

}

void ChooseCategory( String category ){
	ArrayList<String> games = new ArrayList<>();


	if(category.equals("Science")){
		try {
			Scanner f;
			f = new Scanner ( new File("Science.txt"));
			while(f.hasNext()) {
				String search = f.nextLine();
				games.add(search);}
	}
	catch(Exception ex) {}
		
	}
	else if (category.equals("Math")){
		try {
			Scanner f;
			f = new Scanner ( new File("Math.txt"));
			while(f.hasNext()) {
				String search = f.nextLine();
				games.add(search);}
	}
	catch(Exception ex) {}
	}
	else{
		try {
			Scanner f;
			f = new Scanner ( new File("Code.txt"));
			while(f.hasNext()) {
				String search = f.nextLine();
				games.add(search);}
	}
	catch(Exception ex) {}
		
	}

	for(int i = 0 ; i<games.size();i++){
		System.out.println(games.get(i)+"\n");
	}
}

void Play(String username){
	System.out.println("Enter name of game you want to play");
	Scanner s = new Scanner(System.in);
	String name = s.nextLine();
	RequestLoadGames(name);
	Student st = new Student(username);
	 g = new Game(name);
	int v = 0 ;
	
	//edit score in student data base
	for(int i = 0 ; i<data.size();i++){
		if (username.equals(data.get(i).username)){
			int c = data.get(i).getScore();
			c++;
			data.get(i).setScore(c);
			v = data.get(i).getScore();
			ind = i;
			data.get(i).setGames(g);
		}
	}

	st.setScore(v);
	

		//each student with scores   //edit
		for(int i = 0 ; i < data.size() ; i++){
			System.out.println(data.get(i).username+" with Score : "+data.get(i).getScore());
			System.out.println("Played games : ");
			for(int j=0;j<data.get(i).games.size();j++){
				System.out.println(data.get(i).games.get(j).name);
			}
		}

	}

void gamesDetails(){
	g.setStudents(data.get(ind));
	gdata.add(g);
	
	for(int i=0;i<gdata.size();i++){
		System.out.println(gdata.get(i).name);
		for(int j=0;j<gdata.get(i).students.size();j++){
			System.out.println("Students who play this game are : "+gdata.get(i).students.get(j).username);
		}
	}
}

int SendScore(int c) {
		return c;
	}

void RequestLoadGames(String name){
	System.out.println("You are playing " + name);
}

void AddGame(String username) {
		try {
			System.out.print("Name");
			Scanner s = new Scanner(System.in);
			String name = s.nextLine();
			System.out.print("Category");
			String category = s.nextLine();
			System.out.println("Type");
			String type = s.nextLine();
			System.out.println("Complexity");
			String complexity = s.nextLine();
			AddGameFeatures(name, category, type, complexity);
			FileWriter stream = new FileWriter("Games DB.txt", true);
			BufferedWriter out = new BufferedWriter(stream);
			out.write(obj.name + " " + obj.category + " " + obj.type + " " + obj.complexity + "\n");
			gdata.add(obj);
			out.close();
			if (category.equals("Science")) {
				try {
					FileWriter stream1 = new FileWriter("Science.txt", true);
					BufferedWriter out1 = new BufferedWriter(stream);
					out1.write(obj.name);
					out1.close();
				} catch (Exception ex) {
				}
			} else if (category.equals("Math")) {
				try {
					FileWriter stream1 = new FileWriter("Math.txt", true);
					BufferedWriter out1 = new BufferedWriter(stream);
					out1.write(obj.name);
					out1.close();
				} catch (Exception ex) {
				}
			} else {
				try {
					FileWriter stream1 = new FileWriter("Code.txt", true);
					BufferedWriter out1 = new BufferedWriter(stream);
					out1.write(obj.name);
					out1.close();
				} catch (Exception ex) {
				}
			}

		} catch (Exception ex) {
		}
		
		//teacher with his games
		for(int i=0;i<tdata.size();i++){
		if (username.equals(tdata.get(i).username)){
			tdata.get(i).setGames(obj);
		}
		}
		for(int i=0;i<tdata.size();i++){
			System.out.println(tdata.get(i).name);
			System.out.println("You add games : ");
			for(int j = 0 ; j <tdata.get(i).games.size();j++){
				System.out.println(tdata.get(i).games.get(j).name);
			}
		}
	}

 void AddGameFeatures( String name  , String category , String type , String complexity ){
	  obj = new Game(name,category,type,complexity);
 }


}
