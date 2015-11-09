import java.sql.*;

/**
 * Created by allancaine on 2015-11-09.
 */
public class JDBCExample {

    public static void main(String[] args){

        System.out.println("Try to make connections");

        try{
            Class.forName("org.postgresql.Driver");


        }catch (ClassNotFoundException e){
            System.out.println("Could not find driver");
        }

        System.out.println("Found driver");

        Connection connection = null;

        try{
            connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/books");
        }catch (SQLException e){
            System.out.println("Failed to establish a connection");
        }

        if(connection != null){
            System.out.println("Ready to go");
        }else{
            System.out.println("Connection is null");
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM authors ORDER BY au_id");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                System.out.println(resultSet.getString("au_id") + " " + resultSet.getString("au_lname") +
                " " + resultSet.getString("au_fname"));

            }
        }catch(SQLException e){
            System.out.println("Could not process statement");
        }
    }

}
