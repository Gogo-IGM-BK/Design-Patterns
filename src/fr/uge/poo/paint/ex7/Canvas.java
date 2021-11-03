package fr.uge.poo.paint.ex7;

public interface Canvas {
    public void drawLine ( int x1, int y1, int x2, int y2, SuperColor color );
    public void drawRectangle (int x, int y, int width, int height, SuperColor color);
    public  void drawEllipse (int x, int y, int width, int height, SuperColor color);
    public void clean(SuperColor superColor);
    @FunctionalInterface
    public interface Mousse {
        void mouseClicked(int x, int y);
    }
    public void waitMousse(Mousse mousse);

}
