// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of
// those who do.
// -- Jeb Brown

package prj5;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test for Node class
 * 
 * @author jebbrown
 * @version Nov 17, 2023
 */
public class NodeTest
    extends TestCase
{
    // ~ Fields ................................................................

    private Node<String> testNode1;
    private Node<String> testNode2;

    // ~ Constructors ..........................................................
    /**
     * Sets up test methods
     */
    public void setUp()
    {
        testNode1 = new Node<String>("B");
        testNode2 = new Node<String>("A", null, testNode1);
    }

    // ~Public Methods ........................................................


    /**
     * test next method
     */
    public void testNext()
    {
        assertEquals(null, testNode1.next());
        assertEquals(testNode1, testNode2.next());
    }


    /**
     * test setNext method
     */
    public void testSetNext()
    {
        testNode2.setNext(null);
        testNode1.setNext(testNode2);
        assertEquals(testNode2, testNode1.next());
        assertEquals(null, testNode2.next());
    }


    /**
     * test prev method
     */
    public void testPrev()
    {
        assertEquals(null, testNode1.next());
        assertEquals(testNode1, testNode2.next());
    }


    /**
     * test setPrev method
     */
    public void testSetPrev()
    {
        testNode2.setNext(null);
        testNode1.setNext(testNode2);
        assertEquals(testNode2, testNode1.next());
        assertEquals(null, testNode2.next());
    }


    /**
     * test getData method
     */
    public void testGetData()
    {
        assertEquals("B", testNode1.getData());
        assertEquals("A", testNode2.getData());
    }


    /**
     * test setData method
     */
    public void testSetData()
    {
        testNode1.setData("A");
        testNode2.setData("null");
        assertEquals("A", testNode1.getData());
        assertEquals("null", testNode2.getData());
    }

}
