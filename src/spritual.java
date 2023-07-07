import javax.swing.*;

public class spritual extends template {
    ImageIcon icon;
    spritual(){
         icon = new ImageIcon(getClass().getClassLoader().getResource("spritual.png"));
        textArea.setImage(icon);
    }

    public static void main(String[] args) {
        new spritual();
    }
}

