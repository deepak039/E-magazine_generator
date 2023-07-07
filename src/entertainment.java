import javax.swing.*;

public class entertainment extends template {
    entertainment(){
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("entertainment.png"));
        textArea.setImage(icon);
    }

//    public static void main(String[] args) {
//        new entertainment();
//    }
}