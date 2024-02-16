package com.cctbmanagement;
import com.cctbmanagement.CRUD.AddData;
import com.cctbmanagement.CRUD.DataInitializer;
import com.cctbmanagement.CRUD.DeleteData;
import com.cctbmanagement.CRUD.Report;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import io.github.cdimascio.dotenv.Dotenv;

public class Main {
    public static void main(String[] args) throws SQLException {

        // Getting Parameters
        char mainMenu = 'a';
        char secondMenu = 'a';
        //Scanner scanner = new Scanner(System.in);

        // variables menu initializer
        boolean onMenu = true;
        boolean onSecondMenu = true;

        // Load environment variables from .env file
        Dotenv dotenv = Dotenv.configure().load();
        
        // Credentials for Planet Scale
        String dbHost = dotenv.get("DB_HOST");
        String dbUsername = dotenv.get("DB_USERNAME");
        String dbPassword = dotenv.get("DB_PASSWORD");
        String dbName = dotenv.get("DB_NAME");


        // JDBC connection properties
        Properties props = new Properties();
        props.setProperty("user", dbUsername);
        props.setProperty("password", dbPassword);
        props.setProperty("useSSL", "true"); // Enable SSL

        // Building the connection URL
        String url = "jdbc:mysql://" + dbHost + "/" + dbName;

        // Conection variable
        Connection connection = null;

        // Establishing connection with Planet Scale
        try {

            connection = DriverManager.getConnection(url, props);
            if (connection != null) {
                System.out.println("Connected to the database.");
            } else {
                System.out.println("Failed to connect to the database.");
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create an instance of data initializer
        DataInitializer dataInitializer = new DataInitializer();

        //call the initialize data method to insert the first data within the tables
        dataInitializer.InitializeData(connection);

        //main menu call
        System.out.println("Welcome to this Basic School Management Program \n");
        Scanner scanner = new Scanner(System.in);

        while (onMenu) {  // loops the main menu until the user press 'X' to exit the program.
            printMainMenu();
            mainMenu = scanner.next().charAt(0);
            onSecondMenu = true;
            
            switch (mainMenu) {
                case 'S': { //Student Management

                    System.out.println("\n Selecting Student Management \n");
                    while (onSecondMenu){
                        printMenu();
                        secondMenu = scanner.next().charAt(0);

                        switch (secondMenu) {
                            case 'N': {
                                System.out.println("Insert mode enabled: ");
                                // call external class for connecting to DB
                                AddData.StudentAdd(connection);
                                break;
                            }

                            case 'D': {
                                System.out.println("Deleting mode enabled: ");
                                // call external class for connecting to DB
                                DeleteData.IDDelete(connection, "Student", "StudentID");
                                break;
                            }

                            case 'X': {
                                System.out.println("Returning to main menu. ");
                                onSecondMenu = false;
                                break;
                            }

                            default: {
                                System.out.println("Unknown response, try again: \n ");
                                break;
                            }

                        }
                   
                    }
                    break;
                }

                case 'I': { // Instructor Management
                   
                    System.out.println("\n Instructor Management selected! \n");
                    while (onSecondMenu){
                        printMenu();
                        secondMenu = scanner.next().charAt(0);

                        switch (secondMenu) {
                            case 'N': {
                                System.out.println("Insert mode enabled: ");
                                // call external class for connecting to DB
                                AddData.InstructorAdd(connection);
                                break;
                            }

                            case 'D': {
                                System.out.println("Deleting mode enabled: ");
                                // call external class for connecting to DB
                                DeleteData.IDDelete(connection, "Instructor", "InstructorID");
                                break;
                            }

                            case 'X': {
                                System.out.println("Returning to main menu. ");
                                onSecondMenu = false;
                                break;
                            }

                            default: {
                                System.out.println("Unknown response, try again: \n ");
                                break;
                            }

                        }
                   
                    }
                    break;
                }

                case 'C': { // course management

                    System.out.println("\n Course Management selected! \n");
                    while (onSecondMenu){
                        printMenu();
                        secondMenu = scanner.next().charAt(0);

                        switch (secondMenu) {
                            case 'N': {
                                System.out.println("Insert mode enabled: ");
                                // call external class for connecting to DB
                                AddData.CourseAdd(connection);
                                break;
                            }

                            case 'D': {
                                System.out.println("Deleting mode enabled: ");
                                // call external class for connecting to DB
                                DeleteData.IDDelete(connection, "Course", "CourseID");
                                break;
                            }

                            case 'X': {
                                System.out.println("Returning to main menu. ");
                                onSecondMenu = false;
                                break;
                            }

                            default: {
                                System.out.println("Unknown response, try again: \n ");
                                break;
                            }

                        }
                   
                    }
                   break;
                }

                case 'R': { // classroom management
                    System.out.println("\n Classroom Management selected! \n");
                    while (onSecondMenu){
                        printMenu();
                        secondMenu = scanner.next().charAt(0);

                        switch (secondMenu) {
                            case 'N': {
                                System.out.println("Insert mode enabled: ");
                                // call external class for connecting to DB
                                AddData.ClassroomAdd(connection);
                                break;
                            }

                            case 'D': {
                                System.out.println("Deleting mode enabled: ");
                                // call external class for connecting to DB
                                DeleteData.IDDelete(connection, "Classroom", "ClassroomID");
                                break;
                            }

                            case 'X': {
                                System.out.println("Returning to main menu. ");
                                onSecondMenu = false;
                                break;
                            }

                            default: {
                                System.out.println("Unknown response, try again: \n ");
                                break;
                            }
                        }
                    }
                break;
                }

                case 'G':{ // Grades Management
                    System.out.println("\n Grades Management selected! \n");
                    while (onSecondMenu){
                        printMenu();
                        secondMenu = scanner.next().charAt(0);

                        switch (secondMenu) {
                            case 'N': {
                                System.out.println("Insert mode enabled: ");
                                // call external class for connecting to DB
                                AddData.GradesAdd(connection);
                                break;
                            }

                            case 'D': {
                                System.out.println("Deleting mode enabled: ");
                                // call external class for connecting to DB
                                DeleteData.IDDelete(connection, "Grades", "GradesID");
                                break;
                            }

                            case 'X': {
                                System.out.println("Returning to main menu. ");
                                onSecondMenu = false;
                                break;
                            }

                            default: {
                                System.out.println("Unknown response, try again: \n ");
                                break;
                            }
                        }
                    }
                    break;
                }

                case 'E':{ // Enrollment Management
                    System.out.println("\n Enrollment Management selected! \n");
                    while (onSecondMenu){
                        printMenu();
                        secondMenu = scanner.next().charAt(0);

                        switch (secondMenu) {
                            case 'N': {
                                System.out.println("Insert mode enabled: ");
                                // call external class for connecting to DB
                                AddData.EnrollmentAdd(connection);
                                break;
                            }

                            case 'D': {
                                System.out.println("Deleting mode enabled: ");
                                // call external class for connecting to DB
                                DeleteData.IDDelete(connection, "Enrollment", "EnrollmentID");
                                break;
                            }

                            case 'X': {
                                System.out.println("Returning to main menu. ");
                                onSecondMenu = false;
                                break;
                            }

                            default: {
                                System.out.println("Unknown response, try again: \n ");
                                break;
                            }
                        }
                    }
                    break;
                }

                case 'V':{ // Show Report
                    Report.ReadReport(connection);
                    break;
                }

                case 'X':{
                    System.out.println("Exiting now... \n");
                    onMenu = false;
                    break;
                }

                default: {
                    System.out.println("Unknown response, try again.... \n");
                    break;
                }
            }

        }

        scanner.close();
        System.out.println("Thanks for using this program.");

    }

    private static void printMenu() {
        System.out.println("\n Please select from the options: ");
        System.out.println("For inserting data, select N");
        //System.out.println("For editing data, select  E ");
        System.out.println("For deleting data, select  D ");
        System.out.println("To return to the prior menu press  X ");
    }

    private static void printMainMenu() {
        System.out.println("Please select from the options: \n "
                    + "\n For Student management, select S "
                    + "\n For Instructor management, select I "
                    + "\n For Course management, select C "
                    + "\n For Classroom management, select R "
                    + "\n For Grades management, select G "
                    + "\n For Enrollment management, select E "
                    + "\n For Report, select V "
                    + "\n To leave, press X ");
    }

}