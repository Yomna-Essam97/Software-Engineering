import java.util.ArrayList;

public class Student extends Account {
	private int score;

	public static ArrayList<Game> games = new ArrayList<>();
	
	public Student(){
		score = 0;
	}
	public Student(String u){
		username = u;
		score = 0;
	}
	public Student (String name, int age , String gender , String nationality , String email , String username , String password){
	this.name=name;
	this.age=age;
	this.gender=gender;
	this.nationality=nationality;
	this.email=email;
	this.username=username;
	this.password=password;
	score = 0 ;
	
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	public void setGames(Game game) {
		games.add(game);
	}

	
	
	
}
