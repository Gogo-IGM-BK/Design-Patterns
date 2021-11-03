package fr.uge.poo.paint.ex9;

import com.evilcorp.coolgraphics.CoolGraphics;

import java.util.ArrayList;
import java.util.List;


public class CoolGraphicAdapteur implements Canvas {
    public CoolGraphics area;
    public List<Runnable> runnableList = new ArrayList<>();

    public CoolGraphicAdapteur(String name, int width, int height){
        this.area = new CoolGraphics(name, width, height);
    }

    public void draw(SuperColor color) {
        this.clean(color);
        this.runnableList.forEach(Runnable::run);
        this.runnableList.clear();
    }

    public void drawLine ( int x1, int y1, int x2, int y2, SuperColor color ){
        this.runnableList.add(() -> {
            area.drawLine(x1, y1, x2, y2, color.getColorPlus());
        });

    }

    public void drawRectangle (int x, int y, int width, int height, SuperColor color){
        this.runnableList.add(() -> {
            area.drawLine(x, y, x+width, y, color.getColorPlus());
            area.drawLine(x, y, x, y+height, color.getColorPlus());
            area.drawLine(x+width, y, x+width, y+height, color.getColorPlus());
            area.drawLine(x, y+height, x+width, y+height, color.getColorPlus());
        });
    }
    public void drawEllipse(int x, int y, int width, int height, SuperColor color){
        this.runnableList.add(() -> {
            area.drawEllipse(x, y, width, height, color.getColorPlus());
        });
    }

    @Override
    public void clean(SuperColor superColor) {
        area.repaint(superColor.getColorPlus());
    }

    @Override
    public void waitMousse(Mousse mousse) {
        this.area.waitForMouseEvents(mousse::mouseClicked);
    }
}
