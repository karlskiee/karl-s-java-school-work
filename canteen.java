import java.util.Scanner;

public class canteen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char orderAgain;

        do {
            // 1. Display the Menu
            System.out.println("\n=== CANTEEN MENU ===");
            System.out.println("1. Burger   - $100.00");
            System.out.println("2. Pizza    - $150.00");
            System.out.println("3. Pasta    - $120.00");
            System.out.println("4. Sandwich - $80.00");
            System.out.println("5. Soda     - $50.00");
            System.out.println("====================");

            // 2. Get customer inputs
            System.out.print("Enter item number (1-5): ");
            int itemNumber = scanner.nextInt();

            System.out.print("Enter quantity (1-10): ");
            int quantity = scanner.nextInt();

            System.out.print("Are you a student? (Y/N): ");
            char isStudent = scanner.next().toUpperCase().charAt(0);

            // 3. Validation
            if (itemNumber < 1 || itemNumber > 5 || quantity < 1 || quantity > 10) {
                System.out.println("\nInvalid order. Please make sure to choose an item from 1-5 and a quantity between 1 and 10.");
                System.out.print("Do you want to try another order? (Y/N): ");
                orderAgain = scanner.next().toUpperCase().charAt(0);
                continue; // This skips the computation below and restarts the loop
            }

            // Determine the price based on the chosen item
            double price = 0.0;
            switch (itemNumber) {
                case 1: price = 100.00; break;
                case 2: price = 150.00; break;
                case 3: price = 120.00; break;
                case 4: price = 80.00; break;
                case 5: price = 50.00; break;
            }

            double amount = price * quantity;

            // 4. Calculate deduction based on conditions
            double deductionRate = 0.0;

            if (isStudent == 'Y' && amount >= 500) {
                deductionRate = 0.15; // 15% deduction
            } else if (isStudent == 'Y') {
                deductionRate = 0.10; // 10% deduction
            } else if (amount >= 500) {
                deductionRate = 0.05; // 5% deduction
            } else {
                deductionRate = 0.00; // 0% deduction
            }

            // Compute final amounts
            double deductionAmount = amount * deductionRate;
            double finalAmount = amount - deductionAmount;

            // Print the receipt for this order
            System.out.println("\n--- Order Summary ---");
            System.out.println("Subtotal: $" + amount);
            System.out.println("Discount applied: $" + deductionAmount);
            System.out.println("Total Amount to Pay: $" + finalAmount);
            System.out.println("---------------------");

            // 5. Ask to order again
            System.out.print("\nDo you want to order again? (Y/N): ");
            orderAgain = scanner.next().toUpperCase().charAt(0);

        } while (orderAgain == 'Y');

        System.out.println("\nThank you for using the Canteen Ordering System!");
        scanner.close();
    }
}