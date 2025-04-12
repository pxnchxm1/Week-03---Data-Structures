class TicketNode{
    int ticketId;
    String customerName;
    String movieName;
    int seatNo;
    String bookingTime;
    static int countTickets;
    TicketNode next;
    public TicketNode(int ticketId, String customerName, String movieName, int seatNo, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNo = seatNo;
        this.bookingTime = bookingTime;
        this.next = null;
        countTickets++;
    }
}
class Reservations{
    TicketNode head;
    TicketNode tail;
    public Reservations() {
        this.head = null;
        this.tail = null;
    }
    public void bookTicket(TicketNode newTicket) {
        if(head==null){
            head = newTicket;
            tail = newTicket;
            tail.next = head;
        }else{
            TicketNode curr = head;
            while(curr.next!=head){
                curr = curr.next; 
            }
            curr.next = newTicket;
            tail = newTicket;
            tail.next = head;
            
        }
    }
    public void cancelTicket(int t){
        if(head==null){
            System.out.println("There are no tickets to cancel.");
            return;
        }else{
            TicketNode curr = head;
            if(curr.ticketId==t){
                head = curr.next;
                tail.next = curr.next;
            }
            while(curr.next!= head){
                if(curr.next.ticketId ==t){
                    if(curr.next == tail){
                        curr.next = head;
                        tail = curr;
                    }else{
                        curr.next = curr.next.next;
                    }
                    return;
                }
                curr = curr.next;
            }

        }
        
    }
    public void printTickets(){
        if(head==null){
            System.out.println("There are no tickets booked.");
            return;
        }else{
            TicketNode curr = head;
            while(curr.next!=head){
                System.out.print("Ticket ID: " + curr.ticketId + "------>");
                curr = curr.next;
            }
            System.out.print("Ticket ID: " + curr.ticketId + "------>");
            System.out.print("End of tickets.\n");
        }
    }
    public void searchTicket(String cN){
        if(head==null){
            System.out.println("There are no tickets booked.");
            return;
        }else{
            TicketNode curr = head;
            while(curr.next!=head){
                if(curr.customerName.equals(cN)){
                    System.out.print("Ticket ID: " + curr.ticketId );
                    System.out.print("Customer Name: " + curr.customerName);
                    System.out.print("Movie Name: " + curr.movieName);
                    System.out.print("Seat No: " + curr.seatNo);
                    System.out.print("Booking Time: " + curr.bookingTime);
                    System.out.println();
                    return;
                }
                curr = curr.next;
            }
            System.out.println("Ticket not found.");
            
        }
    }
    public String getCountTickets() {
        return "\nTotal Ticket Booked is  : " + TicketNode.countTickets +"\n";
    }
}
public class OnlineTicketReservationSystem {
    public static void main(String[] args) {
        Reservations r = new Reservations();
        r.bookTicket(new TicketNode(1, "John Doe", "Avengers", 5, "2023-10-01 10:00"));
        r.bookTicket(new TicketNode(2, "Jane Smith", "Batman", 10, "2023-10-01 12:00"));
        r.bookTicket(new TicketNode(3, "Alice Johnson", "Superman", 15, "2023-10-01 14:00"));
        r.printTickets();
        r.cancelTicket(2);
        r.printTickets();
        r.cancelTicket(3);
        r.printTickets();
        r.bookTicket(new TicketNode(4, "Bob Brown", "Spiderman", 20, "2023-10-01 16:00"));
        r.printTickets();
        r.searchTicket("John Doe");
        System.out.println(r.getCountTickets());
        
    }
}
