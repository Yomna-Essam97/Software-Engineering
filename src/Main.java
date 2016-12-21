import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Controller c = new Controller();
		while(true){
		System.out.println("You have an account?"+"\n"+"Press 1 if you have or 2 if you haven't");
		Scanner n = new Scanner(System.in);
		Scanner s = new Scanner(System.in);
		int in = n.nextInt();
		if(in == 1){
			System.out.print("Enter user name : ");
			String username = s.nextLine();
			System.out.print("Enter password : ");
			String password = s.nextLine();
			c.LogIn(username, password);
		
			
			System.out.println("Student or Teacher");
			String type = s.nextLine();
			if (type.equals("Student")){
				while(true){
					System.out.println("Choose category");
					System.out.println("Science");
					System.out.println("Math");
					System.out.println("Code");
					String cat = s.nextLine();
					c.ChooseCategory(cat);
					System.out.println("You want to play ?"+"\n"+"Press Yes if you want or No if not");
					String i = s.nextLine();
					if(i.equals("Yes")){
						c.Play(username);
					}
					else {
						break;
					}
				}
				System.out.println("Display all games details ? Yes or No");
				String d = s.nextLine();
				if(d.equals("Yes")){
					c.gamesDetails();
				}
			}
			else{
				System.out.println("Press Add to add Game ");
				String i = s.nextLine();
				if(i.equals("Add"))
				c.AddGame(username);
			}
			
		}
		else if (in == 2){
			System.out.println("Student or Teacher");
			String type = s.nextLine();
			if (type.equals("Student")){
				System.out.println("Enter your Name");
				String name = s.nextLine();
				System.out.println("Enter your age");
				int age = n.nextInt();
				System.out.println("Enter your gender");
				String gender = s.nextLine();
				System.out.println("Enter your natinality");
				String nationality = s.nextLine();
				System.out.println("Enter your Email");
				String email = s.nextLine();
				System.out.println("Enter your Username");
				String username = s.nextLine();
				System.out.println("Enter your password");
				String password = s.nextLine();
				c.Register(name, age, gender, nationality, email, username, password);
			}
			else{
				System.out.println("Enter your Name");
				String name = s.nextLine();
				System.out.println("Enter your age");
				int age = n.nextInt();
				System.out.println("Enter your gender");
				String gender = s.nextLine();
				System.out.println("Enter your natinality");
				String nationality = s.nextLine();
				System.out.println("Enter your Email");
				String email = s.nextLine();
				System.out.println("Enter your Username");
				String username = s.nextLine();
				System.out.println("Enter your password");
				String password = s.nextLine();
				System.out.println("Enter your verification code");
				String verificationcode = s.nextLine();
				c.Register(name, age, gender, nationality, email, username, password, verificationcode);
				
			}
		}
		
		
		}
		
	}

}
