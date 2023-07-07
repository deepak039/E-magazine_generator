
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class home extends JFrame implements ActionListener {
    JButton[] template = new JButton[9];
    JButton generate,open,home,b1,b2,b3,b4,b5,b6,b7,b8,b9,about;
    JPanel panel,sidepanel;
    ImageIcon icon;

    home(){
        about = new JButton("About");
        about.setFocusable(false);
        about.setBackground(Color.LIGHT_GRAY);
        about.setHorizontalTextPosition(JButton.CENTER);
        about.setVerticalTextPosition(JButton.BOTTOM);
        about.setBounds(0,525,200,75);
        about.addActionListener(this);

        generate = new JButton("generate");
        generate.setFocusable(false);
        generate.setBackground(Color.LIGHT_GRAY);
        generate.setHorizontalTextPosition(JButton.CENTER);
        generate.setVerticalTextPosition(JButton.BOTTOM);
        generate.setBounds(0,175,200,175);
        generate.addActionListener(this);

         icon = new ImageIcon("download(1).png");
        home = new JButton("home",icon);

        home.setFocusable(false);

        home.setBackground(Color.ORANGE);
        home.setHorizontalTextPosition(JButton.CENTER);
        home.setVerticalTextPosition(JButton.BOTTOM);
        home.setBounds(0,0,200,175);
        home.addActionListener(this);

        open = new JButton("open");
        open.setFocusable(false);

        open.setBackground(Color.LIGHT_GRAY);
        open.setHorizontalTextPosition(JButton.CENTER);
        open.setVerticalTextPosition(JButton.BOTTOM);
        open.setBounds(0,350,200,175);

        JLabel label = new JLabel("generate magazine");
        label.setBounds(350,50,60,60);


        sidepanel = new JPanel();
        sidepanel.setBackground(Color.LIGHT_GRAY);
        sidepanel.add(generate);
        sidepanel.add(home);
        sidepanel.add(open);
        sidepanel.add(about);

        sidepanel.setBounds(0,0,200,600);
        sidepanel.setLayout(null);



        panel = new JPanel();
        ImageIcon image1 = new ImageIcon("lpoltics.png");
        ImageIcon image2 = new ImageIcon("lnature.png");
        ImageIcon image3 = new ImageIcon("lspace.png");
        ImageIcon image4 = new ImageIcon("lsports.png");
        ImageIcon image5 = new ImageIcon("lscience.png");
        ImageIcon image6 = new ImageIcon("lenterminant.png");
        ImageIcon image7 = new ImageIcon("ieducation.png");
        ImageIcon image8 = new ImageIcon("lreligious.png");
        ImageIcon image9 = new ImageIcon("ispritual.png");

        b1 = new JButton("Political",image1);
        template[0]=b1;

        b2 = new JButton("Nature",image2);
        template[1]=b2;

        b3 = new JButton("Space",image3);
        template[2]=b3;

        b4 = new JButton("Sports",image4);
        template[3]=b4;

        b5 = new JButton("Science",image5);
        template[4]=b5;


        b6 = new JButton("Entertainment",image6);
        template[5]=b6;

        b7 = new JButton("Education",image7);
        template[6]=b7;

        b8 = new JButton("Religious",image8);
        template[7]=b8;

        b9 = new JButton("Spiritual",image9);
        template[8]=b9;

        for (int i = 0; i <9; i++) {
            template[i].setVerticalTextPosition(JButton.BOTTOM);
            template[i].setHorizontalTextPosition(JButton.CENTER);
            template[i].addActionListener(this);
//            template[i].setOpaque(false);
            template[i].setFocusable(false);
            template[i].setBackground(Color.PINK);
            template[i].setForeground(Color.WHITE);
            template[i].setFont(new Font("My Boli",Font.BOLD,20));
        }
//        panel.add(label);
        ImageIcon li = new ImageIcon(ClassLoader.getSystemResource("background.png"));
        JLabel labe = new JLabel(li);
        labe.setBounds(0,0,800,635);

        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
//        panel.add(labe);
//        panel.setBackground(Color.CYAN);
        panel.setBounds(230,70,500,500);
        panel.setLayout(new GridLayout(3,3,10,10));
        panel.setVisible(false);









        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,635);

//        this.add(label);
        this.add(panel);
        this.add(sidepanel);
        this.add(labe);
//        this.getContentPane().setBackground(Color.CYAN);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==home){
            panel.setVisible(false);
            home.setBackground(Color.ORANGE);
            generate.setBackground(Color.LIGHT_GRAY);
        }

        if(e.getSource()==generate) {
            panel.setVisible(true);
            generate.setBackground(Color.ORANGE);
            home.setBackground(Color.LIGHT_GRAY);
        }
        else if (e.getSource() == b1) {
            new poltical();
            this.setVisible(false);

        }
        else if(e.getSource()==about){
            home.setBackground(Color.LIGHT_GRAY);
            generate.setBackground(Color.LIGHT_GRAY);
            open.setBackground(Color.LIGHT_GRAY);
            about.setBackground(Color.ORANGE);
            panel.setVisible(false);


            String message =
                    "<html>"+
                            "The main aim of the project is to provide " +"<br><br>"+
                            "a graphical user interface for creating and generating" +"<br><br>"+
                            " the magazines. It is an application that simplifies the " +"<br><br>"+
                            "task of creating a magazine. The system is flexible to " +"<br><br>"+
                            "be used and reduces the need of thinking and designing " +"<br><br>"+
                            "an appropriate magazine according to the individual’s " +"<br><br>"+
                            "requirements. The system is developed to provide an easy " +"<br><br>"+
                            "means for creating a professional looking magazine. " +"<br><br>"+
                            "Individuals just need to select the template of their " +"<br><br>"+
                            "choice and follow the desired steps as per the template " +"<br><br>"+
                            "to complete the magazine. The details provided by the users " +"<br><br>"+
                            "are stored and the system automatically generates a well-structured" +"<br><br>"+
                            " magazine. Users have the option to create magazines in any format " +"<br><br>"+
                            "and file."+"<html>";
            JOptionPane.showMessageDialog(null,message,"title",JOptionPane.PLAIN_MESSAGE);
            about.setBackground(Color.LIGHT_GRAY);
            home.setBackground(Color.ORANGE);
        }


          if (e.getSource() == b2) {
              new nature();
              this.setVisible(false);
          }


        if (e.getSource() == b3) {
            new space();
            this.setVisible(false);
        }


        if (e.getSource() == b4) {
            new sports();
            this.setVisible(false);
        }


        if (e.getSource() == b5) {
            new science();
            this.setVisible(false);
        }


        if (e.getSource() == b6) {
            new entertainment();
            this.setVisible(false);
        }


        if (e.getSource() == b7) {
            new education();
            this.setVisible(false);
        }


        if (e.getSource() == b8) {

            new religious();
            this.setVisible(false);
        }

        if(e.getSource()==b9){
            new spritual();
            this.setVisible(false);
//            JFileChooser fileChooser = new JFileChooser();
//            FileNameExtensionFilter filter = new FileNameExtensionFilter("4 Extensions Supported","jpg","png","jpeg","gif");
//            fileChooser.setFileFilter(filter);
//            int selected = fileChooser.showOpenDialog(this);
//            if(selected== JFileChooser.APPROVE_OPTION)
//            {
//                File file = fileChooser.getSelectedFile();
//                String getselectedImage= file.getAbsolutePath();
//                JOptionPane.showMessageDialog(null, getselectedImage);
////                ImageIcon imIco = new ImageIcon(getselectedImage );
////
////                Image imFit= imIco.getImage();
////                icon = new ImageIcon(getClass().getClassLoader().getResource("spritual.png"));
//                spritual sprit = new spritual();
//                sprit.pathway(getselectedImage);



            }

        }
    }

//    public static void main(String[] args) {
//        new home();
//    }




