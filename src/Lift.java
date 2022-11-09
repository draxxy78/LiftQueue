import java.util.Scanner;

public class Lift {

    private int sourceLevel;

//    public static void getRequest(int sourceLevel) {
//        int i = 0;
//        RequestQueue rq = new RequestQueue(4);
//        Scanner sc = new Scanner(System.in);
//        Request[] requestList = new Request[4];
//        while (i != 4) {
//            System.out.print("Enter Destination Level : ");
//            int destinationLevel = sc.nextInt();
//            Request r = new Request(destinationLevel, (int) System.nanoTime(), sourceLevel);
//            RequestQueue.queueEnqueue(r);
//            requestList = RequestQueue.giveQueue();
//            i += 1;
//        }
//        moveTo(requestList);
//
//    }

    // 1.Priority 1.Requested time 2.Range 3.Current Load
    static void moveTo(Request[] r)//receives the list of destinationLevel and assigns  them priorities based on the difference in sourceLevel and destination level
    {
        PriorityQueue queuePriority = assignPriority(r);//creates  a priority queue
        int i = 0;

        while (!queuePriority.isEmpty()) {
            Level p = queuePriority.remove();
            System.out.println("Level :" + p.level + " Range: " + p.range + " Current Lvl:" + p.sourceLevel);
            int sourceLevel = moveTo2(p.level, p.sourceLevel);
            queuePriority.getIth(i + 1).sourceLevel = sourceLevel;

        }
    }

    static int moveTo2(int destinationLevel, int sourceLevel) {

        if (sourceLevel < destinationLevel) {
            do {
                sourceLevel += 1;
                System.out.println("You are at : " + sourceLevel);

            } while (sourceLevel != destinationLevel);
        } else {
            while (sourceLevel != destinationLevel) {

                sourceLevel = sourceLevel - 1;
                System.out.println("You are at : " + sourceLevel);
            }
        }
        return sourceLevel;
    }


    static PriorityQueue assignPriority(Request[] r) {
        PriorityQueue pq = new PriorityQueue(r.length);
        int[] rangeList = calcRange(r);
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


    //Once the requestQueue object is passed into decideLevel ,
    // we need to calculate range and assign a priority to each level in the queue
    //floors will be traversed based on the priority

}