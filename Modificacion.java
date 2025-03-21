package sistema.inventarios;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Modificacion {

    private static final ArrayList<Producto> inventario = new ArrayList<>();

    public static void mostrarFormularioModificar() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Modificar Producto");
        dialog.setSize(300, 250);
        dialog.setModal(true);
        dialog.setLayout(new BorderLayout());

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Producto p : inventario) {
            listModel.addElement(p.getNombre() + " - " + p.getTipo());
        }
        JList<String> productList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(productList);

        JPanel panel = new JPanel(new GridLayout(4, 2));
        JLabel lblNuevoNombre = new JLabel("Nuevo Nombre:");
        JTextField txtNuevoNombre = new JTextField();
        JLabel lblNuevoPrecio = new JLabel("Nuevo Precio:");
        JTextField txtNuevoPrecio = new JTextField();

        JButton btnModificar = new JButton("Modificar");
        JButton btnCancelar = new JButton("Cancelar");

        btnModificar.addActionListener(e -> {
            int selectedIndex = productList.getSelectedIndex();
            if (selectedIndex != -1) {
                try {
                    Producto producto = inventario.get(selectedIndex);
                    producto.setNombre(txtNuevoNombre.getText());
                    producto.setPrecio(Double.parseDouble(txtNuevoPrecio.getText()));
                    JOptionPane.showMessageDialog(dialog, "Producto modificado exitosamente.");
                    dialog.dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(dialog, "Ingrese un precio válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(dialog, "Seleccione un producto para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnCancelar.addActionListener(e -> dialog.dispose());

        panel.add(lblNuevoNombre);
        panel.add(txtNuevoNombre);
        panel.add(lblNuevoPrecio);
        panel.add(txtNuevoPrecio);
        panel.add(btnModificar);
        panel.add(btnCancelar);

        dialog.add(scrollPane, BorderLayout.NORTH);
        dialog.add(panel, BorderLayout.CENTER);
        dialog.setVisible(true);
    }
}
