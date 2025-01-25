// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of
// those who do.
// -- Ryan Pini (rtpini18)

package prj5;

import student.TestCase;

/**
 * Tests the CompareByTraditionalRate class
 * 
 * @author rtpini
 * @version Nov 28, 2023
 */
public class CompareByTraditionalRateTest
    extends TestCase
{
    // ~ Fields ................................................................
    private Channel channel1;
    private Channel lessThanChannel1;
    private Channel greaterThanChannel1;
    private Channel equalToChannel1;
    private CompareByTraditionalRate compareRates;

    // ~ Constructors ..........................................................

    /**
     * Sets up the test cases
     */
    public void setUp()
    {

        compareRates = new CompareByTraditionalRate();
        channel1 = new Channel(
            "December",
            "user4",
            "channel4",
            "Italy",
            "Food",
            1,
            1,
            1,
            1,
            1);

        lessThanChannel1 = new Channel(
            "December",
            "user4",
            "channel4",
            "Italy",
            "Food",
            1,
            1,
            2,
            1,
            1);

        greaterThanChannel1 = new Channel(
            "December",
            "user4",
            "channel4",
            "Italy",
            "Food",
            1,
            1,
            1,
            2,
            1);

        equalToChannel1 = new Channel(
            "December",
            "user4",
            "channel4",
            "Italy",
            "Food",
            1,
            1,
            1,
            1,
            1);

    }

    // ~Public Methods ........................................................


    /**
     * Tests the compare() method
     */
    public void testCompare()
    {

        assertEquals(1, compareRates.compare(channel1, lessThanChannel1));
        assertEquals(-1, compareRates.compare(channel1, greaterThanChannel1));
        assertEquals(0, compareRates.compare(channel1, equalToChannel1));
    }

}
