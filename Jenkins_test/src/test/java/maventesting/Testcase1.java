package maventesting;

import org.testng.annotations.Test;

public class Testcase1 
{
	@Test(groups= {"SmokeTesting"})
	public void testCase1()
	{
		System.out.println("testcase1");
	}

}
