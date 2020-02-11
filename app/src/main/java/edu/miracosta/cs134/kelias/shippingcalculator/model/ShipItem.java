package edu.miracosta.cs134.kelias.shippingcalculator.model;

/**
 * Calculates the total cost of shipping
 * using the weight input from user.
 */
public class ShipItem {
    // Instance variables
    private double mWeight;
    private double mBaseCost;
    private double mAddedCost;
    private double mTotalShippingCost;

    /** Constructor
     * Sets weight to 0 ounces
     * base cost to $3.00 and
     * the other costs to $0.00
     */
    public ShipItem()
    {
        mWeight = 0;
        mBaseCost = 3.0;
        mAddedCost = 0.0;
        mTotalShippingCost = 0.0;
    }

    /**
     * Accessor/Getter for weight
     * @return mWeight      weight of package in ounces
     */
    public double getWeight() { return mWeight; }

    /**
     * Accessor/Getter for base cost
     * @return mBaseCost    base cost will always equal 3.0
     */
    public double getBaseCost() { return mBaseCost; }

    /**
     * Accessor/Getter for added cost
     * @return mAddedCost   after 16 ounces, $0.50 is added for every 4 ounces
     */
    public double getAddedCost() { return mAddedCost; }

    /**
     * Accessor/Getter for total shipping cost
     * @return mTotalShippingCost   the total cost added from base and added
     */
    public double getTotalShippingCost() { return mTotalShippingCost; }

    /**
     * Mutator/Setter for weight of package
     * Depending on the weight set by user the added cost is calculated
     * @param weight    more than 16 ounces changes added cost
     */
    public void setWeight(double weight)
    {
        mWeight = weight;
        // if weight is set to more than 16 ounces
        if(mWeight > 16)
        {
            // calculate the weight over 16 and find every 4 ounces
            // then multiply it by $0.50
            // using ceiling to round up when the weight is more than 4 ounces
            mAddedCost = Math.ceil((mWeight - 16) / 4) * 0.50;
        }
        else    // 16 ounces or less = no added cost
        {
            mAddedCost = 0.0;
        }
        // calculate the total shipping cost
        recalculateTotalCost();
    }

    /**
     * Calculates the total shipping cost by adding
     * the base cost and added cost
     */
    private void recalculateTotalCost()
    {
        mTotalShippingCost = mBaseCost + mAddedCost;
    }
}
