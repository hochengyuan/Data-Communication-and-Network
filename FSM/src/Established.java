public class Established extends State
{
  private String stateName = "Established";

  public Established(String established)
  {
    super(established);
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