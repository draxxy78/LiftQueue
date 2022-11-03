public class Request
{
    int currentLevel;
    int destinationLevel;
    int timeStamp;

    public Request(int destinationLevel, int timeStamp, int currentLevel)
    {
        this.destinationLevel = destinationLevel;
        this.timeStamp = (int) timeStamp;
        this.currentLevel = currentLevel;
    }


}
