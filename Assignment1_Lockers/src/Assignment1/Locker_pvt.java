package Assignment1;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Locker_pvt 
{
	private static void displayWelcomeScreen() 
	{
        System.out.println("Welcome to Lockers Pvt. Ltd");
        System.out.println("Developer: Abhishek");
        System.out.println("*************************************");
        System.out.println();
    }

    private static void displayMainMenu() {
        System.out.println("              MAIN MENU             ");
        System.out.println("1. Display file names in file system");
        System.out.println("2. Add a file into file system");
        System.out.println("3. Delete a file from file system");
        System.out.println("4. Search for a file in file system");
        System.out.println("5. Exit");
        System.out.println("*************************************");
        System.out.println();
    }

    // User has to give input to select the operation
    private static int getUserInput() 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the required operation: ");
        return sc.nextInt();
    }

    // Display all files present in the file system
    private static void displayFileNames() 
    {
        File directory = new File(DIRECTORY_PATH);
        File[] files = directory.listFiles();

        if (files != null && files.length > 0) 
        {
            Arrays.sort(files);
            System.out.println("Files in ascending order:");
            for (File file : files) 
            {
                System.out.println(file.getName());
            }
        } 
        else 
        {
            System.out.println("No such files found in the file system.");
        }

        System.out.println();
    }

    // Add new file to file system
    private static void addFile() 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the file name to add in file system: ");
        String fileName = sc.nextLine();

        File file = new File(DIRECTORY_PATH + fileName);
        try 
        {
            if (file.createNewFile()) 
            {
                System.out.println("File added successfully into file system.");
            } 
            else 
            
            {
                System.out.println("File already exists in file system.");
            }
        } catch (Exception e) 
        {
            System.out.println("An error occurred while adding the file.");
        }

        System.out.println();
    }

    // Delete file from file system
    private static void deleteFile() 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the file name to delete: ");
        String fileName = sc.nextLine();

        File directory = new File(DIRECTORY_PATH);
        File[] files = directory.listFiles();

        if (files != null) 
        {
            boolean found = false;
            for (File file : files) 
            {
                if (file.getName().equalsIgnoreCase(fileName))
                {
                    if (file.delete()) 
                    {
                        System.out.println("File deleted successfully from the file system.");
                    } 
                    else 
                    {
                        System.out.println("Unable to delete the file.");
                    }
                    found = true;
                    break;
                }
            }

            if (!found) 
            {
                System.out.println("File not found.");
            }
        } 
        else 
        {
            System.out.println("No files found in the file system.");
        }

        System.out.println();
    }

    // Search file in file system
    private static void searchFile() 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the file name to search: ");
        String fileName = sc.nextLine();

        File directory = new File(DIRECTORY_PATH);
        File[] files = directory.listFiles();

        if (files != null) 
        {
            boolean found = false;
            for (File file : files) 
            {
                if (file.getName().equalsIgnoreCase(fileName)) 
                {
                    System.out.println("File found: " + file.getName());
                    found = true;
                    break;
                }
            }

            if (!found) 
            {
                System.out.println("File not found.");
            }
        } 
        else 
        {
            System.out.println("No files found in the file system.");
        }

        System.out.println();
    }
    
    private static final String DIRECTORY_PATH = "G:\\Test\\Concept\\FileSyatem\\"; // Specify the directory path

    public static void main(String[] args) {
        displayWelcomeScreen();

        boolean exit = false;
        while (!exit) {
            displayMainMenu();
            int choice = getUserInput();

            switch (choice) {
                case 1:
                    displayFileNames();
                    break;
                case 2:
                    addFile();
                    break;
                case 3:
                    deleteFile();
                    break;
                case 4:
                    searchFile();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }

        System.out.println("Thank you for using the file system.");
    }
}

