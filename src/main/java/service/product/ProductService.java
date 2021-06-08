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
            preparedStatement.setString(3,product.getDescription());
//            preparedStatement.setString(4,product.getProducer());
            preparedStatement.setInt(5,product.getCategory().getId());

            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void edit(int index, Product product) {
//        String update = "update Product set name=?, price=?, description=?, producer=?, category_id=? where id=?  ";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(update);
//            preparedStatement.setInt(6,index);
//            preparedStatement.setString(1, product.getName());
//            preparedStatement.setInt(2, product.getPrice());
//            preparedStatement.setString(3, product.getDescription());
//            preparedStatement.setString(4, product.getProducer());
//            preparedStatement.setInt(5, product.getCategory().getId());
//
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
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
//
//        String query = "select * from Product where id=?";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1,id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while(resultSet.next()) {
//
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                int price = resultSet.getInt("price");
//                String description = resultSet.getString("description");
//                String producer = resultSet.getString("producer");
//
////                product = new Product(id, name, price, description, producer);
//            }
//
//        }
//        catch(SQLException e){
//            e.printStackTrace();
//        }
//
        return product;
    }
}

