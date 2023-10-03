import java.util.Stack;

/**
 * This program simulates an undo stack. Note that operations
 * must be undone in the opposite order in which they are first
 * issued.
*/
public class StackDemo
{
    public static void main(String[] args)
    {
        Stack<String> commands = new Stack<>();

        // don't need to specify size even though there is a limit

        //Push commands onto the top of the stack

        commands.push("Insert: 'Hello'");

        commands.push("Insert: ','");

        commands.push("Insert: 'world'");

        commands.push("Insert: '?'");

        commands.push("Delete: '?'");

        commands.push("Insert: '!'");


        //Print the stack with the start of the stack on the far right 

        System.out.println(commands);


        // simulate the user pressing the undo button  4 times

        for(int n = 4; n>0; n--){
            commands.pop();
        }

        System.out.println(commands);

    }
}
