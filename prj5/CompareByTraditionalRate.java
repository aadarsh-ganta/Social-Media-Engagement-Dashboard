// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of
// those who do.
// -- Aadarsh

package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * Compares the channels by their traditional rate and implements Comparator.
 * 
 * @author Aadarsh
 * @version Nov 16, 2023
 */
public class CompareByTraditionalRate
    implements Comparator<Channel>
{
    /**
     * Checks if one channel's rate is greater than, less than, or equal to
     * another rate.
     * 
     * @param rate1
     *            channel rate
     * @param rate2
     *            other channel rate to be compared with
     * @return 1 if rate1 is greater, -1 if rate1 is less, and 0 if they are
     *             equal
     */
    @Override
    public int compare(Channel rate1, Channel rate2)
    {
        double difference = ((rate1.traditionalEngagementRate())
            - (rate2.traditionalEngagementRate()));

        if (difference > 0)
        {
            return 1;
        }
        if (difference < 0)
        {
            return -1;
        }
        return 0;
    }
}
