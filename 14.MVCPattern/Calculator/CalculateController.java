package CalculatorMVCPattern;

public class CalculateController implements ControllerInterface
{
	private ViewFrame view;
	private Subject model;
	
	public CalculateController(Subject model)
	{
		this.model = model;
		view = new ViewFrame(this, model);
	}
	
	@Override
	public void push(int value)
	{
		model.setValue(value);
		model.valueChanged();
	}
}
