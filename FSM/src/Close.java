public class Close extends State
{
  private String stateName = "CLOSE";

  public Close(String CLOSE)
  {
   super(CLOSE);
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