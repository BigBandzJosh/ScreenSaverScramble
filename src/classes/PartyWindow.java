package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PartyWindow extends ProgramWindow {
    private final ArrayList<Shape> shapes = new ArrayList<>();
    private BufferedImage buffer;
    public PartyWindow() {
        super();
        this.addComponentListener(this);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int x = e.getX();
                int y = e.getY();
                int width = 100;
                int height = 100;
                int xSpeed = 10;
                int ySpeed = 10;
                Color color = new Color((int) (Math.random() * 0x1000000));
                int shapeType = (int) (Math.random() * 4);
                Shape shape;

                switch (shapeType) {
                    case 0 -> {
                        shape = new Circle(x, y, width, height, color, xSpeed, ySpeed);
                        shapes.add(shape);
                    }
                    case 1 -> {
                        shape = new Square(x, y, width, height, color, xSpeed, ySpeed);
                        shapes.add(shape);
                    }
                    case 2 -> {
                        shape = new Star(x, y, width, height, color, xSpeed, ySpeed);
                        shapes.add(shape);
                    }
                    case 3 -> {
                        shape = new Triangle(x, y, width, height, color, xSpeed, ySpeed);
                        shapes.add(shape);
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + shapeType);
                }
                repaint();
            }
        });
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Timer timer = new Timer(16, e -> {
            for (Shape shape : shapes) {
                shape.move(shapes, getWidth(), getHeight());
            }
            repaint();
        });
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        int windowWidth = getWidth();
        int windowHeight = getHeight();
        Graphics bufferGraphics = buffer.getGraphics();
          bufferGraphics.setColor(Color.WHITE);
        bufferGraphics.fillRect(0, 0, getWidth(), getHeight());
        for (Shape shape : shapes) {
            int x = shape.getX();
            int y = shape.getY();
            int width = shape.getWidth();
            int height = shape.getHeight();
            if (x + width >= windowWidth) {
                shape.setxSpeed(-shape.getxSpeed());
            }
            if (y + height >= windowHeight) {
                shape.setySpeed(-shape.getySpeed());
            }
            shape.draw(bufferGraphics);
        }

        g.drawImage(buffer, 0, 0, null);

    }
    @Override
    public void componentResized(ComponentEvent e) {
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);

    }
    @Override
    public void componentMoved(ComponentEvent e) {

    }
    @Override
    public void componentShown(ComponentEvent e) {

    }
    @Override
    public void componentHidden(ComponentEvent e) {

    }
}