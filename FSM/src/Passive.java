public class Passive extends Action
{
	private String PASSIVE;

	public Passive(){
	}

	public void execute(FSM paramFSM, Event paramEvent){
		System.out.println("Event "+ paramEvent +" received, current State is "+ paramFSM.currentState());
	}
}