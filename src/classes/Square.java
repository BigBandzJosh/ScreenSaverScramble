package classes;

import java.awt.*;

public class Square extends Shape{
    public Square(int xPosition, int yPosition, int width, int height, Color color, int xSpeed, int ySpeed) {
        super(xPosition, yPosition, width, height, color, xSpeed, ySpeed);
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }
}
