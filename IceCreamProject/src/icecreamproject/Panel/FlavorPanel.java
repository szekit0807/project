package icecreamproject.Panel;
import icecreamproject.Button.*;
import icecreamproject.*;


public class FlavorPanel extends ComponentPanel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public FlavorPanel(SellerFrame parent)throws Exception{ //parent = SellerFrame
        super(parent); // put parent (=SellerFrame) --> super (ComponentPancel)
    }    
   
    public int add(String name, double price){
    	int result;
    	try{
    		result = addComponentButton(new FlavorButton(name, price));
    	}catch(Exception e){
    		if (e.getMessage().equals(FlavorButton.errorName)){
    			result = WrongName;
    		}
    		else if (e.getMessage().equals(FlavorButton.errorNegative)){
    			result = Negative;
    		}else {
    			result = OtherError;
    		}
    	}
    	return result;
    }
           
        
    public void selectButton(ComponentButton f){
    	reset(); // @ componentPanel
        f.updateSelected(); // @ componentPanel
        refreshTotal(); //@ ComponentPanel
    }     
    
    public FlavorButton getFlavor(){
    	FlavorButton selectedFlavor =null;
    	int count=getComponentCount();
    	for (int i= 0; i<count; i++ ){
    		FlavorButton tmp = (FlavorButton)getComponent(i);
    		if ( tmp.isSelected() ){
	    		selectedFlavor=tmp;
	    		i=count;
    		}
    	}
        return selectedFlavor;
    }
}
