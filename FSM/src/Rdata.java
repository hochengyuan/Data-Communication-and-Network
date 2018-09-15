public class Rdata extends Action
{
	private String n;

	public Rdata(){
	}

	public void execute(FSM paramFSM, Event paramEvent){

		if ((paramEvent.getName()).equals("RDATA"))
		{
			System.out.println("DATA recieved "+ paramEvent.getValue() + ", current State is " + paramFSM.currentState());
		}
	}
}