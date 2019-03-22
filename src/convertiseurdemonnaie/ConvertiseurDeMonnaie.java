
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertiseurdemonnaie;

import java.awt.*;
import javax.swing.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author afif.jabnoun
 */
public class ConvertiseurDeMonnaie extends JFrame{

    
    private JTextField text1;
    private JTextField text2;
    private JComboBox comboxe1;
    private JComboBox comboxe2;
    private JButton  convertir;
    private JButton  annuler;
    private JLabel  l1;
            
    
    
    public  ConvertiseurDeMonnaie(String title){
        
        super (title);
        //this.setSize(500, 300);
        this .setLocation(250, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /*JPanel c =(JPanel) this.getContentPane(); reference de l'interface
        text1=new JTextField(10); inisialisation de attribue de texte filed 
        comboxe1=new JComboBox();
        l1=new JLabel("=");
        text2=new JTextField(10);
         comboxe2=new JComboBox();
        
        c.setLayout(new FlowLayout());
        c.add(text1);
        c.add(comboxe1);
        c.add(l1);
        c.add(text2);
        c.add(comboxe2);*/
        
        text1=new JTextField(10);
        String[] str={"Dinar TU","Euro","Dolar"};
        comboxe1=new JComboBox(str);
        l1=new JLabel("=");
        text2=new JTextField(10);
        comboxe2=new JComboBox(str);
        convertir=new JButton("convertir");
        annuler=new JButton("annuler");
        
        
         JPanel c =(JPanel) this.getContentPane();
         JPanel p1=new JPanel();
         JPanel p2=new JPanel();
        
         p1.setLayout(new FlowLayout(FlowLayout.CENTER));
         p2.setLayout(new FlowLayout(FlowLayout.CENTER));
         
         p1.add(text1);
         p1.add(comboxe1);
         p1.add(l1);
         p1.add(text2);
         p1.add(comboxe2);
         
         p2.add(convertir);
         p2.add(annuler);
         annuler.addActionListener(new AnnulairListner() );
         convertir.addActionListener(new ConverteListner());
         c.add(p1,BorderLayout.NORTH);
         c.add(p2);
         this.pack();
         this.show();
    }

    public class AnnulairListner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            text1.setText("");
            text2.setText("");
            comboxe1.setSelectedIndex(0);
            comboxe2.setSelectedIndex(0);
            

        }     /*Joption(null,"bbbbbbbbbbbb")*/ 
}
    public class ConverteListner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {

          if(text1.getText().equals("")){
             JOptionPane.showMessageDialog(null, "errer de saisir","errer",JOptionPane.ERROR_MESSAGE);
          }
          else
                if(comboxe1.getSelectedIndex()==comboxe2.getSelectedIndex()){
                    JOptionPane.showMessageDialog(null,"meme device!!!!!","device",JOptionPane.ERROR_MESSAGE);
          }
          else
                {
                    try{
                        double a=Double.parseDouble(text1.getText());

                        if(comboxe1.getSelectedItem().equals("Euro")&&comboxe2.getSelectedItem().equals("Dinar TU")){
            
                            double res =3.3*Double.parseDouble(text1.getText());
                            text2.setText(""+res);
                                                 }
                        
                           if(comboxe1.getSelectedItem().equals("Dinar TU")&&comboxe2.getSelectedItem().equals("Euro")){
            
                            double res =0.3*Double.parseDouble(text1.getText());
                            text2.setText(""+res);
                                                 }
                        
                    }
                    catch(NumberFormatException e){
                            
                            JOptionPane.showMessageDialog(null,"saisir valeur reel", "valeur reel", JOptionPane.ERROR_MESSAGE);
                            
                           
                    }
                        
                    }
                        
                    }
        
    }
            
    public static void main(String[] args) {
        // TODO code application logic here
        ConvertiseurDeMonnaie fen=new ConvertiseurDeMonnaie("ConvertiseurDeMonnaie");
        
    }
    
}

