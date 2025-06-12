// Name: Tristan Padilla
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
        // Lists to store services and their details
		ArrayList<String> serviceNames = new ArrayList<>();
        ArrayList<String> categories = new ArrayList<>();
        ArrayList<Double> rates = new ArrayList<>();
        ArrayList<Integer> availabilities = new ArrayList<>();
        
        // Lists to store the user's cart
        ArrayList<String> cartServices = new ArrayList<>();
        ArrayList<Integer> cartHours = new ArrayList<>();

        while (true) {
            // Display the main menu
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add a Service");
            System.out.println("2. Book a Service");
            System.out.println("3. View Cart and Checkout");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            String choice = sc.nextLine();

            // Use if / else if / else for menu options
            if (choice.equals("1")) {
                // Add a service
                System.out.print("Enter Service Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Category: ");
                String category = sc.nextLine();
                System.out.print("Enter Hourly Rate: ");
                double rate = sc.nextDouble();
                System.out.print("Enter Available Hours: ");
                int available = sc.nextInt();

                // Store in lists
                serviceNames.add(name);
                categories.add(category);
                rates.add(rate);
                availabilities.add(available);

                System.out.println("Service \"" + name + "\" added successfully.");

            } else if (choice.equals("2")) {
                // Book a service
                if (serviceNames.isEmpty()) {
                    System.out.println("No services available.");
                } else {
                    // Show available categories
                    ArrayList<String> uniqueCategories = new ArrayList<>(categories);
                    System.out.println("Available Categories:");
                    for (String cat : uniqueCategories) {
                        System.out.println("- " + cat);
                    }

                    System.out.print("Choose a category: ");
                    String selectedCategory = sc.nextLine();

                    ArrayList<Integer> matchedIndexes = new ArrayList<>();
                    System.out.println("Services in category: " + selectedCategory);

                    for (int i = 0; i < categories.size(); i++) {
                        if (categories.get(i).equalsIgnoreCase(selectedCategory)) {
                            matchedIndexes.add(i);

                            // Use if-else instead of ternary
                            String status = "";
                            if (availabilities.get(i) > 0) {
                                status = availabilities.get(i) + " hour(s) available";
                            } else {
                                status = "Fully Booked";
                            }

                            System.out.println((matchedIndexes.size()) + ". " + serviceNames.get(i)
                                + " - $" + rates.get(i) + "/hr (" + status + ")");
                        }
                    }

                    if (matchedIndexes.isEmpty()) {
                        System.out.println("No services found in that category.");
                    } else {
                        System.out.println("Select a service by number: ");
                        int selected = sc.nextInt() - 1; sc.nextLine();

                        if (selected < 0 || selected >= matchedIndexes.size()) {
                            System.out.println("Invalid selection.");
                        } else {
                            int serviceIndex = matchedIndexes.get(selected);

                            if (availabilities.get(serviceIndex) == 0) {
                                System.out.println("This service is fully booked.");
                            } else {
                                System.out.print("Enter number of hours to book: ");
                                int hoursToBook = sc.nextInt(); sc.nextLine();

                                if (hoursToBook > availabilities.get(serviceIndex)) {
                                    System.out.println("Only " + availabilities.get(serviceIndex) + " hour(s) available.");
                                } else if (hoursToBook <= 0) {
                                    System.out.println("You must book at least 1 hour.");
                                } else {
                                    // Valid booking
                                    cartServices.add(serviceNames.get(serviceIndex));
                                    cartHours.add(hoursToBook);

                                    // Update availability
                                    int newAvailability = availabilities.get(serviceIndex) - hoursToBook;
                                    availabilities.set(serviceIndex, newAvailability);

                                    System.out.println("Added to cart.");
                                }
                            }
                        }
                    }
                }

            } else if (choice.equals("3")) {
                // View cart and checkout
                if (cartServices.isEmpty()) {
                    System.out.println("Your cart is empty.");
                } else {
                    double total = 0;
                    System.out.println("\n--- Invoice ---");

                    for (int i = 0; i < cartServices.size(); i++) {
                        String name = cartServices.get(i);
                        int hours = cartHours.get(i);
                        int index = serviceNames.indexOf(name);
                        double cost = rates.get(index) * hours;
                        total += cost;

                        System.out.println(name + " - " + hours + " hour(s) - $" + cost);
                    }

                    System.out.println("Total: $" + total);
                    cartServices.clear();
                    cartHours.clear();
                    System.out.println("Thank you for your order!");
                }

            } else if (choice.equals("4")) {
                // Exit
                System.out.println("Goodbye!");
                break;

            } else {
                // Invalid option
                System.out.println("Invalid option. Try again.");
            }
        }

        sc.close();
    }
}
