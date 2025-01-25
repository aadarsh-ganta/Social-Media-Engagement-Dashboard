// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of
// those who do.
// -- Aadarsh

package prj5;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test CompareByName class
 * 
 * @author Aadarsh
 * @version Nov 19, 2023
 */
public class CompareByNameTest
    extends TestCase
{
    // ~ Fields ................................................................
    private Channel channel1;
    private Channel channel2;
    private Channel channel3;
    private CompareByName comparator = new CompareByName();

    // ~Public Methods ........................................................
    /**
     * Sets up test methods
     */
    public void setUp()
    {
        channel1 = new Channel(
            "January",
            "user1",
            "channel1",
            "USA",
            "Sports",
            5,
            10,
            15,
            20,
            25);
        channel2 = new Channel(
            "May",
            "user2",
            "channel2",
            "Canada",
            "Film",
            10,
            20,
            30,
            40,
            50);
        channel3 = new Channel(
            "January",
            "user3",
            "channel1",
            "Spain",
            "Music",
            10,
            100,
            1000,
            10000,
            100000);
    }


    /**
     * Tests compare method
     */
    public void testCompare()
    {
        int comparison = comparator.compare(channel1, channel2);
        assertEquals(-1, comparison);
        int comparison1 = comparator.compare(channel2, channel1);
        assertEquals(1, comparison1);
        System.out.println(
            channel1.getChannelName().compareTo(channel3.getChannelName()));
        int comparison2 = comparator.compare(channel1, channel3);
        assertEquals(0, comparison2);
    }
}
