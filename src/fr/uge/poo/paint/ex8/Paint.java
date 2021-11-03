package fr.uge.poo.paint.ex8;

import fr.uge.poo.ducks.Duck;
import fr.uge.poo.paint.ex8.factory.CanvasFactory;
import fr.uge.poo.paint.ex8.factory.SimpleGraphicAdapterFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Paint {
    public Optional<Shapes> optionalShapes = Optional.empty();

    public void draw(Canvas canvas, ArrayList<Shapes> shapes){
        canvas.clean(SuperColor.WHITE);
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
        Paint paint = new Paint();

        ArrayList<Shapes> shapes = Pars.methode(path);
        Point window = maxShape(shapes);

        Canvas canvas;

        ServiceLoader<CanvasFactory> loader = ServiceLoader.load(fr.uge.poo.paint.ex8.factory.CanvasFactory.class);
        var lib = loader.stream().findFirst();
        if (lib.isPresent()) {
            canvas = lib.get().get().withData("araa", window.x(), window.y());
        } else {
            canvas = new SimpleGraphicAdapterFactory().withData("area", window.x(), window.y());
        }

        paint.draw(canvas,shapes);
        canvas.waitMousse((x,y)-> {
            paint.optionalShapes = Optional.of(Collections.min(shapes, Comparator.comparingInt(s -> s.distance(x,y))));
            paint.draw(canvas, shapes);
        });

    }

}
