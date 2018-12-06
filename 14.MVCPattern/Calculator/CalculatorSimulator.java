package CalculatorMVCPattern;

public class CalculatorSimulator
{
	public static void main(String[] args)
	{
		Subject model = new CalculatorModel();
		ControllerInterface controller = new CalculateController(model);
	}
}
