package classes;

import java.awt.*;

public class Circle extends Shape{
    public Circle(int xPosition, int yPosition, int width, int height, Color color, int xSpeed, int ySpeed) {
        super(xPosition, yPosition, width, height, color,xSpeed,ySpeed);
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getX(), getY(), getWidth(), getHeight());
    }
}
