package ru.stqa.pft.sanbox;

public class program{
	public static void main(String[] args){
		hello("world");
		hello("user");
		double len = 7;
		System.out.println("Сторона квадрата со стороной " + len + " = " + area(len));
		double a = 7;
		double b = 5;
		System.out.println("Сторона прямоугольника со сторонами " + a + " и " + b + " = " + area(a, b));
	}

	public static void hello(String somebody) {
		System.out.println("Hello, " + somebody + "!");
	}

	public static double area(double l) {
		return l * l;
	}

	public static double area(double a, double b) {
		return a * b;
	}
}