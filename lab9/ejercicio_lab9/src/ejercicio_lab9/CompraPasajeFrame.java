package ejercicio_lab9;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class CompraPasajeFrame extends JFrame {

    // Etiquetas
    private final JLabel etiquetaNombre;
    private final JLabel etiquetaDocumento;
    private final JLabel etiquetaFecha;
    private final JLabel etiquetaOrigen;
    private final JLabel etiquetaDestino;
    private final JLabel etiquetaPiso;
    private final JLabel etiquetaServicios;
    private final JLabel etiquetaCalidad;

    // Campos de texto
    private final JTextField campoNombre;
    private final JTextField campoDocumento;
    private final JTextField campoFecha;

    // Casillas de verificación
    private final JCheckBox casillaAudifonos;
    private final JCheckBox casillaManta;
    private final JCheckBox casillaRevistas;

    // Botones de opción
    private final JRadioButton opcionPrimerPiso;
    private final JRadioButton opcionSegundoPiso;
    private final ButtonGroup grupoPisos;

    // Cuadros combinados
    private final JComboBox<String> comboOrigen;
    private final JComboBox<String> comboDestino;

    // Lista
    private final JList<String> listaCalidad;

    // Botones de comando
    private final JButton botonMostrar;
    private final JButton botonLimpiar;

    private static final String[] CIUDADES = {
        "Arequipa", "Lima", "Cusco", "Tacna", "Puno", "Moquegua", "Ica"
    };
    private static final String[] CALIDADES = {"Economico", "Standard", "VIP"};
    private static final DateTimeFormatter FORMATO_FECHA
            = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);

    public CompraPasajeFrame() {
        super("Compra de Pasajes - Transporte Terrestre");
        setLayout(new BorderLayout(10, 10));

        // ---------- Panel de datos del pasajero ----------
        JPanel panelDatos = new JPanel(new GridLayout(8, 2, 8, 8));
        panelDatos.setBorder(BorderFactory.createTitledBorder("Datos del pasajero"));

        etiquetaNombre = new JLabel("Nombres y apellidos:");
        campoNombre = new JTextField(20);
        etiquetaDocumento = new JLabel("Documento de identidad:");
        campoDocumento = new JTextField(20);
        etiquetaFecha = new JLabel("Fecha de viaje (dd/mm/aaaa):");
        campoFecha = new JTextField(20);

        etiquetaOrigen = new JLabel("Origen:");
        comboOrigen = new JComboBox<>(CIUDADES);
        etiquetaDestino = new JLabel("Destino:");
        comboDestino = new JComboBox<>(CIUDADES);
        comboDestino.setSelectedIndex(1);

        etiquetaPiso = new JLabel("Piso:");
        opcionPrimerPiso = new JRadioButton("1er piso", true);
        opcionSegundoPiso = new JRadioButton("2do piso");
        grupoPisos = new ButtonGroup();
        grupoPisos.add(opcionPrimerPiso);
        grupoPisos.add(opcionSegundoPiso);
        JPanel panelPisos = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelPisos.add(opcionPrimerPiso);
        panelPisos.add(opcionSegundoPiso);

        etiquetaServicios = new JLabel("Servicios opcionales:");
        casillaAudifonos = new JCheckBox("Audifonos");
        casillaManta = new JCheckBox("Manta");
        casillaRevistas = new JCheckBox("Revistas");
        JPanel panelServicios = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelServicios.add(casillaAudifonos);
        panelServicios.add(casillaManta);
        panelServicios.add(casillaRevistas);

        panelDatos.add(etiquetaNombre);
        panelDatos.add(campoNombre);
        panelDatos.add(etiquetaDocumento);
        panelDatos.add(campoDocumento);
        panelDatos.add(etiquetaFecha);
        panelDatos.add(campoFecha);
        panelDatos.add(etiquetaOrigen);
        panelDatos.add(comboOrigen);
        panelDatos.add(etiquetaDestino);
        panelDatos.add(comboDestino);
        panelDatos.add(etiquetaPiso);
        panelDatos.add(panelPisos);
        panelDatos.add(etiquetaServicios);
        panelDatos.add(panelServicios);

        // Lista de calidad de servicio (dentro de la misma rejilla)
        etiquetaCalidad = new JLabel("Calidad de servicio:");
        listaCalidad = new JList<>(CALIDADES);
        listaCalidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaCalidad.setVisibleRowCount(3);
        listaCalidad.setSelectedIndex(0);
        panelDatos.add(etiquetaCalidad);
        panelDatos.add(new JScrollPane(listaCalidad));

        add(panelDatos, BorderLayout.CENTER);

        // ---------- Panel de botones ----------
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        botonMostrar = new JButton("Mostrar resumen");
        botonLimpiar = new JButton("Limpiar");
        panelBotones.add(botonMostrar);
        panelBotones.add(botonLimpiar);
        add(panelBotones, BorderLayout.SOUTH);

        // ---------- Registro de manejadores de eventos ----------
        ManejadorBotones manejador = new ManejadorBotones();
        botonMostrar.addActionListener(manejador);
        botonLimpiar.addActionListener(manejador);
    }

    // Reinicia todos los componentes
    private void limpiarFormulario() {
        campoNombre.setText("");
        campoDocumento.setText("");
        campoFecha.setText("");
        comboOrigen.setSelectedIndex(0);
        comboDestino.setSelectedIndex(1);
        opcionPrimerPiso.setSelected(true);
        casillaAudifonos.setSelected(false);
        casillaManta.setSelected(false);
        casillaRevistas.setSelected(false);
        listaCalidad.setSelectedIndex(0);
        campoNombre.requestFocus();
    }

    // Construye el resumen y lo muestra en un cuadro de dialogo
    private void mostrarResumen() {
        String nombre = campoNombre.getText().trim();
        String documento = campoDocumento.getText().trim();
        String fecha = campoFecha.getText().trim();

        // ---------- Validaciones ----------
        if (nombre.isEmpty() || documento.isEmpty() || fecha.isEmpty()) {
            mostrarError("Complete nombre, documento y fecha de viaje.", campoNombre);
            return;
        }
        if (!nombre.matches("[\\p{L} ]{3,}")) {
            mostrarError("El nombre solo debe tener letras y espacios (minimo 3 caracteres).",
                    campoNombre);
            return;
        }
        if (!documento.matches("\\d{8}")) {
            mostrarError("El documento de identidad (DNI) debe tener exactamente 8 digitos.",
                    campoDocumento);
            return;
        }
        LocalDate fechaViaje;
        try {
            fechaViaje = LocalDate.parse(fecha, FORMATO_FECHA);
        } catch (DateTimeParseException e) {
            mostrarError("Fecha no valida. Use el formato dd/mm/aaaa (ejemplo: 25/12/2026).",
                    campoFecha);
            return;
        }
        if (fechaViaje.isBefore(LocalDate.now())) {
            mostrarError("La fecha de viaje no puede ser anterior a hoy.", campoFecha);
            return;
        }
        if (listaCalidad.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione una calidad de servicio.",
                    "Dato invalido", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String origen = (String) comboOrigen.getSelectedItem();
        String destino = (String) comboDestino.getSelectedItem();
        if (origen.equals(destino)) {
            JOptionPane.showMessageDialog(this,
                    "El origen y el destino no pueden ser iguales.",
                    "Ruta invalida", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String piso = opcionPrimerPiso.isSelected() ? "1er piso" : "2do piso";

        StringBuilder servicios = new StringBuilder();
        if (casillaAudifonos.isSelected()) {
            servicios.append("Audifonos ");
        }
        if (casillaManta.isSelected()) {
            servicios.append("Manta ");
        }
        if (casillaRevistas.isSelected()) {
            servicios.append("Revistas ");
        }
        if (servicios.length() == 0) {
            servicios.append("Ninguno");
        }

        String calidad = listaCalidad.getSelectedValue();

        String resumen = String.format(
                "RESUMEN DEL PASAJE%n%n"
                + "Pasajero: %s%n"
                + "Documento: %s%n"
                + "Fecha de viaje: %s%n"
                + "Origen: %s%n"
                + "Destino: %s%n"
                + "Piso: %s%n"
                + "Servicios: %s%n"
                + "Calidad de servicio: %s",
                nombre, documento, fecha, origen, destino, piso,
                servicios.toString().trim(), calidad);

        JOptionPane.showMessageDialog(this, resumen,
                "Resumen de compra", JOptionPane.INFORMATION_MESSAGE);
    }

    // Muestra un mensaje de error y deja el cursor en el campo con problemas
    private void mostrarError(String mensaje, JTextField campo) {
        JOptionPane.showMessageDialog(this, mensaje,
                "Dato invalido", JOptionPane.ERROR_MESSAGE);
        campo.requestFocus();
        campo.selectAll();
    }

    // Clase interna para manejar los eventos de los botones
    private class ManejadorBotones implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            if (evento.getSource() == botonMostrar) {
                mostrarResumen();
            } else if (evento.getSource() == botonLimpiar) {
                limpiarFormulario();
            }
        }
    }
}