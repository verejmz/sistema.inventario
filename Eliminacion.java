package sistema.inventarios;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Eliminacion {

    private static final ArrayList<Producto> inventario = new ArrayList<>();

    public static void mostrarFormularioEliminar() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Eliminar Producto");
        dialog.setSize(300, 200);
        dialog.setModal(true);
        dialog.setLayout(new BorderLayout());

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Producto p : inventario) {
            listModel.addElement(p.getNombre() + " - " + p.getTipo());
        }
        JList<String> productList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(productList);

        JButton btnEliminar = new JButton("Eliminar");
        JButton btnCancelar = new JButton("Cancelar");

        btnEliminar.addActionListener(e -> {
            int selectedIndex = productList.getSelectedIndex();
            if (selectedIndex != -1) {
                inventario.remove(selectedIndex);
                JOptionPane.showMessageDialog(dialog, "Producto eliminado exitosamente.");
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog, "Seleccione un producto para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnCancelar.addActionListener(e -> dialog.dispose());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnEliminar);
        buttonPanel.add(btnCancelar);

        dialog.add(scrollPane, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }
}