public class Active extends Action
{
	private String ACTIVE;

	public Active(){
	}

	public void execute(FSM paramFSM, Event paramEvent){
		System.out.println("Event "+ paramEvent +" received, current State is "+ paramFSM.currentState());
	}
}