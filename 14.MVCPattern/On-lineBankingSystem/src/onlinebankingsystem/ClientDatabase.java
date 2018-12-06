package onlinebankingsystem;

import java.util.ArrayList;

public class ClientDatabase implements Subject
{

	private ArrayList<Observer> observers;
	private ArrayList<Client> client_list;

	ClientDatabase()
	{
		observers = new ArrayList<Observer>();
		client_list = new ArrayList<Client>();
	}

	private Client[] findClient(String name)
	{
		int count = 0;
		Client[] find_client_list;
		for (int i = 0; i < client_list.size(); i++)
		{
			if (client_list.get(i).getName() == name)
			{
				count++;
			}
		}
		find_client_list = new Client[count];
		int j = -1;
		for (int i = 0; i < find_client_list.length; i++)
			for (j = j + 1; j < client_list.size(); j++)
				if (name == client_list.get(j).getName())
				{
					find_client_list[i] = client_list.get(j);
					break;
				}

		return find_client_list;
	}

	private Client findClient(int id)
	{
		for (int i = 0; i < client_list.size(); i++)
			if (client_list.get(i).getId() == id)
			{
				return client_list.get(i);
			}
		return null;
	}

	public boolean checkClient(int id)
	{
		boolean check = true;

		for (int i = 0; i < client_list.size(); i++)
			if (client_list.get(i).getId() == id)
			{
				check = false;
			}
		return check;
	}

	public void insertClient(Client client)
	{
		client_list.add(client);
		clientChanged();
	}

	public void displayClient()
	{
		// for(int i = 0; i < client_list.size(); i++) {
		// System.out.println("ID: " + client_list.get(i).getId());
		// System.out.println("이름: " + client_list.get(i).getName());
		// System.out.println("생년월일: " + client_list.get(i).getBirth());
		// System.out.println("이메일: " + client_list.get(i).getEMail());
		// System.out.println("주소: " + client_list.get(i).getAddress());
		// }
	}

	public int findClientNumber(String personalNumber)
	{
		for (int i = 0; i < client_list.size(); i++)
		{
			if (client_list.get(i).getBirth().equals(personalNumber))
			{
				return i;
			}
		}
		return -1;
	}

	public void deleteClient(int id)
	{
		for (int i = 0; i < client_list.size(); i++)
		{
			if (id == client_list.get(i).getId())
			{
				client_list.remove(i);
			}
		}
		clientChanged();
	}

	public ArrayList<Client> getClientList()
	{
		return client_list;
	}

	public ArrayList<Client> findClientByAddress(String address)
	{
		ArrayList<Client> clientList = new ArrayList<Client>();
		int size = client_list.size();
		for (int i = 0; i < size; ++i)
		{
			Client client = client_list.get(i);
			if (client.getAddress().indexOf(address) != -1)
			{
				clientList.add(client);
			}
		}

		return clientList;
	}

	public ArrayList<Client> findClientByName(String name)
	{
		ArrayList<Client> clientList = new ArrayList<Client>();
		int size = client_list.size();
		for (int i = 0; i < size; ++i)
		{
			Client client = client_list.get(i);
			if (client.getName().indexOf(name) != -1)
			{
				clientList.add(client);
			}
		}

		return clientList;
	}

	public ArrayList<Client> findClientByID(int id)
	{
		ArrayList<Client> clientList = new ArrayList<Client>();
		int size = client_list.size();
		for (int i = 0; i < size; ++i)
		{
			Client client = client_list.get(i);
			if (client.getId() == id)
			{
				clientList.add(client);
			}
		}
		return clientList;
	}

	public String getName(int id)
	{
		return findClient(id).getName();
	}

	public String getBirth(int id)
	{
		return findClient(id).getBirth();
	}

	public String getEMail(int id)
	{
		return findClient(id).getEMail();
	}

	public String getAddress(int id)
	{
		return findClient(id).getAddress();
	}

	public void setName(int id, String name)
	{
		findClient(id).setName(name);
	}

	public void setBirth(int id, String birth)
	{
		findClient(id).setBirth(birth);
	}

	public void setEMail(int id, String eMail)
	{
		findClient(id).setEMail(eMail);
	}

	public void setAddress(int id, String address)
	{
		findClient(id).setAddress(address);
	}

	public void setItems(int id, String name, String birth, String eMail, String address)
	{
		findClient(id).setName(name);
		findClient(id).setBirth(birth);
		findClient(id).setEMail(eMail);
		findClient(id).setAddress(address);
		clientChanged();
	}

	public void clientChanged()
	{
		notifyObservers();
	}

	public void registerObservers(Observer observer)
	{
		// TODO Auto-generated method stub
		observers.add(observer);
	}

	public void removeObservers(Observer observer)
	{
		// TODO Auto-generated method stub
		observers.remove(observer);
	}

	public void notifyObservers()
	{
		// TODO Auto-generated method stub
		for (Observer o : observers)
			o.update(this);
	}
}
