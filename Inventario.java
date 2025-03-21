package sistema.inventarios;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Inventario {

    private static final ArrayList<Producto> inventario = new ArrayList<>();

    public static void mostrarInventario() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Inventario de Productos");
        dialog.setSize(500, 300);
        dialog.setModal(true);
        dialog.setLayout(new BorderLayout());

        String[] columnNames = {"Tipo", "Nombre", "Precio"};
        Object[][] data = new Object[inventario.size()][3];
        for (int i = 0; i < inventario.size(); i++) {
            Producto p = inventario.get(i);
            data[i][0] = p.getTipo();
            data[i][1] = p.getNombre();
            data[i][2] = p.getPrecio();
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        dialog.add(scrollPane, BorderLayout.CENTER);
        dialog.setVisible(true);
    }
}
