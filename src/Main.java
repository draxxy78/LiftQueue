import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.util.Arrays;
import java.util.PropertyResourceBundle;

public class Main
{
    //Assumption : number of inputs given 
    public static void main(String[] args)
    {

        Request r1 = new Request(5, (int) System.nanoTime(),3);
        Request r2 = new Request(8, (int) System.nanoTime(),3);
        Request r3 = new Request(3, (int) System.nanoTime(),3);
        Request r4 = new Request(2, (int) System.nanoTime(),3);


        RequestQueue rq = new RequestQueue(4);
        RequestQueue.queueEnqueue(r1);
        RequestQueue.queueEnqueue(r2);
        RequestQueue.queueEnqueue(r3);
        RequestQueue.queueEnqueue(r4);


        Lift l = new Lift();
        Request[] requestList = RequestQueue.giveQueue();
        l.moveTo(requestList);

    }

}
