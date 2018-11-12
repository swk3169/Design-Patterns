package CeilingFanPullChainStatePattern;

public class TurningOffState implements State
{
	private CeilingFanPullChain ceilingFanPullChain;

	public TurningOffState(CeilingFanPullChain ceilingFanPullChain)
	{
		this.ceilingFanPullChain = ceilingFanPullChain;
	}

	public void pull()
	{
		ceilingFanPullChain.setState(ceilingFanPullChain.getLowSpeedState());
		System.out.println("	low speed");
	}
}
