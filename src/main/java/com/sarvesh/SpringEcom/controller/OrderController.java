package com.sarvesh.SpringEcom.controller;

import com.sarvesh.SpringEcom.model.Order;
import com.sarvesh.SpringEcom.model.dto.OrderRequest;
import com.sarvesh.SpringEcom.model.dto.OrderResponse;
import com.sarvesh.SpringEcom.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class OrderController {

    @Autowired
    public OrderService orderService;

    @PostMapping("orders/place")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest){
        OrderResponse placedOrder = orderService.placeOrder(orderRequest);
        return  new ResponseEntity<>(placedOrder, HttpStatus.CREATED;
    }

    public ResponseEntity<List<OrderResponse>> getAllOrders(){
        List<OrderResponse> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
