package charts;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
public class Sketcher implements WindowListener {
  static JFrame window = new JFrame("Sketcher");
  public Sketcher() {
    window.setBounds(30, 30, 300, 300);
    window.addWindowListener(this);
    window.setVisible(true);
  }
  public static void main(String[] args) {
    new Sketcher();
  }
  public void windowClosing(WindowEvent e) {
    System.out.println("closing");
    window.dispose();
    System.exit(0);
  }
  public void windowOpened(WindowEvent e) {
  }
  public void windowClosed(WindowEvent e) {
  }
  public void windowIconified(WindowEvent e) {
  }
  public void windowDeiconified(WindowEvent e) {
  }
  public void windowActivated(WindowEvent e) {
  }
  public void windowDeactivated(WindowEvent e) {
  }
}
