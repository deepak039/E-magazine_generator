import javax.swing.*;

public class space extends template {
    space(){
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("space.png"));
        textArea.setImage(icon);
    }

    public static void main(String[] args) {
        new space();
    }
}
