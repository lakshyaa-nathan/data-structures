import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 * Write a program that checks whether a sequence of HTML tags
 * is properly nested. For each opening tag, such as <p>, there
 * must be a closing tag </p>. A tag such as <p> may have other
 * tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>
 * <p>
 * The inner tags must be closed before the outer ones.
 * Your program should process a file containing tags.
 * For simplicity, assume that the tags are separated by
 * spaces, and that there is no text inside the tags.
*/
public class HTMLChecker
{
    public static void main(String[] args)
    {
        String filename = "src/TagSample1.html";

        try (Scanner in = new Scanner(new File(filename)))
        {
             String a = in.next();
            curr = a.substring(1, a.length() - 1);
            stack.push(curr);

            while(in.hasNext())
            {
                String t = in.next();
                
                curr = t.substring(1, a.length() - 1);

                test = stack.pop();

                
                if(!curr.equals("/" + test))
                {
                    stack.push(test);
                    
                    stack.push(curr);
                    
                }


                
                if(stack.size()==0)
                {
                    System.out.println("All tags are nested.");
                }
                else{
                    System.out.println("These tags are not nested correctly");
                }

            }


        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }

    }
}
