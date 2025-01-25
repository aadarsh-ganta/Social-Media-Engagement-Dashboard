// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of
// those who do.
// -- Hudson Rothschild

package prj5;

import cs2.*;
import java.awt.Color;
import java.text.DecimalFormat;

// -------------------------------------------------------------------------
/**
 * Creates the window to display the data
 * 
 * @author Hudson Rothschild
 * @version Nov 28, 2023
 */
public class GUI
{
    // ~ Fields ................................................................
    private Window window;

    private static final TextShape januaryText =
        new TextShape(10, 15, "January");
    private static final TextShape februaryText =
        new TextShape(10, 15, "February");
    private static final TextShape marchText = new TextShape(10, 15, "March");
    private static final TextShape firstQuarterText =
        new TextShape(10, 15, "First Quarter (Jan-March)");
    private static final TextShape traditionalEngagementRateText =
        new TextShape(10, 30, "Traditional Engagement Rate");
    private static final TextShape reachEngagementRateText =
        new TextShape(10, 30, "Reach Engagement Rate");
    private static final TextShape sortByChannelNameText =
        new TextShape(10, 45, "Sorting by Channel Name");
    private static final TextShape sortByEngagementRateText =
        new TextShape(10, 45, "Sorting by Engagement Rate");

    private TextShape channel1NameText;
    private TextShape channel2NameText;
    private TextShape channel3NameText;
    private TextShape channel4NameText;
    private TextShape channel1RateText;
    private TextShape channel2RateText;
    private TextShape channel3RateText;
    private TextShape channel4RateText;

    private Shape channelBar1;
    private Shape channelBar2;
    private Shape channelBar3;
    private Shape channelBar4;

    private DoublyLinkedList<Channel> januaryList;
    private DoublyLinkedList<Channel> februaryList;
    private DoublyLinkedList<Channel> marchList;
    private DoublyLinkedList<Channel> quarterList;

    private Channel currentChannel1;
    private Channel currentChannel2;
    private Channel currentChannel3;
    private Channel currentChannel4;

    private Color color1;
    private Color color2;
    private Color color3;
    private Color color4;

    private static final String PATTERN = "#.#";
    private static final DecimalFormat dc = new DecimalFormat(PATTERN);

    private boolean isJanuary;
    private boolean isFebruary;
    private boolean isMarch;
    private boolean isFirstQuarter;
    private boolean isTraditionalEngagementRate;
    private boolean isReachEngagementRate;
    private boolean isSortByChannelName;
    private boolean isSortByEngagementRate;

    // ~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * Create a new GUI object.
     * 
     * @param januaryList
     *            : List of channels in January
     * @param februaryList
     *            : List of channels in February
     * @param marchList
     *            : List of channels in March
     * @param quarterList
     *            : List of channels in the entire quarter
     */
    public GUI(
        DoublyLinkedList<Channel> januaryList,
        DoublyLinkedList<Channel> februaryList,
        DoublyLinkedList<Channel> marchList,
        DoublyLinkedList<Channel> quarterList)
    {
        this.januaryList = januaryList;
        this.februaryList = februaryList;
        this.marchList = marchList;
        this.quarterList = quarterList;

        this.isJanuary = true;
        this.isFebruary = false;
        this.isMarch = false;
        this.isFirstQuarter = false;
        this.isTraditionalEngagementRate = true;
        this.isReachEngagementRate = false;
        this.isSortByChannelName = true;
        this.isSortByEngagementRate = false;

        this.window = new Window();
        this.window.setSize(1000, 800);
        this.window.setTitle("Social Media Vis");

        this.window.addShape(januaryText);
        this.window.addShape(traditionalEngagementRateText);
        this.window.addShape(sortByChannelNameText);

        this.currentChannel1 = this.januaryList.get(0);
        this.currentChannel2 = this.januaryList.get(1);
        this.currentChannel3 = this.januaryList.get(2);
        this.currentChannel4 = this.januaryList.get(3);

        Button sortByChannelNameButton = new Button("Sort by Channel Name");
        sortByChannelNameButton.onClick(this, "clickedSortByChannelName");
        window.addButton(sortByChannelNameButton, WindowSide.NORTH);

        Button sortByEngagementRateButton =
            new Button("Sort by Engagement Rate");
        sortByEngagementRateButton.onClick(this, "clickedSortByEngagementRate");
        window.addButton(sortByEngagementRateButton, WindowSide.NORTH);

        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.NORTH);

