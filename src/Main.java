import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.util.Arrays;
import java.util.PropertyResourceBundle;

public class Main
{
    //Assumption : number of inputs given 
    public static void main(String[] args)
    {

        Request r1 = new Request(5, (int) System.nanoTime(),0);
        Request r2 = new Request(7, (int) System.nanoTime(),0);
        Request r3 = new Request(3, (int) System.nanoTime(),0);

        RequestQueue rq = new RequestQueue(3);
        RequestQueue.queueEnqueue(r1);
        RequestQueue.queueEnqueue(r2);
        RequestQueue.queueEnqueue(r3);


        Lift l = new Lift();
        Request[] requestList = RequestQueue.giveQueue();
        l.moveTo(requestList);

    }

}