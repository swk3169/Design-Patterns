package onlinebankingsystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class DialogCreateAccount extends JDialog
{

	private final JPanel contentPanel = new JPanel();

	private JTextField txtPersonalNumber;
	private JTextField txtAccountPassword;
	private JTextField txtDepositMoney;
	private JComboBox comboKindOfAccount;
	private ClientDatabase clientDB;
	private AccountDatabase accountDB;
	private TransactionDatabase transactionDB;

	/**
	 * Launch the application.
	 */
	/*
	 * depreciated public static void main(String[] args) { try {
	 * DialogCreateAccount dialog = new DialogCreateAccount();
	 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 */
	/**
	 * Create the dialog.
	 */
	public DialogCreateAccount(ClientDatabase clientDB, AccountDatabase accountDB, TransactionDatabase transactionDB)
	{
		init();

		this.clientDB = clientDB;
		this.accountDB = accountDB;
		this.transactionDB = transactionDB;
	}

	public void init()
	{
		setTitle("Register User");
		setBounds(100, 100, 289, 187);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblName = new JLabel("Personal Number:");
		lblName.setBounds(12, 13, 105, 15);
		contentPanel.add(lblName);

		txtPersonalNumber = new JTextField();
		txtPersonalNumber.setBounds(129, 10, 133, 21);
		contentPanel.add(txtPersonalNumber);
		txtPersonalNumber.setColumns(10);

		JLabel lblNewLabel = new JLabel("Account Password:");
		lblNewLabel.setBounds(12, 38, 116, 15);
		contentPanel.add(lblNewLabel);

		txtAccountPassword = new JTextField();
		txtAccountPassword.setBounds(129, 35, 133, 21);
		contentPanel.add(txtAccountPassword);
		txtAccountPassword.setColumns(10);

		JLabel lblEmail = new JLabel("Deposit Money:");
		lblEmail.setBounds(12, 63, 105, 15);
		contentPanel.add(lblEmail);

		txtDepositMoney = new JTextField();
		txtDepositMoney.setBounds(129, 60, 133, 21);
		contentPanel.add(txtDepositMoney);
		txtDepositMoney.setColumns(10);

		String[] kindOfAccount =
		{ "Normal", "Free", "Minus" };
		comboKindOfAccount = new JComboBox(kindOfAccount);
		comboKindOfAccount.setBounds(129, 85, 133, 21);
		comboKindOfAccount.setSelectedIndex(0);
		contentPanel.add(comboKindOfAccount);

		JLabel lblNewLabel_1 = new JLabel("Kind:");
		lblNewLabel_1.setBounds(12, 88, 57, 15);
		contentPanel.add(lblNewLabel_1);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnOK = new JButton("OK");
				btnOK.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String personalNumber = txtPersonalNumber.getText();
						String accPwd = txtAccountPassword.getText();
						String depositMoney = txtDepositMoney.getText();
						int kind = comboKindOfAccount.getSelectedIndex();

						if (personalNumber.equals("") || accPwd.equals("") || depositMoney.equals(""))
						{
							JOptionPane.showMessageDialog(null, "정보를 입력해주세요!");
						} else
						{
							// Command createClient = new CreateClient(clientDB,
							// name, birth, email, address);
							// createClient.excute();
							int client_id = clientDB.findClientNumber(personalNumber);

							if (client_id <= -1)
							{
								JOptionPane.showMessageDialog(null, "등록되지 않은 주민등록번호입니다!");
								return;
							}
							int balance = Integer.parseInt(depositMoney);
							int pin = Integer.parseInt(accPwd);
							String client_mail = clientDB.getEMail(client_id);

							Command createAccount = new CreateAccount(accountDB, transactionDB, client_id, client_mail,
									balance, pin, kind);
							createAccount.execute();

							JOptionPane.showMessageDialog(null, "계좌가 만들어졌습니다!");
							dispose();
						}
					}
				});
				btnOK.setActionCommand("OK");
				buttonPane.add(btnOK);
				getRootPane().setDefaultButton(btnOK);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
