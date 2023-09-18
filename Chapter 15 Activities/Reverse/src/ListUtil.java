import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings)
    {
        int size = strings.size();
        ListIterator <String> iterator = strings.listIterator();
        ListIterator <String> iterator2 = strings.listIterator(size);
        
        for(int i = 1; i<=(size/2); i++){
            String a = iterator.next();
            String b = iterator2.previous();

            iterator.set(b);
            iterator2.set(a);

        }


        
            
        }
    }
