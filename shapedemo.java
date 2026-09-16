import java.util.Scanner;

abstract class Shape {

abstract void printArea();

}

class Rectangle extends Shape {

int length, breadth;


Rectangle(int l, int b) {

length = l;

breadth = b;

}

void printArea() {

System.out.println("Area of Rectangle = " + (length * breadth));

}

}

class Triangle extends Shape {

int base, height;

Triangle(int b, int h) {

base = b;

height = h;

}

void printArea() {

System.out.println("Area of Triangle = " + (0.5 * base * height));

}

}

class Circle extends Shape {

int radius;

Circle(int r) {

radius = r;

}

void printArea() {

System.out.println("Area of Circle = " + (3.14 * radius * radius));

}

}

public class shapedemo {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

System.out.println("Enter Shape (Rectangle/Triangle/Circle): ");

String shape = sc.next();

if (shape.equalsIgnoreCase("Rectangle")) {

System.out.print("Length: ");

int l = sc.nextInt();

System.out.print("Breadth: ");

int b = sc.nextInt();

Rectangle r = new Rectangle(l, b);

r.printArea();

} else if (shape.equalsIgnoreCase("Triangle")) {

System.out.print("Base: ");

int base = sc.nextInt();

System.out.print("Height: ");

int h = sc.nextInt();

Triangle t = new Triangle(base, h);

t.printArea();

} else if (shape.equalsIgnoreCase("Circle")) {

System.out.print("Radius: ");

int r = sc.nextInt();

Circle c = new Circle(r);

c.printArea();

}

sc.close();

}

}