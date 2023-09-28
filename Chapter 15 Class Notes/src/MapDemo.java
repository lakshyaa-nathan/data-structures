import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
    This program demonstrates a map that maps names to colors.
*/
public class MapDemo
{
    public static void main(String[] args)
    {

        /* 
         * The Map interface is generic. 
         * The first type is the type of the key
         * the second type is the type of the value
         */
        
        Map<String, Color> favColors = new HashMap <> (); //initializing the map

        favColors.put("Hyder", Color.red); //same caps
        favColors.put("Athena", Color.magenta);
        favColors.put("Bavya", Color.blue); //put is used to add things to the map. 

        //These maps need a key and a value
        // Two different keys can have the same value

        // For example:

        favColors.put("Mitchell", Color.red);

        //But, a value CANNOT have the same key:

        favColors.put("Athena", Color.orange); //changes to orange, not magenta

        System.out.println(favColors.get("Athena"));

        // Using put for a key that exists changes the value of the key
        // Dictionaries are maps

        // Create a set of the keys in a map

        Set<String> keys = favColors.keySet();

        //keyset will return all the keys from the map

        for(String key:keys){
            System.out.println(key + " ("+key.hashCode()+"): "+ favColors.get(key));
        }









    }
}
