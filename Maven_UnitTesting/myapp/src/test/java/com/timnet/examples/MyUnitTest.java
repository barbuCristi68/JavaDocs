package com.timnet.examples;
import org.junit.Test;

import  static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Cristian.Barbu on 7/10/2017.
 */
public class MyUnitTest {

    @Test
   public void testConcatenate(){

           MyUnit my = new MyUnit();

           String result = my.concatenate("one", "two");

           assertEquals("onetwo", result);
   }
   @Test
   public void testConcatenateNull(){
       MyUnit my = new MyUnit();

       String result = my.concatenate(null, null);

       assertEquals( null, result);
   }
//   @Test
//   public void testGetBoolean(){
//       MyUnit my = new MyUnit();
//
////       assertTrue((Boolean) my.getBoolean() instanceof  Boolean);
//
//       assertThat(123, is(123));
//   }

}
