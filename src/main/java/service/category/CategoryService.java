package service.category;

import connection.ConnectionJDBC;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryService implements ICategoryService{
    Connection connection = ConnectionJDBC.getConnect();
    @Override
    public ArrayList<Category> findAll() {
        ArrayList<Category> categories = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * from category;");
            ResultSet set = statement.executeQuery();
            while (set.next()){
                int id = set.getInt("id");
                String name = set.getString("name");
                Category category = new Category(id, name);
                categories.add(category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categories;
    }


    @Override
    public void create(Category newE) {

    }

    @Override
    public void edit(int index, Category newE) {

    }

    @Override
    public void delete(int index) {

    }

    @Override
    public Category getObjectById(int id) {
        return null;
    }
}
