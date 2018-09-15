import java.util.Scanner;

public class FiniteStateMachine_HW{

	//All possible events for the switch statement 
    enum ALL_Listed_Event {
    	PASSIVE, ACTIVE, SYN, SYNACK, ACK,
    	RDATA, SDATA, FIN, CLOSE, TIMEOUT, QUIT
    };	

    public static void main(String [] args)
    {

    Scanner keyin = new Scanner(System.in);
   	keyin.useDelimiter("\n|\r\n|\\s+");
    System.out.println("HW6_TCP_FSM START TO SHOW. Happy Thanksgiving:)");

    //States which are shown in the diagram
    Listen listen= new Listen("listen");
    Closed closed = new Closed("closed");
    Established established = new Established("established");
    Closing closing = new Closing("closing");
    Fin_Wait_1 fin_wait_1 = new Fin_Wait_1("fin_wait_1");
    Fin_Wait_2 fin_wait_2 = new Fin_Wait_2("fin_wait_2");
    Last_Ack last_ack = new Last_Ack("fin_wait_2");
    Syn_Received syn_rcvd = new Syn_Received("syn_rcvd");
    Syn_Sent syn_sent = new Syn_Sent("syn_sent");
    Time_Wait time_wait = new Time_Wait("time_wait");
    Blank blank = new Blank("blank"); // do not forget blank!!!

    //Events required in the homework, only parse the capital words
    TCPEvent passive = new TCPEvent("PASSIVE");
    TCPEvent active = new TCPEvent("ACTIVE");
    TCPEvent ack = new TCPEvent("ACK");
    TCPEvent syn = new TCPEvent("SYN");
    TCPEvent synAck = new TCPEvent("SYNACK");
    TCPEvent rdata = new TCPEvent("RDATA");
    TCPEvent sdata = new TCPEvent("SDATA");
    TCPEvent fin = new TCPEvent("FIN");
    TCPEvent close = new TCPEvent("CLOSE");
    TCPEvent timeOut = new TCPEvent("TIMEOUT");
    
    //Because the event_Value is an object in the Event class, it is cast as an integer. 
    rdata.setValue((Integer)0);
    sdata.setValue((Integer)0);

    //Actions: define the scope of each actions in the transitions.
    TCPAction tcpAction = new TCPAction();
    Ack hwAck = new Ack();
    Fin hwFin = new Fin();
    N n = new N();
    No_Action no_action = new No_Action();
    SynAck hwSyn_Ack = new SynAck();
    Syn hwSyn = new Syn();

    // list all Transitions edges in the diagram
    // if there is ^ in the transition, put no_action into parameter.
    Transition listen_synRvcd = new Transition(listen, syn, syn_rcvd, hwSyn_Ack);
    Transition listen_close = new Transition(listen, close, closed, no_action);
    Transition syn_sent_established = new Transition(syn_sent, synAck, established, hwAck);
	Transition syn_sent_syn_rcvd = new Transition(syn_sent, syn, syn_rcvd, hwSyn_Ack);
	Transition syn_sent_closed = new Transition(syn_sent, close, closed, no_action);
	Transition closed_syn_sent = new Transition(closed, active, syn_sent, hwSyn);
	Transition closed_listen = new Transition(closed, passive, listen, no_action);
	Transition syn_rcvd_established = new Transition(syn_rcvd, ack, established, no_action);
	Transition syn_rcvd_fin_wait_1 = new Transition(syn_rcvd, close, fin_wait_1, hwFin);
	Transition fin_wait_1_2 = new Transition(fin_wait_1, ack, fin_wait_2, no_action);
	Transition fin_wait_1_closing = new Transition(fin_wait_1, fin, closing, hwAck);
	Transition fin_wait_2_time_wait = new Transition(fin_wait_2, fin, time_wait, hwAck);
	Transition closing_time_wait = new Transition(closing, ack, time_wait, no_action);
	Transition time_wait_closed = new Transition(time_wait, timeOut, closed, no_action);
	Transition established_rdata = new Transition(established, rdata, established, n);
	Transition established_sdata = new Transition(established, sdata, established, n);
	Transition established_fin_wait_1 = new Transition(established, close, fin_wait_1, hwFin);
	Transition established_blank = new Transition(established, fin, blank, hwAck);
	Transition blank_last_ack = new Transition(blank, close, last_ack, hwFin);
	Transition last_ack_closed = new Transition(last_ack, ack, closed, no_action);

	// the following is the explanation for the given diagram in pdf file.
	/* The first thing to note in this diagram is that a subset of the state transitions is typical. We've marked the normal client transitions with
	   a green solid arrow, and the normal server transitions with a red dashed arrow. The other transitions are of course valid, but not typically to
	   be expected.

	   The two transitions leading to the CONNECTION ESTABLISHED state correspond to opening a connection, and the two transitions leading from the 
	   CONNECTION ESTABLISHED state are for the termination of a connection. The CONNECTION ESTABLISHED state is where data transfer can occur between 
	   the two ends in both directions.

	   We've collected the four boxes in the lower left of this diagram within a dashed box and labeled it active CLOSE. Two other boxes (CLOSE_WAIT 
	   and LAST_ACK) are collected in a dashed box with the label passive CLOSE.

	   When a passive OPEN is issued by an end point, it enters into the LISTEN state. This happens whenever a server starts a daemon process that is 
	   expected to wait for incoming TCP-requests. When TCP receives a SYN flag in this state it will enter the 3-way handshake process to move to the 
	   CONNECTION ESTABLISHED state.

       An active OPEN is normally issued by a client in order to initiate a TCP-transaction with a given server. Following the green path, one can 
       clearly see the 3-way handshake leading also to the CONNECTION ESTABLISHED state. */

    // START TO RUN FSM!!!
	
	//Listen TCP
    FSM tcpFSM = new FSM("tcpFSM", listen);

    //try adding the transitions to the FSM; if failed, output 'Invalid transition'
    try{
		tcpFSM.addTransition(listen_synRvcd); 
		tcpFSM.addTransition(listen_close); 
        tcpFSM.addTransition(syn_sent_established);
		tcpFSM.addTransition(syn_sent_syn_rcvd);
		tcpFSM.addTransition(syn_sent_closed);
		tcpFSM.addTransition(closed_syn_sent);
		tcpFSM.addTransition(closed_listen);
		tcpFSM.addTransition(syn_rcvd_established);
		tcpFSM.addTransition(syn_rcvd_fin_wait_1); 
		tcpFSM.addTransition(fin_wait_1_2); 
		tcpFSM.addTransition(fin_wait_1_closing); 
		tcpFSM.addTransition(fin_wait_2_time_wait); 
		tcpFSM.addTransition(closing_time_wait); 
		tcpFSM.addTransition(time_wait_closed); 
		tcpFSM.addTransition(established_rdata); 
		tcpFSM.addTransition(established_sdata); 
		tcpFSM.addTransition(established_fin_wait_1); 
		tcpFSM.addTransition(established_blank); 
		tcpFSM.addTransition(blank_last_ack); 
		tcpFSM.addTransition(last_ack_closed); 
	}
	catch (FsmException e){
		System.out.println("Invalid transition");
	}

	//keep requesting for actions until the user quits 

    boolean quit = false;

	while(quit == false)
        {    

        	System.out.println("\n" + "The current state is " + tcpFSM.currentState());
	        System.out.println("Enter one of the following events or QUIT to quit." );
	        System.out.println("PASSIVE::= Passive Open" );
	        System.out.println("ACTIVE::= Acrive Open " );
	        System.out.println("SYN::= SYN recieved " );
	        System.out.println("SYNACK::= SYN + ACK recieved " );
	        System.out.println("ACK::= ACK recieved " );
	        System.out.println("RDATA::= data recieved from network" );
	        System.out.println("SDATA::= sent from application" );
	        System.out.println("FIN::= FIN recieved " );
	        System.out.println("CLOSE::= client or server issues close" );
	        System.out.println("TIMEOUT::= timeout wait ends" );

	        //keep requesting for valid events until a valid event for the current state is entered 
	        boolean eventValid = false;
	        
	        while(eventValid == false)
            {
                String input = keyin.next();
                keyin.useDelimiter("\n|\r\n|\\s+");

                try
                {
                	ALL_Listed_Event event = ALL_Listed_Event.valueOf(input);
                	// case switching among the event listed in the question stems
                	// if there is FsmException e, println('undefined event for the state')
	                switch(event)
	                {
	                    case PASSIVE: 
	                        System.out.println("You Input " + event.toString() );
	                        eventValid = true;
	                        try{
	                        	tcpFSM.doEvent(passive);
	                        }
	                        catch(FsmException e){
	                        	System.out.println("undefined event for the state");
	                        }
	                        break;

	                    case ACTIVE: 
	                        System.out.println("You Input "+ event.toString() );
	                        eventValid = true;
	                        try{
	                        	tcpFSM.doEvent(active);
	                        }
	                        catch(FsmException e){
	                        	System.out.println("undefined event for the state");
	                        }
	                        break;

	                    case SYN:   
	                        System.out.println("You Input " + event.toString() );
	                        eventValid = true;		                        
	                        try{
	                        	tcpFSM.doEvent(syn);
	                    	}
	                    	catch(FsmException e){
	                    		System.out.println("undefined event for the state");
	                    	}
	                    	break;

	                    case ACK:   
	                        System.out.println("You Input " + event.toString() );
	                        eventValid = true;
	                        try{
	                        	tcpFSM.doEvent(ack);
	                        }
	                        catch(FsmException e){
	                        	System.out.println("undefined event for the state");
	                        }
	                        break;

	                    case SYNACK: 
	                        System.out.println("You Input " + event.toString() );
	                        eventValid=true;
	                        try{
	                        	tcpFSM.doEvent(synAck);
	                        }
	                        catch(FsmException e){
	                        	System.out.println("undefined event for the state");
	                        }
	                        break;

	                    case RDATA:  
	                        System.out.println("You Input " + event.toString() );
	                        eventValid = true;
	                        try{
	                        	// event_Value to an new Integer increased by 1
	                        	Integer val = (Integer)rdata.getValue();
	                        	Integer newVal = (Integer) val.intValue()+1;
	                        	rdata.setValue(newVal);
	                        	tcpFSM.doEvent(rdata);
	                        }
	                        catch(FsmException e){
	                        	System.out.println("undefined event for the state");
	                        }
	                        break;

	                    case SDATA:  
	                        System.out.println("You Input " + event.toString() );
	                        eventValid = true;
	                    	try{
	                    		// event_Value to an new Integer increased by 1
	                        	Integer val = (Integer)sdata.getValue();
	                        	Integer newVal = (Integer) val.intValue() + 1;
	                        	sdata.setValue(newVal);
	                    		tcpFSM.doEvent(sdata);
	                    	}
	                    	catch(FsmException e){
	                    		System.out.println("undefined event for the state");
	                    	}
	                    	break;

	                    case FIN:  
	                        System.out.println("You Input " + event.toString() );
	                        eventValid = true;
	                    	try{
	                    		tcpFSM.doEvent(fin);
	                        }
	                        catch(FsmException e){
	                        	System.out.println("undefined event for the state");
	                        }
	                        break;

	                    case CLOSE:  
	                        System.out.println("You Input " + event.toString() );
	                        eventValid = true;
	                        try{
	                        	tcpFSM.doEvent(close);
	                        }
	                        catch(FsmException e){
	                        	System.out.println("undefined event for the state");
	                        }
	                        break;

	                    case TIMEOUT:  
	                        System.out.println("You Input " + event.toString() );
	                        eventValid = true;
							try{
	                        	tcpFSM.doEvent(timeOut);
	                        }
	                        catch(FsmException e){
	                        	System.out.println("undefined event for the state");
	                        }
	                        break;

	                    case QUIT:  
	                        System.out.println("Quitting.");
	                        eventValid = true;
	                        quit = true;
	                 		System.exit(1);
	                        break;

	                    /* treat ANY String that you read from standard input that is NOT one of the events defined here by writing:
						   "Error: unexpected Event: xxx"
						*/
	                    default: System.out.println("Error: unexpected Event: " + event );
	                        break;
	                    } 

	              	}
	              	catch (IllegalArgumentException e)
	              	{
	              		System.out.println("\n" + "The current state is " + tcpFSM.currentState());
	              		System.out.println("Error: unexpected Event: " + input);
	              		System.out.println("Enter one of the following events or QUIT to quit." );
				        System.out.println("PASSIVE::= Passive Open" );
				        System.out.println("ACTIVE::= Active Open " );
				        System.out.println("SYN::= SYN recieved " );
				        System.out.println("SYNACK::= SYN + ACK recieved " );
				        System.out.println("ACK::= ACK recieved " );
				        System.out.println("RDATA for data recieved from network" );
				        System.out.println("FIN::= FIN recieved " );
				        System.out.println("CLOSE::= client or server claims close" );
				        System.out.println("TIMEOUT::= timeout wait ends" );
	              	}

	            } 

    	}

	}

}