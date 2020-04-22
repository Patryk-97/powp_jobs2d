package edu.kis.powp.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class OperateToCommand implements DriverCommand {
	
	public OperateToCommand(int x, int y, Job2dDriver driver) {
		this.x = x;
		this.y = y;
		this.driver = driver;
	}
	
	public void execute() {
		this.driver.operateTo(x, y);
	}
	
	private int x;
	private int y;
	private Job2dDriver driver;
}