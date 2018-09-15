public class Syn extends Action
{
	private String SYN;

	public Syn(){
	}

	public void execute(FSM paramFSM, Event paramEvent){
		System.out.println("Event "+ paramEvent +" received, current State is "+ paramFSM.currentState());
	}
}