// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of
// those who do.
// -- Jeb Brown

package prj5;

// -------------------------------------------------------------------------
/**
 * Represents a node that can be used to store data in a list.
 * 
 * @author jebbrown
 * @version Nov 14, 2023
 * @param <T>
 */
public class Node<T>
{
    // ~ Fields ................................................................

    private T data;
    private Node<T> next; // Link to next node
    private Node<T> prev; // Link to previous node

    // ~ Constructors ..........................................................

    /**
     * default constructor
     * 
     * @param dataPortion
     *            data for the node
     */
    public Node(T dataPortion)
    {
        this(dataPortion, null, null);
    } // end constructor


    /**
     * constructor with link to next node
     * 
     * @param dataPortion
     *            data for the node
     * @param prevNode
     *            reference to previous node
     * @param nextNode
     *            reference to next node
     */
    public Node(T dataPortion, Node<T> prevNode, Node<T> nextNode)
    {
        data = dataPortion;
        prev = prevNode;
        next = nextNode;
    }


    // ~Public Methods ........................................................
    /**
     * Gets the next node
     * 
     * @return node after current node
     */
    public Node<T> next()
    {
        return next;
    }


    /**
     * Sets the next node
     * 
     * @param nextNode
     *            assigns next node to current node
     */
    public void setNext(Node<T> nextNode)
    {
        next = nextNode;
    }


    /**
     * Gets the previous node
     * 
     * @return node before current node
     */
    public Node<T> prev()
    {
        return prev;
    }


    /**
     * Sets the previous node
     * 
     * @param prevNode
     *            assigns previous node to current node
     */
    public void setPrev(Node<T> prevNode)
    {
        prev = prevNode;
    }


    /**
     * Gets the data of the node
     * 
     * @return data data of node
     */
    public T getData()
    {
        return data;
    }


    /**
     * Sets the data of node
     * 
     * @param newEntry
     *            sets the data for the node
     */
    public void setData(T newEntry)
    {
        data = newEntry;
    }
}
