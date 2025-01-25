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
 * Compares the channels by their name and implements Comparator.
 * 
 * @author Aadarsh
 * @version Nov 16, 2023
 */
public class CompareByName
    implements Comparator<Channel>
{
    /**
     * Checks if one channel's name is greater than, less than, or equal to
     * another channel.
     * 
     * @param channel1
     *            channel object
     * @param channel2
     *            other channel to be compared with
     * @return 1 if channel1 is greater, -1 if channel1 is less, and 0 if they
     *             are equal
     */
    @Override
    public int compare(Channel channel1, Channel channel2)
    {
        double difference = channel1.getChannelName()
            .compareToIgnoreCase(channel2.getChannelName());
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
