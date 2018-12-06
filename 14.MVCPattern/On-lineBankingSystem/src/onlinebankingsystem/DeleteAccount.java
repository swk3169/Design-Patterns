package onlinebankingsystem;

public class DeleteAccount extends AccountCommand
{
	private int account_number;
	private int pin;

	public DeleteAccount(AccountDatabase accountDB, int account_number, int pin)
	{
		super.accountDB = accountDB;
		this.account_number = account_number;
	}

	public void execute()
	{
		// TODO Auto-generated method stub
		boolean check = false;
		while (check != true)
		{
			// screen.displayMessage("\n계좌번호 입력: ");
			boolean check_account = accountDB.checkAccount(account_number);
			if (check_account == false)
			{
				// screen.displayMessage("\nPIN 입력: ");
				boolean checkD = accountDB.authenticateUser(account_number, pin);
				if (checkD)
				{
					// screen.displayMessage("\n계좌를 삭제합니다.");
					accountDB.deleteAccount(account_number);
					check = true;
					break;
				} else
				{
					// screen.displayMsgLine("비밀번호가 일치하지 않습니다. 다시입력해주세요.");
				}
			} else
			{
				// screen.displayMsgLine("일치하는 계좌번호가 없습니다. 다시 입력해 주세요");
			}
		}
	}
}
