package onlinebankingsystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ClientApp extends JFrame
{

	private JPanel contentPane;

	private AccountDatabase accountDB;
	private TransactionDatabase transactionDB;
	private JFrame jframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					AccountDatabase accountDB = new AccountDatabase();
					TransactionDatabase transactionDB = new TransactionDatabase();

					AccountFileManager afm = new AccountFileManager();
					TransactionFileManager tfm = new TransactionFileManager();

					afm.load(accountDB);
					tfm.load(transactionDB);

					ClientApp frame = new ClientApp(accountDB, transactionDB);
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientApp(AccountDatabase accountDB, TransactionDatabase transactionDB)
	{
		setTitle("ATM");
		init();

		this.accountDB = accountDB;
		this.transactionDB = transactionDB;

		jframe = this;
	}

	private void init()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 82);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton button = new JButton("Auth Account");
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				DialogAuthAccount dialog = new DialogAuthAccount(jframe, "Auth Account", accountDB);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				if (dialog.isAuth())
				{
					DialogAuthorizedAccount dialogAuthorizedAccount = new DialogAuthorizedAccount(dialog.getAccount(),
							accountDB, transactionDB);
					dialogAuthorizedAccount.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialogAuthorizedAccount.setVisible(true);
				}
			}
		});

		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				ClientFileManager cfm = new ClientFileManager();
				AccountFileManager afm = new AccountFileManager();
				TransactionFileManager tfm = new TransactionFileManager();

				try
				{
					afm.save(accountDB);
					tfm.save(transactionDB);
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});

		button.setBounds(91, 10, 134, 23);
		contentPane.add(button);
	}
}
