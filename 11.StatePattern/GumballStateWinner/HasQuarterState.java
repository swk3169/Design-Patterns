package GumballStateWinner;

import java.util.Random;

public class HasQuarterState implements State
{
	private Random randomWinner = new Random(System.currentTimeMillis());	// 10%의 확률로 당첨 여부를 결정하는 난수 발생기를 추가
	private GumballMachine gumballMachine;

	public HasQuarterState(GumballMachine gumballMachine)
	{
		this.gumballMachine = gumballMachine;
	}

	public void insertQuarter()
	{
		System.out.println("You can't insert another quarter");
	}

	public void ejectQuarter()
	{
		System.out.println("Quarter returned");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}

	public void turnCrank()
	{
		System.out.println("You turned...");
		// 손잡이를 돌린 손님이 당첨되었는지 확인
		int winner = randomWinner.nextInt(10);
		if ((winner == 0) && (gumballMachine.getCount() > 1))	// 당첨이 되었고 알맹이도 두 개 이상이면 WinnerState
		{
			gumballMachine.setState(gumballMachine.getWinnerState());
		} 
		else	// 두 조건 중 하나라도 만족되지 않으면 그냥 전과 마찬가지로 SoldState
		{
			gumballMachine.setState(gumballMachine.getSoldState());
		}
	}

	public void dispense()
	{
		System.out.println("No gumball dispensed");
	}

	public void refill() {}

	public String toString()
	{
		return "waiting for turn of crank";
	}
}