public class Fin extends Action
{
  private String ack;

  public Fin(){
  }

  public void execute(FSM paramFSM, Event paramEvent){
  	System.out.println("FIN");
  	System.out.println("Event " + paramEvent + " received, current State is " + paramFSM.currentState());
  }
}