package ro.teamnet.zerotohero.oop.graphicshape;


/**
 * Created by Cristian.Barbu on 7/4/2017.
 */
public class Circle extends Shape {
    private int xPos, yPos, radius;
    public Circle(){
        xPos = 5;
        yPos = 4;
        radius = 3;
    }
    public Circle(int radius){
        this.radius = radius;
        xPos = 0;
        yPos = 0;
    }
    public Circle(int radius, int xPos){
        this.radius = radius;
        this.xPos = xPos;
        yPos = 0;
    }

    public Circle(int radius, int xPos, int yPos){
        this.radius = radius;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public String toString(){
        return "center=(" + xPos + "," + yPos + ") and radius= " + radius;
    }

    public void fillColour(){
        System.out.println(super.color);
    }

    public void fillColour(int colour){
        super.color = colour;
        System.out.println("Inside 1 parameter fillColour method");
    }

    public void fillColour(float sat){
        super.saturation = sat;
    }


   public  double area(){
        return this.radius*this.radius*Math.PI;
    }

}