        Button traditionalEngagementRateButton =
            new Button("Traditional Engagement Rate");
        traditionalEngagementRateButton
            .onClick(this, "clickedTraditionalEngagementRate");
        window.addButton(traditionalEngagementRateButton, WindowSide.WEST);

        Button reachEngagementRateButton = new Button("Reach Engagement Rate");
        reachEngagementRateButton.onClick(this, "clickedReachEngagementRate");
        window.addButton(reachEngagementRateButton, WindowSide.WEST);

        Button januaryButton = new Button("January");
        januaryButton.onClick(this, "clickedJanuary");
        window.addButton(januaryButton, WindowSide.SOUTH);

        Button februaryButton = new Button("February");
        februaryButton.onClick(this, "clickedFebruary");
        window.addButton(februaryButton, WindowSide.SOUTH);

        Button marchButton = new Button("March");
        marchButton.onClick(this, "clickedMarch");
        window.addButton(marchButton, WindowSide.SOUTH);

        Button firstQuarterButton = new Button("First Quarter(Jan-March)");
        firstQuarterButton.onClick(this, "clickedFirstQuarter");
        window.addButton(firstQuarterButton, WindowSide.SOUTH);

        this.setColor();
        this.setWindow();
    }


    // ~Public Methods ........................................................
    // ----------------------------------------------------------
    /**
     * Sorts the channels by name
     * 
     * @param button
     *            : button pressed
     */
    public void clickedSortByChannelName(Button button)
    {
        this.removeSortByText();
        this.window.addShape(sortByChannelNameText);
        this.clearBars();
        this.isSortByChannelName = true;
        this.isSortByEngagementRate = false;
        CompareByName compareByName = new CompareByName();
        if (isJanuary)
        {
            januaryList.insertionSort(compareByName);
            this.currentChannel1 = this.januaryList.get(0);
            this.currentChannel2 = this.januaryList.get(1);
            this.currentChannel3 = this.januaryList.get(2);
            this.currentChannel4 = this.januaryList.get(3);
        }
        if (isFebruary)
        {
            februaryList.insertionSort(compareByName);
            this.currentChannel1 = this.februaryList.get(0);
            this.currentChannel2 = this.februaryList.get(1);
            this.currentChannel3 = this.februaryList.get(2);
            this.currentChannel4 = this.februaryList.get(3);
        }
        if (isMarch)
        {
            marchList.insertionSort(compareByName);
            this.currentChannel1 = this.marchList.get(0);
            this.currentChannel2 = this.marchList.get(1);
            this.currentChannel3 = this.marchList.get(2);
            this.currentChannel4 = this.marchList.get(3);
        }
        if (isFirstQuarter)
        {
            quarterList.insertionSort(compareByName);
            this.currentChannel1 = this.quarterList.get(0);
            this.currentChannel2 = this.quarterList.get(1);
            this.currentChannel3 = this.quarterList.get(2);
            this.currentChannel4 = this.quarterList.get(3);
        }
        this.setWindow();
    }


    // ----------------------------------------------------------
    /**
     * Sorts the channels by engagement rate
     * 
     * @param button
     *            : button pressed
     */
    public void clickedSortByEngagementRate(Button button)
    {
        this.removeSortByText();
        this.window.addShape(sortByEngagementRateText);
        this.clearBars();
        this.isSortByChannelName = false;
        this.isSortByEngagementRate = true;

        if (isTraditionalEngagementRate)
        {
            CompareByTraditionalRate compareByTraditionalRate =
                new CompareByTraditionalRate();
            if (isJanuary)
            {
                januaryList.insertionSort(compareByTraditionalRate);
                this.currentChannel1 = this.januaryList.get(0);
                this.currentChannel2 = this.januaryList.get(1);
                this.currentChannel3 = this.januaryList.get(2);
                this.currentChannel4 = this.januaryList.get(3);
            }
            if (isFebruary)
            {
                februaryList.insertionSort(compareByTraditionalRate);
                this.currentChannel1 = this.februaryList.get(0);
                this.currentChannel2 = this.februaryList.get(1);
                this.currentChannel3 = this.februaryList.get(2);
                this.currentChannel4 = this.februaryList.get(3);
            }
            if (isMarch)
            {
                marchList.insertionSort(compareByTraditionalRate);
                this.currentChannel1 = this.marchList.get(0);
                this.currentChannel2 = this.marchList.get(1);
                this.currentChannel3 = this.marchList.get(2);
                this.currentChannel4 = this.marchList.get(3);
            }
            if (isFirstQuarter)
            {
                quarterList.insertionSort(compareByTraditionalRate);
                this.currentChannel1 = this.quarterList.get(0);
                this.currentChannel2 = this.quarterList.get(1);
                this.currentChannel3 = this.quarterList.get(2);
                this.currentChannel4 = this.quarterList.get(3);
            }
        }
        else
        {
            CompareByReachRate compareByReachRate = new CompareByReachRate();
            if (isJanuary)
            {
                januaryList.insertionSort(compareByReachRate);
                this.currentChannel1 = this.januaryList.get(0);
                this.currentChannel2 = this.januaryList.get(1);
                this.currentChannel3 = this.januaryList.get(2);
                this.currentChannel4 = this.januaryList.get(3);
            }
            if (isFebruary)
            {
                februaryList.insertionSort(compareByReachRate);
                this.currentChannel1 = this.februaryList.get(0);
                this.currentChannel2 = this.februaryList.get(1);
                this.currentChannel3 = this.februaryList.get(2);
                this.currentChannel4 = this.februaryList.get(3);
            }
            if (isMarch)
            {
                marchList.insertionSort(compareByReachRate);
                this.currentChannel1 = this.marchList.get(0);
                this.currentChannel2 = this.marchList.get(1);
                this.currentChannel3 = this.marchList.get(2);
                this.currentChannel4 = this.marchList.get(3);
            }
            if (isFirstQuarter)
            {
                quarterList.insertionSort(compareByReachRate);
                this.currentChannel1 = this.quarterList.get(0);
                this.currentChannel2 = this.quarterList.get(1);
                this.currentChannel3 = this.quarterList.get(2);
                this.currentChannel4 = this.quarterList.get(3);
            }
        }
        this.setWindow();
    }


    // ----------------------------------------------------------
    /**
     * Quits the program
     * 
     * @param button
     *            : button pressed
     */
    public void clickedQuit(Button button)
    {
        System.exit(0);
    }


    // ----------------------------------------------------------
    /**
     * shows the traditional engagement rate of the channels
     * 
     * @param button
     *            : button pressed
     */
    public void clickedTraditionalEngagementRate(Button button)
    {
        this.removeEngagementRateText();
        this.window.addShape(traditionalEngagementRateText);
        this.clearBars();
        this.isTraditionalEngagementRate = true;
        this.isReachEngagementRate = false;
        this.setWindow();
    }


    // ----------------------------------------------------------
    /**
     * shows the reach engagement rate of the channels
     * 
     * @param button
     *            : button pressed
     */
    public void clickedReachEngagementRate(Button button)
    {
        this.removeEngagementRateText();
        this.window.addShape(reachEngagementRateText);
        this.clearBars();
        this.isTraditionalEngagementRate = false;
        this.isReachEngagementRate = true;
        this.setWindow();
    }


    // ----------------------------------------------------------
    /**
     * shows the rates of the channels in January
     * 
     * @param button
     *            : button pressed
     */
    public void clickedJanuary(Button button)
    {
        this.removeRangeText();
        this.window.addShape(januaryText);
        this.clearBars();
        this.isJanuary = true;
        this.isFebruary = false;
        this.isMarch = false;
        this.isFirstQuarter = false;
        this.currentChannel1 = this.januaryList.get(0);
        this.currentChannel2 = this.januaryList.get(1);
        this.currentChannel3 = this.januaryList.get(2);
        this.currentChannel4 = this.januaryList.get(3);
        this.setWindow();
    }


    // ----------------------------------------------------------
    /**
     * shows the rates of the channels in February
     * 
     * @param button
     *            : button pressed
     */
    public void clickedFebruary(Button button)
    {
        this.removeRangeText();
        this.window.addShape(februaryText);
        this.clearBars();
        this.isJanuary = false;
        this.isFebruary = true;
        this.isMarch = false;
        this.isFirstQuarter = false;
        this.currentChannel1 = this.februaryList.get(0);
        this.currentChannel2 = this.februaryList.get(1);
        this.currentChannel3 = this.februaryList.get(2);
        this.currentChannel4 = this.februaryList.get(3);
        this.setWindow();
    }


    // ----------------------------------------------------------
    /**
     * shows the rates of the channels in March
     * 
     * @param button
     *            : button pressed
     */
    public void clickedMarch(Button button)
    {
        this.removeRangeText();
        this.window.addShape(marchText);
        this.clearBars();
        this.isJanuary = false;
        this.isFebruary = false;
        this.isMarch = true;
        this.isFirstQuarter = false;
        this.currentChannel1 = this.marchList.get(0);
        this.currentChannel2 = this.marchList.get(1);
        this.currentChannel3 = this.marchList.get(2);
        this.currentChannel4 = this.marchList.get(3);
        this.setWindow();
    }


    // ----------------------------------------------------------
    /**
     * shows the rates of the channels in the first quarter
     * 
     * @param button
     *            : button pressed
     */
    public void clickedFirstQuarter(Button button)
    {
        this.removeRangeText();
        this.window.addShape(firstQuarterText);
        this.clearBars();
        this.isJanuary = false;
        this.isFebruary = false;
        this.isMarch = false;
        this.isFirstQuarter = true;
        this.currentChannel1 = this.quarterList.get(0);
        this.currentChannel2 = this.quarterList.get(1);
        this.currentChannel3 = this.quarterList.get(2);
        this.currentChannel4 = this.quarterList.get(3);
        this.setWindow();
    }


    // ----------------------------------------------------------
    /**
     * Getter for the window object
     * 
     * @return window : the window
     */
    public Window getWindow()
    {
        return this.window;
    }


    private void setWindow()
    {
        int y1 = 0;
        int y2 = 0;
        int y3 = 0;
        int y4 = 0;
        String rate1 = "";
        String rate2 = "";
        String rate3 = "";
        String rate4 = "";
        if (this.isTraditionalEngagementRate)
        {
            y1 = 500
                - 5 * (int)this.currentChannel1.traditionalEngagementRate();
            y2 = 500
                - 5 * (int)this.currentChannel2.traditionalEngagementRate();
            y3 = 500
                - 5 * (int)this.currentChannel3.traditionalEngagementRate();
            y4 = 500
                - 5 * (int)this.currentChannel4.traditionalEngagementRate();
            rate1 = dc.format(this.currentChannel1.traditionalEngagementRate());
            rate2 = dc.format(this.currentChannel2.traditionalEngagementRate());
            rate3 = dc.format(this.currentChannel3.traditionalEngagementRate());
            rate4 = dc.format(this.currentChannel4.traditionalEngagementRate());
        }
        else
        {
            y1 = 500 - 5 * (int)this.currentChannel1.engagementRateByReach();
            y2 = 500 - 5 * (int)this.currentChannel2.engagementRateByReach();
            y3 = 500 - 5 * (int)this.currentChannel3.engagementRateByReach();
            y4 = 500 - 5 * (int)this.currentChannel4.engagementRateByReach();
            rate1 = dc.format(this.currentChannel1.engagementRateByReach());
            rate2 = dc.format(this.currentChannel2.engagementRateByReach());
            rate3 = dc.format(this.currentChannel3.engagementRateByReach());
            rate4 = dc.format(this.currentChannel4.engagementRateByReach());
        }

        channelBar1 = new Shape(
            this.window.getGraphPanelWidth() / 5,
            y1,
            50,
            -(y1 - 500),
            color1);
        channelBar2 = new Shape(
            this.window.getGraphPanelWidth() * 2 / 5,
            y2,
            50,
            -(y2 - 500),
            color2);
        channelBar3 = new Shape(
            this.window.getGraphPanelWidth() * 3 / 5,
            y3,
            50,
            -(y3 - 500),
            color3);
        channelBar4 = new Shape(
            this.window.getGraphPanelWidth() * 4 / 5,
            y4,
            50,
            -(y4 - 500),
            color4);
        window.addShape(channelBar1);
        window.addShape(channelBar2);
        window.addShape(channelBar3);
        window.addShape(channelBar4);

        channel4NameText = new TextShape(
            this.window.getGraphPanelWidth() * 4 / 5,
            515,
            this.currentChannel4.getChannelName());
        window.addShape(channel4NameText);
        channel4RateText =
            new TextShape(this.window.getGraphPanelWidth() * 4 / 5, 530, rate4);
        window.addShape(channel4RateText);
        channel3NameText = new TextShape(
            this.window.getGraphPanelWidth() * 3 / 5,
            515,
            this.currentChannel3.getChannelName());
        window.addShape(channel3NameText);
        channel3RateText =
            new TextShape(this.window.getGraphPanelWidth() * 3 / 5, 530, rate3);
        window.addShape(channel3RateText);
        channel2NameText = new TextShape(
            this.window.getGraphPanelWidth() * 2 / 5,
            515,
            this.currentChannel2.getChannelName());
        window.addShape(channel2NameText);
        channel2RateText =
            new TextShape(this.window.getGraphPanelWidth() * 2 / 5, 530, rate2);
        window.addShape(channel2RateText);
        channel1NameText = new TextShape(
            this.window.getGraphPanelWidth() / 5,
            515,
            this.currentChannel1.getChannelName());
        window.addShape(channel1NameText);
        channel1RateText =
            new TextShape(this.window.getGraphPanelWidth() / 5, 530, rate1);
        window.addShape(channel1RateText);
    }


    private void clearBars()
    {
        this.window.removeShape(this.channelBar1);
        this.window.removeShape(this.channelBar2);
        this.window.removeShape(this.channelBar3);
        this.window.removeShape(this.channelBar4);
        this.window.removeShape(this.channel1NameText);
        this.window.removeShape(this.channel2NameText);
        this.window.removeShape(this.channel3NameText);
        this.window.removeShape(this.channel4NameText);
        this.window.removeShape(this.channel1RateText);
        this.window.removeShape(this.channel2RateText);
        this.window.removeShape(this.channel3RateText);
        this.window.removeShape(this.channel4RateText);
    }


    private void removeRangeText()
    {
        this.window.removeShape(januaryText);
        this.window.removeShape(februaryText);
        this.window.removeShape(marchText);
        this.window.removeShape(firstQuarterText);
    }


    private void removeEngagementRateText()
    {
        this.window.removeShape(traditionalEngagementRateText);
        this.window.removeShape(reachEngagementRateText);
    }


    private void removeSortByText()
    {
        this.window.removeShape(sortByChannelNameText);
        this.window.removeShape(sortByEngagementRateText);
    }


    private void setColor()
    {
        this.color1 = new Color(
            (int)(Math.random() * 255),
            (int)(Math.random() * 255),
            (int)(Math.random() * 255));
        this.color2 = new Color(
            (int)(Math.random() * 255),
            (int)(Math.random() * 255),
            (int)(Math.random() * 255));
        this.color3 = new Color(
            (int)(Math.random() * 255),
            (int)(Math.random() * 255),
            (int)(Math.random() * 255));
        this.color4 = new Color(
            (int)(Math.random() * 255),
            (int)(Math.random() * 255),
            (int)(Math.random() * 255));
        this.checkColor();
    }


    private void checkColor()
    {
        if (this.color1 == this.color2 || this.color1 == this.color3
            || this.color1 == this.color4 || this.color2 == this.color3
            || this.color2 == this.color4 || this.color3 == this.color4)
        {
            this.setColor();
        }
    }
}
