public class Listen extends State
{
  private String stateName = "Listen";

  public Listen(String listen)
  {
    super(listen);
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