import java.util.ArrayList;
import java.util.Scanner;

public class TravelManagement {
    public static void main(String[] args) {

        ArrayList<String> cities = new ArrayList<>();
        Scanner s = new Scanner(System.in);

        int choice;

        do {
            System.out.println("******** MENU ********");
            System.out.println("1. Append City");
            System.out.println("2. Insert City");
            System.out.println("3. Search City");
            System.out.println("4. Display City");
            System.out.println("5. Display All City");
            System.out.println("6. Exit");
            System.out.print("Enter Your Choice: ");

            choice = s.nextInt();
            s.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter city to append: ");
                    String city = s.nextLine();
                    cities.add(city);
                    System.out.println("Updated List: " + cities);
                    break;
                case 2:
                    System.out.print("Enter the position (0 to " + cities.size() + "): ");
                    int position = s.nextInt();
                    s.nextLine(); // Consume newline

                    if (position >= 0 && position <= cities.size()) {
                        System.out.print("Enter city to insert: ");
                        String cityToInsert = s.nextLine();

                        cities.add(position, cityToInsert);
                        System.out.println("Updated List: " + cities);
                     } else {
                        System.out.println("Invalid position!");
                             }
                         break;
                case 3:
                    System.out.print("Enter city to search: ");
                    String searchCity = s.nextLine();

                    if (cities.contains(searchCity)) {
                             System.out.println(searchCity + " is found at position " + cities.indexOf(searchCity));
                     } else {
                             System.out.println(searchCity + " is not found in the list.");
                            }
                    break;
                case 4:
                    System.out.print("Enter position: ");
                     int pos = s.nextInt();

                    if (pos >= 0 && pos < cities.size()) {
                            System.out.println("City at position " + pos + ": " + cities.get(pos));
                    } else {
                            System.out.println("Invalid position!");
                            }
                    break;

                case 5:
                    if (cities.isEmpty()) {
                            System.out.println("No cities available.");
                    } else {
                            System.out.println("All Cities:");
                            for (int i = 0; i < cities.size(); i++) {
                            System.out.println(i + " : " + cities.get(i));
                        }
                            }
                    break;    





                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 6);

        s.close();
    }
}
