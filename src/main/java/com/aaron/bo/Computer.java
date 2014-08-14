package com.aaron.bo;

public class Computer implements Cloneable{

	private Component component;
	private String type;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Computer computer = new Computer();
		Component component = new Component(1, "dell");
		computer.setComponent(component);
		computer.setType("D630");
		try {
			Computer computer2 = (Computer)computer.clone();
			System.out.println(computer2.toString());
			component.setName("Lenovo");
			System.out.println(computer2.toString());
			System.out.println(computer == computer2);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Computer computer = (Computer)super.clone();
		computer.setComponent((Component)computer.getComponent().clone());
		return computer;
	}
	public void setComponent(Component component) {
		this.component = component;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Component getComponent() {
		return component;
	}
	@Override
	public String toString() {
		return component.toString() + " " + type;
	}
	
	

}
