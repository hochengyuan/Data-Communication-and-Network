public class Timeout extends State
{
  private String stateName = "TIMEOUT";

  public Timeout(String TIMEOUT)
  {
    super(TIMEOUT);
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