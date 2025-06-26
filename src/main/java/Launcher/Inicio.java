package Launcher;

import javax.swing.*;
import GUI.Loginview;

public class Inicio {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Loginview login = new Loginview();
            login.setVisible(true);
        });
    }
}
