public class SynAck extends Action
{
	private String SYNACK;

	public SynAck(){
	}

	public void execute(FSM paramFSM, Event paramEvent){
		System.out.println("Event "+ paramEvent +" received, current State is "+ paramFSM.currentState());
	}
}