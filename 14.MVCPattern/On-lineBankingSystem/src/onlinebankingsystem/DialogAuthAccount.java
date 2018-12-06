package onlinebankingsystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogAuthAccount extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtAccountNumber;
	private JTextField txtPassword;
	private AccountDatabase accountDB;
	private boolean isAuth = false;
	//private Account acc;
	private int account_number;
	/**
	 * Launch the application.
	 */
	
	/* depreciated
	public static void main(String[] args) {
		try {
			DialogAuthAccount dialog = new DialogAuthAccount();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 */
	
	/**
	 * Create the dialog.
	 */
	public DialogAuthAccount(JFrame parent, String title, AccountDatabase accountDB) {
		super(parent, title, true);
		
		init();
		
		this.accountDB = accountDB;
	}
	
	private void init() {
		setBounds(100, 100, 313, 130);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblAccountNumber = new JLabel("Account Number:");
			lblAccountNumber.setBounds(41, 10, 106, 15);
			contentPanel.add(lblAccountNumber);
		}
		{
			txtAccountNumber = new JTextField();
			txtAccountNumber.setBounds(149, 7, 116, 21);
			contentPanel.add(txtAccountNumber);
			txtAccountNumber.setColumns(10);
		}
		{
			JLabel lblPassword = new JLabel("Password:");
			lblPassword.setBounds(41, 35, 76, 15);
			contentPanel.add(lblPassword);
		}
		{
			txtPassword = new JTextField();
			txtPassword.setBounds(149, 35, 116, 21);
			contentPanel.add(txtPassword);
			txtPassword.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String accountNumber = txtAccountNumber.getText();
						String password = txtPassword.getText();
						
						if (accountNumber.equals("") || password.equals("")) {
							JOptionPane.showMessageDialog(null, "정보를 입력해주세요!");
						}
						else {
							account_number = Integer.parseInt(accountNumber);
							int numPassword = Integer.parseInt(password);
							if (accountDB.authenticateUser(account_number, numPassword))
							{
								isAuth = true;
								//acc = accountDB.findAccount(numAccountNumber);
								JOptionPane.showMessageDialog(null, "계좌 인증을 성공하였습니다.");
							}
							else
							{
								isAuth = false;
								JOptionPane.showMessageDialog(null, "계좌 인증을 실패하였습니다.");
							}
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public boolean isAuth() {
		return isAuth;
	}
	
	public int getAccount() {
		return account_number;
	}
}
