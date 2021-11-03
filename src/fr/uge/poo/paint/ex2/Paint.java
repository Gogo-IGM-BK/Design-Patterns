package fr.uge.poo.paint.ex2;

import fr.uge.poo.simplegraphics.SimpleGraphics;
import fr.uge.poo.simplegraphics.SimpleGraphicsExample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import java.awt.Color;
import java.awt.Graphics2D;

public class Paint {

    public static void drawLine(ArrayList<Line> lines , Graphics2D graphics){
        graphics.setColor(Color.BLACK);
        lines.forEach(line -> graphics.drawLine(line.x1, line.y1, line.x2, line.y2));

    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(args[0]);
        ArrayList<Line> lines = new ArrayList<Line>();
        SimpleGraphics area = new SimpleGraphics("area", 800, 600);
        area.clear(Color.WHITE);

        try(Stream<String> linest = Files.lines(path)) {
            linest.forEach(line -> {
                String[] tokens = line.split(" ");
                switch (tokens[0]){
                    case "line":
                        lines.add(new Line(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4])));
                        break;
                }
            });
            area.render(graphics2D -> drawLine(lines, graphics2D));
        }

    }

}
