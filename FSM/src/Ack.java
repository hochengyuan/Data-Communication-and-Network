public class Ack extends Action
{
	private String ACK;

	public Ack(){
	}

	public void execute(FSM paramFSM, Event paramEvent){
		System.out.println("Event "+ paramEvent +" received, current State is "+ paramFSM.currentState());
	}
}