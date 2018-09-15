/*
For the actions on the Established/(R|S)DATA Transitions, write the message:
"DATA recieved n" when the event is RDATA
"DATA sent n" when the event is SDATA
where n is a number representing the number of SDATA or RDATA Events recieved to data, including this (R|S)Data Event.
*/

public class N extends Action
{
	private String n;

	public N(){
	}

	public void execute(FSM paramFSM, Event paramEvent){
		if ((paramEvent.getName()).equals("RDATA")){
			System.out.println("DATA recieved "+ paramEvent.getValue() + ", current State is " + paramFSM.currentState());
		}
		if ((paramEvent.getName()).equals("SDATA")){
			System.out.println("DATA sent " + paramEvent.getValue() +", current State is " + paramFSM.currentState());
		}
	}
}