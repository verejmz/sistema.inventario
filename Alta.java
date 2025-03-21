package sistema.inventarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Alta {

    private static final ArrayList<Producto> inventario = new ArrayList<>();

    public static void mostrarFormularioAlta(String tipo) {
        JDialog dialog = new JDialog();
        dialog.setTitle("Alta de " + tipo);
        dialog.setSize(300, 200);
        dialog.setModal(true);
        dialog.setLayout(new GridLayout(4, 2));

        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();
        JLabel lblPrecio = new JLabel("Precio:");
        JTextField txtPrecio = new JTextField();
        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");

        btnGuardar.addActionListener(e -> {
            try {
                String nombre = txtNombre.getText();
                double precio = Double.parseDouble(txtPrecio.getText());
                inventario.add(new Producto(tipo, nombre, precio));
                JOptionPane.showMessageDialog(dialog, "Producto guardado exitosamente.");
                dialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Ingrese un precio válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnCancelar.addActionListener(e -> dialog.dispose());

        dialog.add(lblNombre);
        dialog.add(txtNombre);
        dialog.add(lblPrecio);
        dialog.add(txtPrecio);
        dialog.add(btnGuardar);
        dialog.add(btnCancelar);

        dialog.setVisible(true);
    }
}
