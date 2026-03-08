public class AIModel
{
    // instance variables - replace the example below with your own
    String modelName;
    double price;
    int parameterCount;
    String contextWindowSize;

    /**
     * Constructor for objects of class AIModel
     */
    public AIModel(String modelName, double price, long parameterCount, String contextWindowSize)
    {
        // initialise instance variables
        this.modelName = modelName;
        this.price = price;
        this.parameterCount = parameterCount;
        this.contextWindowSize = contextWindowSize;
    }

    public String getModelName() {
        return modelName;
    }

    public double getPrice() {
      return price;
    }

    public int getParameterCount() {
      return parameterCount;
    }

    public String getContextWindowSize() {
      return contextWindowSize;
    }

    public String displayModelInfo(){
      return "Model Name: " + modelName + "\nPrice: $" + price + "\nParameter Count: " + parameterCount + "\nContext Window Size: " + contextWindowSize;

    }
}
