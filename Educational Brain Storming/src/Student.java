import java.util.Map;

public class Student extends Account {
	int score=0;
	public Student(String name, String password, String mail, String gender, int age, String type) {
		this.name = name;
		this.password=password;
		this.mail=mail;
		this.gender=gender;
		this.age=age;
		this.type=type;
	}

	public Student() {
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
