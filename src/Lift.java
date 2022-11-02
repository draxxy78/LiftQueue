import java.util.Scanner;

public class Lift
{

    int inputCount ;
    int loadCapacity;
    int currentLoad;
    int currentLevel;

    public Lift(int inputCount)
    {
        this.inputCount = inputCount;
        this.loadCapacity = 850;
        this.currentLoad = 750;
        this.currentLevel = 0;
    }


    public static RequestQueue liftInput(int inputCount)
    {
        RequestQueue rq = new RequestQueue(inputCount);
        for (int i = 0; i < inputCount; i++)
        {
            Scanner sc= new Scanner(System.in);
            System.out.print("Enter the element "+i+":");
            rq.enqueue(sc.nextInt());
        }
        return  rq;
    }


    //Task: Move users to input based on the input series
    public static void liftGo(int level, int currentLevel)
    {
        if( level > currentLevel)
        {
            System.out.println("From"+currentLevel+"Goto "+ level);
            moveUp(level , currentLevel);
        }
        else
        {
            System.out.println("From"+currentLevel+"Goto "+ level);
            moveDown(level, currentLevel);
        }
    }

    private static void moveUp(int level, int currentLevel)
    {
        do
        {

            System.out.println("Lift is at "+currentLevel);
            currentLevel += 1;
        }while(currentLevel == level);
    }

    private static void moveDown(int level , int currentLevel)
    {
        do
        {
            System.out.println("Lift is at "+currentLevel);
            currentLevel -= 1;
        }while(currentLevel == level);
    }
}
