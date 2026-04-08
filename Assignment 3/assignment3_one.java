// Compile-time polymorphism: Because: Method selection is decided at compile time based on parameters

import java.util.Scanner;
// Logic Class
class Shapes {
    double length, breadth, radius;

    // Constructor Overloading
    Shapes(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    Shapes(double radius) {
        this.radius = radius;
    }

    Shapes(int side) {
        this.length = side;
    }

    // Method Overloading
    double area(double l, double b) {
        return l * b;
    }

    double area(double r) {
        return Math.PI * r * r;
    }

    int area(int side) {
        return side * side;
    }
}

// Driver Class
public class assignment3_one {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Shape:");
        System.out.println("1. Rectangle");
        System.out.println("2. Circle");
        System.out.println("3. Square");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter length: ");
                double l = sc.nextDouble();
                System.out.print("Enter breadth: ");
                double b = sc.nextDouble();

                Shapes rect = new Shapes(l, b);
                System.out.println("Rectangle Area: " + rect.area(l, b));
                break;

            case 2:
                System.out.print("Enter radius: ");
                double r = sc.nextDouble();

                Shapes circle = new Shapes(r);
                System.out.println("Circle Area: " + circle.area(r));
                break;

            case 3:
                System.out.print("Enter side: ");
                int s = sc.nextInt();

                Shapes square = new Shapes(s);
                System.out.println("Square Area: " + square.area(s));
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
