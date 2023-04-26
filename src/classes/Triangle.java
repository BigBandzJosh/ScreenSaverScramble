package classes;

import java.awt.*;

public class Triangle extends Shape{
    public Triangle(int xPosition, int yPosition, int width, int height, Color color, int xSpeed, int ySpeed) {
        super(xPosition, yPosition, width, height, color, xSpeed, ySpeed);
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillPolygon(new int[]{getX(), getX() + getWidth(), getX() + getWidth() / 2},
                new int[]{getY() + getHeight(), getY() + getHeight(), getY()}, 3);
    }
}
