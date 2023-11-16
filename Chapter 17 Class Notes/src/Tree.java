import java.util.List;
import java.util.ArrayList;

/**
    A tree in which each node has an arbitrary number of children.
*/
public class Tree
{
    
    static class Node
    {
        
        public List<Node> children;
        // we need to know the children

        public Object data; // we need to know what's being stored

        /**
            Computes the size of the subtree whose root is this node.
            @return the number of nodes in the subtree
        */
        public int size()
        {

            int sum = 1;
            for (Node child : this.children){

                sum += child.size(); // recursive call to ultimately reach a leaf. 

            }
            return sum;
        }
    }

    /**
        Constructs a tree with one node and no children.
        @param rootData the data for the root
    */
    private Node root;
    public Tree(Object rootData)
    {
        //there will always be a root
        this.root = new Node();
        this.root.data = rootData;


        this.root.children = new ArrayList<>();
        
    }

    /**
        Adds a subtree as the last child of the root.
    */
    public void addSubtree(Tree subtree)
    {
        this.root.children.add(subtree.root); // going to add the root of the tree, containing the whole subtree
    }

    /**
        Computes the size of this tree.
        @return the number of nodes in the tree
    */
    public int size() 
    {
        
        return this.root.size();
    }

    // Additional methods will be added in later sections.



    /*
    A visitor whose visit method is called for each visited node
    during a tree traversal
     */ 

    public interface Visitor{
        // the visit method is cald for each visited node

        void visit(Object data);
    }

    /*
     * Travrse this tree in preorder
     * @param v = the visitor to be invoked at5 each node
     */

    public void preorder(Visitor v){
        // we need to make a helper method for preorder

        Tree.preorder(this.root, v);
    }

    /*
     * Traverse the tree wiith a given root in preorder
     * @param n: The root of the tree to traverse
     * @param v: The visitor to be invoked at each node
     */

    private static void preorder(Node n, Visitor v){
        if(n==null){
            return;
        }

        v.visit(n.data);

        // we don't know what visit is doing with the data yet

        for(Node child: n.children){
            Tree.preorder(child, v);

        }
    }




    public int leafCount{
        int sum = 0;
        
        if (children.size() == 0){
            sum = 1;
        }
        
        for(Node child: children){
            sum = sum+child.leafCount();}
        }
        return sum
        }
    }
}
