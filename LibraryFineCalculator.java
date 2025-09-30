// Name: Vincent Mutinda
// Registration Number: S10-1823-2022
// SMA391 Object Oriented Programming Assignment
// Library Fine Calculation

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LibraryFineCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input details
        System.out.print("Enter Book ID: ");
        String bookID = scanner.nextLine();

        System.out.print("Enter Due Date (yyyy-MM-dd): ");
        String dueDateInput = scanner.nextLine();

        System.out.print("Enter Return Date (yyyy-MM-dd): ");
        String returnDateInput = scanner.nextLine();

        // Parse dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dueDate = LocalDate.parse(dueDateInput, formatter);
        LocalDate returnDate = LocalDate.parse(returnDateInput, formatter);

        // Calculate days overdue
        long daysOverdue = ChronoUnit.DAYS.between(dueDate, returnDate);
        daysOverdue = daysOverdue > 0 ? daysOverdue : 0; // No fine if returned early

        // Determine fine rate and amount
        int fineRate = 0;
        if (daysOverdue == 0) {
            fineRate = 0;
        } else if (daysOverdue <= 7) {
            fineRate = 20;
        } else if (daysOverdue <= 14) {
            fineRate = 50;
        } else {
            fineRate = 100;
        }
        int fineAmount = (int)daysOverdue * fineRate;

        // Display output
        System.out.println("\n--- Library Fine Details ---");
        System.out.println("Book ID      : " + bookID);
        System.out.println("Due Date     : " + dueDate);
        System.out.println("Return Date  : " + returnDate);
        System.out.println("Days Overdue : " + daysOverdue);
        System.out.println("Fine Rate    : Ksh. " + fineRate);
        System.out.println("Fine Amount  : Ksh. " + fineAmount);
    }
}