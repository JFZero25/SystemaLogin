package GUI;

import Controlador.Login;
import Modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Loginview extends JFrame {
    private final JTextField usuarioField = new JTextField(15);
    private final JPasswordField claveField = new JPasswordField(15);
    private final JButton botonLogin = new JButton("Iniciar sesión");

    public Loginview() {
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Usuario:"));
        panel.add(usuarioField);

        panel.add(new JLabel("Contraseña:"));
        panel.add(claveField);

        panel.add(new JLabel()); // espacio en blanco
        panel.add(botonLogin);

        botonLogin.addActionListener(e -> {
            try {
                autentificarUsuario();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al acceder a datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(panel);
    }

    private void autentificarUsuario() throws IOException {
        String usuario = usuarioField.getText();
        String clave = new String(claveField.getPassword());
        if (usuario.isEmpty() || clave.isEmpty()){
            JOptionPane.showMessageDialog(this,"Debe ingresar usuario y contraseña","Error",JOptionPane.ERROR_MESSAGE);
        }
        boolean valido = Login.autenticar(usuario, clave);
        if (valido) {
            Usuario user = new Usuario(usuario, clave); // puedes completar esto si lo necesitas
            new MainView(user).setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales inválidas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
