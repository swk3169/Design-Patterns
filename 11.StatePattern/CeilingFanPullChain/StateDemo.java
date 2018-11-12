package CeilingFanPullChainStatePattern;

import java.io.*;

public class StateDemo
{
	public static void main(String[] args)
	{
		CeilingFanPullChain chain = new CeilingFanPullChain();
		while (true)
		{
			System.out.print("Press ");
			get_line();
			chain.pull();
		}
	}

	static String get_line()
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try
		{
			line = in.readLine();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return line;
	}
}