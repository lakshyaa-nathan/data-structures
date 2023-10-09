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
        
    	//Scanner scanner = new Scanner(sentence);
        String word;
        int sentencecount = 0;
        for(int i=0; i<sentence.length();i++){
            if(sentence.charAt(i)=='.'){
                sentencecount++; // counts the number of periods AKA the number of sentences
            }
            //System.out.println("test" + sentencecount);
        }
    	
        // Complete this method. Use a Stack.
        Stack<String> words = new Stack<>(); // makes a stack for the reversed sentence
        String temp;  // variable temporarily holding one sentence at a time to reverse
        //Scanner tempScan;

        while (sentencecount>0){  // goes until all the sentences have been reversed
            
            int index = sentence.indexOf("."); //finds the end of the first sentence

            /* 
            temp = sentence.substring(0, index);
            // extracting the first sentence
            
            int length = temp.length(); // variable holding  the length of the first sentence

            


            for(int i = 0; i<length;i++) //goes until the end of the sentence
            {
                if(temp.charAt(i)==' '){

                    word = temp.substring(0, i+1);
                    words.push(word); // finding the index of spaces and substringing when a space is found. 
                    System.out.println(word);
                }

                */
            String tempSent = sentence.substring(0, index);
            Scanner scan = new Scanner(tempSent);
            while(scan.hasNext()){
                words.push(scan.next());
            } 
            
            }
            
            
        
        
    }

    String total="";
    while(words.size()>0){
        total += words.pop(); //printing out the reversed sentence
    }
    return total;

    }
}
