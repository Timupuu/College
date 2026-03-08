public class PersonalPlan extends AIModel
{
  // instance variables - replace the example below with your own
  public int remainingPromptsinMonth;

  /**
   * Constructor for objects of class PersonalPlan
   */
  public PersonalPlan(String modelName, double price, int parameterCount, String contextWindowSize , int remainingPromptsinMonth)
  {
    // initialise instance variables
    super(modelName, price, parameterCount, contextWindowSize);
    this.remainingPromptsinMonth = remainingPromptsinMonth;
      }

  public int getremainingPromptsinMonth() {
    return remainingPromptsinMonth;
  }

  public String purchaseprompts(int amount){
    if (amount > 0) {
      remainingPromptsinMonth += amount;
      return "Successfully purchased " + amount + " prompts. Remaining prompts in month: " + remainingPromptsinMonth;

    }
    if (amount <= 0) {
      return "Invalid amount. Please enter a positive number of prompts to purchase.";
    }
    return;
  }

  public String userprompts(String promptText, String outputLength){
    if (remainingPromptsinMonth > 0) {
      remainingPromptsinMonth -= 1;
      return "Here is your response for the prompt: " + promptText + " with output length: " + outputLength;
    } else {
      return "No more prompts available. Please purchase more prompts.";
    }
  }

  public String displayPlanInfo(){
    return super.displayModelInfo() + "\nRemaining Prompts in Month: " + remainingPromptsinMonth;
  }
}
