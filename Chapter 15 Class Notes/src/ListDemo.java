import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {
        LinkedList <String> staff = new LinkedList<>();

        staff.addLast("Diana");
        staff.addLast("Harry");
        staff.addLast("Romeo");
        staff.addLast("Tom");
        //creating and populating the linked list using the addLast method
        // The list is currently : DHRT (Each element gets added at the end)

        /*
         * The listIterator method creates a new list iterator that is 
         * positioned at the head of the list. 
         * 
         * The "|"(vertical bar) is used to represent the iterator position. 
         */

         ListIterator <String> iterator = staff.listIterator(); // |DHRT

        // the next method advances the iterator to the next element in the liset

        iterator.next(); // D|HRT

        // The next method also returns the element that the iterator is passing 

        String name = iterator.next(); // DH|RT

        System.out.println(name); //printing  the element that is passes as it is moving to the next element. 
        // This should print out Harry

        /* The add method for iterators  inserts an element at the iterator position. 
         * The iterator is then positioned after the element that was added. 
         */
        iterator.add("Juliet"); // DHJ|RT

        iterator.add("Nina"); // DHJN|RT  (Inserts before the iterator position)

        /*
         * the remove method removes the element returned by the last call to 
         * next or precious. 
         * The remove method can ONLY be called once after calling next or previous
         * The remove method CANNOT be called after calling add
         */
        
        iterator.next(); // DHJNR|T


        iterator.remove(); // Romeo gets moved (before the iterator placement)

        System.out.println(staff);

        //the set method updates the element returned by the last call to next or previous
         

        iterator.previous(); // DHJ|NT

        iterator.set("Albert"); // DHJ|AT  (removes and replaces the element it passes)

        /* 
         *The hasNext method returns true if the list
         * has another element. It is often used in the 
         * condition of a while loop. 
         */

         iterator = staff.listIterator(); // |DHJAT

         while(iterator.hasNext()){
            String n = iterator.next();
            if(n.equals("Juliet")){
                // DHJ|AT
                iterator.remove();
                //DH|AT
            }




         }  //DHAT|


         //Enhanced for loops work with linked lists

         for(String n: staff){
            System.out.print(n+ " "); //Should print out every element in the list 
         }

        iterator = staff.listIterator();


        // the next loop doesn't work (ConcurrentModificationException)

        /*
         * Can't modify a linked list while also 
         * using an iterator unless you use the iterator to do.
         */

         /*
          * while(iterator.hasNext()){
            String n  = iterator.next();
            if(n.equals("Harry")){
                staff.remove("Diana");
            }
        }
          */
            // an enhanced for loop AUTOMATICALLY creates an iteration, gives us an error
          for(String n: staff){

            if(n.equals("Harry")){
                //staff.add("Charlie");
            }

          }
        

    }
}
