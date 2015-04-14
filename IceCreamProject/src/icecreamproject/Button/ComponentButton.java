package icecreamproject.Button;

import java.awt.Color;
import java.text.DecimalFormat;

public abstract class ComponentButton extends javax.swing.JButton{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String errorName="Name was not inputted";
	public static final String errorNegative="-ve was inputted";
	private String name;
    private double price;
    private final DecimalFormat df = new DecimalFormat("#.##");     
	private boolean selected =false;
    
    public ComponentButton(String name, double price) throws Exception{ //this Class's constructor (need same name as class, cannot have void or int) 
        super();
        if (name == null || name.trim().equals("") ){
        	throw new Exception(errorName);
        }
        if (price<0){
        	throw new Exception(errorNegative);
        }

        this.name= name.trim();   //get name from ComponentButton -->this --> = line13
        this.price = Double.valueOf(df.format(price));
        updateText();
    }
    
    public double getPrice(){
        return price;
    }
    
    protected String getComponentName(){
        return name;
    }

    private void updateText(){
        setText(name+" :        $"+ String.format("%.2f", price));
    } 
    public void updateSelected(){
        selected = !this.selected;
        if (selected){
            this.setBackground(Color.red);
        }else
            {
            this.setBackground(null);
        }
    }
    
    public boolean isSelected(){
        return selected;
    }
}
