package fr.uge.poo.paint.ex7;

import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;

public class SimpleGraphicAdapteur implements Canvas {

    public SimpleGraphics area;

    public SimpleGraphicAdapteur(String name, int width, int height){
        this.area = new SimpleGraphics(name, width, height);
    }

    public void drawLine (int x1, int y1, int x2, int y2, SuperColor color ){
        area.render(graphics2D -> {
            graphics2D.setColor(color.getColor());
            graphics2D.drawLine(x1, y1, x2, y2);
        });

    }

    public void drawRectangle (int x, int y, int width, int height, SuperColor color){
        area.render(graphics2D ->{
            graphics2D.setColor(color.getColor());
            graphics2D.drawRect(x, y, width, height);
        });

    }

    public void drawEllipse(int x, int y, int width, int height, SuperColor color){
        area.render(graphics2D -> {
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
