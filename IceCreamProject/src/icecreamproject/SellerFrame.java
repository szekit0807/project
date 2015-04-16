package icecreamproject;

import icecreamproject.Button.*; 
import icecreamproject.Panel.*;

import javax.swing.*; //Step 1

import java.awt.BorderLayout;//Step 2
import java.awt.Color;
import java.awt.Font; //Step 4
import java.awt.GridLayout;//Step 3
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SellerFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private FlavorPanel panelFlavor;           //Class:FlavorPanel    Variable:panelFlavor
	private DecoratorPanel panelDecorator;     //Class:DecoratorPanel Variable:panelDecorator
	private JTextField txtTotal;               //Class:JTextField     Variable:txtTotal
	private JButton btn_New_Icecream; 		   //Class:JButton        Variable:btn_New_Icecream
	private JButton btn_Confirm; 		       //Class:JButton        Variable:btn_Confirm
	private JButton btn_System_Administrator;  //Class:JButton        Variable:btn_System_Administrator
	
	
	
	
	public SellerFrame() throws Exception {  //test pull in this time
		super("COMP5134 - Ice Cream POS System");
		getContentPane().setLayout(new GridLayout(1, 3, 10, 0)); //Step3-1 JFrame's get "getContentPane" method . return "setLayout" method (int rows, int cols, int hgap, int vgap)
			JPanel panel_left = new JPanel();
				add(panel_left);
				panel_left.setLayout(new BorderLayout());
					JLabel lblFlavor = new JLabel("  ICE-CREAM Flavor");          //Create New Label & named as lblFlavor
					Font fontFlavor =lblFlavor.getFont();                         //Step 4-1 Set fonts
					lblFlavor.setFont(new Font(fontFlavor.getFontName(), Font.ITALIC|Font.BOLD, 15)); //Step 4-2 Set fonts (Font style, size )
			        panel_left.add(lblFlavor, BorderLayout.NORTH);                //Add lblFlavor onto BorderLayout North position
			        
			        panelFlavor=new FlavorPanel(this);
			        panel_left.add(panelFlavor, BorderLayout.CENTER);
			        panelFlavor.add("Chocolate", 20);
			        panelFlavor.add("Vanilla", 20);

			JPanel panel_center = new JPanel();
				add(panel_center);
				panel_center.setLayout(new BorderLayout());
					JLabel lblDecorator = new JLabel("  Decorator");
					Font fontDecorator =lblDecorator.getFont();
					lblDecorator.setFont(new Font(fontDecorator.getFontName(), Font.ITALIC|Font.BOLD, 15));
					panel_center.add(lblDecorator, BorderLayout.NORTH);
					panelDecorator=new DecoratorPanel(this);
					panel_center.add(panelDecorator, BorderLayout.CENTER);
				    panelDecorator.add("M&M", 5);
				    panelDecorator.add("Strawberry", 4);




			JPanel panel_right = new JPanel(new GridLayout(11, 1));
				add(panel_right);
					JLabel lblblank = new JLabel("");
					panel_right.add(lblblank);
					btn_New_Icecream = new JButton("[New Icecream]");
					btn_New_Icecream.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							btn_New_Icecream_ActionEvent(e);
						}
					});
					panel_right.add(btn_New_Icecream);
					JLabel lblblank2 = new JLabel("");
					panel_right.add(lblblank2);
					JLabel lblblank3 = new JLabel("");
					panel_right.add(lblblank3);
					JLabel lblblank4 = new JLabel("");
					panel_right.add(lblblank4);					
				
					JLabel lblTotal = new JLabel("Total:");
					panel_right.add(lblTotal);
					txtTotal = new JTextField("");
					txtTotal.setEditable(false);
					txtTotal.setBackground(new Color(255,255,255));
					panel_right.add(txtTotal);
					
					btn_Confirm = new JButton("[Confirm]");
					btn_Confirm.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							btn_Confirm_ActionPerformed(e);
						}						
					});
					panel_right.add(btn_Confirm);
					
					JLabel lblblank6= new JLabel("");
					panel_right.add(lblblank6);
					
					btn_System_Administrator = new JButton("[System Administrator]");
					btn_System_Administrator.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							btn_System_Administrator_ActionPerformed(e);
						}
					});
					panel_right.add(btn_System_Administrator);

		refreshTotal();
		//Step 2-2: JFrame size, location, visible
		this.setSize(800, 600);
	    this.setLocation(300, 50);
	    this.setVisible(true);
	    //Step 2-2: JFrame size, location, visible
	    
	}
	

	private void btn_Confirm_ActionPerformed(ActionEvent e) {
		 if (panelFlavor.getFlavor()==null){
	            JOptionPane.showMessageDialog(this,
	            "Flavor had not been selected",
	            "Error - Confirmation",
	            JOptionPane.INFORMATION_MESSAGE
	            );
	            return;
	     }
		 String output="Flavor: \n" + this.panelFlavor.getFlavor().getFlavorName() + " [ $" + panelFlavor.getFlavor().getPrice() + " ] \n";
	        output+="\nDecorator: \n";
	        for (int i = 0; i< panelDecorator.getComponentCount();i++){
	            DecoratorButton db =(DecoratorButton) panelDecorator.getComponent(i);
	            if (db.isSelected())
	                output+=db.getDecoratorName()  + " [ $" + db.getPrice() + " ] \n";
	        }
	        output+="\nTotal: " + txtTotal.getText();
	        int in = JOptionPane.showConfirmDialog(
	            this,
	            output,
	            "Ice Cream - Confirmation",
	            JOptionPane.YES_NO_OPTION);
	        if (in ==0 ){
	            reset();
	        }			
	}
	
	private void btn_System_Administrator_ActionPerformed(ActionEvent e) {
		//generate a Panel for input the new item
        JPanel sysadminpanel =new JPanel();
	        sysadminpanel.setLayout(new GridLayout(6, 1, 0, 0));
			
	        sysadminpanel.add(new JLabel("Name"));
	        JTextField textName = new JTextField("");
			sysadminpanel.add(textName);
			
			sysadminpanel.add(new JLabel("Price"));
			JTextField textPrice = new JTextField("");
			sysadminpanel.add(textPrice);
			
			sysadminpanel.add(new JLabel("Type"));
			JComboBox<String> comboBoxType = new JComboBox<String>();
			comboBoxType.addItem("Flavor");
			comboBoxType.addItem("Decorator");
			sysadminpanel.add(comboBoxType);
        
		// pop up the panel
        int result = JOptionPane.showConfirmDialog(null, sysadminpanel, "New Component",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            
        if (result == JOptionPane.OK_OPTION) {
            String newName= textName.getText().trim();
            String newStringPrice=textPrice.getText().trim();
            String type=(String)comboBoxType.getSelectedItem();
            int newType=comboBoxType.getSelectedIndex();
            double newPrice=-1;
            
            //check is Empty
            if (newName.equals("") || newStringPrice.equals("")){
                JOptionPane.showConfirmDialog(null, "Missing Input!\nName and Price must be inputted\nPlease Check", "Error - Add New Item",
                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            //check the price is valid
            try{
                newPrice =Double.parseDouble(newStringPrice); //try convert price value to double
            }catch(Exception ex){
                JOptionPane.showConfirmDialog(null, "Invaild Number on Price! \nPlease Check", "Error - Add New Item",
                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                return;
            }
               
            int resultAdd =0;
            
            //add into panelFlavor or panelDecorator
            if (newType==0){
            	resultAdd =panelFlavor.add(newName, newPrice); //get return in value from FlavorPanel.java 's "add" method
            }else if (newType==1){
            	resultAdd =panelDecorator.add(newName, newPrice);
            }
            
            //check add successfully
            if (resultAdd ==ComponentPanel.Over){
                JOptionPane.showConfirmDialog(null, "The "+ type +" was Full \nPlease Check", "Error - Add New Item",
                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);            	
            }else if (resultAdd ==ComponentPanel.Duplicated){
                JOptionPane.showConfirmDialog(null, "The Same record was found in "+type+"\nPlease Check", "Error - Add New Item",
                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);            	
            }else if (resultAdd ==ComponentPanel.Negative){
                JOptionPane.showConfirmDialog(null, "Invaild Number! -ve Number was found on Price\nPlease Check", "Error - Add New Item",
                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            }else if (resultAdd ==ComponentPanel.WrongName){
                JOptionPane.showConfirmDialog(null, "Missing Input!\nName and Price must be inputted\nPlease Check", "Error - Add New Item",
                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            }
            setVisible(true);
        }
	}

	private void btn_New_Icecream_ActionEvent(ActionEvent e) {
		reset();
	}
    private void reset(){
    	panelFlavor.reset();
    	panelDecorator.reset();
        refreshTotal();
    }
    private double getTotal(){
        return panelFlavor.getPrice()+panelDecorator.getPrice(); //getPrice @ComponentPanel
    }
    
    public void refreshTotal(){
    	txtTotal.setText( "$ "+String.format("%.2f", getTotal()));  //getTotal @ComponentPanel
    }
	public static void main(String[] args) {
		try{
			new SellerFrame();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

 }
}
