package fr.uge.poo.paint.ex4;

import java.awt.*;

public class Line implements Shapes {
    public int x1;
    public int y1;
    public int x2;
    public int y2;

    public Line(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }


    @Override
    public String toString() {
        return "Line{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                '}';
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.BLACK);
        graphics.drawLine(this.x1, this.y1, this.x2, this.y2);
    }

    @Override
    public int distance( int x, int y) {
        var middle_x = (x1 + x2) / 2;
        var middle_y = (y1 + y2) / 2;
        return (x - middle_x) * (x - middle_x) + (y - middle_y) * (y - middle_y);
    }
}
