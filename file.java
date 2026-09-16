import java.io.*;
import java.util.Scanner;

public class file {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Source File Path: ");
            String sourcePath = scanner.nextLine();
            System.out.print("Destination File Path: ");
            String destPath = scanner.nextLine();
            
            copyFile(sourcePath, destPath);
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    private static void copyFile(String sourcePath, String destPath) {
        try (FileInputStream inStream = new FileInputStream(sourcePath);
             FileOutputStream outStream = new FileOutputStream(destPath)) {
            
            byte[] buffer = new byte[4096];
            int bytesRead;
            
            while ((bytesRead = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
            
            System.out.println("File copied successfully.");
            System.out.println("Destination File Created: " + destPath);
        } catch (FileNotFoundException e) {
            System.out.println("Error: The source or destination file could not be found or created.");
        } catch (IOException e) {
            System.out.println("Error: An I/O error occurred while copying the file.");
        }
    }
}
