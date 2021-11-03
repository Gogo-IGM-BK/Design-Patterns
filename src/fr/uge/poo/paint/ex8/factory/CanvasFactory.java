package fr.uge.poo.paint.ex8.factory;

import fr.uge.poo.paint.ex8.Canvas;

public interface CanvasFactory {
    Canvas withData(String name, int width, int height);
}
