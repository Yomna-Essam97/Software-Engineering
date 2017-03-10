import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterationTest {

	@DataProvider(name="test")
	public static Object[][] test(){
		return new Object[][]{{1},{0},{0}};
	}
	
  @Test(dataProvider="test")
  public void Signin(int input) {
	  Registeration v = new Registeration();
	  int a = v.Signin();
	   Assert.assertEquals(input,a);
  }
  
	

	
  @Test
  public void Check_infoS() {
	  Registeration v = new Registeration();
	  Account account = new Student("nouran","011","nouran@.com","fema",-20,"student") ;
	  Account c = v.Check_info();
	  Assert.assertEquals(account.name,c.name);
	  Assert.assertEquals(account.mail,c.mail);
	  Assert.assertEquals(account.password,c.password);
	  Assert.assertEquals(account.gender,c.gender);
	  Assert.assertEquals(account.age,c.age);
	  Assert.assertEquals(account.type,c.type);

	 
  }
  @Test
  public void Check_infoT(){
	  Registeration v = new Registeration();
	  Account acc=new Teacher("yomna","555","yomna@.com","female",20,"teacher");
	  Account c = v.Check_info();
	  Assert.assertEquals(acc.name,c.name);
	  Assert.assertEquals(acc.mail,c.mail);
	  Assert.assertEquals(acc.password,c.password);
	  Assert.assertEquals(acc.gender,c.gender);
	  Assert.assertEquals(acc.age,c.age);
	  Assert.assertEquals(acc.type,c.type);
	  
	  //code is TECH012
  }
  
}

