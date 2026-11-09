// DemoGridLayout.java
// Prueba de MarcoGridLayout.
import javax.swing.JFrame;

public class DemoGridLayout
{
    public static void main(String[] args)
    {
        MarcoGridLayout marcoGridLayout = new MarcoGridLayout();
        marcoGridLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoGridLayout.setSize(420, 200); // MODIFICADO: mas ancho para que se lea el titulo completo
        marcoGridLayout.setVisible(true);
    }
} // fin de la clase DemoGridLayout
