public class Blank extends State
{
  private String stateName = "Blank";

  public Blank(String blank)
  {
     super(blank);
  }

  public void State(String name)
  {
    this.stateName = name;
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