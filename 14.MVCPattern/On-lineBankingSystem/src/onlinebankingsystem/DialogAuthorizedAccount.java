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

import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class DialogAuthorizedAccount extends JDialog
{

	private final JPanel contentPanel = new JPanel();
	private JLabel labelAccNumber, labelBalance;

	private int account_number;
	private TransactionDatabase transactionDB;
	private AccountDatabase accountDB;

	/**
	 * Launch the application.
	 */
	/*
	 * depreciated public static void main(String[] args) { try {
	 * DialogAuthorizedAccount dialog = new DialogAuthorizedAccount();
	 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 */

	/**
	 * Create the dialog.
	 */
	public DialogAuthorizedAccount(int account_number, AccountDatabase accountDB, TransactionDatabase transactionDB)
	{
		// super(parent, title, true);

		init();

		this.account_number = account_number;
		this.accountDB = accountDB;
		this.transactionDB = transactionDB;

		update();
	}

	private void init()
	{
		setBounds(100, 100, 450, 132);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblAccountNumber = new JLabel("Account Number:");
			lblAccountNumber.setBounds(12, 10, 107, 15);
			contentPanel.add(lblAccountNumber);
		}
		{
			JLabel lblBalance = new JLabel("Balance:");
			lblBalance.setBounds(12, 35, 57, 15);
			contentPanel.add(lblBalance);
		}
		{
			labelAccNumber = new JLabel("0");
			labelAccNumber.setBounds(119, 10, 57, 15);
			contentPanel.add(labelAccNumber);
		}
		{
			labelBalance = new JLabel("0");
			labelBalance.setBounds(119, 35, 57, 15);
			contentPanel.add(labelBalance);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnDeposit = new JButton("Deposit");
				btnDeposit.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String amount = JOptionPane.showInputDialog(null, "금액: ");
						long longAmount = Long.parseLong(amount);
						boolean done = accountDB.credit(account_number, longAmount);
						if (done)
						{
							Transaction transaction = new Transaction("입금", account_number, account_number,
									longAmount, new Date(), "");
							transactionDB.insertTransaction(transaction);
							JOptionPane.showMessageDialog(null, "입금을 완료하였습니다.");
							update();
						} else
						{
							JOptionPane.showMessageDialog(null, "입금을 실패하였습니다.");
						}
					}
				});
				btnDeposit.setActionCommand("OK");
				buttonPane.add(btnDeposit);
				getRootPane().setDefaultButton(btnDeposit);
			}
			{
				JButton btnWithdraw = new JButton("Withdraw");
				btnWithdraw.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String amount = JOptionPane.showInputDialog(null, "금액: ");
						long longAmount = Long.parseLong(amount);
						boolean done = accountDB.debit(account_number, longAmount);
						if (done)
						{
							Transaction transaction = new Transaction("출금", account_number, account_number, longAmount,
									new Date(), "");
							transactionDB.insertTransaction(transaction);
							JOptionPane.showMessageDialog(null, "출금을 완료하였습니다.");
							update();
						} else
						{
							JOptionPane.showMessageDialog(null, "출금을 실패하였습니다.");
						}
					}
				});
				buttonPane.add(btnWithdraw);
			}
			{
				JButton btnTransfer = new JButton("Transfer");
				btnTransfer.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						DialogTransfer dialog = new DialogTransfer(null, "계좌이체", accountDB);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);

						if (dialog.isOK())
						{
							long amount = dialog.getAmount();
							// Transaction(String transaction_info, int
							// deposit_acc_num, int withdraw_acc_num, long
							// amount, Date date, String remarks)

							if (accountDB.debit(account_number, amount))
							{
								// Account depositAcc =
								// accountDB.findAccount(dialog.getAccNumber());
								accountDB.credit(dialog.getAccNumber(), amount);
								// depositAcc.credit(amount);
								Transaction transaction = new Transaction("계좌이체", dialog.getAccNumber(),
										account_number, amount, new Date(), dialog.getRemarks());
								transactionDB.insertTransaction(transaction);
								JOptionPane.showMessageDialog(null, "계좌이체를 완료하였습니다.");
								update();
							}

						}
					}
				});
				buttonPane.add(btnTransfer);
			}
			{
				JButton btnNewButton = new JButton("History");
				btnNewButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						DialogShowTransactions dialog = new DialogShowTransactions(account_number, transactionDB);
						// transactionDB.registerObservers(dialog);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					}
				});
				buttonPane.add(btnNewButton);
			}
			{
				JButton cancelButton = new JButton("Remove");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void update()
	{
		labelAccNumber.setText(String.valueOf(account_number));
		labelBalance.setText(String.valueOf(accountDB.getBalance(account_number)));
	}
}
