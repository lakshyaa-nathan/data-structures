/**
 *   A program that demonstrates the LinkedList class
 */
public class ListDemo
{
    public static void main(String[] args)
    {

        // create our linked list

        LinkedList students = new LinkedList();

        students.addFirst("Preston");
        students.addFirst("Emma");
        students.addFirst("William");
        students.addFirst("Addison");
        

        ListIterator iterator = students.listIterator();
        iterator.next();
        iterator.add("Hyder");

        iterator.next();
        iterator.remove();
        

        System.out.println(students);









    }
}
