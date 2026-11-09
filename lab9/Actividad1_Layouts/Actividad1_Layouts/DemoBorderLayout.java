// DemoBorderLayout.java
// Prueba de MarcoBorderLayout.
import javax.swing.JFrame;

public class DemoBorderLayout
{
    public static void main(String[] args)
    {
        MarcoBorderLayout marcoBorderLayout = new MarcoBorderLayout();
        marcoBorderLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoBorderLayout.setSize(420, 200); // MODIFICADO: mas ancho para que se lea el titulo completo
        marcoBorderLayout.setVisible(true);
    }
} // fin de la clase DemoBorderLayout
