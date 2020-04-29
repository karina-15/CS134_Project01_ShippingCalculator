# Shipping Calculator
> Android app which keeps track of the cost to ship a package, given factors such as base cost,
> weight and additional cost

## Screenshot
<img src="./screenshot/screenshot.png" height="550">

## Instructions
As our first hands-on introduction to the Model-View-Controller design pattern, we will be
implementing a Shipping Calculator to keep track of the cost to ship a package, given factors such
as base cost, weight and additional cost.

<img src="./screenshot/ShippingCalculatorDesign.png">

We will be utilizing a ConstraintLayout to group all of the Views presented in this app together.
A constraint layout organizes widgets with margins relative to other widgets on screen.

In this app:
When the user enters text (numeric only) into the EditText (weightEditText), the app should
automatically calculate the base cost, added cost and total shipping cost, all formatted as currency.

Note: The weightEditText widget should have a selectAllOnFocus property set to "true" (so that user
can quickly modify the package weight), the inputType should be "number" and it should also requestFocus.

Basically, when the app starts, the focus should go to the weightEditText widget and the soft
keyboard for numbers should immediately appear.

<img src="./screenshot/ShippingCalculatorComplete.png" height="550">

**Logistics for Calculating Shipping Costs (in the Model):**
   All items to be shipped will have a base cost of $3.00 for the first 16 ounces (including 16)
   All items weighing more than 16 ounces will have an added charge of $0.50 for each additional 4
   ounces (above 16).
   For example, an item weighing more than 16, but <= 20 will cost $3.50 to deliver. An item
   weighing more than 20, but <= 24 will cost $4.00 (and so on)
   Please create a Model (e.g. MVC) class named ShipItem.java to represent the data and behavior
   that must be stored and calculated to compute shipping costs.  All calculations should be done in
   ShipItem.

   `NO CALCULATIONS` should be made in the Controller (MainActivity.java) or View (activity_main.xml)

**Tasks to Accomplish in the Controller:**
   Add a textChangedListener to the weightEditText widget.
   The listener should be a TextWatcher (similar to IC #04 - Tip Calculator), which will provide
   three methods:  onTextChanged, afterTextChanged and beforeTextChanged.
   You only need to implement the onTextChanged method which will use the model (ShipItem.java) to
   calculate the shipping costs.
   Make sure all costs are displayed as currency.

