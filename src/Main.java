public class Main
{
    //Assumption : number of inputs given 
    public static void main(String[] args)
    {
        RequestQueue rq = new RequestQueue(5);
        //testcommand
        for(int i =0 ; i < RequestQueue.capacity ; i++)
        {
            RequestQueue.queueEnqueue(i);
        }
        RequestQueue.queueDisplay();
        RequestQueue.peek();
    }

}
