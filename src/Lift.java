public class  Lift
{

    int currentLevel = 0 ;

    // 1.Priority 1.Requested time 2.Range 3.Current Load
    void moveTo(Request[] r)//receives the list of destinationLevel and assigns  them priorities based on the difference in currentLevel and destination level
    {
        PriorityQueue queuePriority = assignPriority(r);//creates  a priority queue
        int i =0 ;

        while (!queuePriority.isEmpty())
        {
            Level p = queuePriority.remove();
            System.out.println("Level :"+p.level+" Range: "+p.range+" Current Lvl:"+p.currentLevel);
            moveTo2(p.level,p.currentLevel);
        }


    }

    void moveTo2(int destinationLevel , int currentLevel)
    {
        
            if(currentLevel < destinationLevel)
            {
                do
                {
                    currentLevel += 1;
                    System.out.println(currentLevel);

                }while (currentLevel != destinationLevel);
            }
            else
            {
                System.out.println(currentLevel);
                do
                {
                    currentLevel += 1;
                }while (currentLevel != destinationLevel);
            }
        
    }




    PriorityQueue assignPriority(Request[] r)
    {
        PriorityQueue pq = new PriorityQueue(r.length);
        int[] rangeList = calcRange(r);
        for ( int i = 0 ; i < rangeList.length ; i++)
        {
            pq.insert(r[i].destinationLevel,rangeList[i],r[i].currentLevel);
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
