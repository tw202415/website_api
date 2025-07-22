package tw.com.elf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.elf.dao.ShopRequest;
import tw.com.elf.service.ShopService;

@RestController
@RequestMapping("/api/shop")
public class ShoppingController {

    @Autowired
    private ShopService shopService;

    /**
     * 查詢 
     * @param shopRequest
     * @return
     */
    @PostMapping("/products")
    public ResponseEntity<?> getProducts(@RequestBody ShopRequest shopRequest) {
        return ResponseEntity.ok(shopService.getProducts(shopRequest));
    }
    
    /**
     * 查詢商品細項 
     * @param shopRequest
     * @return
     */
    @GetMapping("/detail/{productId}")
    public ResponseEntity<?> getProductDetail(@PathVariable String productId) {
        return ResponseEntity.ok(shopService.getDetail(productId));
    }
    
    /**
     * 查詢商品評論
     * @param shopRequest
     * @return
     */
    @GetMapping("/reviews/{productId}")
    public ResponseEntity<?> getProductReviews(@PathVariable String productId) {
        return ResponseEntity.ok(shopService.getReviews(productId));
    }
    
}
