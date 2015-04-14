package icecreamproject.Panel;

import static org.junit.Assert.*;
import icecreamproject.SellerFrame;
import icecreamproject.Button.FlavorButton;

import org.junit.Before;
import org.junit.Test;

public class FlavorPanelTest {
	FlavorPanel testFPPanel;
	@Before
	public void setUp() throws Exception {
		testFPPanel = new FlavorPanel(new SellerFrame());
		testFPPanel.add("Chocolate", 20);
		testFPPanel.add("Vanilla", 10);
	}

	@Test
	public void testAddStringDouble() {
		int addDuplicated = testFPPanel.add("Chocolate", 20);
		assertEquals(FlavorPanel.Duplicated,addDuplicated);
		
		int addNegative = testFPPanel.add("Strawberry", -4);
		assertEquals(FlavorPanel.Negative,addNegative);
		
		int addEmptyName = testFPPanel.add("", 5);
		assertEquals(FlavorPanel.WrongName,addEmptyName);
		
		String NullNmae = null;
		int addNullName = testFPPanel.add(NullNmae, 5);
		assertEquals(FlavorPanel.WrongName,addNullName);
		
		int addNormalName = testFPPanel.add("Oreo", 10);
		assertEquals(FlavorPanel.AddOk,addNormalName);
	}

	@Test
	public void testGetPrice() {
		//check the price before selecting buttons
		assertEquals(0,testFPPanel.getPrice(), 0);
		
		FlavorButton fb1 = (FlavorButton) testFPPanel.getComponent(0);
		FlavorButton fb2 = (FlavorButton) testFPPanel.getComponent(1);

		assertEquals(0,testFPPanel.getPrice(), 0);
		
		testFPPanel.selectButton(fb1);
		assertEquals(20,testFPPanel.getPrice(), 0);
		
				
		testFPPanel.selectButton(fb2);
		assertEquals(10,testFPPanel.getPrice(), 0);
		
		
		testFPPanel.selectButton(fb1);
		assertEquals(20,testFPPanel.getPrice(), 0);
	}

	@Test
	public void testReset() {
		FlavorButton fb1 = (FlavorButton) testFPPanel.getComponent(0);
		FlavorButton fb2 = (FlavorButton) testFPPanel.getComponent(1);
		
		assertEquals(0,testFPPanel.getPrice(), 0);
		
		testFPPanel.selectButton(fb1);
		assertEquals(20,testFPPanel.getPrice(), 0);
		assertEquals( fb1, testFPPanel.getFlavor());
		
		testFPPanel.reset();
		
		
		assertEquals(0,testFPPanel.getPrice(), 0);
		assertNull(testFPPanel.getFlavor());
		
		
		testFPPanel.selectButton(fb2);
		assertEquals(10,testFPPanel.getPrice(), 0);
	}

	@Test
	public void testFlavorPanel() {
		//test Null SellerFrame
		FlavorPanel testNullSellerFrame =null;
		String testNullSellerFrameError = null;
		
		try{
			testNullSellerFrame = new FlavorPanel(null);
		}catch(Exception e){
			testNullSellerFrameError = e.getMessage();
		}
		assertNull(testNullSellerFrame);
		assertEquals( DecoratorPanel.NullSellerFrame, testNullSellerFrameError); 
		
		
		
		//test Normal Case
		FlavorPanel testNormalSellerFrame =null;
		String testNornalSellerFrameError = null;
		
		try{
			testNormalSellerFrame = new FlavorPanel(new SellerFrame());
		}catch(Exception e){
			testNornalSellerFrameError = e.getMessage();
		}
		assertNotNull(testNormalSellerFrame);
		assertNull( testNornalSellerFrameError); 

	}

	@Test
	public void testGetFlavor() {
		FlavorButton fb1 = (FlavorButton) testFPPanel.getComponent(0);
		FlavorButton fb2 = (FlavorButton) testFPPanel.getComponent(1);
		
		assertNull(testFPPanel.getFlavor());
		
		testFPPanel.selectButton(fb1);
		assertEquals(fb1, testFPPanel.getFlavor());		
		
		testFPPanel.selectButton(fb2);
		assertEquals(fb2,testFPPanel.getFlavor());
	}

}
