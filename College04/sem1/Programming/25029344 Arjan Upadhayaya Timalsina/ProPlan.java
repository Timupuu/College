import java.util.ArrayList;

public class ProPlan extends AIModel {
  public int slotsAvailable;
  public int initialSlots;
  public int remainingPromptsinMonth;
  public ArrayList<String> members = new ArrayList<>(); // NEW

  public ProPlan(int slotsAvailable, String modelName, double price, int parameterCount, String contextWindowSize) {
    super(modelName, price, parameterCount, contextWindowSize);
    this.slotsAvailable = slotsAvailable;
    this.initialSlots = slotsAvailable;
  }

  public String addMember(String memberName) {
    if (slotsAvailable > 0) {
      slotsAvailable -= 1;
      members.add(memberName); // NEW
      return "Successfully booked slot for " + memberName + ". Remaining slots: " + slotsAvailable;
    } else {
      return "No slots available. Please try again later.";
    }
  }

  public String removeMember(String memberName) {
    if (members.isEmpty()) {
      return "There are no team members to remove.";
    }
    if (!members.contains(memberName)) {
      return "Member \"" + memberName + "\" was not found.";
    }
    members.remove(memberName); // NEW
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
