package onlinebankingsystem;

public class Client
{
	private static int ID = 0;
	private int id;
	private String name;
	private String birth;
	private String eMail;
	private String address;

	Client()
	{
		id = ID++;
	}

	Client(String name, String birth, String eMail, String address)
	{
		id = ID++;
		this.name = name;
		this.birth = birth;
		this.eMail = eMail;
		this.address = address;
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public String getBirth()
	{
		return birth;
	}

	public String getEMail()
	{
		return eMail;
	}

	public String getAddress()
	{
		return address;
	}

	public void setId(int id)
	{
		this.id = id;
		Client.ID = ++id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setBirth(String birth)
	{
		this.birth = birth;
	}

	public void setEMail(String eMail)
	{
		this.eMail = eMail;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}
}
