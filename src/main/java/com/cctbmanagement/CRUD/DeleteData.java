package com.cctbmanagement.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteData {

    public static void StudentDelete(Connection connection) throws SQLException {
     String deleteStudentQuery = "DELETE FROM Student WHERE StudentID = ?";

     try (PreparedStatement statement = connection.prepareStatement(deleteStudentQuery)) {

         // Solicita ao usuário as informações do estudante
         Scanner scanner = new Scanner(System.in);
         System.out.println("Please insert the Student ID to be deleted:");
         Integer deleteStudentID = scanner.nextInt();
         scanner.close();
         
         //Executa o query para deletar estudante na tabela
         statement.setInt(1, deleteStudentID);
         int afectedLines = statement.executeUpdate();

         // Verifica se a inserção foi bem-sucedida
         if (afectedLines > 0) {
             System.out.println("Student deleted!");
         } else {
             System.out.println("Student ID not found.");
         }

     }catch (Exception e) {
        // TO DO: handle exception
        System.out.println("Sorry, you tried to delete a record from the Student table but there are dependent records in the database that reference this StudentID.\n This ensures that you don't violate the foreign key constraint.");
    }
    }
    
    public static void InstructorDelete(Connection connection) throws SQLException {
        String deleteInstructorQuery = "DELETE FROM Instructor WHERE InstructorID = ?";

        try (PreparedStatement statement = connection.prepareStatement(deleteInstructorQuery)) {
            // Solicita ao usuário as informações do instrutor
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please insert the Instructor ID to be deleted:");
            Integer deleteInstructorID = scanner.nextInt();
            scanner.close();
            
            //Executa o query para deletar estudante na tabela
            statement.setInt(1, deleteInstructorID);
            int afectedLines = statement.executeUpdate();

            // Verifica se a inserção foi bem-sucedida
            if (afectedLines > 0) {
                System.out.println("Instructor deleted!");
            } else {
                System.out.println("Instructor ID not found.");
            }
        } catch (Exception e) {
            // TO DO: handle exception
            System.out.println("Sorry, you tried to delete a record from the Instructor table but there are dependent records in the database that reference this InstructorID.\n This ensures that you don't violate the foreign key constraint.");
        }
    }

    public static void IDDelete(Connection connection, String tableName, String idColumnName) throws SQLException {
    
        // Not the ideal fix! This is vulnerable to SQL Injection.
        String deleteCourseQuery = "DELETE FROM " + tableName + " WHERE " + idColumnName + " = ?";

        try (PreparedStatement statement = connection.prepareStatement(deleteCourseQuery)) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please insert the " + tableName + " ID to be deleted:");
            Integer deleteID = scanner.nextInt();
            
            //Executa o query para deletar estudante na tabela
            statement.setInt(1, deleteID);
            int afectedLines = statement.executeUpdate();

            // Verifica se a inserção foi bem-sucedida
            if (afectedLines > 0) {
                System.out.println("Data deleted!");
            } else {
                System.out.println("ID not found.");
            }
        } catch (Exception e) {
            // TO DO: handle exception
            System.out.println("Sorry, you tried to delete a record from the " + tableName +  " table but there are dependent records in the database that reference this colunm.\n This ensures that you don't violate the foreign key constraint.");
      
        }
    }

    // public static void ClassroomDelete(Connection connection) throws SQLException {
    // }

    // public static void GradesDelete(Connection connection) throws SQLException {
    // }

    // public static void EnrollmentDelete(Connection connection) throws SQLException {
    // }

}
