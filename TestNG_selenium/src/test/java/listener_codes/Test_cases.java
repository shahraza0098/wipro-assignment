package listener_codes;

import org.testng.Assert;
import org.testng.annotations.Test;
 
public class Test_cases {
  @Test
  public void test1() {
	  System.out.println("Test test test... test again upto fixed the bug");
  }
  @Test
  public void test2() {
	 Assert.fail();
  }
  
}
 