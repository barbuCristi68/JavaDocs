package ro.teamnet.zerotohero.reflection.demoobjects;

/**
 * Created by Cristian.Barbu on 7/12/2017.
 */
public class forInnerClass {

    public int x,z;
    private int y;

    public forInnerClass(){}

    public forInnerClass(int x){
        this.x = x;
    }
    public forInnerClass(int x, int z){
        this.x = x;
        this.z = z;
    }
    public class innerClass1{

    }

    public class innerClass2{

    }
    public void show(){
//        System.out.println("Method");
    }

}
