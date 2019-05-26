package com.diastodoallinone;

import java.sql.*;

/**
 * Created by dia on 11/04/2019.
 */
public class ToDoDAO {

    private static final String  DATABASEROUTE = "jdbc:sqlite:/Users/dia/todo.db";
    Connection connection = DriverManager.getConnection(DATABASEROUTE);

    public ToDoDAO() throws SQLException {
    }


    public void createDbColumns(){


        try {
            Statement statement = connection.createStatement();
            connection.setAutoCommit(true);
            statement.execute("CREATE TABLE IF NOT EXISTS toDoList (todoShortDescription TEXT, todoLongDescription TEXT, todoDueDate TEXT, todoOrder INTEGER, hasBeenDone boolean)");

            statement.close();
//            connection.close();

        } catch (SQLException e) {
            System.out.println("Something went wrong..." + e.getMessage());

        }
    }

    public void createToDoListItem(String toDoShortDescription, String todoLongDescription, String todoDueDate, String todoOrder, String  hasBeenDone) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.execute(String.format("INSERT INTO toDoList (todoShortDescription, todoLongDescription, todoDueDate, todoOrder, hasBeenDone) VALUES ('%s', '%s', '%s',  %s, '%s')", toDoShortDescription, todoLongDescription,todoDueDate,todoOrder, hasBeenDone));
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void getToDOItems() throws SQLException {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM toDoList");

            while(rs.next()){
                String todoShortDescription = rs.getString("todoShortDescription");
                String todoLongDescription = rs.getString("todoLongDescription");
                String todoDueDate = rs.getString("todoDueDate");
                int todoOrder = rs.getInt("todoOrder");
                boolean hasBeenDone = rs.getBoolean("hasBeenDone");
                System.out.println("todoShortDescription is: " + todoShortDescription + " todoLongDescription is: " + todoLongDescription + " todoDueDate is: " + todoDueDate + " todoOrder is: " + todoOrder + " hasBeenDone is: " + hasBeenDone);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        statement.close();

    }


}
