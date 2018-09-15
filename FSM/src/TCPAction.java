public class TCPAction extends Action
{
  private String actionName;

  public TCPAction(){
  }

  public void execute(FSM paramFSM, Event paramEvent){
  	System.out.println("Event " + paramEvent + " received, current State is " + paramFSM.currentState());
  }
}