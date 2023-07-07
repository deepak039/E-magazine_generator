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

 public class source implements ActionListener {
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
    JPanel panel;

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

    void print(JPanel panel) {
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
                panel.paint(g2);
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


    source(){
//pane= new JTextPane();
//pane.setSize(300,300
//);
        frame = new JFrame();
        fontlabel = new JLabel("font");

        panel = new JPanel();

        panel.add(fontlabel);
       panel.add(fontsizespinner);
        panel.add(backgroundcolor);
        panel.add(fontbox);
        panel.add(fontColorButton);




        textArea = new TextareaPlus();

        textArea.setPreferredSize(new Dimension(700,700));

        textArea.setFont(new Font("Arial", Font.PLAIN,20));






        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(740,550));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        fontsizespinner = new JSpinner();
        fontsizespinner.setPreferredSize(new Dimension(50,25));
        fontsizespinner.setValue(20);
        fontsizespinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                textArea.setFont(new Font(textArea.getFont().getFamily(),Font.PLAIN,(int)fontsizespinner.getValue()));

            }
        });
        fontColorButton = new JButton("Color");
        fontColorButton.addActionListener(this);

        backgroundcolor = new JButton("background");
        backgroundcolor.addActionListener(this);


        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fontbox = new JComboBox (fonts);
        fontbox.addActionListener(this);

        //--------menubar-------

        menuBar = new JMenuBar();
        fileMenu = new JMenu("file");
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
        frame .setSize(1000,800);
//        this.add(textArea);
//        this.add(pane);
        frame.add(panel);

//        frame.add(fontlabel);
//        frame.add(fontsizespinner);
//        frame.add(fontColorButton);
//        frame.add(backgroundcolor);
//        frame.add(fontbox);
        frame.add(scrollPane);
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
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
            print(panel);




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

    public static void main(String[] args) {
        new source();
    }






}

