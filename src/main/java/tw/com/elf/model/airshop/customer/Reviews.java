package tw.com.elf.model.airshop.customer;

import lombok.Data;

@Data
public class Reviews {
    
    private Integer reviewId;

    private Integer productId;
    
    private Integer userId;

    private Integer rating;

    private String comment;

    private String createdAt;

    private String name;

}