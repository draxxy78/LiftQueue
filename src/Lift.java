import java.util.Scanner;

public class Lift
{
    int loadCapacity;
    int currentLoad ;
    int inputCount;
    public Lift(int inputCount)
    {
        this.inputCount = inputCount;
        this.loadCapacity = 850 ;
        this.currentLoad = 750;
    }


    public static RequestQueue liftInput(int inputCount)
    {
        RequestQueue rq = new RequestQueue(inputCount);
        for ( int i =0 ; i < inputCount ; i ++ )
        {

            Scanner s = new Scanner(System.in);
            RequestQueue.queueEnqueue(s.nextInt());

        }
        return rq;

    }

    //    go()
//    {
//        if(currentLoad > loadCapacity)
//        {
//            if (currentFloor != requestFloor)
//            {
//                if( currentFloor < requestFloor)
//                {
//                    moveUp();
//                }
//                else
//                {
//                    moveDown();
//                }
//            }
//        }
//
//    }

}
