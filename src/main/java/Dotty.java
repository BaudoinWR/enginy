import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Dotty {
  private static Logger logger = Logger.getLogger(Dotty.class.getName());
  public static void main(String[] args) {
    System system = new System();
    new MovingDot(50,50,500,500);
    new MovingDot(50,50,500,500);
    new MovingDot(50,50,500,500);
    new MovingDot(50,50,500,500);
    new MovingDot(50,50,500,500);
    new MovingDot(50,50,500,500);
  }

  public Dotty() {
    EventQueue.invokeLater(() -> {
      try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        logger.log(Level.SEVERE, "Error", ex);
      }

      JFrame frame = new JFrame("Testing");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new BorderLayout());
      frame.add(new TestPane());
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
    });
  }

  public class TestPane extends JPanel {

    private int count = 0;
    private int dotCount = 1000;
    transient BufferedImage bckg;

    TestPane() {
      bckg = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);

      Timer timer;
      timer = new Timer(40, e -> {
        count++;
        if (count < dotCount) {
          int x = (int) Math.round((Math.random() * 600));
          int y = (int) Math.round((Math.random() * 600));
          Graphics2D g2d = bckg.createGraphics();
          g2d.setColor(Color.BLACK);
          g2d.drawRect(x, y, 1, 1);
          g2d.dispose();
          repaint();
        } else {
          ((Timer) e.getSource()).stop();
        }
      });
      timer.setRepeats(true);
      timer.setCoalesce(true);
      timer.start();
    }

    @Override
    public Dimension getPreferredSize() {
      return new Dimension(600, 600);
    }

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g.create();
      int x = (getWidth() - bckg.getWidth()) / 2;
      int y = (getHeight() - bckg.getHeight()) / 2;
      g2d.drawImage(bckg, x, y, this);
      g2d.dispose();
    }
  }
}