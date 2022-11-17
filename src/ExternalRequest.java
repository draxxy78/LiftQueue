public class ExternalRequest {
    int sourceFloor;
    Direction direction;
    int intRequestTime;

    public ExternalRequest(int sourceFloor, Direction direction, int intRequestTime) {
        this.sourceFloor = sourceFloor;
        this.direction = direction;
        this.intRequestTime = (int) System.nanoTime();
    }
}
