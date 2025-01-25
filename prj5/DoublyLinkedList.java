// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of
// those who do.
// -- Jeb Brown

package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * Represents a doubly linked list with sentinel nodes.
 * 
 * @author jebbrown
 * @version Nov 14, 2023
 * @param <T>
 */
public class DoublyLinkedList<T>
    implements LList<T>
{
    // ~ Fields ................................................................

    private Node<T> head; // Reference to first sentinel node
    private Node<T> tail; // Reference to last sentinel node
    private int numberOfEntries;

    // ~ Constructors ..........................................................

    /**
     * default constructor
     */
    public DoublyLinkedList()
    {
        head = new Node<T>(null);
        tail = new Node<T>(null);
        head.setNext(tail);
        tail.setPrev(head);
        numberOfEntries = 0;
    } // end default constructor

    // ~Public Methods ........................................................


    /**
     * size method
     * 
     * @return numberOfEntries
     */
    @Override
    public int size()
    {
        return numberOfEntries;
    }


    /**
     * addToFront method
     * 
     * @param newEntry
     *            entry to be added
     */
    public void addToFront(T newEntry)
    {
        // Add to beginning of chain:
        Node<T> newNode = new Node<T>(newEntry);
        head.next().setPrev(newNode);
        newNode.setPrev(head); // Make new node reference rest of chain
        newNode.setNext(head.next());
        head.setNext(newNode); // New node is at beginning of chain
        numberOfEntries++;

    } // end addToFront


    /**
     * add to back method
     * 
     * @param newEntry
     *            new entry to be added
     */
    @Override
    public void add(T newEntry)
    {
        // Add to end of chain:
        Node<T> newNode = new Node<T>(newEntry);
        tail.prev().setNext(newNode);
        newNode.setPrev(tail.prev());
        newNode.setNext(tail); // Make new node reference rest of chain
        tail.setPrev(newNode); // New node is at end of chain
        numberOfEntries++;
    } // end add


    /**
     * add at index method
     * 
     * @param index
     *            position where object should be added
     * @param obj
     *            object to be added at the specified position
     */
    @Override
    public void add(int index, T obj)
    {
        if (index < 0 || numberOfEntries < index)
        {
            throw new IndexOutOfBoundsException();
        }
        if (obj == null)
        {
            throw new IllegalArgumentException(
                "Cannot add null " + "objects to a list");
        }

        Node<T> nodeAfter;
        if (index == numberOfEntries)
        {
            nodeAfter = tail;
        }
        else
        {
            nodeAfter = getNodeAtIndex(index);
        }

        Node<T> addition = new Node<T>(obj);
        addition.setPrev(nodeAfter.prev());
        addition.setNext(nodeAfter);
        nodeAfter.prev().setNext(addition);
        nodeAfter.setPrev(addition);
        numberOfEntries++;
    }


    /**
     * isEmpty method
     * 
     * @return boolean size
     */
    @Override
    public boolean isEmpty()
    {
        return (size() == 0);
    }


    /**
     * remove from front method
     * 
     * @param removedEntry
     *            entry to be removed
     * @return boolean removed or not
     */
    @Override
    public boolean remove(T removedEntry)
    {
        Node<T> current = head.next();
        while (!current.equals(tail))
        {
            if (current.getData().equals(removedEntry))
            {
                current.prev().setNext(current.next());
                current.next().setPrev(current.prev());
                numberOfEntries--;
                return true;
            }
            current = current.next();
        }
        return false;
    }


    /**
     * remove at index method
     * 
     * @param index
     *            position where object should be removed
     * @return boolean removed or not
     */
    @Override
    public boolean remove(int index)
    {
        if (index < 0 || size() <= index)
        {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head.next();
        int currentIndex = 0;
        while (current != null)
        {
            if (currentIndex == index)
            {
                current.prev().setNext(current.next());
                current.next().setPrev(current.prev());
                numberOfEntries--;
                return true;
            }
            currentIndex++;
            current = current.next();
        }
        return false;
    }


    /**
     * get method
     * 
     * @param index
     *            position at which to get object
     */
    @Override
    public T get(int index)
    {
        Node<T> current = head.next();
        int currentIndex = 0;
        T data = null;
        while (current != null)
        {
            if (currentIndex == index)
            {
                data = current.getData();
            }
            currentIndex++;
            current = current.next();
        }
        if (data == null)
        {
            throw new IndexOutOfBoundsException();
        }
        return data;
    }


    /**
     * gets the node at that index
     * 
     * @param index
     *            position where to get node
     * @return node at index
     */
    public Node<T> getNodeAtIndex(int index)
    {
        if (index < 0 || size() <= index)
        {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head.next();
        for (int i = 0; i < index; i++)
        {
            current = current.next();
        }
        return current;
    }


    /**
     * contains method
     * 
     * @param item
     *            item to be checked if it's in list
     * @return boolean contains
     */
    @Override
    public boolean contains(T item)
    {
        Node<T> current = head.next();
        while (!current.equals(tail))
        {
            if (current.getData().equals(item))
            {
                return true;
            }
            current = current.next();
        }
        return false;
    }


    /**
     * clear method
     */
    @Override
    public void clear()
    {
        head = new Node<T>(null);
        tail = new Node<T>(null);
        head.setNext(tail);
        tail.setPrev(head);
        numberOfEntries = 0;
    }


    /**
     * lastIndexOf method
     * 
     * @param item
     *            item that should be checked where its last index is
     * @return int lastIndexOf
     */
    @Override
    public int lastIndexOf(T item)
    {
        Node<T> current = tail.prev();
        for (int i = size() - 1; i >= 0; i--)
        {
            if (current.getData().equals(item))
            {
                return i;
            }
            current = current.prev();
        }
        return -1;
    }


    /**
     * to String method
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder("{");
        if (!isEmpty())
        {
            Node<T> currentNode = head.next();
            while (currentNode != tail && currentNode != null)
            {
                T item = currentNode.getData();
                builder.append(item.toString());
                if (currentNode.next() != tail)
                {
                    builder.append(", ");
                }
                currentNode = currentNode.next();
            }
        }

        builder.append("}");
        return builder.toString();
    }


    /**
     * insertionSort method
     * 
     * @param comparator
     *            comparator to be used for sorting
     */
    @SuppressWarnings("null")
    public void insertionSort(Comparator<T> comparator)
    {
        if (numberOfEntries > 1)
        {
            Node<T> sortedPart = head.next();
            Node<T> unsortedPart = sortedPart.next();
            sortedPart.setNext(tail);
            tail.setPrev(sortedPart);
            while (unsortedPart.next() != null)
            {
                Node<T> toInsert = unsortedPart;
                unsortedPart = unsortedPart.next();
                insertInOrder(toInsert, comparator);
            }
        }
    }


    /**
     * insertInOrder method
     * 
     * @param toInsert
     *            node to be inserted in list
     * @param comparator
     *            comparator to be used for sorting
     */
    @SuppressWarnings("null")
    private void insertInOrder(Node<T> toInsert, Comparator<T> comparator)
    {
        T item = toInsert.getData();

        if (item == null)
        {
            throw new IllegalArgumentException();
        }

        Node<T> current = head.next();
        boolean inserted = false;

        while (current.next().getData() != null)
        {
            if (!inserted && comparator.compare(item, current.getData()) <= 0)
            {
                current.prev().setNext(toInsert);
                toInsert.setPrev(current.prev());
                toInsert.setNext(current);
                current.setPrev(toInsert);
                inserted = true;
            }
            current = current.next();
        }

        if (!inserted)
        {
            if (comparator.compare(item, current.getData()) <= 0)
            {
                current.prev().setNext(toInsert);
                toInsert.setPrev(current.prev());
                toInsert.setNext(current);
                current.setPrev(toInsert);
            }
            else
            {
                current.setNext(toInsert);
                toInsert.setPrev(current);
                toInsert.setNext(tail);
            }
            inserted = true;
        }
    }
}
