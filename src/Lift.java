import java.util.Scanner;


public class Lift {

    public static int sourceLevel;

    public Lift() {
        sourceLevel = 3;
    }

    //New

    public Request[] getRequest() {
        int i = 0;
        new RequestQueue(5);
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
    void moveTo(Request[] request)//receives the list of destinationLevel and assigns  them priorities based on the difference in sourceLevel and destination level
    {

        PriorityQueue queuePriority = assignPriority(request);//creates  a priority queue
        int i = 0;
        while (!queuePriority.isEmpty()) {
            Level p = queuePriority.remove();
            System.out.println("Level : " + p.level + " Range : " + p.range);
            long start = System.nanoTime();
            sourceLevel = moveTo2(p);
            long end = System.nanoTime();
            System.out.println("Time taken :" + (end - start) / 1000);
            System.out.println("People remaining : " + queuePriority.size());
        }
    }


    //externalRequests = [{direction, timeStamp, sourceLevel}]
    //internalRequests = [{timeStamp, destinationLevel , sourceLevel}]


    //linking externalRequest of one user to his internalRequest

    int moveTo2(Level p) {
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

    PriorityQueue assignPriority(Request[] r) {
        PriorityQueue pq = new PriorityQueue(r.length);
        int[] rangeList = calcRange(r);
        pq.displayQueue();
        for (int i = 0; i < rangeList.length; i++) {
            pq.insert(r[i].destinationLevel, rangeList[i], r[i].sourceLevel);
        }
        return pq;
    }

    int[] calcRange(Request[] r) {
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