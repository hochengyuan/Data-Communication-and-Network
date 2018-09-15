public class Last_Ack extends State
{
  private String stateName = "Last_Ack";

  public Last_Ack(String last_ack)
  {
    super(last_ack);
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