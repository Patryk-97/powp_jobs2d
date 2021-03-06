package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.Job2dDriver;

public class RectangleFigure implements IFigure {

	public RectangleFigure(Job2dDriver driver, int leftUpX, int leftUpY, int length, int height) {
		this.builder = ComplexCommand.builder();
		this.driver = driver;
		this.leftUpX = leftUpX;
		this.leftUpY = leftUpY;
		this.length = length;
		this.height = height;
	}
	
	@Override
	public DriverCommand draw() {
		
		builder.addCommand(new SetPositionCommand(leftUpX, leftUpY, driver));
		builder.addCommand(new OperateToCommand(leftUpX, leftUpY + height, driver));
		builder.addCommand(new OperateToCommand(leftUpX + length, leftUpY + height, driver));
		builder.addCommand(new OperateToCommand(leftUpX + length, leftUpY, driver));
		builder.addCommand(new OperateToCommand(leftUpX, leftUpY, driver));
		
		return builder.build();
	}
	
	private ComplexCommand.Builder builder;
	
	private Job2dDriver driver;
	
	private int leftUpX;
	private int leftUpY;
	private int length;
	private int height;
}
