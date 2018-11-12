package CeilingFanPullChainStatePattern;

public class LowSpeedState implements State
{
	private CeilingFanPullChain ceilingFanPullChain;

	public LowSpeedState(CeilingFanPullChain ceilingFanPullChain)
	{
		this.ceilingFanPullChain = ceilingFanPullChain;
	}

	public void pull()
	{
		ceilingFanPullChain.setState(ceilingFanPullChain.getMediumSpeedState());
		System.out.println("	medium speed");
	}
}
