public class TCPEvent extends Event
{
  private String eventName;
  private Object eventValue;

  public TCPEvent(String name)
  {
    super(name);
    this.eventName=name;  
  }
 
  public String getName()
  {
   return this.eventName;
  }

  public Object getValue()
  {
   return this.eventValue;
  }

  public void setValue(Object o)
  {
   this.eventValue = o;
  }
  
  public String toString()
  {
   return new String("Event(" + this.eventName + ") Value(" + this.eventValue + ")");
  }
 }
