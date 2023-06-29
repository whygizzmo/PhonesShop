import models.Phone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static String URLDB = "jdbc:postgresql://localhost:5433/phones_shop";
    static String USERNAMEDB = "postgres";
    static String PASSWORDDB = "postgres";
        //order
        // id
        // email
        // phone
        // total price
        // paid
        // change
        //date
    public static void main(String[] args) {


        //Phone phone = new Phone("aa", "123wq", 123, 12, 124, 2014);
        // savePhone(phone);

        findbyId(2);


    }


    public static List<Phone> findbyId(int id) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(URLDB, USERNAMEDB, PASSWORDDB);
            String sqlQuery = "SELECT id,manufacturer ,model,memory,megapixel,price,release_date,count from phones where id =" + id;
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            List<Phone> phones = new ArrayList<>();
            while (resultSet.next()) {
                Phone phone = new Phone();
                phone.setId(resultSet.getInt("id"));
                phone.setManufacturer(resultSet.getString("manufacturer"));
                phone.setModel(resultSet.getString("model"));
                phone.setMemory(resultSet.getInt("memory"));
                phone.setMegapixel(resultSet.getInt("megapixel"));
                phone.setPrice(resultSet.getDouble("price"));
                phone.setRelease(resultSet.getInt("release_date"));
                phone.setCount(resultSet.getInt("count"));
                phones.add(phone);
            }
            phones.stream().forEach(System.out::println);
            return phones;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Phone> findAllPhones() {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(URLDB, USERNAMEDB, PASSWORDDB);
            String sqlQuery = "SELECT id,manufacturer ,model,memory,megapixel,price,release_date from phones";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            List<Phone> phones = new ArrayList<>();
            while (resultSet.next()) {
                Phone phone = new Phone();
                phone.setId(resultSet.getInt("id"));
                phone.setManufacturer(resultSet.getString("manufacturer"));
                phone.setModel(resultSet.getString("model"));
                phone.setMemory(resultSet.getInt("memory"));
                phone.setMegapixel(resultSet.getInt("megapixel"));
                phone.setPrice(resultSet.getDouble("price"));
                phone.setRelease(resultSet.getInt("release_date"));
                phone.setCount(resultSet.getInt("count"));

                phones.add(phone);
            }
            phones.stream().forEach(System.out::println);
            return phones;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void savePhone(Phone phone) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(URLDB, USERNAMEDB, PASSWORDDB);
            System.out.println("succesful connected");
            String sqlQuery = "INSERT INTO phones (manufacturer,model,memory,megapixel,price,release_date,count) VALUES (?,?,?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, phone.getManufacturer());
            preparedStatement.setString(2, phone.getModel());
            preparedStatement.setInt(3, phone.getMemory());
            preparedStatement.setInt(4, phone.getMegapixel());
            preparedStatement.setDouble(5, phone.getPrice());
            preparedStatement.setInt(6, phone.getRelease());
            preparedStatement.setInt(7,phone.getCount());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            long generatedKey = 0;
            if (generatedKeys.next()) {
                generatedKey = generatedKeys.getLong(1);
            }

            System.out.println("Успешно сохранен под Id: " + generatedKey);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }
}