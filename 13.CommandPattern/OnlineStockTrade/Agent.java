package OnlineStockTradeCommandPattern;

import java.util.LinkedList;

public class Agent
{
	private LinkedList<Command> commandQueue = new LinkedList<Command>();
	
	public Agent() {}
	
	public void placeCommand(Command command)
	{
		commandQueue.add(command);
		commandQueue.remove(0);
		command.execute();
	}
}
