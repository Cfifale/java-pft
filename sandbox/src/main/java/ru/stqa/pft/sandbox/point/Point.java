package ru.stqa.pft.sandbox.point;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Point {
    public double x;
    public double y;
    public double x2;
    public double y2;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(double x, double y, double x2, double y2) {
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double distance() {
        return sqrt(pow(this.x2 - this.x,2) + pow(this.y2 - this.y,2));
    }
}


