// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of
// those who do.
// -- Hudson Rothschild

package prj5;

import java.util.Scanner;
import student.IOHelper;

// -------------------------------------------------------------------------
/**
 * Reads and converts the text in the file to be utilized in the program
 * 
 * @author Hudson Rothschild
 * @version Nov 14, 2023
 */
public class InputFileReader
{
    // ~ Fields ................................................................
    private DoublyLinkedList<Channel> januaryChannels;
    private DoublyLinkedList<Channel> februaryChannels;
    private DoublyLinkedList<Channel> marchChannels;
    private DoublyLinkedList<String[]> channelNameList;
    // ----------------------------------------------------------
    /**
     * Create a new InputFileReader object.
     * 
     * @param fileName
     *            : name of the file
     */
    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    /**
     * Creates the InputFileReader objects and reads the file to create channel
     * lists for each month
     * 
     * @param fileName
     *            : name of the file
     */
    public InputFileReader(String fileName)
    {
        getChannels(fileName);
        januaryChannels = readOnlyMonth(fileName, "January");
        februaryChannels = readOnlyMonth(fileName, "February");
        marchChannels = readOnlyMonth(fileName, "March");
    }


    // ----------------------------------------------------------
    /**
     * Reads through and gets names of all channels included in data
     * 
     * @return DoublyLinkedList<String> : list of info from the file
     * @param file
     *            : name of the file
     */
    public DoublyLinkedList<String[]> getChannels(String file)
    {
        channelNameList = new DoublyLinkedList<String[]>();

        Scanner inStream = IOHelper.createScanner(file);
        inStream.nextLine();// skip header
        while (inStream.hasNextLine())
        {
            String line = inStream.nextLine().replaceAll(" ", "");
            String[] values = line.split(",");

            if (this.validMonth(values[0]))
            {
                String username = values[1];
                String channel = values[2];
                String country = values[3];
                String mainTopic = values[4];
                String[] channelDetails = new String[4];
                channelDetails[0] = username;
                channelDetails[1] = channel;
                channelDetails[2] = country;
                channelDetails[3] = mainTopic;

                boolean listContains = false;
                if (!channelNameList.isEmpty())
                {
                    Node<String[]> curr = channelNameList.getNodeAtIndex(0);
                    while (curr.next() != null)
                    {
                        if (curr.getData()[0].equals(channelDetails[0]))
                        {
                            listContains = true;
                        }
                        curr = curr.next();
                    }
                }

                if (!listContains)
                {
                    channelNameList.add(channelDetails);
                }
            }
        }
        return channelNameList;
    }


    /**
     * Reads through and sorts the file according to month inputed
     * 
     * @param file
     *            : name of the file
     * @param month
     *            : month of channels to read.
     * @return Channel[] : array of info from the file
     */
    public DoublyLinkedList<Channel> readOnlyMonth(String file, String month)
    {
        DoublyLinkedList<Channel> channelList = new DoublyLinkedList<Channel>();

        Scanner inStream = IOHelper.createScanner(file);
        inStream.nextLine();// skip header
        while (inStream.hasNextLine())
        {
            String line = inStream.nextLine().replaceAll(" ", "");
            String[] values = line.split(",");

            if (values[0].equals(month))
            {
                String username = values[1];
                String channel = values[2];
                String country = values[3];
                String mainTopic = values[4];
                int likes = toInt(values[5]);
                int posts = toInt(values[6]);
                int followers = toInt(values[7]);
                int comments = toInt(values[8]);
                int views = toInt(values[9]);

                Channel newChannel = new Channel(
                    month,
                    username,
                    channel,
                    country,
                    mainTopic,
                    likes,
                    posts,
                    followers,
                    comments,
                    views);
                channelList.addToFront(newChannel);
            }
        }

        String channel1 = channelNameList.get(0)[0];
        String channel2 = channelNameList.get(1)[0];
        String channel3 = channelNameList.get(2)[0];
        String channel4 = channelNameList.get(3)[0];
        boolean containsChannel1 = false;
        boolean containsChannel2 = false;
        boolean containsChannel3 = false;
        boolean containsChannel4 = false;

        Node<Channel> curr = channelList.getNodeAtIndex(0);
        while (curr.next() != null)
        {
            if (curr.getData().getUsername().equals(channel1))
            {
                containsChannel1 = true;
            }
            else if (curr.getData().getUsername().equals(channel2))
            {
                containsChannel2 = true;
            }
            else if (curr.getData().getUsername().equals(channel3))
            {
                containsChannel3 = true;
            }
            else if (curr.getData().getUsername().equals(channel4))
            {
                containsChannel4 = true;
            }
            curr = curr.next();
        }

        if (!containsChannel1)
        {
            String username = channelNameList.get(0)[0];
            String channelName = channelNameList.get(0)[1];
            String country = channelNameList.get(0)[2];
            String mainTopic = channelNameList.get(0)[3];
            Channel addChannel = new Channel(
                month,
                username,
                channelName,
                country,
                mainTopic,
                0,
                0,
                0,
                0,
                0);
            channelList.add(addChannel);
        }

        if (!containsChannel2)
        {
            String username = channelNameList.get(1)[0];
            String channelName = channelNameList.get(1)[1];
            String country = channelNameList.get(1)[2];
            String mainTopic = channelNameList.get(1)[3];
            Channel addChannel = new Channel(
                month,
                username,
                channelName,
                country,
                mainTopic,
                0,
                0,
                0,
                0,
                0);
            channelList.add(addChannel);
        }

        if (!containsChannel3)
        {
            String username = channelNameList.get(2)[0];
            String channelName = channelNameList.get(2)[1];
            String country = channelNameList.get(2)[2];
            String mainTopic = channelNameList.get(2)[3];
            Channel addChannel = new Channel(
                month,
                username,
                channelName,
                country,
                mainTopic,
                0,
                0,
                0,
                0,
                0);
            channelList.add(addChannel);
        }

        if (!containsChannel4)
        {
            String username = channelNameList.get(3)[0];
            String channelName = channelNameList.get(3)[1];
            String country = channelNameList.get(3)[2];
            String mainTopic = channelNameList.get(3)[3];
            Channel addChannel = new Channel(
                month,
                username,
                channelName,
                country,
                mainTopic,
                0,
                0,
                0,
                0,
                0);
            channelList.add(addChannel);
        }

        return channelList;
    }


