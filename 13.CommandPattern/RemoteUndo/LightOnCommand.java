package RemoteUndoCommandPattern;

public class LightOnCommand implements Command
{
	private Light light;
	private int level;

	public LightOnCommand(Light light)
	{
		this.light = light;
	}

	public void execute()
	{
		level = light.getLevel();
		light.on();
	}

	public void undo()
	{
		light.dim(level);
	}
}
