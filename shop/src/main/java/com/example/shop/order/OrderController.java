package com.example.shop.order;

import com.example.shop.order.dto.OrderCreateRequest;
import com.example.shop.order.service.OrderServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
@Tag(name="주문 관리",description="주문 CRUD Api")
public class OrderController {

    private final OrderServiceImpl orderService;

    @PostMapping
    @Operation(summary="주문 생성",description ="새로운 주문을 등록합니다.")
    @ApiResponse(responseCode = "400", description = "잘못된 주문 (유효성 검사 실패 또는 중복된 주문 이름)")
    public ResponseEntity<Void> createOrder(@RequestBody @Valid OrderCreateRequest request){
        Long orderId= orderService.createOrder(request);
        return ResponseEntity.created(URI.create("/orders/"+orderId)).build();
    }

    @GetMapping
    @Operation(summary="모든 주문 조회",description ="모든 주문을 조회합니다.")
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orders=orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{orderId}")
    @Operation(summary="주문 조회",description ="특정 주문을 조회합니다.")
    @ApiResponse(responseCode = "404", description = "찾을 수 없음 (존재하지 않는 주문 조회 시도시)")
    public ResponseEntity<Order> getOrder(@PathVariable Long orderId){
        Order order = orderService.getOrderById(orderId);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping("/{orderId}")
    @Operation(summary="주문 삭제",description ="특정 주문을 삭제합니다.")
    @ApiResponse(responseCode = "404", description = "찾을 수 없음 (존재하지 않는 주문 삭제 시도시)")
    public ResponseEntity<Order> deleteOrder(@PathVariable Long orderId){
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }


}
