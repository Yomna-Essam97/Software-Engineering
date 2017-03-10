import org.testng.Assert;
import org.testng.annotations.Test;

public class Data_managerTest {

  @Test
  public void load_data() {
	  Data_manager d = new Data_manager();
	 
	  Assert.assertEquals(d.load_data(),true);
  }
}
