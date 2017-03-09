import java.util.ArrayList;

public class Game {
	public String name;
//	public static String []category={"Science","Math","Code"};
	public String category ;
	public String complexity;
	public static ArrayList<Student> students = new ArrayList<>();
	public String type;
	
	public Game(){}
	
	public Game( String name , String category , String type , String complexity){
		this.name=name;
		this.category=category;
		this.type=type;
		this.complexity=complexity;
		students=new ArrayList<>();
		
	}
	public Game(String name){
		this.name=name;
	}
	
	public void setStudents(Student us) {
		students.add(us);
	}

	
}
