package fr.uge.poo.paint.ex9;

import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class SimpleGraphicAdapteur implements Canvas {

    public SimpleGraphics area;
    public final List<Consumer<Graphics2D>> lst = new ArrayList<Consumer<Graphics2D>>();

    public SimpleGraphicAdapteur(String name, int width, int height){
        this.area = new SimpleGraphics(name, width, height);
    }

    public void draw(SuperColor color) {
        this.clean(color);
        this.area.render(graphics2D -> {
            this.lst.forEach(it -> it.accept(graphics2D));
            this.lst.clear();
        });
    }


    public void drawLine (int x1, int y1, int x2, int y2, SuperColor color ){
        this.lst.add(graphics2D -> {
            graphics2D.setColor(color.getColor());
            graphics2D.drawLine(x1, y1, x2, y2);
        });
    }

    public void drawRectangle (int x, int y, int width, int height, SuperColor color){
        this.lst.add(graphics2D -> {
            graphics2D.setColor(color.getColor());
            graphics2D.drawRect(x, y, width, height);
        });
    }

    public void drawEllipse(int x, int y, int width, int height, SuperColor color){
        this.lst.add(graphics2D -> {
            graphics2D.setColor(color.getColor());
            graphics2D.drawOval(x, y, width, height);
        });
    }

    @Override
    public void clean(SuperColor superColor) {
        area.clear(superColor.getColor());
    }

    @Override
    public void waitMousse(Mousse mousse) {
        this.area.waitForMouseEvents(mousse::mouseClicked);
    }
}
