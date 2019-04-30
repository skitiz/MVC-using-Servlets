package model;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Model {
    public Connection connectDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sales", "root",
                "G0oner4life!"
        );
    }
    public boolean authenticate(String username, String password) throws ClassNotFoundException, SQLException {
        Connection connection = connectDB();
        String uname, pwd;
        PreparedStatement preparedStatement =
                connection.prepareStatement(
                        "select * from users where username = ?"
                );
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet!= null) {
            resultSet.next();
            uname = resultSet.getString("username");
            pwd = resultSet.getString("pwd");
        return true;
        }
        return false;
    }

    public Map<String, Integer> getResults(String username) throws ClassNotFoundException, SQLException {
        Map<String, Integer> values = new HashMap<>();
        Connection connection = connectDB();
        PreparedStatement pst = connection.prepareStatement("select * from items");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            values.put(rs.getString("item"), rs.getInt("qty"));
        }
        connection.close();
        return values;
    }

    public Map<String, Integer> updateDB(String item, int qty) throws SQLException, ClassNotFoundException {
        Map<String, Integer> values = new HashMap<>();
        Connection connection = connectDB();
        Statement statement = connection.createStatement();
        statement.execute("SET SQL_SAFE_UPDATES = 0");
        PreparedStatement pst = connection.prepareStatement("UPDATE items SET qty = ? WHERE item = ?");
        pst.setInt(1, qty);
        pst.setString(2, item);
        pst.executeUpdate();
        pst = connection.prepareStatement("select * from items");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            values.put(rs.getString("item"), rs.getInt("qty"));
        }
        connection.close();
        return values;
    }

    public void createUser(String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales", "root",
                "G0oner4life!");
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ITEMS VALUES (?, ?)");
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        preparedStatement.executeUpdate();
        connection.close();
    }
}
