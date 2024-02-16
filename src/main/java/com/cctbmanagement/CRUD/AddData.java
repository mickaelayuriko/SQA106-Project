package com.cctbmanagement.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddData {

    public static void StudentAdd(Connection connection) throws SQLException {
     String insertStudentQuery = "INSERT INTO Student (StudentID, StudentName) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(insertStudentQuery)) {

            // Obtém o próximo valor do sequenciador para StudentID
            int nextStudentID = nextStudentID(connection);

            // Solicita ao usuário as informações do novo estudante
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please insert the student name:");
            String nome = scanner.nextLine();
            
            //Executa o query para add novo estudante na tabela
            statement.setInt(1, nextStudentID);
            statement.setString(2, nome);
            int afectedLines = statement.executeUpdate();

            // Verifica se a inserção foi bem-sucedida
            if (afectedLines > 0) {
                System.out.println("Student added!");
            } else {
                System.out.println("Error to add student");
            }

        }
    }
    
    public static void InstructorAdd(Connection connection) throws SQLException {
        String insertStudentQuery = "INSERT INTO Instructor (InstructorID, InstructorName) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(insertStudentQuery)) {

            int nextID = nextID(connection, "Instructor", "InstructorID");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Please insert the Instructor Name:");
            String name = scanner.nextLine();
            
            //Execute the query 
            statement.setInt(1, nextID);
            statement.setString(2, name);
            int afectedLines = statement.executeUpdate();

            // Verify if it succeed 
            if (afectedLines > 0) {
                System.out.println("Instructor added!");
            } else {
                System.out.println("Error to add instructor");
            }

        }
    }

    public static void CourseAdd(Connection connection) throws SQLException {
        System.out.println("\nIMPORTANT:For this table you need to insert a Course Name, assign an Instructor and a Classroom.\n Please, do not assign an Instructor or Classroom that are not in your Instructor and Classroom tables.");
        String insertCourseQuery = "INSERT INTO Course (CourseID, CourseName, InstructorID, ClassroomID) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(insertCourseQuery)) {

            int nextID = nextID(connection, "Course", "CourseID");

            Scanner courseScanner = new Scanner(System.in);
            System.out.println("Please insert the Course Name:");
            String courseName = courseScanner.nextLine();

            Scanner instructorScanner = new Scanner(System.in);
            System.out.println("Please insert the Instructor ID for this course:");
            String instructorID = instructorScanner.nextLine();

            Scanner classroomScanner = new Scanner(System.in);
            System.out.println("Please insert the Classroom ID:");
            String classroomID = classroomScanner.nextLine();
            
            
            //Execute the query 
            statement.setInt(1, nextID);
            statement.setString(2, courseName);
            statement.setString(3, instructorID);
            statement.setString(4, classroomID);
            int afectedLines = statement.executeUpdate();

            // Verify if it succeed 
            if (afectedLines > 0) {
                System.out.println("Course added!");
            } else {
                System.out.println("Error to add course");
            }

            // courseScanner.close();
            // instructorScanner.close();
            // classroomScanner.close();

        }
    }

    public static void ClassroomAdd(Connection connection) throws SQLException {
        String insertClassroomQuery = "INSERT INTO Classroom (ClassroomID, ClassroomNumber) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(insertClassroomQuery)) {

            int nextID = nextID(connection, "Classroom", "ClassroomID");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Please insert the Classroom Number:");
            Integer classNumber = scanner.nextInt();
            
            //Execute the query 
            statement.setInt(1, nextID);
            statement.setInt(2, classNumber);
            int afectedLines = statement.executeUpdate();

            // Verify if it succeed 
            if (afectedLines > 0) {
                System.out.println("Classroom added!");
            } else {
                System.out.println("Error to add Classroom");
            }

        }
    }

    public static void GradesAdd(Connection connection) throws SQLException {
        System.out.println("\nIMPORTANT: For this table you need to insert the Course ID, the Student ID and assign the grade.\n Please, do not assign grades for Students and Courses that are not in your Student and Course tables.");
        String insertGradeQuery = "INSERT INTO Grades (StudentID, CourseID, GradesID, Grades) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(insertGradeQuery)) {

            int nextID = nextID(connection, "Grades", "GradesID");

            Scanner studentScanner = new Scanner(System.in);
            System.out.println("Please insert the Student ID:");
            Integer studentID = studentScanner.nextInt();

            Scanner courseScanner = new Scanner(System.in);
            System.out.println("Please insert the Course ID:");
            Integer courseID = courseScanner.nextInt();

            Scanner gradeScanner = new Scanner(System.in);
            System.out.println("Please insert the Grade (0 - 100):");
            Integer grade = gradeScanner.nextInt();
            
            
            //Execute the query 
            statement.setInt(1, studentID);
            statement.setInt(2, courseID);
            statement.setInt(3, nextID);
            statement.setInt(4, grade);
            int afectedLines = statement.executeUpdate();

            // Verify if it succeed 
            if (afectedLines > 0) {
                System.out.println("Grade assigned!");
            } else {
                System.out.println("Error to add grade");
            }
        
        // studentScanner.close();
        // courseScanner.close();
        // gradeScanner.close();

        }
    }

    public static void EnrollmentAdd(Connection connection) throws SQLException {
        System.out.println("\nIMPORTANT: For this table you need to insert the Course ID, the Student ID and Instructor ID.\n Please, do not enroll a Student to a Course or Instructor that are not in your Course and Instructor tables.");
        String insertGradeQuery = "INSERT INTO Enrollment (StudentID, CourseID, InstructorID, EnrollmentID) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(insertGradeQuery);

            int nextID = nextID(connection, "Enrollment", "EnrollmentID");

            Scanner studentScanner = new Scanner(System.in);
            System.out.println("Please insert the Student ID:");
            Integer studentID = studentScanner.nextInt();

            Scanner courseScanner = new Scanner(System.in);
            System.out.println("Please insert the Course ID:");
            Integer courseID = courseScanner.nextInt();

            Scanner instructorScanner = new Scanner(System.in);
            System.out.println("Please insert the Instructor ID:");
            Integer instructorID = instructorScanner.nextInt();
            
            
            //Execute the query 
            statement.setInt(1, studentID);
            statement.setInt(2, courseID);
            statement.setInt(3, instructorID);
            statement.setInt(4, nextID);
            int afectedLines = statement.executeUpdate();

            // Verify if it succeed 
            if (afectedLines > 0) {
                System.out.println("Enrollment added!");
            } else {
                System.out.println("Error to add enrollment.");
            }

            // studentScanner.close();
            // courseScanner.close();
            // gradeScanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int nextStudentID(Connection connection) throws SQLException {
        // Obtém o próximo valor do sequenciador para StudentID
        String sql = "SELECT MAX(StudentID) + 1 AS nextStudentID FROM Student";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        int nextStudentID = 1;

        if (resultSet.next()) {
            nextStudentID = resultSet.getInt("nextStudentID");
        }

        resultSet.close();
        preparedStatement.close();

        return nextStudentID;
    }

    private static int nextID(Connection connection, String tableName, String idColumnName) throws SQLException {
        // Obtém o próximo valor do sequenciador para o ID da tabela fornecida
        String sql = "SELECT MAX(" + idColumnName + ") + 1 AS nextID FROM " + tableName;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
    
        int nextID = 1;
    
        if (resultSet.next()) {
            nextID = resultSet.getInt("nextID");
        }
    
        resultSet.close();
        preparedStatement.close();
    
        return nextID;
    }
    

}
