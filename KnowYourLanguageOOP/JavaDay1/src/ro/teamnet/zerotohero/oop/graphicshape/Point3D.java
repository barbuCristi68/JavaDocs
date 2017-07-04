package ro.teamnet.zerotohero.oop.graphicshape;

import ro.teamnet.zerotohero.oop.exceptions.ExceptionTest;
import ro.teamnet.zerotohero.oop.exceptions.MyException;

/**
 * Created by Cristian.Barbu on 7/4/2017.
 */
public class Point3D extends Point {
    private int zPos;
    public Point3D(int x, int y, int z) throws ExceptionTest, MyException {
        super(x,y);
        this.zPos = z;
    }
}
