package com.study.sid;

public class swap {

	public static void main(String args[]) {
		Animal a2 = new Animal("Crocodile");

		System.out.println("Before change a2:" + a2);
		swap(a2);
		System.out.println("After change:a2:" + a2);
	}

	public static void swap(Animal animal1) {
		animal1.name = "Lion";
	}

}

class Animal {
	String name;

	public Animal(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}