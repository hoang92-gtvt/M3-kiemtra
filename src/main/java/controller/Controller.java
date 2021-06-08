package controller;

import model.Category;
import model.Product;
import service.category.CategoryService;
import service.category.ICategoryService;
import service.product.IProductService;
import service.product.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Controller", value = "/product")
public class Controller extends HttpServlet {
    IProductService productService = new ProductService();
    ICategoryService catelogyService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try{


        switch (action) {
            case "create":
                showCreatProduct(request,response);
                break;
//            case "edit":
//                showUpdateProduct(request, response);
//                break;
//            case "delete" :
//                alertDeleteProduct(request, response);
//                break;
//            case "detail" :
//                showDetailProduct(request,response);
//                break;
            default:
                showAllProduct(request, response);
                break;

        }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
//    private void showDetailProduct(HttpServletRequest request, HttpServletResponse response) {
//        RequestDispatcher dispatcher;
//
//        int index = Integer.parseInt(request.getParameter("id"));
//        Product product = productService.getProductByIndex(index);
//
//        request.setAttribute("product",product);
//        request.setAttribute("index", index);
//
//        if(product== null){
//            dispatcher= request.getRequestDispatcher("error-404.jsp");
//        } else {
//            dispatcher = request.getRequestDispatcher("/products/detail.jsp");
//        }
//
//
//        try {
//            dispatcher.forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }


//    private void alertDeleteProduct(HttpServletRequest request, HttpServletResponse response) {
//
//        int index = Integer.parseInt(request.getParameter("id")) ;
////        boolean check = ((checkID)productService).checkID("123");
//
//        productService.deleteProduct(index);
//
//        showAllProduct(request,response);
//
//    }

//    private void showUpdateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher dispatcher;
//
//        int index = Integer.parseInt(request.getParameter("id"));
//
//        Product product = productService.getProductByIndex(index);
//        ArrayList<Category> categories = catalogyService.findAll();
//
//        request.setAttribute("product",product);
//        request.setAttribute("categories", categories);
//
//
//        if(product== null){
//            dispatcher= request.getRequestDispatcher("error-404.jsp");
//        } else {
//            dispatcher = request.getRequestDispatcher("/products/formEdit.jsp");
//        }
//
//        dispatcher.forward(request,response);
//

//
//    }

    private void showCreatProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ArrayList<Category> categories = catelogyService.findAll();

        RequestDispatcher dispatcher = request.getRequestDispatcher("/products/create.jsp");
        request.setAttribute("categories", categories);
        Product product =new Product();
        request.setAttribute("product", product);

        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/products/list.jsp");

        ArrayList<Product> ProductList = new ArrayList<>();

        ProductList = productService.findAll();

        request.setAttribute("dssp", ProductList);

        dispatcher.forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
//            case "create":
//                creatProduct(request,response);
//                break;
//            case "update":
//                updateProduct(request, response);
//                break;
//            case "delete" :
//                break;
//            case "detail" :
//                break;
//            default :
//                showAllProduct(request, response);
//                break;

        }

//
//        private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
//
//            int index = Integer.parseInt(request.getParameter("id"));
//            // không khai báo trong fromEdit tuy nhiên "id" đã tồn tại trên url
//
//            String name = request.getParameter("name");
//            int price = Integer.parseInt(request.getParameter("price"));
//            String description = request.getParameter("description");
//            String producer = request.getParameter("producer");
//
//            int category_id =Integer.parseInt(request.getParameter("category_id")) ;
//
//            Category category= new Category(category_id);
//
//            Product product = new Product( name, price, description, producer);
//
//            product.setCategory(category);
//
//
//
//            if(product==null){
//                RequestDispatcher dispatcher = request.getRequestDispatcher("/error-404");
//            }else{
//
//                productService.updateProduct(index, product);
//
//                showAllProduct(request,response);
//            }
//
//
//        }
//
//        private void creatProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
////        int id = Integer.parseInt(request.getParameter("id"));
//            String name = request.getParameter("name");
//            int price = Integer.parseInt(request.getParameter("price"));
//            String description = request.getParameter("description");
//            String producer = request.getParameter("producer");
//
//            Product product = new Product(name,price, description, producer);
//
//            int category_id= Integer.parseInt(request.getParameter("category_id"));
//            Category category = new Category(category_id);
//            product.setCategory(category);
//
//            productService.creatProduct(product);
//
////        showAllProduct(request,response);
//
//            response.sendRedirect("/products");
//
//        }
//    }
    }
}
