import java.util.Scanner;

public class Passenger {
    static  int ID =1;
    int p_ID;
    String name;
    int age;
    String Berth_pref;
    String alloted;
    int number;

    Passenger(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name, age and birth preference(L,M,U)");
        p_ID=ID++;
        name = scanner.next();
        age = scanner.nextInt();
        Berth_pref = scanner.next();
        alloted="";
        number=-1;
    }

}
