import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Registeration {
String name="";
String password="";
String mail="";
String gender="";
int age=0;
String type="";
Data_manager data = new Data_manager();

public Registeration(String name, String password, String mail, String gender, int age, String type) {
	super();
	this.name = name;
	this.password = password;
	this.mail = mail;
	this.gender = gender;
	this.age = age;
	this.type = type;
	}
public Registeration() {
	// TODO Auto-generated constructor stub
}
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


boolean SignUp(){
	Save_Data(Check_info());
	return true;	
}
Account Check_info(){
	data.load_data();
	Scanner sc = new Scanner(System.in);
		System.out.print("Enter your name : ");
		name = sc.nextLine();
		while(true){
		System.out.print("Enter your Email : ");
		mail = sc.nextLine(); 
		if(data.mail_pass.get(mail)==null && mail.contains("@") && mail.contains(".com")){break;}
		else if(data.mail_pass.get(mail)!=null){System.out.println("Taken mail");}
		else{System.out.println("Wrong mail");}
		}
		System.out.print("Enter your Password : ");
		password = sc.nextLine();
		System.out.print("Enter your Gender : ");
		 gender = sc.nextLine();
		System.out.print("Enter your Age : ");
		age = Integer.parseInt(sc.nextLine());
		System.out.print("Enter your Type : ");
		type = sc.nextLine();
		if(type.equalsIgnoreCase("teacher")){
		while(true){
		System.out.print("Enter your Teacher_code : ");
		String reg = sc.nextLine();
		if(reg.equals("TECH012")){break;}
		else {System.out.println("Wrong code");}
		}
		}
		Account new_acc ;
		if(type.equalsIgnoreCase("teacher")){
			new_acc = new Teacher(name , password , mail , gender , age , "teacher"  );
		}
		else{
			new_acc = new Student(name , password , mail , gender , age , "student"  );
			((Student)new_acc).score=0;
		}
	return new_acc;
}
boolean Save_Data(Account new_acc){
	data.update_data(new_acc);
	return true;
}
int Signin(){
	data.load_data();
	Scanner sc;
	String inputmail;
	String inputpass;
	while(true){
	sc = new Scanner(System.in);
	System.out.print("Enter your Email : ");
	inputmail = sc.nextLine();
	System.out.print("Enter your Password : ");
	inputpass = sc.nextLine();
	if(data.mail_pass.get(inputmail)==null || !inputpass.equals(data.mail_pass.get(inputmail))){System.out.println("Wrong password or mail");}
	else{break;}
	}
	return data.mail_type.get(inputmail);
}

}


