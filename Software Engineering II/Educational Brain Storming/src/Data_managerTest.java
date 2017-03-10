import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_managerTest {

	@DataProvider(name = "incorrect")
	public static Object[][] test(){
		return new Object[][]{{true,"TF"},{false,""}};
	}
	
  @Test(dataProvider="incorrect")
  public void load_data(boolean e , String msg) {
	  Data_manager d = new Data_manager();
	  d.load_data();
	  Assert.assertTrue(e,msg);
  }
}
