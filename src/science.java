import javax.swing.*;

public class science extends template {
    science(){
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("science.png"));
        textArea.setImage(icon);
    }

    public static void main(String[] args) {
        new science();
    }
}
