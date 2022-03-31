package service;

import model.ProductDetails;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.*;

public class ProductDetailsService {

    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;

    public ProductDetailsService(EntityManager mgr) {
        this.mgr = mgr;
    }

    public boolean addProductDetails(ProductDetails productDetails) {
        mgr.persist(productDetails);
        return true;
    }

    public ProductDetails findProductDetailsByCode(String code) {
        ProductDetails productDetails = mgr.find(ProductDetails.class, code);
        return productDetails;
    }

    public boolean deleteProductDetails(String code) {
        ProductDetails productDetails = findProductDetailsByCode(code);
        if (productDetails != null) {
            mgr.remove(productDetails);
            return true;
        }
        return false;
    }

    public List<ProductDetails> findAll() {
        List productDetailsList = mgr.createNamedQuery("ProductDetails.findAll").getResultList();
        return productDetailsList;
    }

    public boolean updateProductDetails(ProductDetails productDetails) {
        ProductDetails tempProductDetails = findProductDetailsByCode(productDetails.getProductdetailsid());
        if (tempProductDetails != null) {
            tempProductDetails.setProductsize(productDetails.getProductsize());
            tempProductDetails.setQuantity(productDetails.getQuantity());
            tempProductDetails.setProductid(productDetails.getProductid());
            return true;
        }
        return false;
    }
}
