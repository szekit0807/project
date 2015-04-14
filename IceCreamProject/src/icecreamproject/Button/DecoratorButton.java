package icecreamproject.Button;

public class DecoratorButton  extends ComponentButton {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    
    public DecoratorButton(String decoratorName, double price)  throws Exception{
        super(decoratorName, price);
    }


    public String getDecoratorName(){
        return getComponentName();
    }
       

}
