import java.util.Scanner;
import java.util.Stack;

/**
 * Class for reversing the order of a sentence.
*/
public class SentenceReverser
{
    /**
     * Reverses the given sentence.
     *
     * @param sentence Sentence to be reversed.
     * @return reversed sentence.
    */
    public static String reverse(String sentence)
    {
    	Scanner scanner = new Scanner(sentence);
        
    	
        // Complete this method. Use a Stack.
        Stack<String> words = new Stack<>();
        String temp;

        while (sentence.length() > 0){
            int index = sentence.indexOf(".");
            temp = sentence.substring(0, index);
           







    }

    }
}
