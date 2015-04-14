package icecreamproject.Button;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DecoratorButtonTest {
	DecoratorButton testDButton;
	DecoratorButton testDButton2;
	
	@Before
	public void setUp() throws Exception {
		testDButton = new DecoratorButton("testDButton", 123);
		testDButton2 = new DecoratorButton("testDButton2", 3);
	}
	
	@Test
	public void testDecoratorButton() {
		
		//test negative price
		DecoratorButton testNegative = null;
		String testNegativeError = null;
		try{
			new DecoratorButton("testNegative", -123); // try to input a negative price value -123 
		}catch(Exception e){
			testNegativeError=e.getMessage();
		}
		assertNull(testNegative);
		assertEquals( DecoratorButton.errorNegative, testNegativeError); //compare error msg with [class:ComponentButton]
		
		//Test Empty Name
		DecoratorButton testName = null;
		String testNameError = null;
		try{
			new DecoratorButton("", 123); //try blank value of Flavor name 
		}catch(Exception e){
			testNameError=e.getMessage();
		}
		assertNull(testName);
		assertEquals(DecoratorButton.errorName, testNameError);//compare error msg with [class:ComponentButton]
		
		//Test Null Name
		DecoratorButton testNullName = null;
		String testNullNameError = null;
		try{
			new DecoratorButton("", 123); //try Null value of Flavor name 
		}catch(Exception e){
			testNullNameError=e.getMessage();
		}
		assertNull(testNullName);
		assertEquals(DecoratorButton.errorName, testNullNameError);//compare error msg with [class:ComponentButton]
		
		

		//Test Normal Case
		DecoratorButton testNormal = null;
		String testNormalError = null;
		try{
			testNormal=new DecoratorButton("testNormal", 123);
		}catch(Exception e){
			testNormalError=e.getMessage();
		}
		assertNotNull(testNormal);
		assertNull(testNormalError);
	}

	@Test
	public void testIsSelected() {
		assertEquals(false, testDButton.isSelected());
		testDButton.updateSelected();
		assertEquals(true, testDButton.isSelected());
		testDButton.updateSelected();
		assertEquals(false, testDButton.isSelected());
	}

	@Test
	public void testGetDecoratorName() {
		assertEquals("testDButton", testDButton.getDecoratorName());
		assertEquals("testDButton2", testDButton2.getDecoratorName());
	}

	@Test
	public void testGetPrice() {
		assertEquals( 123.0, testDButton.getPrice(), 0);
		assertEquals( 3.0, testDButton2.getPrice(), 0);
	}

}
