import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddGameTest {

	@DataProvider(name="fileData")
	  public static Object[][] test() throws IOException {
		 AddGame add = new AddGame();
		 add.creat_game();
		Scanner f = null;
		f = new Scanner ( new File("Games.txt"));
		String Name[] = new String[3];
		String Category[] = new String[3];
		int MinAge[] = new int [3];
		int MaxAge[] = new int [3];
		String data_path [] = new String[3];	
		
		for(int i=0;i<3;i++)
		{
			Name[i]=f.nextLine();
			Category[i]=f.nextLine();
			MinAge[i]=Integer.parseInt(f.nextLine());
			MaxAge[i]=Integer.parseInt(f.nextLine());
			data_path[i]=f.nextLine();
			//f.close();
		}
		
		f.close();
		return new Object[][]{{Name[0],Category[0],MinAge[0],MaxAge[0],data_path[0]},{Name[1],Category[1],MinAge[1],MaxAge[1],data_path[1]},{Name[2],Category[2],MinAge[2],MaxAge[2],data_path[2]}};
		}
	
	
  @Test(dataProvider = "fileData")
  public void create_game( String n, String c, int ma,int xa , String da) {
	  String name = "Math&Scince";
	  String cat = "TF";
	  int min = 7;
	  int max = 15;
	  String p = "TF_GAME.txt";
	  
	  String name2 = "Math";
	  String cat2 = "TF";
	  int min2 = 8;
	  int max2 = 20;
	  String p2 = "TF_GAME.txt";
	  
	  String name3 = "Sc";
	  String cat3 = "MCQ";
	  int min3 = 8;
	  int max3 = 20;
	  String p3 = "MCQ_GAME.txt";
	  
	  
	  Assert.assertEquals(name, n);
	  Assert.assertEquals(cat, c);
	  Assert.assertEquals(min, ma);
	  Assert.assertEquals(max, xa);
	  Assert.assertEquals(p, da);
	  Assert.assertEquals(name2, n);
	  Assert.assertEquals(cat2, c);
	  Assert.assertEquals(min2, ma);
	  Assert.assertEquals(max2, xa);
	  Assert.assertEquals(p2, da);
	  Assert.assertEquals(name3, n);
	  Assert.assertEquals(cat3, c);
	  Assert.assertEquals(min3, ma);
	  Assert.assertEquals(max3, xa);
	  Assert.assertEquals(p3, da);

	  
  }
}
