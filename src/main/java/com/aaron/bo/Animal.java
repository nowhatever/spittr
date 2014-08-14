package com.aaron.bo;

/**
 * 匿名内部类演示源码
 * @author aaron
 *
 */
public abstract class Animal {
	
	public abstract void eat(String something);
	
	public abstract void drink(String something);
	
	public static class Dog extends Animal{

		@Override
		public void eat(String something) {
			System.out.println("dog eat " + something);
		}

		@Override
		public void drink(String something) {
			System.out.println("dog drink " + something);
		}
		
	}
	
	public static void main(String[] args) {
		
		Dog dog = new Animal.Dog();
		if(dog instanceof Animal){
			System.out.println(true);
		}
		
		Animal animal = new Animal() {
			
			@Override
			public void eat(String something) {
				System.out.println("eat " + something);
			}
			
			@Override
			public void drink(String something) {
				System.out.println("drink " + something);
			}
		};
		
		animal.eat("にく");
		animal.drink("milk");
	}
}
