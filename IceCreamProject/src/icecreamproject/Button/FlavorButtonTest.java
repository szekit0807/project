package icecreamproject.Button;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FlavorButtonTest {
	FlavorButton testFButton;
	FlavorButton testFButton2;
	@Before
	public void setUp() throws Exception {
		testFButton = new FlavorButton("testFButton", 123);
		testFButton2 = new FlavorButton("testFButton2", 3);
	}

	@Test
	public void testFlavorButton() {
		
		//test negative price
		FlavorButton testNegative = null;
		String testNegativeError = null;  
		try{
			testNegative=new FlavorButton("testNegative", -123); // try to input a negative price value -123 
		}catch(Exception e){
			testNegativeError=e.getMessage();
		}
		assertNull(testNegative);
		assertEquals(FlavorButton.errorNegative, testNegativeError); //compare error msg with [class:ComponentButton]
		
		//Test Empty Name
		FlavorButton testName = null;
		String testNameError = null;
		try{
			new FlavorButton("", 123); //try blank value of Flavor name 
		}catch(Exception e){
			testNameError=e.getMessage();
		}
		assertNull(testName);
		assertEquals( FlavorButton.errorName, testNameError); //compare error msg with [class:ComponentButton]
		
		//Test Null Name
		FlavorButton testNullName = null;
		String testNullNameError = null;
		try{
			new FlavorButton(null, 123); //try Null value of Flavor name 
		}catch(Exception e){
			testNullNameError=e.getMessage();
		}
		assertNull(testNullName);
		assertEquals(FlavorButton.errorName, testNullNameError); //compare error msg with [class:ComponentButton]
		
		//Test Normal Case
		FlavorButton testNormal = null;
		String testNormalError=null;
		try{
			testNormal=new FlavorButton("testNormal", 123);
		}catch(Exception e){
			testNormalError=e.getMessage();
		}
		assertNotNull(testNormal);
		assertNull(testNormalError);
	}

	@Test
	public void testGetFlavorName() {
		assertEquals("testFButton", testFButton.getFlavorName());
		assertEquals("testFButton2", testFButton2.getFlavorName());
	}

	@Test
	public void testGetPrice() {
		assertEquals(123, testFButton.getPrice(),0);
		assertEquals(3, testFButton2.getPrice(),0);
	}
	
	@Test
	public void testIsSelected() {
		assertEquals(false, testFButton.isSelected());
		testFButton.updateSelected();
		assertEquals(true, testFButton.isSelected());
		testFButton.updateSelected();
		assertEquals(false, testFButton.isSelected());
	}




}
