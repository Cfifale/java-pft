package ru.stqa.pft.sandbox.point;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class ProgramPoint {
    public static void main(String[] args) {
        Point p1 = new Point(3,-4);
        Point p2 = new Point(-6,5);
        System.out.println("Вычисление через функцию. Расстояние между двумя точками A("+p1.x+";"+p1.y+") и B("+p2.x+";"+p2.y+") = "+distance(p1,p2));
        System.out.println("Вычисление через метод. Расстояние между двумя точками A("+p1.x+";"+p1.y+") и B("+p2.x+";"+p2.y+") = "+p1.distance(p2));
    }

    public static double distance(Point p1, Point p2) {
        return sqrt(pow(p2.x - p1.x,2) + pow(p2.y - p1.y,2));
    }

}