public class gitSaberBotHome extends JFrame {
    private static final Universidad[] UNIVERSIDADES = {
        new Universidad("Cesde", "Institución educativa privada en Colombia.", new Color(255, 153, 204)),
        new Universidad("UdeMedellín", "Universidad pública ubicada en Medellín.", new Color(255, 102, 102)),
        new Universidad("UdeCataluña", "Universidad privada con sede en España.", new Color(102, 153, 255)),
        new Universidad("UdeA", "Universidad pública de Antioquia.", new Color(0, 204, 102)),
        new Universidad("UdeNacional", "Universidad pública con presencia nacional.", new Color(255, 204, 0))
    };

    private final ArrayList<String> universidadesSeleccionadas = new ArrayList<>();

    public SaberBotHome() {
        configurarVentana();
        agregarComponentes();
    }

    private void configurarVentana() {
        setTitle("SaberBot");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void agregarComponentes() {
        add(crearEncabezado(), BorderLayout.NORTH);
        add(crearPanelCentral(), BorderLayout.CENTER);
        add(crearPanelBotones(), BorderLayout.SOUTH);
    }

    private JLabel crearEncabezado() {
        JLabel titulo = new JLabel("¡Hola Jaime!", SwingConstants.CENTER);
        titulo.setOpaque(true);
        titulo.setBackground(Color.BLACK);
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setPreferredSize(new Dimension(600, 40));
        return titulo;
    }

    private JPanel crearPanelCentral() {
        JPanel panel = new JPanel();
        JButton boton = new JButton("SaberBot");
        boton.setBackground(new Color(51, 51, 204));
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.setFocusPainted(false);
        boton.addActionListener(e -> mostrarSaludo());
        panel.add(boton);
        return panel;
    }

    private JPanel crearPanelBotones() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        for (Universidad universidad : UNIVERSIDADES) {
            JButton boton = new JButton(universidad.getNombre());
            boton.setFont(new Font("Arial", Font.BOLD, 14));
            boton.setForeground(Color.WHITE);
            boton.setBackground(universidad.getColor());
            boton.addActionListener(e -> mostrarInformacionUniversidad(universidad));
            panel.add(boton);
        }
        return panel;
    }

    private void mostrarSaludo() {
        JOptionPane.showMessageDialog(this, "¡Hola! Soy SaberBot, ¿en qué puedo ayudarte?");
    }

    private void mostrarInformacionUniversidad(Universidad universidad) {
        JOptionPane.showMessageDialog(this, "Bienvenido a " + universidad.getNombre() + "\n" + universidad.getDescripcion());
        if (!universidadesSeleccionadas.contains(universidad.getNombre())) {
            universidadesSeleccionadas.add(universidad.getNombre());
            mostrarUniversidadesSeleccionadas();
        }
    }

    private void mostrarUniversidadesSeleccionadas() {
        StringBuilder mensaje = new StringBuilder("Universidades seleccionadas:\n");
        universidadesSeleccionadas.forEach(nombre -> mensaje.append("- ").append(nombre).append("\n"));
        JOptionPane.showMessageDialog(this, mensaje.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SaberBotHome().setVisible(true));
    }
}

class Universidad {
    private final String nombre;
    private final String descripcion;
    private final Color color;

    public Universidad(String nombre, String descripcion, Color color) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Color getColor() {
        return color;
    }
}