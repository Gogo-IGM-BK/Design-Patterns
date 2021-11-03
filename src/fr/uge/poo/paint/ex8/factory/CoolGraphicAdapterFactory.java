package fr.uge.poo.paint.ex8.factory;

import fr.uge.poo.paint.ex8.Canvas;
import fr.uge.poo.paint.ex8.CoolGraphicAdapteur;

public class CoolGraphicAdapterFactory implements CanvasFactory {
    @Override
    public Canvas withData(String name, int width, int height) {
        return new CoolGraphicAdapteur(name, width, height);
    }
}
