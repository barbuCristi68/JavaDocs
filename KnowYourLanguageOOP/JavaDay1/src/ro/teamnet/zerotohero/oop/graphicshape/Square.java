package ro.teamnet.zerotohero.oop.graphicshape;

import ro.teamnet.zerotohero.oop.graphicshape.Shape;

/**
 * Created by Cristian.Barbu on 7/4/2017.
 */
public class Square extends Shape {
    private int side;

    public Square(int side){
        this.side = side;
    }
    public double area(){
        return side*side;
    }
}
