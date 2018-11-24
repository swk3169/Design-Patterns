package RemoteCommandPattern;

public class HottubOffCommand implements Command
{
	private Hottub hottub;

	public HottubOffCommand(Hottub hottub)
	{
		this.hottub = hottub;
	}

	public void execute()
	{
		hottub.cool();
		hottub.off();
	}
}