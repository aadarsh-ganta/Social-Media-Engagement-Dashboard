// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of
// those who do.
// -- Hudson Rothschild

package prj5;

import java.io.IOException;
import java.text.DecimalFormat;

// -------------------------------------------------------------------------
/**
 * Runs the program
 * 
 * @author Hudson Rothschild
 * @version Nov 14, 2023
 */
public class ProjectRunner
{
    // ~ Fields ................................................................

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    /**
     * Creates the overall program
     * 
     * @param args
     *            String array of arguements
     * @throws IOException
     */
    public static void main(String args[])
        throws IOException
    {
        InputFileReader filer;

        if (args.length > 0)
        {
            filer = new InputFileReader(args[0]);
        }
        else
        {
            filer = new InputFileReader("SampleInput1_2023.csv");
        }
        DoublyLinkedList<Channel> JanuaryList = filer.getJanuaryChannels();
        DoublyLinkedList<Channel> FebruaryList = filer.getFebruaryChannels();
        DoublyLinkedList<Channel> MarchList = filer.getMarchChannels();
        DoublyLinkedList<Channel> Quarter1List = filer.getChannels();

        boolean showConsole = false;
        boolean showGUI = true;

        if (showConsole)
        {
            /*
             * TODO: For intermediate Submission - Should print the data on the
             * console
             */
            final String PATTERN = "#.#";
            final DecimalFormat dc = new DecimalFormat(PATTERN);

            CompareByName compareByName = new CompareByName();
            Quarter1List.insertionSort(compareByName);
            Node<Channel> current = Quarter1List.getNodeAtIndex(0);
            while (current.getData() != null)
            {
                Channel channel = current.getData();
                System.out.println(channel.getChannelName());
                System.out.println("traditional: ");
                System.out
                    .println(dc.format(channel.traditionalEngagementRate()));
                System.out.println("==========");
                current = current.next();
            }
            System.out.println("**********");
            System.out.println("**********");
            CompareByReachRate compareByReachRate = new CompareByReachRate();
            Quarter1List.insertionSort(compareByReachRate);
            Node<Channel> current1 =
                Quarter1List.getNodeAtIndex(Quarter1List.size() - 1);
            while (current1.getData() != null)
            {
                Channel channel1 = current1.getData();
                System.out.println(channel1.getChannelName());
                System.out.println("reach: ");
                System.out.println(dc.format(channel1.engagementRateByReach()));
                System.out.println("==========");
                current1 = current1.prev();
            }
        }
        if (showGUI)
        {
            GUI gui =
                new GUI(JanuaryList, FebruaryList, MarchList, Quarter1List);

        }
    }
}
