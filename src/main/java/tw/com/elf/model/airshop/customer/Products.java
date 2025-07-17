package tw.com.elf.model.airshop.customer;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class Products {
    
    private Integer productId;
    
    private String name;
    
    private String description;
    
    private BigDecimal price;
    
    private BigDecimal discountPrice;

    private BigDecimal ratingAvg;

    private Integer reviewCount;

    private Integer stockQuantity;

    private Integer categoryId;
    
    private Integer brandId;

    private Date createdAt;
    
    private Date updatedAt;
    
    private String categoryName;
    
    private String imageUrl;

    
}