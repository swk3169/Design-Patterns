package CeilingFanPullChainStatePattern;

public class CeilingFanPullChain
{
	private State lowSpeedState;
	private State mediumSpeedState;
	private State highSpeedState;
	private State turningOffState;

	private State state;

	public CeilingFanPullChain()
	{
		lowSpeedState = new LowSpeedState(this);
		mediumSpeedState = new MediumSpeedState(this);
		highSpeedState = new HighSpeedState(this);
		turningOffState = new TurningOffState(this);

		state = turningOffState;
	}

	public void pull()
	{
		state.pull();
	}

	void setState(State state)
	{
		this.state = state;
	}

	public State getState()
	{
		return state;
	}

	public State getLowSpeedState()
	{
		return lowSpeedState;
	}

	public State getMediumSpeedState()
	{
		return mediumSpeedState;
	}

	public State getHighSpeedState()
	{
		return highSpeedState;
	}

	public State getTurningOffState()
	{
		return turningOffState;
	}
}
