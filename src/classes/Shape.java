package classes;

import java.awt.*;
import java.util.ArrayList;

public abstract class Shape {
    private int xPosition;
    private int yPosition;
    private int width;
    private int height;
    private Color color;
    private int xSpeed;
    private int ySpeed;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int score;

    public Shape(int xPosition, int yPosition, int width, int height, Color color, int xSpeed, int ySpeed) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        this.color = color;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public int getxPosition() {
        return xPosition;
    }
    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public int getX() {
        return xPosition;
    }

    public void setX(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getY() {
        return yPosition;
    }

    public void setY(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    // I feel like collision detection should be its own method.
    public void move(ArrayList<Shape> shape, int windowWidth, int windowHeight) {

       int newX = getxPosition() + xSpeed;
       int newY = getyPosition() + ySpeed;
       Color newColor = new Color((int) (Math.random() * 0x1000000));
       int newHeight = (int) (Math.random() * 100);
         int newWidth = (int) (Math.random() * 100);

         // left edge
        if (newX < 0 || newX > windowWidth - getWidth()) {
            setxSpeed(-getxSpeed());
        }
        // top edge
        if (newY < 0 || newY > windowHeight - getHeight()) {
            setySpeed(-getySpeed());
        }
        // right edge
        if (newX > windowWidth - getWidth()) {
            setxSpeed(-getxSpeed());
        }
        // bottom edge
        if (newY > windowHeight - getHeight()) {
            setySpeed(-getySpeed());
        }
        // collision detection between shapes
        for (Shape shapes : shape) {
            if (shapes != this) {
                if (newX < shapes.getX() + shapes.getWidth() && newX + getWidth() > shapes.getX() &&
                    newY < shapes.getY() + shapes.getHeight() && newY + getHeight() > shapes.getY()) {
                    setxSpeed(-getxSpeed());
                    setySpeed(-getySpeed());
                    setColor(newColor);
                    setHeight(newHeight);
                    setWidth(newWidth);
                }
            }
        }
        setX(newX);
        setY(newY);
    }
    // an abstract method that will be implemented in the subclasses
    public abstract void draw(Graphics g);

}
