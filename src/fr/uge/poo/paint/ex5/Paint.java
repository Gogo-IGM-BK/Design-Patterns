package fr.uge.poo.paint.ex5;

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

        Shapes  shape = Collections.min(shapes, Comparator.comparingInt(s -> s.distance(x,y)));
        area.clear(Color.WHITE);
        area.render(graphics2D -> shapes.forEach(shapes1 -> shapes1.draw(graphics2D, Color.BLACK)));
        area.render(graphics2D -> shape.draw(graphics2D, Color.ORANGE));
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(args[0]);
        ArrayList<Shapes> shapes = Pars.methode(path);
        SimpleGraphics area = new SimpleGraphics("area", 800, 600);
        area.clear(Color.WHITE);

        area.render(graphics2D -> shapes.forEach(shape -> shape.draw(graphics2D, Color.BLACK)));

        area.waitForMouseEvents((x, y) -> mousseCallback(x,y, shapes,area));


    }

}
