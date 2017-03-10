import java.util.HashMap;
import java.util.Map;

public class Account {
	String name="";
	String password="";
	String mail="";
	String gender="";
	int age=0;
	String type="";	
	

	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Account(String name, String password, String mail, String gender, int age, String type) {
		super();
		this.name = name;
		this.password = password;
		this.mail = mail;
		this.gender = gender;
		this.age = age;
		this.type = type;

	}
	public Account(){}
	public void setScore(int parseInt) {
		
	}
}
