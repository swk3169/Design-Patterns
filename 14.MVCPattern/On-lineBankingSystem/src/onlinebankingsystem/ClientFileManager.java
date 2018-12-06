package onlinebankingsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ClientFileManager
{
	public void save(ClientDatabase clientDB) throws IOException
	{
		PrintWriter pw = new PrintWriter("Client.txt");
		ArrayList<Client> client_list = clientDB.getClientList();

		for (int i = 0; i < client_list.size(); i++)
		{
			Client client = client_list.get(i);
			pw.println(client.getId() + "," + client.getName() + "," + client.getBirth() + "," + client.getEMail() + ","
					+ client.getAddress());
		}

		pw.close();
	}

	public void load(ClientDatabase clientDB) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("Client.txt"));
		while (true)
		{
			String line = br.readLine();
			if (line == null)
				break;

			String array[] = line.split(",");

			int id = Integer.parseInt(array[0]);
			String name = array[1];
			String birth = array[2];
			String eMail = array[3];
			String address = array[4];

			Client client = new Client(name, birth, eMail, address);
			client.setId(id);

			clientDB.insertClient(client);
		}
		br.close();
	}
}
