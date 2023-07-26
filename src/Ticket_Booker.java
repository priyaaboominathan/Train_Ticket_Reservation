import java.util.*;

public class Ticket_Booker {
    static int avlbleLower = 21; //21
    static int avlblemiddle = 21;  //21
    static int avlbleupper = 21; //21
    static int avlbleRAC = 18;  //21
    static int avlbleWL = 10;  //21
    static List<Integer> L_seats = new ArrayList<>(Arrays.asList(21));  //1-21
    static List<Integer> M_seats = new ArrayList<>(Arrays.asList(21));
    static List<Integer> U_seats = new ArrayList<>(Arrays.asList(21));
    static List<Integer> RAC_seats = new ArrayList<>(Arrays.asList(18));
    static List<Integer> WL_seats = new ArrayList<>(Arrays.asList(10));


     static Queue<Integer> RAC = new ArrayDeque<>();
    static Queue<Integer> WL = new ArrayDeque<>();
    static List<Integer> Booked_list = new ArrayList<>();
    static HashMap<Integer,Passenger> passenger = new HashMap<>();

    public static void booklower(Passenger p){

        p.alloted = "L";
        p.number = L_seats.get(0);
        L_seats.remove(0);
        Ticket_Booker.avlbleLower--;
        Booked_list.add(p.p_ID);
        passenger.put(p.p_ID,p);
        PrintTicket(p);
    }
    public static void bookmiddle(Passenger p){

        p.alloted = "M";
        p.number = M_seats.get(0);
        M_seats.remove(0);
        Ticket_Booker.avlblemiddle--;
        Booked_list.add(p.p_ID);
        passenger.put(p.p_ID,p);
        PrintTicket(p);
    }
    public static void bookupper(Passenger p){
        Ticket_Booker.avlbleupper--;
        p.alloted = "U";
        p.number =U_seats.get(0);
        U_seats.remove(0);
        Booked_list.add(p.p_ID);
        passenger.put(p.p_ID,p);
        PrintTicket(p);
    }
    public static void bookRac(Passenger p){
        System.out.println("Sorry all berths are full and RAC will be alloted");
        Ticket_Booker.avlbleRAC--;
        p.alloted = "RAC";
        p.number =RAC_seats.get(0);
        RAC_seats.remove(0);
        RAC.add(p.p_ID);
        passenger.put(p.p_ID,p);
        PrintTicket(p);
    }
    public static void bookWL(Passenger p){
        System.out.println("Sorry all seats are full and you are under waiting list");
        Ticket_Booker.avlbleWL--;
        p.alloted = "WL";
        p.number =WL_seats.get(0);
        WL_seats.remove(0);
        WL.add(p.p_ID);
        passenger.put(p.p_ID,p);
        PrintTicket(p);
    }
    public static void PrintTicket(Passenger p){
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Passenger ID: "+p.p_ID+"\nName: "+p.name+"\nAge: "+p.age+"\nSeat Alloted : "+p.alloted+"-"+p.number);
        System.out.println("--------------------------------------------------------------------------------------------");
    }
    public static void BookTicket(Passenger p){
            switch (p.Berth_pref){
                case "L":
                    if(Ticket_Booker.avlbleLower>0) {
                        System.out.println("Your preferred berth is alloted");
                        Ticket_Booker.booklower(p); break;
                    }
                    else if (Ticket_Booker.avlblemiddle>0) {
                        System.out.println("Sorry preferred berth not available");
                        Ticket_Booker.bookmiddle(p); break;
                    }
                    else if(Ticket_Booker.avlbleupper>0) {
                        System.out.println("Sorry preferred berth not available");
                        Ticket_Booker.bookupper(p); break;
                    }
                    else if(Ticket_Booker.avlbleRAC>0){
                        Ticket_Booker.bookRac(p); break;
                    }
                    else {
                        Ticket_Booker.bookWL(p);break;
                    }
                case "M":
                    if(Ticket_Booker.avlblemiddle>0) {
                        System.out.println("Your preferred berth is alloted");
                        Ticket_Booker.bookmiddle(p); break;
                    }
                    else   if(Ticket_Booker.avlbleLower>0) {
                        System.out.println("Sorry preferred berth not available");
                        Ticket_Booker.booklower(p); break;
                    }
                    else if(Ticket_Booker.avlbleupper>0) {
                        System.out.println("Sorry preferred berth not available");
                    Ticket_Booker.bookupper(p); break;
                    }
                    else if(Ticket_Booker.avlbleRAC>0){
                        Ticket_Booker.bookRac(p); break;
                    }
                    else {
                        Ticket_Booker.bookWL(p);break;
                    }

                case "U":
                    if(Ticket_Booker.avlbleupper>0) {
                        System.out.println("Your preferred berth is alloted");
                        Ticket_Booker.bookupper(p);
                        break;
                    }
                    else if(Ticket_Booker.avlbleLower>0) {
                        System.out.println("Sorry preferred berth not available");
                        Ticket_Booker.booklower(p); break;
                    }
                    else if (Ticket_Booker.avlblemiddle>0) {
                        System.out.println("Sorry preferred berth not available");
                        Ticket_Booker.bookmiddle(p); break;
                    }
                    else if(Ticket_Booker.avlbleRAC>0){
                        Ticket_Booker.bookRac(p); break;
                    }
                    else {
                        Ticket_Booker.bookWL(p);break;
                    }
        }

    }
    public static void cancelTicket(){
        System.out.println("Enter your passenger ID: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        if(Booked_list.contains(id)){
            Booked_list.remove(Integer.valueOf(id));
        }
        else {
            System.out.println("Please enter correct Passenger ID or Booking doesn't exist");
            return;
        }
        Passenger p_cancel = passenger.get(id);
        switch (p_cancel.alloted){
            case "L": avlbleLower++;
            L_seats.add(p_cancel.number);
            break;
            case "M": avlblemiddle++;
            M_seats.add(p_cancel.number);
            break;
            case "U": avlbleupper++;
            U_seats.add(p_cancel.number);
            break;
        }
        passenger.remove(id);
        //shifting tickets
        if(Ticket_Booker.avlbleRAC==0){
            Integer curr_ID  = RAC.poll();
            avlbleRAC++;

            Passenger p_next = passenger.get(curr_ID);
            RAC_seats.add(p_next.number);
            System.out.println("Your berth is confirmed");
            BookTicket(p_next);
        }
        if(Ticket_Booker.avlbleWL==0){
            Integer curr_Id = WL.poll();
            avlbleWL++;
            Passenger p_next = passenger.get(curr_Id);
            WL_seats.add(p_next.number);
            System.out.println("Ticket promoted to RAC");
            Ticket_Booker.bookRac(p_next);
        }
    }
    public static void printPassengers(){
        for (Passenger p: passenger.values()){
            PrintTicket(p);
        }
    }
    public static void printAvailable(){
        System.out.println("Available tickets: \nLower berth: "+avlbleLower+
                "\nMiddle berth: "+avlblemiddle+"\nUpper berth: "+avlbleupper+"\nRAC: "+avlbleRAC);
    }
}
