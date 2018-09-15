public class Syn_Sent extends State
{
  private String stateName = "SYN_SENT";

  public Syn_Sent(String SYN_SENT)
  {
    super(SYN_SENT);
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