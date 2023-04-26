package classes;

import java.awt.*;

public class Star extends Shape{
    public Star(int xPosition, int yPosition, int width, int height, Color color, int xSpeed, int ySpeed) {
        super(xPosition, yPosition, width, height, color, xSpeed, ySpeed);
    }

    //This shape was incredibly hard to draw, Google was my best friend, my geometry is not great
    public void draw(Graphics g) {
        int x = getX();
        int y = getY();
        int width = getWidth();
        int outerRadius = width / 2;
        int innerRadius = width / 4;
        int numPoints = 5;

        int[] xPoints = new int[numPoints * 2];
        int[] yPoints = new int[numPoints * 2];

        for (int i = 0; i < numPoints * 2; i++) {
            double angle = i * Math.PI / numPoints - Math.PI / 2;
            int radius = (i % 2 == 0) ? outerRadius : innerRadius;
            xPoints[i] = (int) (x + radius * Math.cos(angle));
            yPoints[i] = (int) (y + radius * Math.sin(angle));
        }
        g.setColor(getColor());
        g.fillPolygon(xPoints, yPoints, numPoints * 2);
    }
}
