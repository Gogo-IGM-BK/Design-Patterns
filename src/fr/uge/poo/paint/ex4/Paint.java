package fr.uge.poo.paint.ex4;

import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

public class Paint {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(args[0]);
        ArrayList<Shapes> shapes = Pars.methode(path);
        SimpleGraphics area = new SimpleGraphics("area", 800, 600);
        area.clear(Color.WHITE);

        area.render(graphics2D -> shapes.forEach(shape -> shape.draw(graphics2D)));
        area.waitForMouseEvents((x, y) -> System.out.println(Collections.min(shapes, Comparator.comparingInt(s -> s.distance(x,y)))));
    }

}
