package fr.uge.poo.paint.ex6;

import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Paint {

    public static void mousseCallback(int x , int y, ArrayList<Shapes> shapes, SimpleGraphics area){
        if(shapes == null || shapes.isEmpty())
            return;

        Shapes shape = Collections.min(shapes, Comparator.comparingInt(s -> s.distance(x,y)));
        area.clear(Color.WHITE);
        area.render(graphics2D -> shapes.forEach(shapes1 -> shapes1.draw(graphics2D, Color.BLACK)));
        area.render(graphics2D -> shape.draw(graphics2D, Color.ORANGE));
    }

    public static Point maxShape(ArrayList<Shapes> shapes) {
        int x=500,y=500;
        if (shapes.size() ==0 ) {
            throw new IllegalAccessError("Don't have any shapes");
        }

        for(var s : shapes) {
            if(s.max().x()> x ) {
                x=s.max().x();
            }
            if (s.max().y() > y) {
                y=s.max().y();
            }
        }

        return new Point(x,y);
    }



    public static void main(String[] args) throws IOException {
        Path path = Paths.get(args[0]);
        ArrayList<Shapes> shapes = Pars.methode(path);
        Point window = maxShape(shapes);
        SimpleGraphics area = new SimpleGraphics("area", window.x(), window.y());
        area.clear(Color.WHITE);

       // Shapes shapo = Collections.max(shapes, Comparator.comparingInt(s -> s.distance(0,0)));
       // System.out.println(shapo);
       // System.out.println(maxShape(shapes));


        area.render(graphics2D -> shapes.forEach(shape -> shape.draw(graphics2D, Color.BLACK)));

        area.waitForMouseEvents((x, y) -> mousseCallback(x,y, shapes,area));


    }

}
