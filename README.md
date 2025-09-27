import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LibraryFine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // i. Input
        System.out.print("Enter Book ID: ");
        String bookID = sc.nextLine();

        System.out.print("Enter Due Date (YYYY-MM-DD): ");
        String dueDateStr = sc.nextLine();
        LocalDate dueDate = LocalDate.parse(dueDateStr, formatter);

        System.out.print("Enter Return Date (YYYY-MM-DD): ");
        String returnDateStr = sc.nextLine();
        LocalDate returnDate = LocalDate.parse(returnDateStr, formatter);

        // ii. Calculate days overdue
        long daysOverdue = ChronoUnit.DAYS.between(dueDate, returnDate);

        int fineRate;
        long fineAmount;

        if (daysOverdue <= 0) {
            fineRate = 0;
            fineAmount = 0;
            daysOverdue = 0;
        } else {
            // iii. Determine fine rate
            if (daysOverdue <= 7) {
                fineRate = 20;
            } else if (daysOverdue <= 14) {
                fineRate = 50;
            } else {
                fineRate = 100;
            }
            fineAmount = daysOverdue * fineRate;
        }

        // iv. Display output
        System.out.println("\n--- Library Fine Details ---");
        System.out.println("Book ID      : " + bookID);
        System.out.println("Due Date     : " + dueDate);
        System.out.println("Return Date  : " + returnDate);
        System.out.println("Days Overdue : " + daysOverdue);
        System.out.println("Fine Rate    : Ksh. " + fineRate);
        System.out.println("Fine Amount  : Ksh. " + fineAmount);

        sc.close();
    }
}
