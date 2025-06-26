package GUI;

import Modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainView extends JFrame {

    private final Usuario usuario;

    public MainView(Usuario usuario) {
        this.usuario = usuario;
        inicializar();
    }

    private void inicializar() {
        setTitle("Bienvenido");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel(new BorderLayout());
        JLabel bienvenida = new JLabel("Bienvenido, " + usuario.getNombre(), SwingConstants.CENTER);
        bienvenida.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(bienvenida, BorderLayout.CENTER);
        JPanel botones = new JPanel();
        JButton cerrarSesion = new JButton("Cerrar sesión");
        cerrarSesion.addActionListener(e -> {
            new Loginview().setVisible(true);
            dispose();
        });

        botones.add(cerrarSesion);
        panel.add(botones, BorderLayout.SOUTH);

        add(panel);
    }
}
