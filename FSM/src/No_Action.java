public class No_Action extends Action
{
  private String noAction;

  public No_Action(){
  }

  public void execute(FSM paramFSM, Event paramEvent){
  	System.out.println("Event " + paramEvent + " received, current State is " + paramFSM.currentState());

  }
}