package icecreamproject.Panel;

import java.awt.GridLayout;

import icecreamproject.SellerFrame;
import icecreamproject.Button.ComponentButton;

import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class ComponentPanel extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SellerFrame parentFrame = null;
    public final static int AddOk = 0;
    public final static int Over = -1;
    public final static int Duplicated = -2;
    public final static int Negative = -3;
    public final static int WrongName = -4;
    public final static int OtherError = -5;
    public final static String NullSellerFrame = "SellerFrame must not null";
    
    
    public final int Max = 10; //Set Flavor or Decorator max record is 10
	public ComponentPanel(SellerFrame parent) throws Exception{
        super();
        init(parent);
    }
    public void reset(){
        int count =getComponentCount();
        for (int i=0; i <count; i++){
        	ComponentButton d =((ComponentButton) getComponent(i));
            if (d.isSelected()){
                d.updateSelected();
            }
        }
    }
	protected void init(SellerFrame parent) throws Exception{ //initialize
		if (parent == null){
			throw new Exception(NullSellerFrame);
		}
        parentFrame=parent;
        setLayout(new GridLayout(Max, 1, 5, 5));
    }
    
    protected void refreshTotal(){
    	parentFrame.refreshTotal();
    	
    }
    
    protected int getIndex (ComponentButton CB){ // Protected means Allow child class use this method only
        return getIndex(CB, 0, getComponentCount());
    }
    private boolean isReachMax(){
    	return (count()>=Max);
    }
    
    protected int count(){
    	int a =0;
    	for (int i = 0; i<getComponentCount() ; i++){
    		if (getComponent(i).isVisible())
    			a++;
    	}
    	return a;
    }
    private int getIndex (ComponentButton f, int min, int max){ //
        if (max<=min){
            return min;
        }
        ComponentButton mid=(ComponentButton) getComponent((min+max)/2);
        if (! mid.isVisible()){
        	return getIndex(f, min, (min+max)/2);
        }
        int tmp =mid.getText().compareToIgnoreCase(f.getText()) ;
        if (tmp > 0){
            return getIndex(f, min, (min+max)/2);
        }else if (tmp < 0){
            return getIndex(f, (min+max)/2+1, max);
        }else{
        	return (min+max)/2;
        }
    }
    protected int addComponentButton(ComponentButton i){
        i.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonActionPerformed(evt);
            }
        });
        
    	if (isReachMax())
    		return Over;
    	else {
    		int index = getIndex(i);
    		String tmpString=null;  //similar i=0
    		
    		if (getComponentCount()>index)
    			tmpString =((ComponentButton) getComponent(index)).getText();
    		
    		int tmp = -1;
    		if(tmpString != null){
    			tmp=i.getText().compareToIgnoreCase(tmpString); //calcate difference is same, tmp=0
    		}
    		
    		if (tmp == 0 ){
    			return Duplicated;
    		}else{
    			add((JButton) i, index);
    		}
    		
    	}
    	while (getComponentCount()>Max){
    		this.remove(Max);
    	};
    	
    	return AddOk;
    }
    
    public double getPrice(){
        int count = getComponentCount();
        double sum = 0.0;
        for(int i = 0 ; i<count;i++){
        	ComponentButton tmp = (ComponentButton) getComponent(i);
            if (tmp.isSelected()){
                sum+=tmp.getPrice();
            }
        }
        return sum;
    }
    
    protected void ButtonActionPerformed(java.awt.event.ActionEvent evt) { 
    	selectButton((ComponentButton) evt.getSource());
    }      
    
    public abstract void selectButton(ComponentButton e);
    public abstract int add(String name, double price);

     
    
}
