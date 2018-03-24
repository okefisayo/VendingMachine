import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class VendingMachine extends JFrame
{
   private int a = 5;
   private int b = 5;
   private int c = 5;
   private int d = 5;
   private double e = 0;
   private JRadioButton button1;
   private JRadioButton button2;
   private JRadioButton button3;
   private JRadioButton button4;
   private JTextField amount;
   private JTextField  money;
   private JTextArea area;
   private JTextField sodaNo;
   private JTextField cookieNo;
   private JTextField twixNo;
   private JTextField getoNo;
   
   
   public VendingMachine()
   {
      setSize(600, 300);
      createRadioButton();
      createMoney();
      Menu();
   }
   //this actionListener displays the amount of each product when selected
   class BuyListener implements ActionListener{
   public void actionPerformed(ActionEvent e){
      if(button1.isSelected())
      {
         amount.setText("1.50");
      }
      else if(button2.isSelected())
      {
         amount.setText("1.25");
      }
      else if(button3.isSelected())
      {
         amount.setText("1.25");
      }
      else if(button4.isSelected())
      {
         amount.setText("1.75");
      }
         
   }
   }

   
   public void createRadioButton(){
      ActionListener list = new BuyListener();
      
      button1 = new JRadioButton("soda");
      button1.addActionListener(list);
      button2 = new JRadioButton("cookie");
      button2.addActionListener(list);
      button3 = new JRadioButton("twix");
      button3.addActionListener(list);
      button4 = new JRadioButton("getorade");
      button4.addActionListener(list);
      ButtonGroup group = new ButtonGroup();
      group.add(button1);
      group.add(button2);
      group.add(button3);
      group.add(button4);
      JPanel panel = new JPanel();
      JPanel panel3 = new JPanel();
      panel3.setLayout(new GridLayout(2, 1, 4, 4));
      
      panel.add(button1);
      panel.add(button2);
      panel.add(button3);
      panel.add(button4);
      panel.setBorder(new TitledBorder(new EtchedBorder(), "products"));
      panel3.add(panel);
      JButton button = new JButton("purchase");
      panel3.add(button);
      add(panel3, BorderLayout.SOUTH);
      ActionListener press = new PurchaseListener();
      button.addActionListener(press);
   }
   public void createMoney()
   {
      JLabel label1 = new JLabel("insert Money");
      money = new JTextField(10);
      JLabel label2 = new JLabel("amount");
      amount = new JTextField(10);
      amount.setEditable(false);
      area = new JTextArea(3, 40);
      area.setEditable(false);
      JPanel panel2 = new JPanel();
      panel2.add(label2);
      panel2.add(amount);
      panel2.add(label1);
      panel2.add(money);
      panel2.add(area);
      add(panel2, BorderLayout.NORTH);
   }
   // this action listener displays a new frame to restock the item
     class ClickListener implements ActionListener{
      public void actionPerformed(ActionEvent event){
         JFrame frame2 = new JFrame();
         frame2.setSize(500, 500);
         frame2.setVisible(true);
         
         JLabel password = new JLabel("password");
         JTextField fieldPass = new JTextField(10);
         fieldPass.setText("");
         JLabel soda = new JLabel("soda");
         sodaNo = new JTextField(10);
         sodaNo.setEditable(false);
         JLabel cookie = new JLabel("cookie");
         cookieNo = new JTextField(10);
         cookieNo.setEditable(false);
         JLabel twix = new JLabel("twix");      
         twixNo = new JTextField(10); 
         twixNo.setEditable(false);     
         JLabel getorade = new JLabel("getorade");
         getoNo = new JTextField(10);
         getoNo.setEditable(false);
         JButton buttonStock = new JButton("enter");
         JPanel pan = new JPanel();
         JButton button5 = new JButton("enter");
         pan.add(password);
         pan.add(fieldPass);
         pan.add(button5);
         
        // this actionlistener checks maybe the password is correct before restocking
         class EnterListener implements ActionListener{
         public void actionPerformed(ActionEvent ev){
            if(fieldPass.getText().equals("operator"))
            {
               sodaNo.setEditable(true);
               cookieNo.setEditable(true);
               twixNo.setEditable(true);
               getoNo.setEditable(true);
            }
         ActionListener l = new RestockListener();
         buttonStock.addActionListener(l);
   
         }
         }
         ActionListener listen = new EnterListener();
         button5.addActionListener(listen);
         pan.add(soda);
         pan.add(sodaNo);
         pan.add(cookie);
         pan.add(cookieNo);
         pan.add(twix);
         pan.add(twixNo);
         pan.add(getorade);
         pan.add(getoNo);
         pan.add(buttonStock);
         frame2.add(pan);
                  
   }
   }
    public void Menu()
   {
      JMenuBar bar = new JMenuBar();
      JMenu menu = new JMenu("File");   
      JMenuItem item = new JMenuItem("restock");
      JMenuItem tem = new JMenuItem("remove money");
      menu.add(item);
      menu.add(tem);
      bar.add(menu);
      setJMenuBar(bar);
      ActionListener listener = new ClickListener();
      item.addActionListener(listener);
      
      ActionListener remove = new RemoveListener();
      tem.addActionListener(remove);
   }
   class PurchaseListener implements ActionListener{
   public void actionPerformed(ActionEvent evv){
      double Amount = Double.parseDouble(amount.getText());
      double Money = Double.parseDouble(money.getText());
      if(Money == Amount || Money > Amount)
      {
         if(button1.isSelected())
         {
            if(a == 0)
            {
               area.setText("item not available, take coin.");
            }
            else
            {
               area.setText("item purchased, Remove item.");
                a--;
                e = e + Double.parseDouble(money.getText());
               
            }
         }
         else if(button2.isSelected())
         {
            if(b == 0)
            {
               area.setText("item not available, take coin.");
            }
            else
            {
               area.setText("item purchased, Remove item.");
               b--;
               e = e + Double.parseDouble(money.getText());
            }
         }
         else if(button3.isSelected())
         {
            if(c == 0)
            {
               area.setText("item not available, take coin.");
            }
            else
            {
               area.setText("item purchased, Remove item.");
               c--;
               e = e + Double.parseDouble(money.getText());
            }
         }
         else if(button4.isSelected())
         {
            if(d == 0)
            {
               area.setText("item not available, take coin.");         
            }
            else
            {
               area.setText("item purchased, Remove item.");
               d--;
               e = e + Double.parseDouble(money.getText());
            }
         }

      }
      else if(Money < Amount)
      {
         area.setText("insufficient amount, take coin back.");
      }    
      money.setText("");
   }
   }
   class RestockListener implements ActionListener{
   public void actionPerformed(ActionEvent even){
     a = a + Integer.parseInt(sodaNo.getText());
     b = b + Integer.parseInt(cookieNo.getText());
     c = c + Integer.parseInt(twixNo.getText());
     d = d + Integer.parseInt(getoNo.getText());
     
     sodaNo.setText("");
     cookieNo.setText("");
     twixNo.setText("");
     getoNo.setText("");
      
      
   }
   }
   class RemoveListener implements ActionListener{
   public void actionPerformed(ActionEvent events){
      JFrame frame3 = new JFrame();
      frame3.setSize(500, 300);
         frame3.setVisible(true);
         
         JLabel password = new JLabel("password");
         JTextField fieldPass = new JTextField(10);
         fieldPass.setText("");
         JButton button5 = new JButton("enter");

         
         JTextArea area2 = new JTextArea(3, 40);
         area2.setEditable(false);
         JPanel panel3 = new JPanel();
         panel3.add(password);
         panel3.add(fieldPass);
         panel3.add(button5);
         panel3.add(area2);
         frame3.add(panel3);
         
        
         
         class EnterListener implements ActionListener{
         public void actionPerformed(ActionEvent ev){
            if(fieldPass.getText().equals("operator"))
            {
               area2.setText("$" + e + " has been removed from the system."); 
            }
            else
            {
               area2.setText("incorrect password.");
            }
         }
         }
         
         ActionListener ll = new EnterListener();
         button5.addActionListener(ll);
            
   
   }
   }
      
   
      
}
