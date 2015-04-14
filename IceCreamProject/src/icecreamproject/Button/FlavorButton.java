
package icecreamproject.Button;



public class FlavorButton extends ComponentButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    public FlavorButton(String flavorName, double price)  throws Exception{
        super(flavorName, price); //pass value back to class:ComponentButton for save value
    }

    public String getFlavorName(){
        return getComponentName(); // ComponentButton's getComponentName method for return name
    }

    
}
