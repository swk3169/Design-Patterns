package RemoteCommandPattern;

public class LivingroomLightOffCommand implements Command
{
	private Light light;

	public LivingroomLightOffCommand(Light light)
	{
		this.light = light;
	}

	public void execute()
	{
		light.off();
	}
}
