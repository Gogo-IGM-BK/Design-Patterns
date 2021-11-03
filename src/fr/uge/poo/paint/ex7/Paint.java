package fr.uge.poo.paint.ex7;

import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;

public class Paint {
    public Optional<Shapes> optionalShapes = Optional.empty();

    /* public static void mousseCallback(int x , int y, ArrayList<Shapes> shapes, SimpleGraphics area){
        if(shapes == null || shapes.isEmpty())
            return;

        Shapes shape = Collections.min(shapes, Comparator.comparingInt(s -> s.distance(x,y)));
        area.clear(Color.WHITE);
        area.render(graphics2D -> shapes.forEach(shapes1 -> shapes1.draw(graphics2D, Color.BLACK)));
        area.render(graphics2D -> shape.draw(graphics2D, Color.ORANGE));
    }
    */

    public void draw(Canvas canvas,ArrayList<Shapes> shapes){
        canvas.clean(SuperColor.WHITE);
        for (var shape:shapes) {
            this.optionalShapes.ifPresentOrElse(shapes1 -> {
                if(shapes1.equals(shape)){
                    shape.draw(canvas,SuperColor.ORANGE);
                }
                else {
                    shape.draw(canvas, SuperColor.BLACK);
                }
            }, ()->{
                shape.draw(canvas,SuperColor.BLACK);
            });
        }
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
        boolean legacy = false;
        Path path;
        Paint paint = new Paint();

        if(args.length != 0 ){
            if (args[0].equals("-legacy")){
                legacy = true;
                path = Paths.get(args[1]);
            }
            else{
                path = Paths.get(args[0]);
            }
        }
        else{
            throw new IOException("args missing");
        }


        ArrayList<Shapes> shapes = Pars.methode(path);
        Point window = maxShape(shapes);
        Canvas canvas ;

        if(legacy){
            canvas = new SimpleGraphicAdapteur("SimpleGeraphicAdapteur", window.x(), window.y());
        }
        else{
            canvas = new CoolGraphicAdapteur( "CoolGraphicAdapteur", window.x(), window.y());
        }
        paint.draw(canvas,shapes);
        canvas.waitMousse((x,y)-> {
            paint.optionalShapes = Optional.of(Collections.min(shapes, Comparator.comparingInt(s -> s.distance(x,y))));
            paint.draw(canvas, shapes);
        } );
    }

}
