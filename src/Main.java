import static com.sun.tools.sjavac.Main.go;

public class Main
{
    //Assumption : number of inputs given 
    public static void main(String[] args)
    {
        RequestQueue requestQueue = Lift.liftInput(5);
        //Task : iterate through the request queue an move the lift
        requestQueue.peek();
    }

}