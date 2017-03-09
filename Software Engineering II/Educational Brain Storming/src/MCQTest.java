import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MCQTest {

	@DataProvider(name = "test1")
	public static Object[][]Play(){
			return new Object[][]{{true},{false}};
	}
  @Test(dataProvider = "test1")
  public void PlayMCQ(boolean result) {
	  MCQ obj = new MCQ();
	  Game g = new Game();
	  g.Name="Math&Scince";
	  g.type="MCQ";
	  g.MinAge=7;
	  g.MaxAge=150;
	  g.data_path="MCQ_GAME.txt";
	  Assert.assertEquals(result, obj.PlayMCQ(g));

	  
	  
  }
}
