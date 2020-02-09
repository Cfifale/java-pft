package ru.stqa.pft.sandbox.point;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

    @Test
    public void testPoint1() {
        Point p1 = new Point(3,3);
        Point p2 = new Point(5,5);
        Assert.assertEquals(ProgramPoint.distance(p1,p2),2.8284271247461903);
    }

    @Test
    public void testPoint2() {
        Point p1p2 = new Point(3,3,5,5);
        Assert.assertEquals(p1p2.distance(),2.8284271247461903);
    }
}
