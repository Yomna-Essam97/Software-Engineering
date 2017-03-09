import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TF {
	ArrayList<Game> TFgames = new ArrayList<Game>();
	
	String TF_path ="TF1.txt";

	
	boolean PlayTF(Game x)
	{
		int score = 0;
		//Game x=TFgames.get(0);
		Scanner sc;
		try {
			sc = new Scanner(new File(x.data_path));
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Answer With True OR False : ");
			int count = 1;
			while(sc.hasNext()){
				String Q = sc.nextLine();
				System.out.println(count+") " + Q);
				count++;
				String A = sc.nextLine();
				System.out.println("Enter Your Answer : ");
				String CA = sc1.nextLine();
				if(CA.equals(A)){
					System.out.println("Right Answer");
					score++;
				}
				else{System.out.println("Wrong Answer");}
			}
			System.out.println("Your Score increased by : " + score);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}
	
	
	int TFExit(int score,Student obj)
	{
		obj.score += score;
		return obj.score;
	}
}
