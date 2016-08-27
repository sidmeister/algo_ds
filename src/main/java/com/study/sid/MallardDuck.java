package com.study.sid;

public class MallardDuck extends Duck {

	public MallardDuck()
	{
		flybehavoir = new FlyWithWings();
	}

	public void display()
	{
		System.out.println("I am a Mallard duck");
	}
	
	public static void main (String [] args)
	{
		Duck mallard = new MallardDuck();
		mallard.performfly();
	}
}
