package com.cctbmanagement.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException; 

public class Report {

    public static void ReadReport(Connection connection) throws SQLException {
        
        // Update the report first
        UpdateReport(connection);

        // SQL query
        String selectReportQuery = "SELECT * FROM Report ORDER BY Report.StudentID";

        try {
            PreparedStatement statement = connection.prepareStatement(selectReportQuery);
            ResultSet resultSet = statement.executeQuery();

            // Get metadata to retrieve column names
            ResultSetMetaData metaData = resultSet.getMetaData();

            // Add line jump
            System.out.println("\n");

            // Print header
            System.out.printf("%-15s%-20s%-45s%-20s%-15s%n", 
                metaData.getColumnName(1), 
                metaData.getColumnName(2), 
                metaData.getColumnName(3), 
                metaData.getColumnName(4), 
                metaData.getColumnName(5));
            System.out.println();

            // Print rows
            while (resultSet.next()) {
                System.out.printf("%-15s%-20s%-45s%-20s%-15s%n",
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5));
                System.out.println();
            }

            // Add line jump
            System.out.println("\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void UpdateReport(Connection connection) throws SQLException {
        String insertCourseQuery = "INSERT INTO Report (StudentID, StudentName, CourseName, InstructorName, Grades)\r\n" + //
                        "SELECT Student.StudentID, Student.StudentName, Course.CourseName, Instructor.InstructorName, Grades.Grades\r\n" + //
                        "FROM Grades\r\n" + //
                        "INNER JOIN Student ON Grades.StudentID = Student.StudentID\r\n" + //
                        "INNER JOIN Course ON Grades.CourseID = Course.CourseID\r\n" + //
                        "INNER JOIN Instructor ON Course.InstructorID = Instructor.InstructorID\r\n" + //
                        "WHERE NOT EXISTS (\r\n" + //
                        "    SELECT 1\r\n" + //
                        "    FROM Report\r\n" + //
                        "    WHERE Report.StudentID = Grades.StudentID AND Report.CourseName = Course.CourseName\r\n" + //
                        ");";

        try {
            PreparedStatement statement = connection.prepareStatement(insertCourseQuery);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
