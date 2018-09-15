public class Transition
{
	private State cState;
	private Event event;
	private State nState;
	private Action action;
	private Long myKey;

	public Transition(State cs, Event evt, State ns, Action act)
	{
		this.cState = cs;
		this.event = evt;
		this.nState = ns;
		this.action = act;
		this.myKey = key(cs, evt);
	}

	protected static Long key(State s, Event e)
	{
		return new Long(s.getName().hashCode() * e.getName().hashCode());
	}

	public State getCurrentState()
	{
		return this.cState;
	}

	public State getNextState()
	{
		return this.nState;
	}

	public Event getEvent()
	{
		return this.event;
	}

	public Long getKey()
	{
		return this.myKey;
	}

	protected void doAction(FSM fsm, Event evt)
	{
		if ((this.action instanceof Action))
			this.action.execute(fsm, evt);
	}

	public String toString()
	{
		return " " + this.cState + " -> " + this.nState + " on " + this.event + ":  key is " + Long.toHexString(this.myKey.longValue());
	}
}