package onlinebankingsystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class AdminApp extends JFrame {

	private JPanel contentPane;
	
	private ClientDatabase clientDB;
	private AccountDatabase accountDB;
	private TransactionDatabase transactionDB;
	private JFrame jframe;
	
	/**
	 * Create the frame.
	 */
	public AdminApp(ClientDatabase clientDB, AccountDatabase accountDB, TransactionDatabase transactionDB) {
		setTitle("Banking System");
		init();
		
		this.clientDB = clientDB;
		this.accountDB = accountDB;
		this.transactionDB = transactionDB;
		
		jframe = this;
	}
	
	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 248);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnRegisterUser = new JButton("Register User");
		btnRegisterUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DialogCreateClient dialog = new DialogCreateClient(clientDB);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		});
		
		btnRegisterUser.setBounds(157, 10, 134, 23);
		contentPane.setLayout(null);
		contentPane.add(btnRegisterUser);
		
		JButton btnShowUser = new JButton("Show Users");
		btnShowUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogShowUsers dialog = new DialogShowUsers(clientDB);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		btnShowUser.setBounds(157, 76, 134, 23);
		contentPane.add(btnShowUser);
		
		JButton btnMakeAcc = new JButton("Make Account");
		btnMakeAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogCreateAccount dialog = new DialogCreateAccount(clientDB, accountDB, transactionDB);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		btnMakeAcc.setBounds(157, 43, 134, 23);
		contentPane.add(btnMakeAcc);
		
		JButton btnShowAccount = new JButton("Show Accounts");
		btnShowAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogShowAccounts dialog = new DialogShowAccounts(accountDB);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		btnShowAccount.setBounds(157, 109, 134, 23);
		contentPane.add(btnShowAccount);
		
		JButton btnAuthAccount = new JButton("Auth Account");
		btnAuthAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogAuthAccount dialog = new DialogAuthAccount(jframe, "Auth Account", accountDB);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				if (dialog.isAuth()) {
					//Account acc = dialog.getAccount();
					//JOptionPane.showMessageDialog(null, "인증 성공");
					DialogAuthorizedAccount dialogAuthorizedAccount = new DialogAuthorizedAccount(dialog.getAccount(), accountDB, transactionDB);
					dialogAuthorizedAccount.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialogAuthorizedAccount.setVisible(true);
				}
			}
		});
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				ClientFileManager cfm = new ClientFileManager();
				AccountFileManager afm = new AccountFileManager();
				TransactionFileManager tfm = new TransactionFileManager();
				
				try {
					cfm.save(clientDB);
					afm.save(accountDB);
					tfm.save(transactionDB);	
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		
		btnAuthAccount.setBounds(157, 142, 134, 23);
		contentPane.add(btnAuthAccount);
		
		JButton btnPromote = new JButton("Promote");
		btnPromote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogMailing dialog = new DialogMailing(jframe, "Promote", clientDB);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		btnPromote.setBounds(157, 175, 134, 23);
		contentPane.add(btnPromote);
	}
}
