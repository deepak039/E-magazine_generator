import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

 abstract public class template implements ActionListener {
    JFrame frame;
    TextareaPlus textArea;
    JScrollPane scrollPane;
    JSpinner fontsizespinner;
    JLabel fontlabel;
    JButton fontColorButton,backgroundcolor;
    JComboBox fontbox;
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem home;
    JMenuItem saveItem;
    JMenuItem exitItem;
    JTextField title;

    //JTextPane pane;
    class TextareaPlus extends JTextArea{
        Image image;
        //    JTextareaPlus(){
//
//    }
        void setImage( ImageIcon icon){
            this.image = icon.getImage();
            setOpaque(false);
            repaint();

        }
        public void paint(Graphics g){
            g.drawImage(image,0,0,null);
            super.paint(g);
        }
    }

     void print(JFrame frame) {
         try
         {


             PrinterJob job= PrinterJob.getPrinterJob();
             job.setJobName("Print Data");
             job.setPrintable((Graphics pg, PageFormat pf, int pageNum) -> {
                 if(pageNum>0){
                     return Printable.NO_SUCH_PAGE;
                 }
                 Graphics2D g2=(Graphics2D)pg;
                 g2.translate(pf.getImageableX(),pf.getImageableY());
                 g2.scale(0.55,1);
//                 textArea.paint(g2);
//                 title.paint(g2);
                 frame.paint(g2);
                 return Printable.PAGE_EXISTS;
             });
             boolean ok=job.printDialog();
             if(ok){
                 try{
                     job.print();
                 }
                 catch(PrinterException ex){}
             }
         }
         catch(Exception e)
         {
             JOptionPane.showMessageDialog(null, e.getMessage());
         }
     }


     template(){
//pane= new JTextPane();
//pane.setSize(300,300
//);
        frame = new JFrame();
        fontlabel = new JLabel(" Font ");
        fontlabel.setSize(50,30);
        fontlabel.setBackground(Color.BLACK);
        fontlabel.setForeground(Color.BLACK);



       title = new JTextField("                                        Set Title....                                     ");
//       title.setSize(400,40);
       title.setFont(new Font("My Boli",Font.PLAIN,25));
       title.setForeground(Color.WHITE);
       title.setBackground(Color.BLACK);
//}

        textArea = new TextareaPlus();
//        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("education.png"));
//        textArea.setImage(icon);
        textArea.setPreferredSize(new Dimension(700,700));
//        textArea.setLineWrap(true);
//        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN,20));






        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(700,540));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBackground(Color.black);
        scrollPane.setForeground(Color.WHITE);
        scrollPane.setFont(new Font("My Boli",Font.PLAIN,25));

        fontsizespinner = new JSpinner();
        fontsizespinner.setPreferredSize(new Dimension(60,20));
        fontsizespinner.setValue(20);
        fontsizespinner.setBackground(Color.black);
        fontsizespinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                textArea.setFont(new Font(textArea.getFont().getFamily(),Font.PLAIN,(int)fontsizespinner.getValue()));

            }
        });
        fontColorButton = new JButton("Color");
        fontColorButton.addActionListener(this);
        fontColorButton.setBackground(Color.BLACK);
        fontColorButton.setForeground(Color.WHITE);
        fontColorButton.setSize(650,30);

        backgroundcolor = new JButton("background");
        backgroundcolor.addActionListener(this);
        backgroundcolor.setForeground(Color.WHITE);
        backgroundcolor.setBackground(Color.BLACK);

        backgroundcolor.setSize(125,30);


        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fontbox = new JComboBox (fonts);
        fontbox.addActionListener(this);
        fontbox.setBackground(Color.BLACK);
        fontbox.setForeground(Color.WHITE);

        //--------menubar-------

        menuBar = new JMenuBar();
        fileMenu = new JMenu("file");
        fileMenu.setBackground(Color.black);
        fileMenu.setForeground(Color.black);
//fileMenu.setIcon(image);
        home = new JMenuItem("home");
        home.addActionListener(this);

        exitItem = new JMenuItem("exit");
        exitItem.addActionListener(this);

        saveItem = new JMenuItem("save");
        saveItem.addActionListener(this);

        fileMenu.add(home);
        fileMenu.add(exitItem);
        fileMenu.add(saveItem);
        menuBar.add(fileMenu);
//--------/menubar-------

//        frame.add(backg);
        frame.setJMenuBar(menuBar);
        frame.setTitle("text editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame .setSize(1000,700);
//        this.add(textArea);
//        this.add(pane);

        frame.add(fontlabel);
        frame.add(fontsizespinner);
        frame.add(fontColorButton);
        frame.add(backgroundcolor);
        frame.add(fontbox);
        frame.add(title);
        frame.add(scrollPane);
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
         frame.getContentPane().setBackground(Color.LIGHT_GRAY);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==fontColorButton){
            JColorChooser colorChooser = new JColorChooser();
            Color color = colorChooser.showDialog(null,"choose a color",Color.BLACK);
//            textArea.setBackground(color);
            textArea.setForeground(color);


        }
        if(e.getSource()==backgroundcolor){
            JColorChooser colorChooser = new JColorChooser();
            Color back = colorChooser.showDialog(null,"choose a color",Color.BLACK);
//            textArea.setBackground(back);
            frame.getContentPane().setBackground(back);
//            textArea.setForeground(color);
        }
        if(e.getSource() == fontbox){
            textArea.setFont(new Font((String)fontbox.getSelectedItem(),Font.PLAIN,textArea.getFont().getSize()));
        }
        if(e.getSource()== saveItem){

            fontlabel.setVisible(false);
            fontsizespinner.setVisible(false);
            backgroundcolor.setVisible(false);
            fontlabel.setVisible(false);
            fontbox.setVisible(false);
            fontColorButton.setVisible(false);
            fileMenu.setVisible(false);
            scrollPane.setVisible(false);
            frame.add(textArea);
            print(frame);




//            JFileChooser fileChooser = new JFileChooser();
////fileChooser.setCurrentDirectory(new File("."));
//            int response = fileChooser.showSaveDialog(null);
//            if (response == JFileChooser.APPROVE_OPTION) {
//                File file;
//                PrintWriter fileout = null;
//                file = new File(String.valueOf(fileChooser.getSelectedFile().getAbsoluteFile()));
//                try{
//                    fileout = new PrintWriter(file);
//                    fileout.println(textArea.getText());
//                } catch (FileNotFoundException ex) {
//                    ex.printStackTrace();
//                }
//                finally {
//                    fileout.close();
//                }
//            }
        }

        if(e.getSource()==home){
new home();
frame.setVisible(false);
        }
        if(e.getSource()==exitItem){
            System.exit(0);
        }

    }

//    public static void main(String[] args) {
//        new jhhh();
//    }






}

