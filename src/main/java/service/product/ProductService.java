package service.product;

import connection.ConnectionJDBC;
import model.Category;
import model.Product;

import java.sql.*;
import java.util.ArrayList;

public class ProductService implements IProductService {

    public static final String CALL_GET_ALL_PRODUCT = "call getAllProduct()";
    public static final String Insert_BOOK = "insert into products(name, price, quanlity, color, description, category_id) value (?,?,?,?,?,?);";
    Connection connection = ConnectionJDBC.getConnect();

    @Override
    public ArrayList<Product> findAll() throws SQLException {

        ArrayList<Product> productList = new ArrayList<>();

        CallableStatement statement = connection.prepareCall(CALL_GET_ALL_PRODUCT);

        ResultSet result = statement.executeQuery();

        while (result.next()) {

            int id = result.getInt(1);
            String name = result.getString(2);
            float price = result.getFloat(3);
            int quanlity = result.getInt(4);
            String color = result.getString(5);
            int category_id = result.getInt(6);
            String category_name= result.getString(7);

            String description = "";

            Category category = new Category (category_id, category_name);

            Product product = new Product(id, name, quanlity,price, color,description, category );

            productList.add(product);

        }
        return productList;
    }

    @Override
    public void create(Product product) {
        String newProduct = Insert_BOOK;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(newProduct);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setFloat(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuanlity());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getDescription());
//            preparedStatement.setString(4,product.getProducer());
            preparedStatement.setInt(6,product.getCategory().getId());

            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void edit(int index, Product product) {
        String update = "update Products set name=?,  price=?, quanlity=?,color=?, description=? category_id=? where id=?  ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setInt(7,index);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuanlity());

            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());

            preparedStatement.setInt(6, product.getCategory().getId());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void delete(int index) {
//
//        String delete = "delete from Product where id=? ";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(delete);
//            preparedStatement.setInt(1,index);
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//
    }

    @Override
    public Product getObjectById(int id) {
        Product product = null;

        String query = "select * from Products where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {


                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                int quanlity =resultSet.getInt("quanlity");

                String color = resultSet.getString("color");
                String description = resultSet.getString("description");

                product = new Product(id, name, quanlity, price, color, description);
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return product;
    }
}

