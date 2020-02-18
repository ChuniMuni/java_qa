package ru.stqa.pft.sanbox;

class Point {
    public double x;
    public double y;

    public Point(double x1, double y1) {
        this.x = x1;
        this.y = y1;
    }

    public double distance(Point p0){
        return Math.sqrt((p0.x - this.x) * (p0.x - this.x) + (p0.y - this.y) * (p0.y - this.y));
    }

    public String toString() {
        return "x = " + x + "; y = " + y;
    }
}
