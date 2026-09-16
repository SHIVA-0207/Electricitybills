import java.util.Scanner;

interface Calculator {
    void add(int a, int b);
    void sub(int a, int b);
    void mul(int a, int b);
    void div(int a, int b);
}

class Arithmetic implements Calculator {

    public void add(int a, int b) {
        System.out.println("Addition = " + (a + b));
    }

    public void sub(int a, int b) {
        System.out.println("Subtraction = " + (a - b));
    }

    public void mul(int a, int b) {
        System.out.println("Multiplication = " + (a * b));
    }

    public void div(int a, int b) {
        System.out.println("Division = " + (a / b));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        Arithmetic obj = new Arithmetic();

        obj.add(a, b);
        obj.sub(a, b);
        obj.mul(a, b);
        obj.div(a, b);
    }
}