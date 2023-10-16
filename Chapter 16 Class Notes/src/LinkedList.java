import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of nodes with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
*/
public class LinkedList
{
    // need a reference to the first node
    // If the list is empty, first is null

    private Node first;

    /**
        Constructs an empty linked list.
    */

    public LinkedList(){
        this.first = null;
    }



    /**
        Returns the first element in the linked list.
        @return the first element in the linked list
    */

    public Object getFirst(){
        if(this.first == null){
            throw new NoSuchElementException(); //gives an error if the first element is null
        }
        
        return this.first.data;
    }


    /**
        Removes the first element in the linked list.
        @return the removed element
    */
     public Object removefirst(){
        if(this.first == null){
            throw new NoSuchElementException(); //gives an error if the first element is null
        }
        
        Object element = this.first.data; //storing the object into a variable for future reference

        this.first = this.first.next; //making the first object the second object

        return element;


    }




    /**
        Adds an element to the front of the linked list.
        @param element the element to add
    */

    public void addFirst(Object element){
        Node newNode = new Node();

        newNode.data = element;

        newNode.next= this.first;

        this.first = newNode;
    }



    /**
        Returns an iterator for iterating through this list.
        @return an iterator for iterating through this list
    */





    //Class Node
    // Node is static because it does not need access to anything in linked list
    static class Node{
        public Object data;
        public Node next;


    }


    class LinkedListIterator implements ListIterator
    {
      //private data

        // We need to know what node the iterator is at

        private Node position;
        private Node previous;
        private boolean isAfterNext;


        /**
            Constructs an iterator that points to the front
            of the linked list.
        */

        public LinkedListIterator (){
            position = null;
            previous = null;
             
            isAfterNext=  false;

        }


        /**
            Moves the iterator past the next element.
            @return the traversed element
        */

        public Object next(){
            previous = position;

            isAfterNext = true;

            //position is null when the iterator is first created.
            if(position == null){
                // at the end of the list
                position = first; // loop back to the beginning of the list
            }
            else{
                position = position.next;
            }

            return position.data;

        }



        /**
            Tests if there is an element after the iterator position.
            @return true if there is an element after the iterator position
        */


        /**
            Adds an element before the iterator position
            and moves the iterator past the inserted element.
            @param element the element to add
        */






        /**
            Removes the last traversed element. This method may
            only be called after a call to the next() method.
        */







        /**
            Sets the last traversed element to a different value.
            @param element the element to set
        */




    }//LinkedListIterator
}//LinkedList
