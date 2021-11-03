package fr.uge.poo.paint.ex8;

public class Rectangle implements Shapes {

    public int x;
    public int y;
    public int width;
    public int height;

    public Rectangle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

    @Override
    public void draw(Canvas canvas, SuperColor superColor) {
        canvas.drawRectangle(x,y,width,height,superColor);
    }

    @Override
    public int distance( int x1, int y1) {
        var middle_x = x + (width / 2);
        var middle_y = y + (height / 2);
        return (x1 - middle_x) * (x1 - middle_x) + (y1 - middle_y) * (y1 - middle_y);
    }

    public Point max(){
        return new Point(x + width, y + height);
    }
}
