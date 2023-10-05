import java.util.Stack;
import java.util.Scanner;

/**
 * Class for simulating a driveway and a street, using stacks
 * of cars with license plate numbers as representation.
*/
public class Driveway
{
    /**
      * Stacks representing the cars in the driveway and street
    */
    Stack<Integer> driveway = new Stack<>();
    Stack<Integer> street = new Stack<>();

    /**
      * Constructor.
    */
    public Driveway()
    {
        // Complete the constructor
        


    }

    /**
      * Add the given license plate to the driveway.
      *
      * @param licensePlate number of license plate.
    */
    public void add(int licensePlate)
    {
        // Complete this method
        driveway.push(licensePlate);

        


    }

    /**
      * Remove the given license plate from the driveway.
      *
      * @param licensePlate number of license plate.
    */
    public void remove(int licensePlate)
    {
        // Complete this method
        int place=0;
        for(int n=0; n<driveway.size(); n++){
          if(driveway.get(n)== (-1)*licensePlate){
              place=n;
          }
        } 



        for(int n=place;n>0;n--){
          driveway.remove(n);
          street.add(n);

        }
        

    }

    /**
      * Prints the driveway and street details to the screen.
    */
    public void print()
    {
        System.out.println("In Driveway, starting at first in (one license plate per line):");
        // Print the cars in the driveway here
        
        for(int n = driveway.size()-1; n>=0; n--){
          System.out.println(driveway.get(n));
        }

        System.out.println("In Street, starting at first in (one license plate per line):");
        // Print the cars in the street here
        for(int n = street.size()-1; n>=0; n--){
          System.out.println(street.get(n));
        }

    }

    
}
