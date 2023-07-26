import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean bool = true;
        while (bool){
            System.out.println("Welcome to Railway Ticket booking System ");
            System.out.println("Enter 1 to book tickets \n Enter 2 to cancel tickets \n Enter 3 to view booked " +
                    "tickets \n Enter 4 to view available tickets \nEnter 5 to exit ");
            int n = scanner.nextInt();
            switch (n){
                //to book tickets
                case 1:
                    Passenger p = new Passenger();
                    if(Ticket_Booker.avlbleWL>0) Ticket_Booker.BookTicket(p);
                    else System.out.println("Sorry No tickets available");

                    break;
                    //to cancel tickets
                case 2:
                    Ticket_Booker.cancelTicket();
                    break;
                    //view booked tickets
                case 3:
                    Ticket_Booker.printPassengers();
                    break;
                    //view available tickets
                case 4:
                    Ticket_Booker.printAvailable();
                    break;
                default:
                    bool = false;
                    break;
            }
        }
    }
}