public class ProPlan extends AIModel {
  public int slotsAvailable;
  public int initialSlots; // NEW — set once at construction, never changed
  public int remainingPromptsinMonth;

  public ProPlan(int slotsAvailable, String modelName, double price, int parameterCount, String contextWindowSize) {
    super(modelName, price, parameterCount, contextWindowSize);
    this.slotsAvailable = slotsAvailable;
    this.initialSlots = slotsAvailable; // NEW
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

  public String displayPlanInfo() {
    return super.displayModelInfo() + "\nSlots Available: " + slotsAvailable;
  }

  public String userprompts(String promptText, String outputLength) {
    return "Here is your response for the prompt: " + promptText + " with output length: " + outputLength + ". You have unlimited prompts";
  }
}
