package onlinebankingsystem;

public class DeleteClient extends ClientCommand
{
	private int id;

	public DeleteClient(ClientDatabase clientDB, int id)
	{
		super.clientDB = clientDB;
		this.id = id;
	}

	public void execute()
	{
		// TODO Auto-generated method stub
		clientDB.deleteClient(id);
	}
}
