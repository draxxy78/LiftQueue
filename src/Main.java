import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.util.Arrays;
import java.util.PropertyResourceBundle;


public class Main {
    //Assumption : number of inputs given 
    public static void main(String[] args) {
        long start = System.nanoTime();
        // some time passes
        long end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.println(elapsedTime);
    }

    // UP  : 4 , 5
    //DOWN : 1 , 2
    // The lift will start from sourcePosition  =  3, has to complete all the request in the down[] , before going to the UP{]

}
