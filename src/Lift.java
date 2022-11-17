import java.util.Random;
import java.util.Scanner;


public class Lift {

    public static int sourceLevel;

    public Lift() {
        sourceLevel = 3;
    }

    public static Request[] getRequest() {
        int i = 0;
        RequestQueue rq = new RequestQueue(5);
        Scanner sc = new Scanner(System.in);
        Request[] requestList = new Request[5];
        while (i != 5) {
            System.out.print("Enter Destination Level : ");
            int destinationLevel = sc.nextInt();
            Request r = new Request(destinationLevel, (int) System.nanoTime(), sourceLevel);
            RequestQueue.queueEnqueue(r);
            requestList = RequestQueue.giveQueue();
            i += 1;
        }
        return requestList;
    }

    // 1.Priority 1.Requested time 2.Range 3.Current Load
    static <StopWatch> void moveTo(Request[] r)//receives the list of destinationLevel and assigns  them priorities based on the difference in sourceLevel and destination level
    {

        Random rand = new Random();
        int load = rand.nextInt(1000);
        if (load < 700) {
            PriorityQueue queuePriority = assignPriority(r);//creates  a priority queue
            int i = 0;
            while (!queuePriority.isEmpty()) {
                Level p = queuePriority.remove();
                System.out.println("Level : " + p.level + " Range : " + p.range);
                long start = System.nanoTime();
                sourceLevel = moveTo2(p);
                long end = System.nanoTime();
                System.out.println("Time taken :" + (end - start) / 1000);
            }
        }
    }

    static int moveTo2(Level p) {
        if (sourceLevel < p.level) {
            while (sourceLevel != p.level) {
                sourceLevel += 1;
                System.out.println("-You are at : " + sourceLevel);
            }
        } else {
            while (sourceLevel != p.level) {
                sourceLevel -= 1;
                System.out.println("-You are at : " + sourceLevel);
            }
        }
        return sourceLevel;
    }

    static PriorityQueue assignPriority(Request[] r) {
        PriorityQueue pq = new PriorityQueue(r.length);
        int[] rangeList = calcRange(r);
        pq.displayQueue();
        for (int i = 0; i < rangeList.length; i++) {
            pq.insert(r[i].destinationLevel, rangeList[i], r[i].sourceLevel);
        }
        return pq;
    }

    static int[] calcRange(Request[] r) {
        int[] rangeList = new int[r.length];
        for (int i = 0; i < r.length; i++) {
            rangeList[i] = r[i].destinationLevel - r[i].sourceLevel;
        }
        return rangeList;
    }

    public Boolean checkload(double currentLoad) {

        Boolean loadFlag = false;
        int loadLimit = 1050;
        if (currentLoad < loadLimit) {
            loadFlag = true;
        } else {
            loadFlag = false;
        }

        return loadFlag;
    }

    //Once the requestQueue object is passed into decideLevel ,
    // we need to calculate range and assign a priority to each level in the queue
    //floors will be traversed based on the priority


}