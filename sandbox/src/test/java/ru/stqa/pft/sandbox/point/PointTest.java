package ru.stqa.pft.sandbox.point;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {
    Point p1 = new Point(3,3);
    Point p2 = new Point(5,5);

    @Test
    public void testPoint1() {
        Assert.assertEquals(ProgramPoint.distance(p1,p2),2.8284271247461903);
    }

    @Test
    public void testPoint2() {
        Assert.assertEquals(p1.distance(p2),2.8284271247461903);
    }
}