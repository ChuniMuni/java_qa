package ru.stqa.pft.sanbox;

import java.util.Scanner;

public class Program {
	public static void main(String[] args){
		hello("world");
		hello("user");

		Square s = new Square(5);
		System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

		Rectangle r = new Rectangle(7, 5);
		System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

		Point p1 = new Point(-4,10);
		Point p2 = new Point(0,13);
		System.out.println("Расстояние между точками (" + p1.toString() + ") и (" + p2.toString() + ") = " + p1.distance(p2));

		int a = printAndRead("Введите число:");
		int b = printAndRead("Введите число:");
		int c = printAndRead("Введите число:");

		if (a + b > c && a + c > b && b + c > a)
			System.out.println("Треугольник существует.");
		else
			System.out.println("Треугольник не существует.");
	}

	public static void hello(String somebody) {
		System.out.println("Hello, " + somebody + "!");
	}

	public static int printAndRead(String string) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print(string);

			if (sc.hasNextInt()) {
				return sc.nextInt();
			} else {
				sc.next();
				System.out.println("Введено не целое число ");
			}
		}
	}
}