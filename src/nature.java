import javax.swing.*;

public class nature extends template {
    nature(){
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("nature.png"));
        textArea.setImage(icon);
    }

//    public static void main(String[] args) {
//        new nature();
//    }
}