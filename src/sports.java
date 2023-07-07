import javax.swing.*;

public class sports extends template {
    sports(){
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("sports.png"));
        textArea.setImage(icon);
    }

    public static void main(String[] args) {
        new sports();
    }
}
