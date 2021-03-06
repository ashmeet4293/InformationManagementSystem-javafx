package pckgdatabase;

import pckgmodel.Student;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StudentDBUtils {

    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Connection connection = DatabaseConnector.databaseConnector();

    ObservableList<Student> list = FXCollections.observableArrayList();  //MAking the list of student objects

    public boolean createStudent(Student student) {
        if (connection != null) {
            String query = "INSERT INTO Student (Namel, Address,sem,roll,username,password,dob,RegisteredDate) VALUES (?,?,?,?,?,?,?,?)";
            try {

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, student.getName());
                preparedStatement.setString(2, student.getAddress());
                preparedStatement.setInt(3, student.getSem());
                preparedStatement.setInt(4, student.getRoll());
                preparedStatement.setString(5, student.getUsername());
                preparedStatement.setString(6, student.getPassword());
                preparedStatement.setString(7, student.getDob());
                preparedStatement.setDate(8, student.getRegDate());

                preparedStatement.execute();
                connection.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    public ObservableList<Student> fetchData() { // Returning the list Student object after executing SQL 
        try {
            String query = "SELECT * FROM Student";
            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("namel");
                String address = resultSet.getString("address");
                Integer sem = resultSet.getInt("sem");
                Integer roll = resultSet.getInt("roll");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String dob = resultSet.getString("dob");
                Date date = resultSet.getDate("RegisteredDate");

                list.add(new Student(id, name, address, sem, roll, username, password, dob, date)); // Creaing student object and adding to the list
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void fetchById(int id) {
        try {
            if (connection != null) {
                String query = "SELECT * FROM Student Where id=?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id);

                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    System.out.println("ID : " + resultSet.getInt("id"));
                    System.out.println("NAME : " + resultSet.getString("namel"));
                    System.out.println("ADDRESS : " + resultSet.getString("address"));
                    System.out.println("Semester : " + resultSet.getInt("sem"));
                    System.out.println("Roll  : " + resultSet.getInt("roll"));

                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public boolean updateData(Student student) {
        if (connection != null) {
            String query = "UPDATE Student Set namel=?, address=?, sem=?, roll=? where id = ?";
            try {

                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, student.getName());
                preparedStatement.setString(2, student.getAddress());
                preparedStatement.setInt(3, student.getSem());
                preparedStatement.setInt(4, student.getRoll());
                preparedStatement.setInt(5, student.getId());

                preparedStatement.executeUpdate();
                connection.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean deleteById(int id) {
        try {
            if (connection != null) {
                String query = "DELETE FROM Student Where id=?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id);

                preparedStatement.executeUpdate();
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean loginAsAdmin(String username, String password) {
        try {
            String query = "SELECT Username,password FROM Student where username=? and password=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return true;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
