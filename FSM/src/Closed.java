public class Closed extends State
{
  private String stateName = "CLOSED";

  public Closed(String CLOSED)
  {
   super(CLOSED);
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