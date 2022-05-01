package Database;

import model.Admin;

import java.sql.*;


public class DatabaseHandler extends Configs{
    private static Connection dbConnection;

    public static void connect() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?useSSL=false";
            Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
    }

    public static Connection getDbConnection() {

        return dbConnection;
    }

    // Write
    public void signUpUser(String firstName, String lastName, String userName, String password, String email, String tel) {
        String insert = "INSERT INTO" + Const.USERS_TABLE + "(" + Const.USERS_FIRSTNAME
                + "," + Const.USERS_LASTNAME + "," + Const.USERS_USERNAME + "," + Const.USERS_PASSWORD
                + "," + Const.USERS_EMAIL + "," + Const.USERS_PHONENUMBER + ")" + "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(1, lastName);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(1, password);
            preparedStatement.setString(1, email);
            preparedStatement.setString(1, tel);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Read
    //Read Admin From The Database for login window
    public static ResultSet getAdmin(Admin admin) {
        ResultSet resultSet = null;

        if (!admin.getUsername().equals("") && !admin.getPassword().equals("")) {
            String query = "SELECT * FROM " + Const.ADMINS_TABLE + " WHERE "
                    + Const.ADMINS_USERNAME + "=?" + " AND "
                    + Const.ADMINS_PASSWORD + "=?";

            try {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
                preparedStatement.setString(1, admin.getUsername());
                preparedStatement.setString(2, admin.getPassword());

                resultSet = preparedStatement.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("(parent, \"Please fill your correct Username and Password\")");
        }
        return resultSet;
    }

    // Update


    // Delete
}
