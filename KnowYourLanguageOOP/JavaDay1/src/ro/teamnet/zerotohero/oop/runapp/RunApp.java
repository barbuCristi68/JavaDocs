package ro.teamnet.zerotohero.oop.runapp;

import ro.teamnet.zerotohero.canvas.Canvas;
import ro.teamnet.zerotohero.oop.exceptions.ExceptionTest;
import ro.teamnet.zerotohero.oop.exceptions.MyException;
import ro.teamnet.zerotohero.oop.graphicshape.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Cristian.Barbu on 7/4/2017.
 */
public class RunApp {
    public static void main(String[] args) throws MyException {
        Circles circs = new Circles();
        System.out.println(circs.getAreaPub());
        circs.getAreaDef();

        Canvas canv = new Canvas();
//       canv.paint();

        Shape shape1 = new Circle(10);
        System.out.println(shape1.area());

        ShapeBehaviour shape2 = new Square(10);
        System.out.println(shape2.area());

        Object p1 = null;
        Object p2 = null;
        Object p3 = null;
        try {
            p1 = new Point(10,20);
            p2 = new Point(50,100);
            p3 = new Point(10,20);
        } catch (ExceptionTest exceptionTest) {
            exceptionTest.printStackTrace();
        }catch (MyException me){
            me.printStackTrace();
        }
        finally {
            System.out.println("Inside finally");
        }




        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));





    }
}
