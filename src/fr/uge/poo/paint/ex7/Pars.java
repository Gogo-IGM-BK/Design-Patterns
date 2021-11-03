package fr.uge.poo.paint.ex7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Pars {


    public static ArrayList<Shapes> methode (Path path) throws IOException {
        ArrayList<Shapes> shapes = new ArrayList<Shapes>();
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

        }
        return shapes;
    }




}
