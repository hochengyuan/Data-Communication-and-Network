public class Sdata extends Action
{
	private String n;

	public Sdata(){
	}

	public void execute(FSM paramFSM, Event paramEvent){

		if ((paramEvent.getName()).equals("SDATA"))
		{
			System.out.println("DATA sent " + paramEvent.getValue() + ", current State is " + paramFSM.currentState());
		}
	}
}