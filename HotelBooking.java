import java.sql.*;
import java.util.Scanner;

public class HotelBooking {

    static final String URL = "jdbc:mysql://localhost:3306/hoteldb";
    static final String USER = "root";
    static final String PASSWORD = "test@123";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            try ( // Connect Database
                    Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
                int choice;
                
                do {
                    
                    System.out.println("\n========== HOTEL BOOKING MANAGEMENT ==========");
                    System.out.println("1. Add Booking");
                    System.out.println("2. View Bookings");
                    System.out.println("3. Search Booking");
                    System.out.println("4. Update Booking Days");
                    System.out.println("5. Delete Booking");
                    System.out.println("6. Exit");
                     System.out.print("Enter Your Choice: ");
                    choice = sc.nextInt();
                    
                    switch(choice) {
                        
                        case 1:
                            
                            System.out.print("Enter Booking ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            
                            System.out.print("Enter Customer Name: ");
                            String name = sc.nextLine();
                            
                            System.out.print("Room Type !! \n1.Single bed\n2.Double Bed\n3.Master Bed");
                            System.out.print("\nEnter Room Type: ");
                            String room = sc.nextLine();
                            
                            System.out.print("Enter Number of Days: ");
                            int days = sc.nextInt();
                            double amount = 0;
                            if(room.equalsIgnoreCase("Single bed"))
                            {
                                amount=days*1000;
                            }
                            else if(room.equalsIgnoreCase("Double bed"))
                            {
                                amount=days*1500;
                            }
                            else if(room.equalsIgnoreCase("Master bed"))
                            {
                                amount=days*2500;
                            }
                            else
                            {
                                System.out.print("TYPE CORRECTLY !!! ");
                            }
                            System.out.print("TOTAL AMOUNT: "+ amount);
                            
                            
                            String insert = "INSERT INTO booking VALUES(?,?,?,?,?)";
                            
                            PreparedStatement ps = con.prepareStatement(insert);
                            
                            ps.setInt(1, id);
                            ps.setString(2, name);
                            ps.setString(3, room);
                            ps.setInt(4, days);
                            ps.setDouble(5, amount);
                            
                            int row = ps.executeUpdate();
                            
                            if(row > 0)
                                System.out.println("Booking Added Successfully.");
                            
                            break;
                            
                        case 2:
                            
                            Statement st = con.createStatement();
                            
                            ResultSet rs = st.executeQuery("SELECT * FROM booking");
                            
                            System.out.println("\n--------------------------------------------------------------");
                            System.out.println("ID\tCustomer\tRoom\tDays\tAmount");
                            System.out.println("--------------------------------------------------------------");
                            
                            while(rs.next()) {
                                
                                System.out.println(
                                        rs.getInt("booking_id") + "\t" +
                                                rs.getString("customer_name") + "\t" +
                                                rs.getString("room_type") + "\t" +
                                                rs.getInt("days") + "\t" +
                                                rs.getDouble("amount"));
                            }
                            
                            break;
                        case 3:
                            System.out.print("Enter Booking ID to Search: ");
                            int searchId = sc.nextInt();

                            String search = "SELECT * FROM booking WHERE booking_id=?";

                            PreparedStatement psSearch = con.prepareStatement(search);

                            psSearch.setInt(1, searchId);

                            ResultSet rsSearch = psSearch.executeQuery();

                            if(rsSearch.next()) {

                            System.out.println("\nBooking Found");
                            System.out.println("-----------------------------");
                            System.out.println("Booking ID    : " + rsSearch.getInt("booking_id"));
                            System.out.println("Customer Name : " + rsSearch.getString("customer_name"));
                            System.out.println("Room Type     : " + rsSearch.getString("room_type"));
                            System.out.println("Days          : " + rsSearch.getInt("days"));
                            System.out.println("Amount        : " + rsSearch.getDouble("amount"));

                            } 
                            else 
                            {

                            System.out.println("Booking Not Found.");

                            }

                            break;
                        case 4:
                            
                            System.out.print("Enter Booking ID: ");
                            int bid = sc.nextInt();
                            
                            System.out.print("Enter DAYS: ");
                            double newDays = sc.nextDouble();
                            
                            String update = "UPDATE booking SET days=? WHERE booking_id=?";
                            
                            PreparedStatement ps2 = con.prepareStatement(update);
                            
                            ps2.setDouble(1, newDays);
                            ps2.setInt(2, bid);
                            
                            int updateRow = ps2.executeUpdate();
                            
                            if(updateRow > 0)
                                System.out.println("Booking Updated Successfully.");
                            else
                                System.out.println("Booking Not Found.");
                            
                            break;
                            
                        case 5:
                            
                            System.out.print("Enter Booking ID: ");
                            int deleteId = sc.nextInt();
                            
                            String delete = "DELETE FROM booking WHERE booking_id=?";
                            
                            PreparedStatement ps3 = con.prepareStatement(delete);
                            
                            ps3.setInt(1, deleteId);
                            
                            int deleteRow = ps3.executeUpdate();
                            
                            if(deleteRow > 0)
                                System.out.println("Booking Deleted Successfully.");
                            else
                                System.out.println("Booking Not Found.");
                            
                            break;
                            
                        case 6:
                            
                            System.out.println("Thank You...");
                            break;
                            
                        default:
                            
                            System.out.println("Invalid Choice.");
                            
                    }
                    
                } while(choice != 6);
            }
            sc.close();

        }

        catch(ClassNotFoundException e) {
            System.out.println("MySQL Driver Not Found.");
        }

        catch(SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        catch(Exception e) {
            System.out.println(e);
        }

    }

}