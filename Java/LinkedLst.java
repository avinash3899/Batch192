import java.util.LinkedList;
import java.util.Scanner;

class Ticket {

    String name;
    int age, type, fee;

    public void takeDetails() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter name: ");
        this.name = scan.nextLine();
        System.out.print("Customer(1) or Crew(2) ? :");
        this.type = scan.nextInt();
        System.out.print("Enter age: ");
        this.age = scan.nextInt();
        this.fee = ((type == 2) ? 0 : ((age >= 10) ? 500 : 250));
    }

    public void displayDetails() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Fee: " + this.fee);
        if (this.type == 1) {

            System.out.println("Person is a Customer");

        } else {

            System.out.println("Person is in crew");

        }

    }

}

public class LinkedLst {

    public static void main(String[] args) {

        LinkedList<Ticket> tickets = new LinkedList<Ticket>();

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("1.Add in DB");
            System.out.println("2.Display");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    Ticket t = new Ticket();
                    t.takeDetails();
                    tickets.add(t);
                    break;
                case 2:
                    System.out.println("What do you want to display ?");
                    System.out.println("1.Number of adults");
                    System.out.println("2.Number of childrens");
                    System.out.println("3.Number of crew");
                    System.out.println("4.Total cost of sold tickets");
                    System.out.println("5.Details about person");
                    System.out.print("Enter your choice: ");
                    int inerch = scan.nextInt();
                    switch (inerch) {
                        case 1:
                            int adultCount = 0;
                            for (Ticket tic : tickets) {
                                if (tic.age >= 10) {
                                    adultCount++;
                                }
                            }
                            System.out.println("Number of adults: " + adultCount);
                            break;
                        case 2:
                            int childrenCount = 0;
                            for (Ticket tic : tickets) {
                                if (tic.age < 10) {
                                    childrenCount++;
                                }
                            }
                            System.out.println("Number of children: " + childrenCount);
                            break;
                        case 3:
                            int crewCount = 0;
                            for (Ticket tic : tickets) {
                                if (tic.type == 2) {
                                    crewCount++;
                                }
                            }
                            System.out.println("Number of crew: " + crewCount);
                            break;
                        case 4:
                            int totalcost = 0;
                            for (Ticket tic : tickets) {
                                totalcost += tic.fee;
                            }
                            System.out.println("Total cost of tickets sold: " + totalcost);
                            break;
                        case 5:
                            Scanner sc = new Scanner(System.in);
                            System.out.print("Enter name of person:");
                            String nam = sc.nextLine();
                            for (Ticket ticket : tickets) {
                                if (ticket.name.equals(nam)) {
                                    System.out
                                            .println("\n\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
                                    ticket.displayDetails();
                                    System.out.println("\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
                                    break;
                                } else {
                                    if (ticket.name.equals(tickets.getLast().name))
                                        System.out.println("Not Found!");
                                }
                            }
                            break;
                        default:
                            System.out.println("Enter correct Choice.");
                            break;
                    }
                    break;

                default:
                    System.out.println("Enter correct Choice.");
                    break;
            }

        }

    }

}
