public class Request
{
     int sourceLevel;

    int destinationLevel;

    int requestedAt;

    public Request(int destinationLevel, int requestedAt, int sourceLevel)
    {
        this.destinationLevel = destinationLevel;
        this.requestedAt =  requestedAt;
        this.sourceLevel = sourceLevel;
    }


}
