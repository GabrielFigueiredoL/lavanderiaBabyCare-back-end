package com.gabrielfigueiredol.lavanderiababycare.infra;

import com.gabrielfigueiredol.lavanderiababycare.exceptions.OrderNotFoundException;
import com.gabrielfigueiredol.lavanderiababycare.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<String> productNotFoundHandler(ProductNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
    }

    @ExceptionHandler(OrderNotFoundException.class)
    private ResponseEntity<String> orderNotFoundHandler(OrderNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado");
    }
}
