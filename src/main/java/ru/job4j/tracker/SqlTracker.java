package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store{


    private Connection connection;

    public SqlTracker(){
        init();
    }

    public SqlTracker(Connection connection){

        this.connection = connection;

    }




    private boolean ifExists (Item item ) throws SQLException {

        boolean result = false;

        Statement statement = connection.createStatement();
        try(ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM items WHERE id = %d", item.getId()))){

            while ( resultSet.next()){
                if (resultSet.getInt("id") == item.getId()){
                    result = true;
                }
            }

        }

        return result;
    }


    private void init(){

        try(InputStream input = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")){

            Properties config = new Properties();
            config.load(input);
            Class.forName(config.getProperty("driver-class-name"));

            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );

        }catch (Exception e ){
            e.printStackTrace();
        }

    }


    @Override
    public Item add(Item item) {


        try {
            if (ifExists(item)){
                throw new IllegalArgumentException("Item already exists");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO items (id, name, created) VALUES (?,?,?)")){
            statement.setInt(1, item.getId());
            statement.setString(2, item.getName());
            statement.setTimestamp(3, Timestamp.valueOf(item.getCreated()));
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }


        return item;
    }

    @Override
    public boolean replace(int id, Item item) {


        try {
            if (ifExists(item)){
                throw new IllegalArgumentException("Нет такого объекта");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try( PreparedStatement statement = connection.prepareStatement("UPDATE items SET id = ? where id = ? ")){
            statement.setInt(1, id);
            statement.setInt(2, item.getId());
         return statement.executeUpdate() > 0;
        }catch (Exception e ){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void delete(int id) {

        try( PreparedStatement statement = connection.prepareStatement("DELETE IF EXISTS FROM items WHERE id = ?")){
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> findAll() {

        List<Item> result = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM items")){
            try (ResultSet resultSet = statement.executeQuery()){

                while (resultSet.next()){

                    result.add(new Item(resultSet.getInt("id"), resultSet.getString("name")));

                }
            }

        }catch (Exception e ){
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<Item> findByName(String key) {

        List<Item> result = new ArrayList<>();

        try ( PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE name = ?")){
            statement.setString(1,key);
            try (ResultSet resultSet = statement.executeQuery()){
                    while (resultSet.next()){

                        result.add(new Item(resultSet.getInt("id"), resultSet.getString("name")));

                    }

            }
        }catch (Exception e ){
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Item findById(int id) {

        try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE id = ?")){
            statement.setInt(1, id);
            try(ResultSet resultSet = statement.executeQuery()){

                return new Item(resultSet.getInt("id"), resultSet.getString("name") );

            }
        }catch ( Exception e ){
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
