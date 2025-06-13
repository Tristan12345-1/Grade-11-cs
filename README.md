# Grade-11-cs

serviceNames	  ArrayList<String>	Stores the names of each service added by the user.

categories	ArrayList<String>	Stores the category (e.g., "Cleaning") of each service.

rates	ArrayList<Double>	Stores the hourly rate for each service.

availabilities	ArrayList<Integer>	Stores the number of available hours for each service.

cartServices	ArrayList<String>	Tracks which services the user has added to their cart.

cartHours	ArrayList<Integer>	Tracks the number of hours booked for each service in the    
                                                           cart.

choice	String	Stores the user's menu selection (1–4).

matchedIndexes	ArrayList<Integer>	Temporarily stores indexes of services that match the selected category.

selected, hoursToBook	int	Used to store use


1. Main Menu System
Displayed in a while (true) loop until the user chooses to exit.

Offers 4 options:

Add a service

Book a service

View cart and checkout

Exit the program


2. Add a Service
Prompts the user to input:

Service name

Category

Hourly rate

number of available hours


3 Book a Service
Displays all service categories.

Let the user choose a category, then filter and display matching services.

For each matching service:

Shows name, hourly rate, and availability.

Marks services as "Fully Booked" if their available hours = 0.

Let the user book hours if available.

Adds selected service and hours to the cart (cartServices and cartHours).


4. View Cart and Checkout
Lists all services in the cart.

Shows:

Name

Hours booked

Cost (rate × hours)

Displays total cost.

Clears the cart after checkout.

Thanks the user.


5. Exit
Ends the loop and prints a goodbye message.
