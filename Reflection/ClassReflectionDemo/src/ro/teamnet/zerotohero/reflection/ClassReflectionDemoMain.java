package ro.teamnet.zerotohero.reflection;

import ro.teamnet.zerotohero.reflection.demoobjects.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * TODO
 * in order to resolve the exercises below, you will have to create
 * all the needed clasees, with their members and methods
 * (in ro.teamnet.zerotohero.reflection.demoobjects package)
 */
public class ClassReflectionDemoMain {
    public static void main(String[] args) throws NoSuchFieldException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //TODO get the class for a String object, and print it
		
        String a = "sdssa";
        System.out.println(a.getClass());

        //TODO get the class of an Enum, and print it
        
        Class b = EnumClass.e1.getClass();
        System.out.println(b);
        //TODO get the class of a collection, and print it

        Class c = new ArrayList().getClass();
        System.out.println(c);

        //TODO get the class of a primitive type, and print it
        System.out.println(int.class);

        //TODO get and print the class for a field of primitive type

        System.out.println(forFieldClass.class.getDeclaredField("x").getType());

        //TODO get and print the class for a primitive type, using the wrapper class
        System.out.println(Integer.TYPE);

        //TODO get the class for a specified class name

        Class t = Class.forName("ro.teamnet.zerotohero.reflection.demoobjects.forFieldClass");
        System.out.println(t);


        //TODO get the superclass of a class, and print it

        System.out.println(forFieldClassSuperclass.class.getSuperclass());

        //TODO get the superclass of the superclass above, and print it

        System.out.println(forFieldClassSuperSuperClass.class.getSuperclass().getSuperclass());

        //TODO get and print the declared classes within some other class

        Class[] array;

     array =    forInnerClass.class.getDeclaredClasses();
       for(Class it:array){
           System.out.println(it);
       }

        //TODO print the number of constructors of a class
        int x;
        Constructor<?>[] array1;
        array1 = forInnerClass.class.getConstructors();
        System.out.println(array1.length);

        //TODO get and invoke a public constructor of a class
        forInnerClass.class.getConstructor(int.class).newInstance(5);


        //TODO get and print the class of one private field 

        System.out.println(forInnerClass.class.getDeclaredField("y").getType());

		//TODO set and print the value of one private field for an object

        forInnerClass class1 = new forInnerClass(5);

        Field privateField = forInnerClass.class.getDeclaredField("y");

        privateField.setAccessible(true);
        privateField.set(class1, 4);

        System.out.println((int)privateField.get(class1));

        //TODO get and print only the public fields class
        System.out.println();
        Field[] array2;
        forInnerClass class2 = new forInnerClass(5,7);
        array2 = forInnerClass.class.getFields();
        for(Field iti:array2){
            System.out.println(iti.get(class2));
        }


        //TODO get and invoke one public method of a class

        forInnerClass.class.getMethod("show").invoke(new forInnerClass());

        //TODO get and invoke one inherited method of a class

        forFieldClassSuperclass.class.getMethod("show1").invoke(new forFieldClassSuperclass());

		//TODO invoke a method of a class the classic way for ten times, and print the timestamp (System.currentTimeMillis())
        System.out.println();
        System.out.println();
        double init =  System.currentTimeMillis();
        forInnerClass class3 = new forInnerClass();
        for(int i =0; i< 10000; i++) {
            class3.show();
        }

        double first = System.currentTimeMillis();

		//TODO invoke a method of a class by Reflection for 100 times, and print the timestamp
        System.out.println();
        System.out.println();
        for(int j =0; j< 10000; j++){
            forInnerClass.class.getMethod("show").invoke(new forInnerClass());
        }

        double second = System.currentTimeMillis();

		//what do you observe?
        System.out.println(first - init);
        System.out.println(second - init);

    }
}
