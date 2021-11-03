package fr.uge.poo.paint.ex3;

import java.awt.*;

public class Ellipse implements Shapes{
    public int x;
    public int y;
    public int width;
    public int height;

    public Ellipse(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.BLACK);
        graphics.drawOval(x, y, width, height);
    }
}
