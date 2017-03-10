import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddGameTest {
	


	@DataProvider(name="fileData")
	  public static Object[][] test() throws IOException {
		 
		Game g1 = new Game();
		 g1.Name="Math&Scince";
		 g1.Category="TF";
		 g1.MinAge=7;
		 g1.MaxAge=15;
		 g1.data_path = "TF_GAME.txt";
			  
			  
		 Game g2= new Game();
		  g2.Name = "Math";
		  g2.Category = "TF";
		  g2.MinAge = 8;
		  g2.MaxAge = 20;
		  g2.data_path = "TF_GAME.txt";
		  
		Scanner f ;
		f = new Scanner ( new File("Games.txt"));
		Game games[]=new Game[2];		
//		AddGame add = new AddGame();
//		add.creat_game();
		
		for(int i=0;i<2;i++)
		{
			games[i].Name=f.nextLine();
			games[i].Category=f.nextLine();
			games[i].MinAge=Integer.parseInt(f.nextLine());
			games[i].MaxAge=Integer.parseInt(f.nextLine());
			games[i].data_path=f.nextLine();
		}
		
		f.close();
		return new Object[][]{{g1,games[0]},{g2,games[1]}};
		}
	
  @Test(dataProvider = "fileData")
  public void create_game( Game in , Game r ) {
	  
	
	  Assert.assertEquals(in.Name, r.Name);
	  Assert.assertEquals(in.Category, r.Category);
	  Assert.assertEquals(in.MinAge, r.MinAge);
	  Assert.assertEquals(in.MaxAge, r.MaxAge);
	  Assert.assertEquals(in.data_path, r.data_path);
  }
}
