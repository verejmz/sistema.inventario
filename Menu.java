package sistema.inventarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {

    public static void menuOnline() {
        JFrame frame = new JFrame("Menú Principal - Sistema de Inventarios");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();

        JMenu menuElectronicos = new JMenu("Gestión de Electrónicos");
        JMenuItem altaElectronico = new JMenuItem("Alta");
        JMenuItem eliminarElectronico = new JMenuItem("Eliminar");
        JMenuItem modificarElectronico = new JMenuItem("Modificar");
        JMenuItem inventarioElectronico = new JMenuItem("Inventario");
        menuElectronicos.add(altaElectronico);
        menuElectronicos.add(eliminarElectronico);
        menuElectronicos.add(modificarElectronico);
        menuElectronicos.add(inventarioElectronico);

        JMenu menuAlimentos = new JMenu("Gestión de Alimentos");
        JMenuItem altaAlimento = new JMenuItem("Alta");
        JMenuItem eliminarAlimento = new JMenuItem("Eliminar");
        JMenuItem modificarAlimento = new JMenuItem("Modificar");
        JMenuItem inventarioAlimento = new JMenuItem("Inventario");
        menuAlimentos.add(altaAlimento);
        menuAlimentos.add(eliminarAlimento);
        menuAlimentos.add(modificarAlimento);
        menuAlimentos.add(inventarioAlimento);

        JMenu menuRopa = new JMenu("Gestión de Ropa");
        JMenuItem altaRopa = new JMenuItem("Alta");
        JMenuItem eliminarRopa = new JMenuItem("Eliminar");
        JMenuItem modificarRopa = new JMenuItem("Modificar");
        JMenuItem inventarioRopa = new JMenuItem("Inventario");
        menuRopa.add(altaRopa);
        menuRopa.add(eliminarRopa);
        menuRopa.add(modificarRopa);
        menuRopa.add(inventarioRopa);

        JMenu menuInventario = new JMenu("Inventario General");
        JMenuItem mostrarInventario = new JMenuItem("Mostrar");
        menuInventario.add(mostrarInventario);

        JMenu menuSalir = new JMenu("Salir");
        JMenuItem salir = new JMenuItem("Cerrar Aplicación");
        menuSalir.add(salir);

        menuBar.add(menuElectronicos);
        menuBar.add(menuAlimentos);
        menuBar.add(menuRopa);
        menuBar.add(menuInventario);
        menuBar.add(menuSalir);

        altaElectronico.addActionListener(e -> Alta.mostrarFormularioAlta("Electrónico"));
        eliminarElectronico.addActionListener(e -> Eliminacion.mostrarFormularioEliminar());
        modificarElectronico.addActionListener(e -> Modificacion.mostrarFormularioModificar());
        inventarioElectronico.addActionListener(e -> Inventario.mostrarInventario());

        altaAlimento.addActionListener(e -> Alta.mostrarFormularioAlta("Alimento"));
        eliminarAlimento.addActionListener(e -> Eliminacion.mostrarFormularioEliminar());
        modificarAlimento.addActionListener(e -> Modificacion.mostrarFormularioModificar());
        inventarioAlimento.addActionListener(e -> Inventario.mostrarInventario());

        altaRopa.addActionListener(e -> Alta.mostrarFormularioAlta("Ropa"));
        eliminarRopa.addActionListener(e -> Eliminacion.mostrarFormularioEliminar());
        modificarRopa.addActionListener(e -> Modificacion.mostrarFormularioModificar());
        inventarioRopa.addActionListener(e -> Inventario.mostrarInventario());

        mostrarInventario.addActionListener(e -> Inventario.mostrarInventario());
        salir.addActionListener(e -> System.exit(0));

        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        menuOnline();
    }
}
