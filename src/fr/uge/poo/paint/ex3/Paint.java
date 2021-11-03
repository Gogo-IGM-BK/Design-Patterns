package fr.uge.poo.paint.ex3;

import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Paint {


    public static void main(String[] args) throws IOException {
        Path path = Paths.get(args[0]);
        ArrayList<Shapes> shapes = new ArrayList<Shapes>();
        SimpleGraphics area = new SimpleGraphics("area", 800, 600);
        area.clear(Color.WHITE);

        try(Stream<String> linest = Files.lines(path)) {
            linest.forEach(line -> {
                String[] tokens = line.split(" ");
                switch (tokens[0]){
                    case "line":
                        shapes.add(new Line(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4])));
                        break;
                    case "rectangle":
                        shapes.add(new Rectangle(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4])));
                        break;
                    case "ellipse":
                        shapes.add(new Ellipse(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4])));
                        break;
                }
            });
            area.render(graphics2D -> shapes.forEach(shape -> shape.draw(graphics2D)));
        }

    }

}
