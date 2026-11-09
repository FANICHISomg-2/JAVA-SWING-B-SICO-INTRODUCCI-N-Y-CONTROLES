package ejercicio_lab9;
import javax.swing.JFrame;

public class App {

    public static void main(String[] args) {
        CompraPasajeFrame marco = new CompraPasajeFrame();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(520, 440);
        marco.setLocationRelativeTo(null);
        marco.setVisible(true);
    }
}