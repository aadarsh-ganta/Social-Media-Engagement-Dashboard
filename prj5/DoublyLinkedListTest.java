// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of 
//those who do.
// -- Aadarsh

package prj5;

import student.TestCase;
// -------------------------------------------------------------------------
/**
 *  Test for DoublyLinkedList class
 * 
 *  @author Aadarsh
 *  @version Nov 16, 2023
 */
public class DoublyLinkedListTest extends TestCase
{
    //~ Fields ................................................................
    private DoublyLinkedList<String> list;

    //~Public  Methods ........................................................
    /**
     * Sets up test methods
     */
    public void setUp() {
        list = new DoublyLinkedList<String>();
        list.addToFront("A");
        list.addToFront("B");
        list.add("C");
    }
    

    /**
     * Tests size method
     */
    public void testSize() {
        assertEquals(3, list.size());
        list.clear();
        assertEquals(0, list.size());
    }
    
    /**
     * Tests addToFront method
     */
    public void testAddToFront() {
        assertEquals(3, list.size());
        list.addToFront("D");
        assertEquals(4, list.size());
        assertEquals("B", list.get(1));
    }
    
    /**
     * Tests adding to back method
     */
    public void testAddBack() {
        assertEquals(3, list.size());
        list.add("D");
        assertEquals(4, list.size());
        assertEquals("D", list.get(3));
    }
    
    /**
     * Tests adding at index method
     */
    public void testAddIndex() {
        assertEquals("B", list.get(0));
        assertEquals(3, list.size());
        list.add(2, "D");
        assertEquals("D", list.get(2));
        list.add(2, "C");
        assertEquals("C", list.get(2));
    }
    
    /**
     * Tests get method
     */
    public void testGet()
    {
        assertEquals("B", list.get(0));
        assertEquals("A", list.get(1));
        assertEquals("C", list.get(2));
        
        IndexOutOfBoundsException exception = null;
        try
        {
            list.get(-1);
        }
        catch (IndexOutOfBoundsException e)
        {
            exception = e;
        }
        assertNotNull(exception);
        
        try
        {
            list.get(3);
        }
        catch (IndexOutOfBoundsException e)
        {
            exception = e;
        }
        assertNotNull(exception);
    }
    
    /**
     * Tests getNodeAtIndex method
     */
    public void testGetNodeAtIndex() {
        assertEquals("B", list.getNodeAtIndex(0).getData());
        assertEquals("A", list.getNodeAtIndex(1).getData());
        assertEquals("C", list.getNodeAtIndex(2).getData());
        
        IndexOutOfBoundsException exception = null;
        try
        {
            list.getNodeAtIndex(-1);
        }
        catch (IndexOutOfBoundsException e)
        {
            exception = e;
        }
        assertNotNull(exception);
        
        try
        {
            list.getNodeAtIndex(3);
        }
        catch (IndexOutOfBoundsException e)
        {
            exception = e;
        }
        assertNotNull(exception);
    }
    
    /**
     * Tests lastIndexOf method
     */
    public void testLastIndexOf()
    {
        assertEquals(2, list.lastIndexOf("C"));
        assertEquals(1, list.lastIndexOf("A"));
        assertEquals(0, list.lastIndexOf("B"));
        list.addToFront("A");
        assertEquals(2, list.lastIndexOf("A"));
        assertEquals(-1, list.lastIndexOf("Data Not Found"));
    }
    
    /**
     * Tests isEmpty method
     */
    public void testIsEmpty()
    {
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }
    
    /**
     * Tests contains method
     */
    public void testContains()
    {
        assertTrue(list.contains("A"));
        assertFalse(list.contains("Data Not Found"));
    }
    
    /**
     * Tests remove from front method
     */
    public void testRemove() {
        assertFalse(list.remove(null));
        assertTrue( list.remove("A"));
        assertEquals("B", list.get(0));
        assertEquals(2, list.size());
        list.add("D");
        assertTrue(list.remove("D"));
        assertEquals("B", list.get(0));
    }
    
    /**
     * Tests remove at index method
     */
    public void testRemoveIndex()
    {
        assertTrue(list.remove("A"));
        assertEquals("C", list.get(1));
        assertEquals(2, list.size());
        assertFalse(list.remove("A"));
        assertTrue(list.remove(1));
        assertEquals("B", list.get(0));
        assertEquals(1, list.size());
        
        IndexOutOfBoundsException exception = null;
        try
        {
            list.remove(-1);
        }
        catch (IndexOutOfBoundsException e)
        {
            exception = e;
        }
        assertNotNull(exception);
        
        try
        {
            list.remove(3);
        }
        catch (IndexOutOfBoundsException e)
        {
            exception = e;
        }
        assertNotNull(exception);
    }
    
    /**
     * Tests clear method
     */
    public void testClear() {
        assertEquals(3, list.size());
        list.clear();
        assertEquals(0, list.size());
    }
    
    /**
     * Tests toString method
     */
    public void testToString()
    {
        assertEquals("{B, A, C}", list.toString());
        list.clear();
        assertEquals("{}", list.toString());
    }
    
    /**
     * Tests insertionSort method
     */
    public void testInsertionSort() {
        CompareByName compareByName = new CompareByName();
        Channel quarter1 = new Channel("January", "user1", "channel1", "USA", 
            "Sports", 5, 10, 15, 20, 25);
        
        Channel quarter2 = new Channel("May", "user2", "channel2", "Canada",
            "Film", 10, 20, 30, 40, 50);
        
        Channel quarter3 = new Channel("July", "user3", "channel3", "Spain", 
            "Music", 10, 100, 1000, 10000, 100000);
        DoublyLinkedList<Channel> list1 = new DoublyLinkedList<Channel>();
        list1.addToFront(quarter2);
        list1.addToFront(quarter3);
        list1.addToFront(quarter1);
        assertEquals("{channel1, channel3, channel2}", list1.toString());
        list1.insertionSort(compareByName);       
        assertEquals("{channel1, channel2, channel3}", list1.toString());
    }
}
