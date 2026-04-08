import java.util.Scanner;

// Parent Class
class Hillstations {
    void famousfood() {
        System.out.println("Famous food of hill station");
    }

    void famousfor() {
        System.out.println("Famous for scenic beauty");
    }
}

// Child Class 1
class Manali extends Hillstations {
    @Override //optional but good practice to indicate method overriding
    void famousfood() {
        System.out.println("Manali is famous for Siddu");
    }

    @Override
    void famousfor() {
        System.out.println("Manali is famous for Snow Mountains");
    }
}

// Child Class 2
class Mussoorie extends Hillstations {
    @Override
    void famousfood() {
        System.out.println("Mussoorie is famous for Momos");
    }

    @Override
    void famousfor() {
        System.out.println("Mussoorie is famous for Hills and Waterfalls");
    }
}

// Child Class 3
class Gulmarg extends Hillstations {
    @Override
    void famousfood() {
        System.out.println("Gulmarg is famous for Rogan Josh");
    }

    @Override
    void famousfor() {
        System.out.println("Gulmarg is famous for Skiing");
    }
}

// Driver Class
public class assignment3_two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Hill Station:");
        System.out.println("1. Manali");
        System.out.println("2. Mussoorie");
        System.out.println("3. Gulmarg");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        Hillstations hs; // Parent reference variable

        switch (choice) {
            case 1:
                hs = new Manali();  //actual object is of Manali class but reference is of Hillstations class 
                break;
            case 2:
                hs = new Mussoorie();
                break;
            case 3:
                hs = new Gulmarg();
                break;
            default:
                System.out.println("Invalid choice!");
                sc.close();
                return;
        }

        System.out.println("\n--- Details ---");
        hs.famousfood();   // Runtime Polymorphism
        hs.famousfor();

        sc.close();
    }
}