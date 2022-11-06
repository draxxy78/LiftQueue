/**
 ** Java Program to implement Priority Queue
 **/

/** class Task **/
class Level
{
    int level;
    int range;

    int currentLevel;


    /** Constructor **/
    public Level(int level, int range, int currentLevel)
    {
        this.level = level;
        this.range = range;
        this.currentLevel = currentLevel;
    }

    public String toString()
    {
        return "Level : "+ level +"\nPriority : "+ range;
    }
}

class PriorityQueue
{
    private Level[] heap;
    private int heapSize, capacity;


    /** Constructor **/
    public PriorityQueue(int capacity)
    {
        this.capacity = capacity + 1;
        heap = new Level[this.capacity];
        heapSize = 0;
    }
    public void clear()
    {
        heap = new Level[capacity];
        heapSize = 0;
    }
    public boolean isEmpty()
    {
        return heapSize == 0;
    }

   public boolean isFull()
    {
        return heapSize == capacity - 1;
    }
    /** function to get Size **/
    public int size()
    {
        return heapSize;
    }
    /** function to insert task **/
    public void insert(int level, int range, int currentLevel)
    {
        Level newJob = new Level(level, range, currentLevel);

        heap[++heapSize] = newJob;
        int pos = heapSize;
        while (pos != 1 && newJob.range > heap[pos/2].range)
        {
            heap[pos] = heap[pos/2];
            pos /=2;
        }
        heap[pos] = newJob;
    }
    /** function to remove task **/
    public Level remove()
    {
        int parent, child;
        Level item, temp;
        if (isEmpty() )
        {
            System.out.println("Heap is empty");
            return null;
        }

        item = heap[heapSize--];
        temp = heap[1];

        parent = 1;
        child = 2;
        while (child <= heapSize)
        {
            if (child < heapSize && heap[child].range < heap[child + 1].range)
                child++;
            if (temp.range >= heap[child].range)
                break;

            heap[parent] = heap[child];
            parent = child;
            child *= 2;
        }
        heap[parent] = temp;

        return item;
    }


}
