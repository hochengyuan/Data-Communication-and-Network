public class Closing extends State
{
  private String stateName = "CLOSING";

  public Closing(String CLOSING)
  {
    super(CLOSING);
  }

  public String getName()
  {
    return this.stateName;
  }

  public String toString()
  {
    return new String("State(" + this.stateName + ")");
  }
}