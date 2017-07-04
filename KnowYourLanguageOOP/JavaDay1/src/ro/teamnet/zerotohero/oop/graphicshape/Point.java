package ro.teamnet.zerotohero.oop.graphicshape;

import ro.teamnet.zerotohero.oop.exceptions.ExceptionTest;
import ro.teamnet.zerotohero.oop.exceptions.MyException;

/**
 * Created by Cristian.Barbu on 7/4/2017.
 */
public class Point {
    int xPos, yPos;

    public Point(int xPos, int yPos) throws ExceptionTest, MyException {
        if(xPos == 10)
            throw new ExceptionTest();
        if(yPos == 20)
            throw new MyException();

        this.xPos = xPos;
        this.yPos = yPos;
    }

    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (other instanceof Point) {
            Point anotherPoint = (Point) other;

            if ((xPos == anotherPoint.xPos) && (yPos == anotherPoint.yPos))
                return true;
        }
        return false;
    }
}
