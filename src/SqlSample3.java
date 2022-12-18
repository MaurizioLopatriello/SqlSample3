import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SqlSample3 {

    public static void main(String[] args) {

        ArrayList<String> Surnames = new ArrayList<>();
        String query = "Select last_name , first_name , country  from students;";

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "dev1", "dev1");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("first_name" )+" "
                        +resultSet.getString("last_name")+" "
                        +resultSet.getString("country"));
                Surnames.add(resultSet.getString("last_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Surnames);
    }
}



