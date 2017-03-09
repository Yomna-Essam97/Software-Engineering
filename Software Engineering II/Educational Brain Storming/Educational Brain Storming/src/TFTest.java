import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TFTest {
	@DataProvider(name = "test2")
	public static Object[][]Play(){
			return new Object[][]{{false},{true}};
	}
	
	
	
  @Test(dataProvider = "test2")
  public void PlayTF(boolean result) {
	  TF obj = new TF();
	  Game g = new Game();
	  g.Name="Math&Scince";
	  g.type="TF";
	  g.MinAge=88;
	  g.MaxAge=15;
	  g.data_path="TF_GAME.txt";
	  Assert.assertEquals(result, obj.PlayTF(g));
	   }
}
