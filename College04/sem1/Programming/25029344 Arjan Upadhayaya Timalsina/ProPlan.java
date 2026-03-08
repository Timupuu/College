public class ProPlan extends AIModel
{
  // instance variables - replace the example below with your own
  public int slotsAvailable;

  /**
   * Constructor for objects of class ProPlan
   */
  public ProPlan(int slotsAvailable, String modelName, double price, int parameterCount, String contextWindowSize)
  {
    super(modelName, price, parameterCount, contextWindowSize);

    // initialise instance variables
    this.slotsAvailable = slotsAvailable;
  }

  public String addMember(String memberName) {
    if (slotsAvailable > 0) {
      slotsAvailable -= 1;
      return "Successfully booked slot for " + memberName + ". Remaining slots: " + slotsAvailable;
    } else {
      return "No slots available. Please try again later.";
    }
  }

  public String removeMember(String memberName) {
    slotsAvailable += 1;
    return "Successfully removed " + memberName + ". Remaining slots: " + slotsAvailable;
  }

  public String displayPlanInfo(){
    return super.displayModelInfo() + "\nSlots Available: " + slotsAvailable;
  }
}
