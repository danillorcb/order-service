package br.com.fiap.orderservice.controller;

import br.com.fiap.orderservice.Order;
import br.com.fiap.orderservice.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderServiceController {

    @Autowired
    OrderRepository repository;

    @GetMapping("/exercicio-1/findById/{idPedido}")
    public ResponseEntity<Order> findById(
            @PathVariable(value="idPedido", required=true) Long idPedido) {

        Order order = repository.get(idPedido);
        System.out.println(order);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
