// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of
// those who do.
// -- Ryan Pini (rtpini18)

package prj5;

/**
 * Holds the information for a channel for one month, including the name of the
 * user and channel, the month, the country, their main topic, and their
 * engagement information. It also checks what quarter the month falls into and
 * calculates both the traditional and by reach engagement rates
 * 
 * @author rtpini
 * @version Nov 17, 2023
 */
public class Channel
{
    // ~ Fields ................................................................
    private String month;
    private String username;
    private String channelName;
    private String country;
    private String mainTopic;
    private String quarter;
    private int likes;
    private int posts;
    private int followers;
    private int comments;
    private int views;

    // ~ Constructors ..........................................................
    /**
     * Create a new Channel object.
     * 
     * @param mon
     *            Entered Month
     * @param user
     *            Entered Username
     * @param channel
     *            Entered Channel Name
     * @param cntry
     *            Entered Country
     * @param topic
     *            Entered Main Topic
     * @param like
     *            Entered Like Count
     * @param post
     *            Entered Post Count
     * @param follow
     *            Entered Follower Count
     * @param comm
     *            Entered Comment Count
     * @param view
     *            Entered View Count
     */
    public Channel(
        String mon,
        String user,
        String channel,
        String cntry,
        String topic,
        int like,
        int post,
        int follow,
        int comm,
        int view)
    {

        this.month = mon;
        this.username = user;
        this.channelName = channel;
        this.country = cntry;
        this.mainTopic = topic;
        this.likes = like;
        this.posts = post;
        this.followers = follow;
        this.comments = comm;
        this.views = view;
        this.setQuarter();
    }

    // ~Public Methods ........................................................


    /**
     * Makes the month field public
     * 
     * @return value stored in month field
     */
    public String getMonth()
    {

        return this.month;
    }


    /**
     * Makes the username field public
     * 
     * @return value stored in username field
     */
    public String getUsername()
    {

        return this.username;
    }


    /**
     * Makes the channelName field public
     * 
     * @return value stored in channelName field
     */
    public String getChannelName()
    {

        return this.channelName;
    }


    /**
     * Makes the country field public
     * 
     * @return value stored in country field
     */
    public String getCountry()
    {

        return this.country;
    }


    /**
     * Makes the mainTopic field public
     * 
     * @return value stored in mainTopic field
     */
    public String getMainTopic()
    {

        return this.mainTopic;
    }


    /**
     * Makes the quarter field public
     * 
     * @return value stored in quarter field
     */
    public String getQuarter()
    {

        return this.quarter;
    }


    /**
     * Makes the likes field public
     * 
     * @return value stored in likes field
     */
    public int getLikes()
    {

        return this.likes;
    }


    /**
     * Makes the posts field public
     * 
     * @return value stored in posts field
     */
    public int getPosts()
    {

        return this.posts;
    }


    /**
     * Makes the followers field public
     * 
     * @return value stored in followers field
     */
    public int getFollowers()
    {

        return this.followers;
    }


    /**
     * Makes the comments field public
     * 
     * @return value stored in comments field
     */
    public int getComments()
    {

        return this.comments;
    }


    /**
     * Makes the views field public
     * 
     * @return value stored in views field
     */
    public int getViews()
    {

        return this.views;
    }


    /**
     * Sets a value to the quarter field based on the month field January,
     * February, March = First Quarter April, May, June = Second Quarter July,
     * August, September = Third Quarter October, November, December = Fourth
     * Quarter
     */
    private void setQuarter()
    {

        if (this.month.equals("January") || this.month.equals("February")
            || this.month.equals("March"))
        {

            this.quarter = "First";
        }

        else if (this.month.equals("April") || this.month.equals("May")
            || this.month.equals("June"))
        {

            this.quarter = "Second";
        }

        else if (this.month.equals("July") || this.month.equals("August")
            || this.month.equals("September"))
        {

            this.quarter = "Third";
        }

        else
        {

            this.quarter = "Fourth";
        }
    }

    /**
     * Returns the channel name as the string representation of channel
     * @return channel name
     */
    public String toString() {
        
        return this.channelName;
    }

    /**
     * Adds to the likes field, used when keeping track of the quarterly numbers
     * 
     * @param add
     *            Number of likes being added
     */
    public void addLikes(int add)
    {

        this.likes += add;
    }


    /**
     * Adds to the posts field, used when keeping track of the quarterly numbers
     * 
     * @param add
     *            Number of posts being added
     */
    public void addPosts(int add)
    {

        this.posts += add;
    }


    /**
     * Adds to the followers field, used when keeping track of the quarterly
     * numbers
     * 
     * @param add
     *            Number of followers being added
     */
    public void addFollowers(int add)
    {

        this.followers += add;
    }


    /**
     * Adds to the comments field, used when keeping track of the quarterly
     * numbers
     * 
     * @param add
     *            Number of comments being added
     */
    public void addComments(int add)
    {

        this.comments += add;
    }


    /**
     * Adds to the views field, used when keeping track of the quarterly numbers
     * 
     * @param add
     *            Number of views being added
     */
    public void addViews(int add)
    {

        this.views += add;
    }


    /**
     * Calculates the traditional engagement rate based on the comments, likes,
     * and followers the channel has within the month
     * 
     * @return the traditional engagement rate using the formula ((comments +
     *             likes)/followers) * 100
     */
    public double traditionalEngagementRate()
    {

        Double commentsDouble = Double.valueOf(this.comments);
        Double likesDouble = Double.valueOf(this.likes);
        Double followersDouble = Double.valueOf(this.followers);
        return ((commentsDouble + likesDouble) / followersDouble) * 100;
    }


    /**
     * Calculates the engagement rate by reach based on the comments, likes, and
     * views the channel has within the month
     * 
     * @return the engagement rate by reach using the formula ((comments +
     *             likes)/views) * 100
     */
    public double engagementRateByReach()
    {

        Double commentsDouble = Double.valueOf(this.comments);
        Double likesDouble = Double.valueOf(this.likes);
        Double viewsDouble = Double.valueOf(this.views);
        return ((commentsDouble + likesDouble) / viewsDouble) * 100;
    }

}
