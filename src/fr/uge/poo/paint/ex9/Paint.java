package fr.uge.poo.paint.ex9;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;

public class Paint {
    public Optional<Shapes> optionalShapes = Optional.empty();

    public void draw(Canvas canvas, ArrayList<Shapes> shapes){
        for (var shape:shapes) {
            this.optionalShapes.ifPresentOrElse(shapes1 -> {
                if(shapes1.equals(shape)){
                    shape.draw(canvas, SuperColor.ORANGE);
                }
                else {
                    shape.draw(canvas, SuperColor.BLACK);
                }
            }, ()->{
                shape.draw(canvas, SuperColor.BLACK);
            });
        }
        canvas.draw(SuperColor.WHITE);
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
