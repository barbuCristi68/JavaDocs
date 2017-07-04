package ro.teamnet.zerotohero.oop.graphicshape;

import ro.teamnet.zerotohero.oop.graphicshape.Circle;

/**
 * Created by Cristian.Barbu on 7/4/2017.
 */
public class Circles {
    public double getAreaPub(){
        Circle circ = new Circle();
        return circ.area();
    }

    public void getAreaDef(){
        Circle circ = new Circle();
        circ.fillColour();
        circ.fillColour(5);
        circ.fillColour((float) 0.32);
    }

}
