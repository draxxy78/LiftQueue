public class  Lift
{

    int currentLevel = 0 ;

    // 1.Priority 1.Requested time 2.Range 3.Current Load
    void moveTo(Request[] r)
    {
        PriorityQueue queuePriority = assignPriority(r);
        Level p = queuePriority.remove();
        System.out.println("Level :"+p.level+" ,Range :"+ p.range);
    }


    PriorityQueue assignPriority(Request[] r)
    {
        PriorityQueue pq = new PriorityQueue(r.length);
        int[] rangeList = calcRange(r);
        for ( int i = 0 ; i < rangeList.length ; i++)
        {
            pq.insert(r[i].destinationLevel,rangeList[i]);
        }
        return pq;
    }

    int[] calcRange(Request[] r)
    {
        int[] rangeList = new int[r.length];
        for ( int i = 0 ; i < r.length ; i++)
        {
            rangeList[i] = r[i].destinationLevel - r[i].currentLevel;
        }
        return rangeList;
    }


    //Once the requestQueue object is passed into decideLevel ,
    // we need to calculate range and assign a priority to each level in the queue
    //floors will be traversed based on the priority

}