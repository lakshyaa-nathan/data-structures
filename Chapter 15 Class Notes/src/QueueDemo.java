import java.util.LinkedList;
import java.util.Queue;

/**
 * This program simulates a print queue. Note that documents are printed
 * in the same order as they are submitted.
*/
public class QueueDemo
{
    public static void main(String[] args)
    {
        Queue < String> jobs = new LinkedList<>();

        // Adds some print Jobs

        jobs.add("Joe: Expense Report 2023");
        jobs.add("Cathy: Top Secret Document #5");

        System.out.println("Printing: "+jobs.remove());

        // Remember that first in is first out with queues

        jobs.add("Cathy: Really top secret document #2");

        jobs.add("Joe: Grocery List");

        jobs.add("Cathy: Can I get fired for this?");

        System.out.println("Printing: "+ jobs.remove());

        jobs.add("Boss: Cathy's termination letter");

        //Print the rest of the joobs in the queue

        

        for(int len = jobs.size(); len>0; len-- ){
            System.out.println(jobs.remove());
        }



    }
}
