import java.util.Scanner;

public class AddGame {

	Game NewGame;
	Data_manager manager = new Data_manager(); 
	
	void creat_game(){
		Scanner sc = new Scanner(System.in);
		Game new_game = new Game();
		System.out.print("Enter The name of the game : ");
		new_game.Name = sc.nextLine();
		System.out.print("Enter The type of the game (TF or MCQ) : ");
		new_game.type = sc.nextLine();
		System.out.print("Enter Minmum age : ");
		new_game.MinAge = Integer.parseInt(sc.nextLine());
		System.out.print("Enter Maximum age : ");
		new_game.MaxAge = Integer.parseInt(sc.nextLine());
		System.out.print("creat file that have the Questetion and the answers and uplouad it : ");
		new_game.data_path = sc.nextLine();
		if(AddGame(new_game , new Admin())){
			System.out.println("your game is Successfully Uploaded");
		}
		else{System.out.println("The Admin Refuses your request");}
	}
	
	
	boolean AddGame(Game g, Admin a)
	{
		if(a.Review_Game(g) == true)
		{
			manager.upload_game(g);
			return true;
		}
		else
		{
			return false;
		}
	}
}
