package CeilingFanPullChainStatePattern;

public class HighSpeedState implements State
{
	private CeilingFanPullChain ceilingFanPullChain;

	public HighSpeedState(CeilingFanPullChain ceilingFanPullChain)
	{
		this.ceilingFanPullChain = ceilingFanPullChain;
	}

	public void pull()
	{
		ceilingFanPullChain.setState(ceilingFanPullChain.getTurningOffState());
		System.out.println("	turning off");
	}
}
