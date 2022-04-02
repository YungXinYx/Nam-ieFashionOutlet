package controller;

import model.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.swing.JOptionPane;
import javax.transaction.UserTransaction;
import service.ProductDetailsService;

@WebServlet(name = "AddProduct", urlPatterns = {"/AddProduct"})
@MultipartConfig(maxFileSize = 16177216) //1.5MB
public class AddProduct extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;
    private String host = "jdbc:derby://localhost:1527/clothesdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private Connection conn;
    private PreparedStatement stmt;
    PrintWriter out;
    private String[] productSize = {"S", "M", "L", "XL"};

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String productName = request.getParameter("productname");
            float productPrice = Float.parseFloat(request.getParameter("productprice"));
            String categoryName = request.getParameter("category");
            Category category = findAll(categoryName);
            String productID = createProductID();

            Product product = new Product(productID);
            Part part1 = request.getPart("productimage1");
            Part part2 = request.getPart("productimage2");
            Part part3 = request.getPart("productimage3");
            
            if (part1 != null) {
                try {
                    createConnection();
                    stmt = conn.prepareStatement("INSERT INTO PRODUCT VALUES (?, ?, ?, ?, ?, ?, ?)");
                    InputStream productImage1 = part1.getInputStream();
                    InputStream productImage2 = part2.getInputStream();
                    InputStream productImage3 = part3.getInputStream();
                    stmt.setString(1, productID);
                    stmt.setString(2, productName);
                    stmt.setDouble(3, productPrice);
                    stmt.setBlob(4, productImage1);
                    stmt.setBlob(5, productImage2);
                    stmt.setBlob(6, productImage3);
                    stmt.setString(7, String.valueOf(category.getCategoryid()));
                    stmt.executeUpdate();

                } catch (Exception e) {
                    out.println(e);
                }
            }
            //Product Details
            ProductDetails[] productDetails = new ProductDetails[productSize.length];
            int[] quantity = {Integer.parseInt(request.getParameter("size-s")), Integer.parseInt(request.getParameter("size-m")),
                Integer.parseInt(request.getParameter("size-l")), Integer.parseInt(request.getParameter("size-xl"))};
            String[] productDetailsID = createProductDetailsID(productID, productSize);

            for (int i = 0; i < productSize.length; i++) {
                productDetails[i] = new ProductDetails(productDetailsID[i], productSize[i], quantity[i], product);
            }
            boolean success = false;
            ProductDetailsService productDetailsService = new ProductDetailsService(em);
            utx.begin();
            for (int i = 0; i < productDetails.length; i++) {
                success = productDetailsService.addProductDetails(productDetails[i]);
            }
            utx.commit();
            HttpSession session = request.getSession();
            session.setAttribute("success", success);
            response.sendRedirect("AddConfirm.jsp");
        } catch (Exception ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Category findAll(String categoryName) {
        List<Category> categoryList = em.createNamedQuery("Category.findAll").getResultList();
        for (int i = 0; i < categoryList.size(); i++) {
            if (categoryList.get(i).getCategoryname().equals(categoryName)) {
                return categoryList.get(i);
            }
        }
        return null;
    }

    private String createProductID() {
        List<Product> tempProductList = em.createNamedQuery("Product.findAll").getResultList();
        if (!tempProductList.isEmpty()) {
            char firstIndex = tempProductList.get(tempProductList.size() - 1).getProductid().charAt(1);
            char secondIndex = tempProductList.get(tempProductList.size() - 1).getProductid().charAt(2);
            char thirdIndex = tempProductList.get(tempProductList.size() - 1).getProductid().charAt(3);

            String tempProductID = String.valueOf(firstIndex) + String.valueOf(secondIndex) + String.valueOf(thirdIndex);
            int nextProductID = Integer.parseInt(tempProductID) + 1;
            return "P" + String.format("%03d", nextProductID);
        } else {
            return "P" + String.format("%03d", 1);
        }
    }

    private String[] createProductDetailsID(String productID, String[] productSize) {
        String[] tempProductDetailsID = new String[productSize.length];
        for (int i = 0; i < productSize.length; i++) {
            tempProductDetailsID[i] = productID + productSize[i];
        }
        return tempProductDetailsID;
    }

}
