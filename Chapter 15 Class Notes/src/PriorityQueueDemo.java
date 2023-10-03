import java.util.PriorityQueue;
import java.util.Queue;


/**
 * This program demonstrates a priority queue of to-do items. The
 * most important to-do items are removed first.
*/
public class PriorityQueueDemo
{
    public static void main(String[] args)
    {
        // Simulate a to do list

        // Create a prioriy queue of to do items
        // a work order has a message ID that is used to determine priority
        // A priority queue can only store comparable objects, and workorder is comparable

        Queue<WorkOrder> toDo = new PriorityQueue<>();

        toDo.add(new WorkOrder(3, "Water plants"));

        toDo.add(new WorkOrder(2, "Make dinner"));

        toDo.add(new WorkOrder( 2, "Walk Dog"));

        toDo.add(new WorkOrder(9, "Play Videogames"));

        toDo.add(new WorkOrder( 1, "Study for the Chapter 15 exam"));

        System.out.println(toDo);
        // Prints out the items in order (priority)

        while(toDo.size()>0){
            System.out.println(toDo.remove());

        }

        System.out.println(toDo);













    }
}
