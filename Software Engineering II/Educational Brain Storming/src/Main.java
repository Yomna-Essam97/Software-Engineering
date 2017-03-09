import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) throws FileNotFoundException{
		TF TFgame = new TF();
		MCQ MCQgame= new MCQ();
		Registeration reg = new Registeration();
		Data_manager manager = new Data_manager();
		AddGame addgame = new AddGame();
		manager.load_data();
		//reg.SignUp();
		int choose;
		Scanner sc = new Scanner(System.in);
		System.out.println("1)SignUp" + "\n" + "2)SignIn");
		choose = Integer.parseInt(sc.nextLine());
		if(choose==1){reg.SignUp();}
		else if(choose==2){
		int type = reg.Signin();
		System.out.println("*********************************************************");
		if(type==0){
			System.out.println("1)Play Game" + "\n" + "2)Exit");
			int chose = Integer.parseInt(sc.nextLine());
			if(chose == 1){
				System.out.println("1)True-False Game" + "\n" + "2)MCQ Game" );
				choose = Integer.parseInt(sc.nextLine());
				if(choose == 1){
					for(int i=0;i<manager.TFGames.TFgames.size();i++){
						System.out.println(i+1 + ")" + manager.TFGames.TFgames.get(i).Name);
					}
					int choosengame = Integer.parseInt(sc.nextLine());
					boolean x = TFgame.PlayTF(manager.TFGames.TFgames.get(choosengame-1));
					}
			else if(choose==2){
				for(int i=0;i<manager.MCQGames.MCQgames.size();i++){
					System.out.println(i+1 + ")" + manager.MCQGames.MCQgames.get(i).Name);
				}
				int choosengame = Integer.parseInt(sc.nextLine());
				boolean x = MCQgame.PlayMCQ(manager.MCQGames.MCQgames.get(choosengame-1));				
				}
		}
		}
		
		else if(type==1){
			System.out.println("1)Play Game" + "\n" + "2)Add Game" + "\n" + "3)Exit");
			int chose1 = Integer.parseInt(sc.nextLine());
			if(chose1 == 1){
				System.out.println("1)True-False Game" + "\n" + "2)MCQ Game" );
				choose = Integer.parseInt(sc.nextLine());
				if(choose == 1){
					if(manager.TFGames.TFgames.size() == 0){System.out.println("No Created Game .");}
					for(int i=0;i<manager.TFGames.TFgames.size();i++){
						System.out.println(i+1 + ")" + manager.TFGames.TFgames.get(i).Name);
					}
					int choosengame = Integer.parseInt(sc.nextLine());
					boolean x = TFgame.PlayTF(manager.TFGames.TFgames.get(choosengame-1));
				}
			else if(choose==2){
				if(manager.MCQGames.MCQgames.size()== 0){System.out.println("No Created Game . ");}
				for(int i=0;i<manager.MCQGames.MCQgames.size();i++){
					System.out.println(i+1 + ")" + manager.MCQGames.MCQgames.get(i).Name);
				}
				int choosengame = Integer.parseInt(sc.nextLine());
				boolean x = MCQgame.PlayMCQ(manager.MCQGames.MCQgames.get(choosengame-1));				
				}
			}
			if(chose1 == 2){
					addgame.creat_game();
			}
		}
			
	
		
		
		

	}
	}

}

