import java.util.Scanner;

public class  Lift
{

    int weightCapacity = 120;
    int liftPos = 0 ;


    public void selectDirection(int userPos)
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter 0 for DOWN , 1 for UP : ");
        int upOrDown= sc.nextInt();
        boolean weightFlag;
        if(userPos != liftPos)
        {

            liftPos = moveLiftToUserPos(liftPos,userPos);
            Scanner sc1= new Scanner(System.in);
            System.out.println("Enter the total user weight:");
            int totalUserWeight = sc1.nextInt();
            weightFlag = userWeightCheck(totalUserWeight);
        }
        else
        {
            weightFlag = userWeightCheck(118);
        }

        if (!weightFlag)
        {
            Scanner sc1= new Scanner(System.in);
            System.out.println("Enter the floor you want to go to :");
            int floorInput= sc1.nextInt();
            liftPos = moveLiftToUserInput(floorInput,liftPos);
        }
        else
        {
            System.out.println("Overweight !!");
        }

    }



    public boolean userWeightCheck(int totalUserWeight)
    {
        boolean weightFlag;
        if( totalUserWeight > weightCapacity)
        {
            weightFlag =  true;
        }
        else
        {
            weightFlag = false;
        }

        return weightFlag;
    }

    public int moveLiftToUserInput(int floorInput , int liftPos)
    {
        if(this.liftPos > floorInput)
        {
            do
            {
                System.out.println("You are at floor"+ this.liftPos) ;
                this.liftPos -= 1;
            }while (this.liftPos != floorInput);
        }
        else
        {
            do
            {
                System.out.println("You are at floor"+ this.liftPos) ;
                this.liftPos += 1;
            }while (this.liftPos != floorInput);
        }
        return this.liftPos;
    }

    public int moveLiftToUserPos(int liftPos, int userPos)
    {
        if(this.liftPos > userPos)
        {
            do{

                System.out.println("Lift is at "+ this.liftPos) ;
                this.liftPos--;
            }while(this.liftPos != userPos);
        }
        else
        {
            do
            {
                System.out.println("Lift is at "+ this.liftPos) ;
                this.liftPos++;
            }while(this.liftPos != userPos);
        }

        return this.liftPos;
    }

}
