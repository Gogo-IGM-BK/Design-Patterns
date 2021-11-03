package fr.uge.poo.paint.ex7;

import java.awt.*;

public interface Shapes {
    public void draw( Canvas canvas, SuperColor superColor);
    public int distance( int x, int y);
    public Point max();
}
