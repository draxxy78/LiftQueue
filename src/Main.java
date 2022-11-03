public class Main
{
    //Assumption : number of inputs given 
    public static void main(String[] args)
    {
        Request r = new Request(5, (int) System.nanoTime(),0);
        Request r1 = new Request(7, (int) System.nanoTime(),0);
        Request r2 = new Request(3, (int) System.nanoTime(),0);

        RequestQueue rq = new RequestQueue(3);
    }

}