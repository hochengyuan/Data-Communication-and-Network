public class Time_Wait extends State
{
  private String stateName = "Time_Wait";

  public Time_Wait(String timewait)
  {
    super(timewait);
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