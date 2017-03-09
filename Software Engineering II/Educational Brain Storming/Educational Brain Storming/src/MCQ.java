import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MCQ {
	ArrayList<Game> MCQgames = new ArrayList<Game>();
	String MCQ_path ="MCQ.txt";
	
boolean PlayMCQ(Game g)
	{
		int score = 0;
		Scanner sc;
		try {
			sc = new Scanner(new File(g.data_path));
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Answer With right answer : ");
			while(sc.hasNext()){
				String Q = sc.nextLine();
				System.out.println(Q);
				String A1 = sc.nextLine();
				String A2 = sc.nextLine();
				String A3 = sc.nextLine();
				String A4 = sc.nextLine();
				String rA = sc.nextLine();
				System.out.println(A1 +"  " + A2 + "  " + A3 + "  " +A4);
				System.out.println("Enter Your Answer : ");
				String CA = sc1.nextLine();
				if(CA.equals(rA)){
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

int MCQExit(int score,Student obj)
{
	obj.score += score;
	return obj.score;
}


}
