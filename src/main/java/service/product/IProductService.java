package service.product;

import model.Product;
import service.IService;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IProductService extends IService<Product> {


    ArrayList<Product> findProductByName(String name) throws SQLException;
}
