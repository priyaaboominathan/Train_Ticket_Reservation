# Train_Ticket_Reservation
This is a train ticket booking console application written in java.
There are total of 63 berths for 63 confirmed tickets, 18 RAC and 10 Waiting List.
If confirmed seats are not available then, RAC is given. If RAC is not available then, Waiting list is given. If waiting list is greater than 10, then seats are full message is displayed.
This application implements the following modules:
  1) Booking a ticket:
         a) Passenger details are taken as input
         b) Seats are alloted based on passenger's berth preference and availability.
  2) Cancelling a ticket:
         Whenever a ticket is cancelled, a ticket from RAC should be confirmed and a Waiting List ticket must be moved to RAC.
  3) Printing Booked tickets:
         Occupied tickets are printed along with the passenger details.
  4) Printing available tickets:
         Unoccupied tickets are printed.
