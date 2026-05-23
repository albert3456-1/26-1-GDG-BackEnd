package com.example.shop.product;

import com.example.shop.product.dto.ProductCreateRequest;
import com.example.shop.product.dto.ProductUpdateRequest;
import com.example.shop.product.service.ProductServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
@Tag(name="상품 관리",description="상품 CRUD Api")

public class ProductController {

    private final ProductServiceImpl productService;

    @PostMapping
    @Operation(summary="상품 생성",description ="새로운 상품을 등록합니다.")
    @ApiResponse(responseCode = "400", description = "잘못된 요청 (유효성 검사 실패 또는 중복된 상품 이름)")
    public ResponseEntity<Void> createProduct(@RequestBody @Valid ProductCreateRequest request){
        Long productId= productService.createProduct(request);
        return ResponseEntity.created(URI.create("/product/"+productId)).build();
    }

    @GetMapping
    @Operation(summary="모든 상품 조회",description ="모든 상품을 조회합니다.")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products=productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{productId}")
    @Operation(summary="상품 조회",description ="특정 상품을 조회합니다.")
    @ApiResponse(responseCode = "404", description = "찾을 수 없음 (존재하지 않는 상품 조회 시도시)")
    public ResponseEntity<Product> getProduct(@PathVariable Long productId){
        Product product = productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }

    @PatchMapping("/{productId}")
    @Operation(summary="상품 정보 수정",description ="특정 상품 정보를 수정합니다.")
    @ApiResponses(value={
            @ApiResponse(responseCode = "400", description = "잘못된 요청 (유효성 검사 실패)"),
            @ApiResponse(responseCode = "404", description = "찾을 수 없음 (존재하지 않는 상품 조회 시도시)")
    })
    public ResponseEntity<Void> updateProduct(
            @PathVariable Long productId,
            @RequestBody @Valid ProductUpdateRequest request){
        productService.updateProduct(productId,request);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{productId}")
    @Operation(summary="상품 삭제",description ="특정 상품을 삭제합니다.")
    @ApiResponse(responseCode = "404", description = "찾을 수 없음 (존재하지 않는 상품 삭제 시도시)")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}
