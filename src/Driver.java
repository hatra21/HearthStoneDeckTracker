import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        HearthStoneCard c1 = new HearthStoneCard("Armor Vendor",1,1,3);
        HearthStoneCard c2 = new HearthStoneCard("Wandmaker",2,2,2);
        c1.display();
        c2.display();


        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = input.nextLine();
        System.out.println(name);



    }
}
