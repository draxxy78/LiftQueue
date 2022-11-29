public class Main
{
    //Assumption : number of inputs given 
    public static void main(String[] args) {
        long start = System.nanoTime();
        // some time passes
        long end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.println(elapsedTime);
    }

}
