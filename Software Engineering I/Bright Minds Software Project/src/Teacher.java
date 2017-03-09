import java.util.ArrayList;

public class Teacher extends Account {
private String VerificationCode;
public static ArrayList<Game> games = new ArrayList<>();

public Teacher (String name, int age , String gender , String nationality , String email , String username , String password ,String VerificationCode ){
this.name=name;
this.age=age;
this.gender=gender;
this.nationality=nationality;
this.email=email;
this.username=username;
this.password=password;
this.VerificationCode=VerificationCode;
}

public Teacher (){}

public void setGames(Game game) {
	games.add(game);
}

public String getVerificationCode() {
	return VerificationCode;
}

public void setVerificationCode(String verificationCode) {
	VerificationCode = verificationCode;
}
}
