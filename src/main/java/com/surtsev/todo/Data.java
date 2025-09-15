package com.surtsev.todo;

import java.sql.*;

public class Data implements AutoCloseable {

    private Connection conn;

    public Data(String url, String db, String usr, String pwd) {
        // "jdbc:postgresql://localhost:5432/"
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url + db, usr, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addTask(Task task) {
        try {
            PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO tasks (name, description, status) VALUES (?, ?, ?)"
            );
            stmt.setString(1, task.getName());
            stmt.setString(2, task.getDescription());
            stmt.setString(3, task.getStatus().toString());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTask(String name) {
        try {
            PreparedStatement stmt = conn.prepareStatement(
                "DELETE FROM tasks WHERE name = ?"
            );
            stmt.setString(1, name);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTask(String name) {
        String sql = "UPDATE tasks SET status = ? WHERE name = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, Status.DONE.toString()); // ставим DONE
            stmt.setString(2, name);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllTasks() {
        try {
            PreparedStatement stmt = conn.prepareStatement(
                "DELETE FROM tasks WHERE status = ?"
            );
            stmt.setString(1, Status.DONE.toString());
            stmt.executeUpdate();

            System.out.println("All tasks deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getTasks() {
        try {
            PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM tasks"
            );
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Task task = new Task();
                task.setName(rs.getString("name"));
                task.setDescription(rs.getString("description"));
                String statusStr = rs.getString("status");
                task.setStatus(Status.valueOf(statusStr));
                System.out.println(task.getTask());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        conn.close();
    }
}
