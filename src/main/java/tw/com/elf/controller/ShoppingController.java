package tw.com.elf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getProductsByCategoryId(@RequestBody ShopRequest shopRequest) {
    	
        return ResponseEntity.ok(shopService.getProducts(shopRequest));
    }
    
}
