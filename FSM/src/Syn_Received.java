public class Syn_Received extends State
{
  private String stateName = "SYN_RECEIVED";

  public Syn_Received(String SYN_RECEIVED)
  {
    super(SYN_RECEIVED);
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