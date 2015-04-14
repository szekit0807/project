package icecreamproject.Panel;

import icecreamproject.Button.*;
import icecreamproject.*;

public class DecoratorPanel extends ComponentPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DecoratorPanel(SellerFrame parent)throws Exception{
        super(parent);

    }    

    public int add(String name, double price){
    	int result;
    	try{
    		result = addComponentButton(new DecoratorButton(name, price));
    	}catch(Exception e){
    		if (e.getMessage().equals(DecoratorButton.errorName)){
    			result = WrongName;
    		}
    		else if (e.getMessage().equals(DecoratorButton.errorNegative)){
    			result = Negative;
    		}else{
    			result = OtherError;
    		}
    	}
    	return result;
    }
            

   
    public void selectButton(ComponentButton d){
        d.updateSelected();
        refreshTotal();
    }
        

}
