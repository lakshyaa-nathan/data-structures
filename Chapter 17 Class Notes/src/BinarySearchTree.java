/**
    This class implements a binary search tree whose
    nodes hold objects that implement the Comparable
    interface.
*/
public class BinarySearchTree
{   
    private Node root;

    /**
        Constructs an empty tree.
    */
    public BinarySearchTree()
    {   
        this.root = null;
    }
    
    /**
        Inserts a new node into the tree.
        @param obj the object to insert
    */
    public void add(Comparable obj) 
    {   
        Node newNode = new Node();

        newNode.data = obj;
        newNode.left = null;
        newNode.right = null;

        if(this.root == null){
            this.root= newNode;
        }

        else{
            this.root.addNode(newNode);

        }
    }

    /**
        Tries to find an object in the tree.
        @param obj the object to find
        @return true if the object is contained in the tree
    */
    public boolean find(Comparable obj)
    {
        
        Node current = this.root; // need to start at the root (current node)
        

        // we want a loop that runs while current is not equal to null

        while(current!=null){
            
            int diff = obj.compareTo(current.data); //finds the difference between the current node and the node we want to find

            if(diff == 0){ // found the node
                return true;
            }
            else if(diff< 0){
                current = current.left; //moving down the tree if the node is not found
            }
            else if(diff>0){
                current = current.right;
            }

        }
        
        
        
        return false; // returns false if the node isn't ound during the loop
    }
    
    /**
        Tries to remove an object from the tree. Does nothing
        if the object is not contained in the tree.
        @param obj the object to remove
    */
    public void remove(Comparable obj)
    {
        Node remove = this.root;

        Node parent = null; // need to keep track of the parent in case we are removing a parent with a child

        // the child needs to be connected to the previous parent

        boolean found = false;

        // we want to find the object to remove

        while(!found && remove != null){ // the second part is there just in case we find a node with no child
            int diff = obj.compareTo(remove.data);
            if(diff == 0){
                found = true;
            }

            else{
                parent = remove;

                if(diff<0){
                    remove = remove.left;

                }

                else{
                    remove = remove.right;
                }
            }
        }// outside the while loop

        if(!found){
            return;
        }


        // Case 1 and 2 (One child is null) (reconnecting children)

        if(remove.left == null || remove.right == null){ // just one of the has to equal null
            Node newChild;

            if(remove.left == null){
                newChild = remove.right;

            }

            else{
                newChild = remove.left;
            }

            if(parent == null){
                this.root = newChild;

            }
            else if(parent.left == remove){
                parent.left = newChild;
            }

            else{
                parent.right = newChild;
            }

            return;
        }
        
        // Case 3 (let's say it has two children)

        // we have to find the least element of the right sub tree

        Node leastparent = remove;
        Node least = remove.right;

        while(least.left !=null){
            leastparent = least;
            least = least.left;

        
        }

        // we want to move the data

        remove.data = least.data;

        // Unlink the least child

        if(leastparent == remove){
            leastparent.right = least.right;
        }
        else{
            leastparent.left = least.right;
        }
    }
    
    /**
        Prints the contents of the tree in sorted order.
    */
    public void print()
    {   
        print(this.root);
        System.out.println();


    }   

    /**
        Prints a node and all of its descendants in sorted order.
        @param parent the root of the subtree to print
    */
    private static void print(Node parent)
    {   
        if(parent==null){
            return;
        }

        print(parent.left);

        System.out.println(parent.data+" ");

        print(parent.right);

        
    }

    /**
        A node of a tree stores a data item and references
        to the left and right child nodes.
    */
    static class Node
    {   
        public Comparable data;

        // A bst has to be made up of comparable objects

        public Node left;
        public Node right;


        /**
            Inserts a new node as a descendant of this node.
            @param newNode the node to insert
        */
        public void addNode(Node newNode)
        {   
            //Adding a new node as a descendant of the current node
            // we need to figure out if it is going to be to the left or right of the current node

            int diff= newNode.data.compareTo(data);

            // <0, newNode is to the left
            // >0, newNode is to the right

            if(diff<0){
                //means that the output is to the left

                if(left == null){
                    left = newNode; // this is easy because the new number will go to the left of the node automatically if there is nothing there
                    // recursively calling this method to figure out where the node goes. 
                }

                else{
                    left.addNode(newNode); //calling again
                }

            }
            // same thing for the right side

            if(diff>0){
                //means that the output is to the right

                if(right == null){
                    right = newNode; // this is easy because the new number will go to the left of the node automatically if there is nothing there
                    // recursively calling this method to figure out where the node goes. 
                }

                else{
                    right.addNode(newNode); //calling again
                }

            }
            // We do not do an if statement for diff = 0 because binary search trees don't hold duplicates. 

        }
    }
}



