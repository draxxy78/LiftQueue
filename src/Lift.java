public class Lift
{
    int loadCapacity = 850;
    int currentLoad = 750;
    int inputCount ;

    public Lift(int inputCount)
    {
        this.inputCount = inputCount;
        liftInput(inputCount);
    }


    public static void liftInput(int inputCount)
    {

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
