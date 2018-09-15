/* Olga Romanova
 * DCN Finite State Lab   
 * Spring 2014 
 */

public class Fin_Wait_2 extends State
{
  private String stateName = "FIN_WAIT_2";

  public Fin_Wait_2(String FIN_WAIT_2)
  {
    super(FIN_WAIT_2);
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