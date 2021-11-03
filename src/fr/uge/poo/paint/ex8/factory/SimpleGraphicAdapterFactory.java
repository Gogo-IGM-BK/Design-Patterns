package fr.uge.poo.paint.ex8.factory;

import fr.uge.poo.paint.ex8.Canvas;
import fr.uge.poo.paint.ex8.SimpleGraphicAdapteur;

public class SimpleGraphicAdapterFactory implements CanvasFactory {
    @Override
    public Canvas withData(String name, int width, int height) {
        return new SimpleGraphicAdapteur(name, width, height);
    }
}
