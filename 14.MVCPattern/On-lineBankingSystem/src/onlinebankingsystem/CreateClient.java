package onlinebankingsystem;

public class CreateClient extends ClientCommand
{
	private String name;
	private String birth;
	private String eMail;
	private String address;

	public CreateClient(ClientDatabase clientDB, String name, String birth, String eMail, String address)
	{
		super.clientDB = clientDB;
		this.name = name;
		this.birth = birth;
		this.eMail = eMail;
		this.address = address;
	}

	public void execute()
	{
		Client client = new Client(name, birth, eMail, address);
		clientDB.insertClient(client);
	}
}
