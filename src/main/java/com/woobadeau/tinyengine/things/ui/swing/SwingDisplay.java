package com.woobadeau.tinyengine.things.ui.swing;

import com.woobadeau.tinyengine.TinyEngine;
import com.woobadeau.tinyengine.things.ui.Shape;
import com.woobadeau.tinyengine.things.ThingMouseClickListener;
import com.woobadeau.tinyengine.things.physics.Vector2D;
import com.woobadeau.tinyengine.things.ui.Display;
import com.woobadeau.tinyengine.things.ui.UIInterfaceProvider;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SwingDisplay extends JPanel implements Display, MouseListener {
    public static BufferedImage screen;
    private int width;
    private int height;
    private Graphics2D graphics;

    public SwingDisplay(int width, int height) {
        this.width = width;
        this.height = height;
        screen = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
        graphics = screen.createGraphics();

        this.addMouseListener(this);
        setOpaque(false);
        initDisplay(width, height);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(screen.getWidth(), screen.getHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        int x = (getWidth() - screen.getWidth()) / 2;
        int y = (getHeight() - screen.getHeight()) / 2;
        g2d.drawImage(screen, x, y, this);
        g2d.dispose();
        screen = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
        graphics = screen.createGraphics();
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        //propagate(ThingMouseClickListener::onClick);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        TinyEngine.mouseDown = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        TinyEngine.mouseDown = false;
        TinyEngine.propagate(ThingMouseClickListener.class, ThingMouseClickListener::onClick);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void drawImage(Image image, int x, int y, Display display) {
        graphics.drawImage(image, x, y, null, this);
    }

    @Override
    public void setColor(Object color) {
        graphics.setColor((Color) color);

    }

    @Override
    public void draw(Shape shape) {

    }

    @Override
    public Object getGreen() {
        return Color.GREEN;
    }

    @Override
    public void setFont(Object font) {
        screen.getGraphics().setFont((Font) font);
    }

    @Override
    public void drawString(String string, int x, int y) {
        screen.getGraphics().drawString(string, x, y);
    }

    @Override
    public void drawHalo(int red, int green, int blue, int x, int y, int currentSize) {

        Color colors[] = {new Color(red, green, blue, 150),
                new Color(red, green, blue, 100),
                new Color(red, green, blue, 25),
                new Color(red, green, blue, 0),
        };
        float fractions[] = {0.0f, 0.2f, 0.6f, 1.0f};

        RadialGradientPaint paint =
                new RadialGradientPaint(new Point(x, y), currentSize, fractions, colors);
        graphics.setPaint(paint);

        graphics.fill(new Rectangle(this.width, this.height));
    }

    @Override
    public Object getRed() {
        return Color.RED;
    }

    @Override
    public void drawOval(int x, int y, int i, int i1) {
        graphics.drawOval(x, y, i, i1);
    }

    @Override
    public void addKeyBinding(String key, Runnable action) {
        this.getInputMap().put(KeyStroke.getKeyStroke(key), key);
        this.getActionMap().put(key, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                action.run();
            }
        });
    }

    @Override
    public Vector2D getMousePositionVector() {
        Point mousePosition = getMousePosition();
        if (mousePosition != null) {
            return new Vector2D(mousePosition.x, mousePosition.y);
        }
        return null;
    }

    private static Logger logger = Logger.getLogger(UIInterfaceProvider.class.getName());

    private void initDisplay(int width, int height) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                logger.log(Level.SEVERE, "Error", ex);
            }

            JFrame frame = new JFrame("Testing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.add(this);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

}