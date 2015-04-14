package icecreamproject.Panel;

import static org.junit.Assert.*;
import icecreamproject.SellerFrame;
import icecreamproject.Button.DecoratorButton;

import org.junit.Before;
import org.junit.Test;

public class DecoratorPanelTest {
	DecoratorPanel testDPPanel;
	@Before
	public void setUp() throws Exception {
		testDPPanel = new DecoratorPanel(new SellerFrame());
		testDPPanel.add("M&M", 5);
		testDPPanel.add("Strawberry", 4);
	}

	@Test
	public void testAddStringDouble() {
		int addDuplicated = testDPPanel.add("M&M", 5);
		assertEquals(DecoratorPanel.Duplicated,addDuplicated);
		
		int addNegative = testDPPanel.add("Strawberry", -4);
		assertEquals(DecoratorPanel.Negative,addNegative);
		
		int addEmptyName = testDPPanel.add("", 5);
		assertEquals(DecoratorPanel.WrongName,addEmptyName);
		
		String NullNmae = null;
		int addNullName = testDPPanel.add(NullNmae, 5);
		assertEquals(DecoratorPanel.WrongName,addNullName);
		
		int addNormalName = testDPPanel.add("Oreo", 10);
		assertEquals(DecoratorPanel.AddOk,addNormalName);
		
	}

	@Test
	public void testGetPrice() {
		//check the price before selecting buttons
		assertEquals(0,testDPPanel.getPrice(), 0);
		
				
		DecoratorButton db1 = (DecoratorButton) testDPPanel.getComponent(0);
		DecoratorButton db2 = (DecoratorButton) testDPPanel.getComponent(1);


		testDPPanel.selectButton(db1);
		assertEquals(true, db1.isSelected());
		assertEquals(false, db2.isSelected());	
		assertEquals(5,testDPPanel.getPrice(), 0);
		
				
		testDPPanel.selectButton(db1);
		assertEquals(false, db1.isSelected());
		assertEquals(false, db2.isSelected());	
		assertEquals(0,testDPPanel.getPrice(), 0);
		
		
		testDPPanel.selectButton(db2);
		assertEquals(false, db1.isSelected());
		assertEquals(true, db2.isSelected());	
		assertEquals(4,testDPPanel.getPrice(), 0);
		
				
		testDPPanel.selectButton(db1);
		assertEquals(true, db1.isSelected());
		assertEquals(true, db2.isSelected());	
		assertEquals(9,testDPPanel.getPrice(), 0);
	}

	@Test
	public void testReset() {
		//select some buttons
		DecoratorButton db1 = (DecoratorButton) testDPPanel.getComponent(0);
		testDPPanel.selectButton(db1);
		DecoratorButton db2 = (DecoratorButton) testDPPanel.getComponent(1);
		testDPPanel.selectButton(db2);
		
		assertEquals(true, db1.isSelected());
		assertEquals(true, db2.isSelected());		
		assertEquals(9,testDPPanel.getPrice(), 0);

		
		//reset
		testDPPanel.reset();

		
		//check after reset
		assertEquals(false, db1.isSelected());
		assertEquals(false, db2.isSelected());
		assertEquals(0,testDPPanel.getPrice(), 0);
	
	}

	@Test
	public void testDecoratorPanel() {
		//test Null SellerFrame
		DecoratorPanel testNullSellerFrame =null;
		String testNullSellerFrameError = null;
		
		try{
			testNullSellerFrame = new DecoratorPanel(null);
		}catch(Exception e){
			testNullSellerFrameError = e.getMessage();
		}
		assertNull(testNullSellerFrame);
		assertEquals( DecoratorPanel.NullSellerFrame, testNullSellerFrameError); 
		
		
		
		//test Normal Case
		DecoratorPanel testNormalSellerFrame =null;
		String testNornalSellerFrameError = null;
		
		try{
			testNormalSellerFrame = new DecoratorPanel(new SellerFrame());
		}catch(Exception e){
			testNornalSellerFrameError = e.getMessage();
		}
		assertNotNull(testNormalSellerFrame);
		assertNull( testNornalSellerFrameError); 
	}

}
