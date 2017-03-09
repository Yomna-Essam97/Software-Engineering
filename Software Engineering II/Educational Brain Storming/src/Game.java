
public class Game {
String Name="";
String Category ="";
int MinAge = 0;
int MaxAge =0;
String type="";
String data_path="";
public Game(String name, String type, int minAge, int maxAge, String data_path) {
	super();
	Name = name;
	type = type;
	MinAge = minAge;
	MaxAge = maxAge;
	this.data_path = data_path;
}
public Game() {
	// TODO Auto-generated constructor stub
}
}
