package ru.stqa.pft.sandbox.point;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point p) {
        return sqrt(pow(p.x - this.x,2) + pow(p.y - this.y,2));
    }
}