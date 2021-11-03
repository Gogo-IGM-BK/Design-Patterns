package fr.uge.poo.paint.ex8;

public record Point (int x, int y) {
    @Override
    public String toString() {
        return x+" "+y;
    }

    public int distance (Point a) {

        return (a.x()-this.x)*(a.x()-this.x) + (a.y()-this.y)*(a.y()-this.y);
    }


}