package fr.uge.poo.paint.ex6;

import java.awt.*;

public interface Shapes {
    public void draw(Graphics2D graphics, Color color);
    public int distance( int x, int y);
    public Point max();
}
