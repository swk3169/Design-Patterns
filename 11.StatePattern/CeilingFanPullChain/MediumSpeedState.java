package CeilingFanPullChainStatePattern;

public class MediumSpeedState implements State
{
	private CeilingFanPullChain ceilingFanPullChain;

	public MediumSpeedState(CeilingFanPullChain ceilingFanPullChain)
	{
		this.ceilingFanPullChain = ceilingFanPullChain;
	}

	public void pull()
	{
		ceilingFanPullChain.setState(ceilingFanPullChain.getHighSpeedState());
		System.out.println("	high speed");
	}
}