    /**
     * getJanuaryChannels method
     * 
     * @return DoublyLinkedList<Channel> channel list
     */
    public DoublyLinkedList<Channel> getJanuaryChannels()
    {
        return januaryChannels;
    }


    /**
     * getFebruaryChannels method
     * 
     * @return DoublyLinkedList<Channel> channel list
     */
    public DoublyLinkedList<Channel> getFebruaryChannels()
    {
        return februaryChannels;
    }


    /**
     * getMarchChannels method
     * 
     * @return DoublyLinkedList<Channel> channel list
     */
    public DoublyLinkedList<Channel> getMarchChannels()
    {
        return marchChannels;
    }


    /**
     * getChannels method
     * 
     * @return DoublyLinkedList<Channel> channel list
     */
    public DoublyLinkedList<Channel> getChannels()
    {
        DoublyLinkedList<Channel> newChannelList =
            new DoublyLinkedList<Channel>();
        januaryChannels.insertionSort(new CompareByName());
        februaryChannels.insertionSort(new CompareByName());
        marchChannels.insertionSort(new CompareByName());

        for (int i = 0; i < 4; i++)
        {

            Channel channeliJanuary = januaryChannels.get(i);
            Channel channeliFebruary = februaryChannels.get(i);
            Channel channeliMarch = marchChannels.get(i);

            String month = "Q1";
            String username = channeliJanuary.getUsername();
            String channel = channeliJanuary.getChannelName();
            String country = channeliJanuary.getCountry();
            String mainTopic = channeliJanuary.getMainTopic();

            int likes = channeliJanuary.getLikes() + channeliFebruary.getLikes()
                + channeliMarch.getLikes();
            int posts = channeliJanuary.getPosts() + channeliFebruary.getPosts()
                + channeliMarch.getPosts();
            int followers = channeliMarch.getFollowers();
            int comments = channeliJanuary.getComments()
                + channeliFebruary.getComments() + channeliMarch.getComments();
            int views = channeliJanuary.getViews() + channeliFebruary.getViews()
                + channeliMarch.getViews();

            Channel newChannel = new Channel(
                month,
                username,
                channel,
                country,
                mainTopic,
                likes,
                posts,
                followers,
                comments,
                views);
            newChannelList.addToFront(newChannel);
        }
        return newChannelList;
    }


    /**
     * Converts strings to an integer
     * 
     * @return string as integer
     */
    private int toInt(String str)
    {
        try
        {
            return Integer.parseInt(str);
        }
        catch (Exception e)
        {
            return 0;
        }
    }


    /**
     * Checks that that the string is a valid month
     * 
     * @param month
     *            month string to be checked
     * @return true if valid month; otherwise return false
     */
    private boolean validMonth(String month)
    {

        String[] months =
            { "January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December" };

        for (String valid : months)
        {

            if (month.equals(valid))
            {

                return true;
            }
        }
        return false;
    }


    /**
     * getChannelNameList method
     * 
     * @return DoublyLinkedList<String> channelNameList
     */
    public DoublyLinkedList<String[]> getChannelNameList()
    {
        return channelNameList;
    }
}
