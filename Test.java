
package Jabo;

import java.io.IOException;


public class Test 
{
    String testSource,testdestination;
   Test()
   {
       
   }
   Test(String s,String d)
   {
       testSource=s;
       testdestination=d;
   }
   public String getTestSource()
   {
       System.out.println( testSource);
       return testSource;
   }
   public String getTestdetination()
   {
       System.out.println(testdestination);
       return testdestination;
   }
   
}
