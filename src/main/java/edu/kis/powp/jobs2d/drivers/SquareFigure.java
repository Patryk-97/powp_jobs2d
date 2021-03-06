package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.command.ComplexCommand;
import edu.kis.powp.command.DriverCommand;
import edu.kis.powp.command.OperateToCommand;
import edu.kis.powp.command.SetPositionCommand;
import edu.kis.powp.jobs2d.Job2dDriver;

public class SquareFigure implements IFigure {
	
	public SquareFigure(Job2dDriver driver, int leftUpX, int leftUpY, int length) {
		this.builder = ComplexCommand.builder();
		this.driver = driver;
		this.leftUpX = leftUpX;
		this.leftUpY = leftUpY;
		this.length = length;
	}
	
	@Override
	public DriverCommand draw() {
		
		builder.addCommand(new SetPositionCommand(leftUpX, leftUpY, driver));
		builder.addCommand(new OperateToCommand(leftUpX, leftUpY + length, driver));
		builder.addCommand(new OperateToCommand(leftUpX + length, leftUpY + length, driver));
		builder.addCommand(new OperateToCommand(leftUpX + length, leftUpY, driver));
		builder.addCommand(new OperateToCommand(leftUpX, leftUpY, driver));
		
		return builder.build();
	}
	
	private ComplexCommand.Builder builder;
	
	private Job2dDriver driver;
	
	private int leftUpX;
	private int leftUpY;
	private int length;
}
