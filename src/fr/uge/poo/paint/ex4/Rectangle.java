package fr.uge.poo.paint.ex4;

import java.awt.*;

public class Rectangle implements Shapes {

    public int x;
    public int y;
    public int width;
    public int height;

    public Rectangle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }



    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.BLACK);
        graphics.drawRect(x, y, width, height);
    }

    @Override
    public int distance( int x1, int y1) {
        var middle_x = x + (width / 2);
        var middle_y = y + (height / 2);
        return (x1 - middle_x) * (x1 - middle_x) + (y1 - middle_y) * (y1 - middle_y);
    }
}
