import javax.swing.*;

public class poltical extends template {
    poltical(){
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("poltics.png"));
        textArea.setImage(icon);
    }

    public static void main(String[] args) {
        new poltical();
    }
}