// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of
// those who do.
// -- Ryan Pini (rtpini18)

package prj5;

import student.TestCase;

/**
 * Tests the Channel Class
 * 
 * @author rtpini
 * @version Nov 17, 2023
 */
public class ChannelTest
    extends TestCase
{
    // ~ Fields ................................................................
    private Channel quarter1;
    private Channel quarter2;
    private Channel quarter3;
    private Channel quarter4;

    // ~ Constructors ..........................................................
    /**
     * Sets up test methods
     */
    public void setUp()
    {

        quarter1 = new Channel(
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

        quarter2 = new Channel(
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

        quarter3 = new Channel(
            "July",
            "user3",
            "channel3",
            "Spain",
            "Music",
            10,
            100,
            1000,
            10000,
            100000);

        quarter4 = new Channel(
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
     * Tests the getMonth() method
     */
    public void testGetMonth()
    {

        assertEquals("January", quarter1.getMonth());
        assertEquals("May", quarter2.getMonth());
        assertEquals("July", quarter3.getMonth());
        assertEquals("December", quarter4.getMonth());
    }


    /**
     * Tests the getUsername() method
     */
    public void testGetUsername()
    {

        assertEquals("user1", quarter1.getUsername());
        assertEquals("user2", quarter2.getUsername());
        assertEquals("user3", quarter3.getUsername());
        assertEquals("user4", quarter4.getUsername());
    }


    /**
     * Tests the getChannelName() method
     */
    public void testGetChannelName()
    {

        assertEquals("channel1", quarter1.getChannelName());
        assertEquals("channel2", quarter2.getChannelName());
        assertEquals("channel3", quarter3.getChannelName());
        assertEquals("channel4", quarter4.getChannelName());
    }


    /**
     * Tests the getCountry() method
     */
    public void testGetCountry()
    {

        assertEquals("USA", quarter1.getCountry());
        assertEquals("Canada", quarter2.getCountry());
        assertEquals("Spain", quarter3.getCountry());
        assertEquals("Italy", quarter4.getCountry());
    }


    /**
     * Tests the getMainTopic() method
     */
    public void testGetMainTopic()
    {

        assertEquals("Sports", quarter1.getMainTopic());
        assertEquals("Film", quarter2.getMainTopic());
        assertEquals("Music", quarter3.getMainTopic());
        assertEquals("Food", quarter4.getMainTopic());
    }


    /**
     * Tests the getUsername() method
     */
    public void testGetQuarter()
    {

        Channel february = new Channel(
            "February",
            "user4",
            "channel4",
            "Italy",
            "Food",
            1,
            1,
            1,
            1,
            1);
        Channel march = new Channel(
            "March",
            "user4",
            "channel4",
            "Italy",
            "Food",
            1,
            1,
            1,
            1,
            1);
        Channel april = new Channel(
            "April",
            "user4",
            "channel4",
            "Italy",
            "Food",
            1,
            1,
            1,
            1,
            1);
        Channel june = new Channel(
            "June",
            "user4",
            "channel4",
            "Italy",
            "Food",
            1,
            1,
            1,
            1,
            1);
        Channel august = new Channel(
            "August",
            "user4",
            "channel4",
            "Italy",
            "Food",
            1,
            1,
            1,
            1,
            1);
        Channel september = new Channel(
            "September",
            "user4",
            "channel4",
            "Italy",
            "Food",
            1,
            1,
            1,
            1,
            1);

        assertEquals("First", quarter1.getQuarter());
        assertEquals("First", february.getQuarter());
        assertEquals("First", march.getQuarter());
        assertEquals("Second", april.getQuarter());
        assertEquals("Second", quarter2.getQuarter());
        assertEquals("Second", june.getQuarter());
        assertEquals("Third", quarter3.getQuarter());
        assertEquals("Third", august.getQuarter());
        assertEquals("Third", september.getQuarter());
        assertEquals("Fourth", quarter4.getQuarter());

    }


    /**
     * Tests the getLikes() method
     */
    public void testGetLikes()
    {

        assertEquals(5, quarter1.getLikes());
        assertEquals(10, quarter2.getLikes());
        assertEquals(10, quarter3.getLikes());
        assertEquals(1, quarter4.getLikes());
    }


    /**
     * Tests the getPosts() method
     */
    public void testGetPosts()
    {

        assertEquals(10, quarter1.getPosts());
        assertEquals(20, quarter2.getPosts());
        assertEquals(100, quarter3.getPosts());
        assertEquals(1, quarter4.getPosts());
    }


    /**
     * Tests the getFollowers() method
     */
    public void testGetFollowers()
    {

        assertEquals(15, quarter1.getFollowers());
        assertEquals(30, quarter2.getFollowers());
        assertEquals(1000, quarter3.getFollowers());
        assertEquals(1, quarter4.getFollowers());
    }


    /**
     * Tests the getComments() method
     */
    public void testGetComments()
    {

        assertEquals(20, quarter1.getComments());
        assertEquals(40, quarter2.getComments());
        assertEquals(10000, quarter3.getComments());
        assertEquals(1, quarter4.getComments());
    }


    /**
     * Tests the getViews() method
     */
    public void testGetViews()
    {

        assertEquals(25, quarter1.getViews());
        assertEquals(50, quarter2.getViews());
        assertEquals(100000, quarter3.getViews());
        assertEquals(1, quarter4.getViews());
    }


    /**
     * Tests the addLikes() method
     */
    public void testAddLikes()
    {

        assertEquals(1, quarter4.getLikes());
        quarter4.addLikes(1);
        assertEquals(2, quarter4.getLikes());
    }


    /**
     * Tests the addPosts() method
     */
    public void testAddPosts()
    {

        assertEquals(1, quarter4.getPosts());
        quarter4.addPosts(1);
        assertEquals(2, quarter4.getPosts());
    }


    /**
     * Tests the addFollowers() method
     */
    public void testAddFollowers()
    {

        assertEquals(1, quarter4.getFollowers());
        quarter4.addFollowers(1);
        assertEquals(2, quarter4.getFollowers());
    }


    /**
     * Tests the addComments() method
     */
    public void testAddComments()
    {

        assertEquals(1, quarter4.getComments());
        quarter4.addComments(1);
        assertEquals(2, quarter4.getComments());
    }


    /**
     * Tests the addViews() method
     */
    public void testAddViews()
    {

        assertEquals(1, quarter4.getViews());
        quarter4.addViews(1);
        assertEquals(2, quarter4.getViews());
    }


    /**
     * Tests the traditionalEngagementRate() method
     */
    public void testTraditionalEngagementRate()
    {

        assertEquals(167.0, quarter1.traditionalEngagementRate(), 0.999);
        assertEquals(167.0, quarter2.traditionalEngagementRate(), 0.999);
        assertEquals(1001.0, quarter3.traditionalEngagementRate(), 0.999);
        assertEquals(200.0, quarter4.traditionalEngagementRate(), 0.999);
    }


    /**
     * Tests the engagementRateByReach() method
     */
    public void testEngagementRateByReach()
    {

        assertEquals(100.0, quarter1.engagementRateByReach(), 0.999);
        assertEquals(100.0, quarter2.engagementRateByReach(), 0.999);
        assertEquals(10.01, quarter3.engagementRateByReach(), 0.999);
        assertEquals(200.0, quarter4.engagementRateByReach(), 0.999);
    }
}
