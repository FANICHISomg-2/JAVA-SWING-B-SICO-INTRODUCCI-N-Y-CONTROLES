// DemoFlowLayout.java
// Prueba MarcoFlowLayout.
import javax.swing.JFrame;

public class DemoFlowLayout
{
    public static void main(String[] args)
    {
        MarcoFlowLayout marcoFlowLayout = new MarcoFlowLayout();
        marcoFlowLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoFlowLayout.setSize(420, 100); // MODIFICADO: mas ancho para que se lea el titulo completo
        marcoFlowLayout.setVisible(true);
    }
} // fin de la clase DemoFlowLayout
