
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registration extends JFrame implements ActionListener {

    JLabel first,last,email,number,addres;
    JTextField name,lastname,gmail,pnumber,resses;
    JButton register,alreadyregister;
    registration(){

        alreadyregister = new JButton("Alreadyregester");
        alreadyregister.addActionListener(this);
        alreadyregister.setBounds(370,380,170,70);


        register = new JButton("Register");
        register.addActionListener(this);
        register.setBounds(200,380,110,70);

        first = new JLabel("First name");
        first.setBounds(50,40,150,50);

        last = new JLabel("Last name");
        last.setBounds(370,40,90,50);

        email = new JLabel("Email");
        email.setBounds(50,120,90,50);

        number = new JLabel("Mobile number");
        number.setBounds(50,210,90,50);

        addres = new JLabel( "Address");
        addres.setBounds(50,310,90,50);

        name = new JTextField("");
        name.setBounds(200,25,150,50);
        name.addActionListener(this);

        lastname = new JTextField();
        lastname.setBounds(470,25,150,50);
        lastname.addActionListener(this);

        gmail = new JTextField();
        gmail.setBounds(200,130,400,50);
        gmail.addActionListener(this);

        resses = new JTextField();
        resses.setBounds(200,300,400,50);
        resses.addActionListener(this);

        pnumber = new JTextField();
        pnumber.setBounds(200,220,400,50);
        pnumber.addActionListener(this);

        ImageIcon li = new ImageIcon(ClassLoader.getSystemResource("resource/background.png"));
        JLabel label = new JLabel(li);
        label.setBounds(0,0,740,600);


        this.setTitle("login");//sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit out of application
        //  frame.setResizable(false);prevent frame from being resized
//        this.setSize(700,700);//sets the x-dimension, and y-dimension of the frame
        this.add(name);
        this.add(addres);
        this.add(email);
        this.add(first);
        this.add(last);
        this.add(gmail);
        this.add(register);
        this.add(alreadyregister);
        this.add(number);
        this.add(pnumber);
        this.add(resses);
        this.add(lastname);
        this.add(label);

//this.setLocationRelativeTo(null);

        this.setSize(750,600);
//
        this.setLayout(null);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == register){
            String Id = name.getText().toString();
            String last = lastname.getText().toString();
            String number = pnumber.getText().toString();
            String em = gmail.getText().toString();
            String ad = resses.getText().toString();
            if (Id.equals("")){
                JOptionPane.showMessageDialog(null,"please enter first name");
            }if (last.equals("")){
                JOptionPane.showMessageDialog(null,"please enter last name");
            }if (number.equals("")){
                JOptionPane.showMessageDialog(null,"please enter number");
            }if (em.equals("")){
                JOptionPane.showMessageDialog(null,"please enter gmail");
            }if (ad.equals("")){
                JOptionPane.showMessageDialog(null,"please enter address");
            }
            else {
                new home();
                this.setVisible(false);
            }

        }

        if (e.getSource() == alreadyregister){
            new home();
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new registration();
    }
}




//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class registration extends JFrame implements ActionListener {
//
//    JLabel first,last,email,number,addres;
//    JTextField name,lastname,gmail,pnumber,resses;
//    JButton register,alreadyregister;
//    registration(){
//
//        alreadyregister = new JButton("Alreadyregester");
//        alreadyregister.addActionListener(this);
//        alreadyregister.setOpaque(false);
//        alreadyregister.setBounds(440,380,180,70);
//        alreadyregister.setFocusable(false);
//
//
//        register = new JButton("Register");
//        register.addActionListener(this);
//        register.setBounds(200,380,180,70);
//        register.setFocusable(false);
//
//        first = new JLabel("First name");
//        first.setBounds(50,32,150,50);
//
//        last = new JLabel("Last name");
//        last.setBounds(370,32,90,50);
//
//        email = new JLabel("Email");
//        email.setBounds(50,120,90,50);
//
//        number = new JLabel("Mobile number");
//        number.setBounds(50,218,90,50);
//
//        addres = new JLabel( "Address");
//        addres.setBounds(50,305,90,50);
//
//        name = new JTextField("");
//        name.setBounds(200,25,150,50);
//        name.addActionListener(this);
//        name.setFocusable(false);
//
//        name.setEditable(true);
//
//        lastname = new JTextField();
//        lastname.setBounds(470,25,150,50);
//        lastname.addActionListener(this);
//        lastname.setFocusable(false);
//        lastname.setOpaque(false);
//
//        gmail = new JTextField();
//        gmail.setBounds(200,130,420,50);
//        gmail.addActionListener(this);
//        gmail.setFocusable(false);
//        gmail.setOpaque(false);
//
//        resses = new JTextField();
//        resses.setBounds(200,300,420,50);
//        resses.addActionListener(this);
//        resses.setFocusable(false);
//        resses.setOpaque(false);
//
//        pnumber = new JTextField();
//        pnumber.setBounds(200,220,420,50);
//        pnumber.addActionListener(this);
//        pnumber.setFocusable(false);
//
//
//
//
//
//
//
//
//
//        ImageIcon li = new ImageIcon(ClassLoader.getSystemResource("background.png"));
//        JLabel label = new JLabel(li);
//        label.setBounds(0,0,740,600);
//
//
//        this.setTitle("login");//sets title of frame
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit out of application
//        //  frame.setResizable(false);prevent frame from being resized
////        this.setSize(700,700);//sets the x-dimension, and y-dimension of the frame
//        this.add(name);
//        this.add(addres);
//        this.add(email);
//        this.add(first);
//        this.add(last);
//        this.add(gmail);
//        this.add(register);
//        this.add(alreadyregister);
//        this.add(number);
//        this.add(pnumber);
//        this.add(resses);
//        this.add(lastname);
//        this.add(label);
//
////this.setLocationRelativeTo(null);
//
//        this.setSize(750,600);
////
//        this.setLayout(null);
//        this.setVisible(true);
//    }
//
//
//
//
//
//
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == register){
//            String Id = name.getText().toString();
//            String last = lastname.getText().toString();
//            String number = pnumber.getText().toString();
//            String em = gmail.getText().toString();
//            String ad = resses.getText().toString();
//            if (Id.equals("")){
//                JOptionPane.showMessageDialog(null,"please enter first name");
//            }if (last.equals("")){
//                JOptionPane.showMessageDialog(null,"please enter last name");
//            }if (number.equals("")){
//                JOptionPane.showMessageDialog(null,"please enter number");
//            }if (em.equals("")){
//                JOptionPane.showMessageDialog(null,"please enter gmail");
//            }if (ad.equals("")){
//                JOptionPane.showMessageDialog(null,"please enter address");
//            }
//            else {
//                new home();
//                this.setVisible(false);
//            }
//
//
//
//        }
//
//        if (e.getSource() == alreadyregister){
//            new home();
//            this.setVisible(false);
//        }
//
//
//
//    }
//
//    public static void main(String[] args) {
//        new registration();
//    }
//}
//
