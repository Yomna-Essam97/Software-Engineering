import java.util.ArrayList;
import java.util.Map;

public class Teacher extends Account{

	ArrayList<Game> created_game = new ArrayList<Game>(); 
	public Teacher(String name, String password, String mail, String gender, int age, String type) {
		this.name = name;
		this.password=password;
		this.mail=mail;
		this.gender=gender;
		this.age=age;
		this.type=type;
	}
	public Teacher() {
		// TODO Auto-generated constructor stub
	}


	
}
