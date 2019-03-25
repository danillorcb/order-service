package br.com.fiap.orderservice.controller;

import br.com.fiap.orderservice.dto.OrderDTO;
import br.com.fiap.orderservice.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/order-service")
public class OrderServiceController {

    @Autowired
    OrderRepository repository;

    @GetMapping("/{idPedido}")
    public ResponseEntity<OrderDTO> findById(
            @PathVariable(value="idPedido", required=true) Long idPedido) {

        OrderDTO order = repository.get(idPedido);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Object> post(@RequestBody OrderDTO order) {
        repository.add(order);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(order.getIdPedido()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{idPedido}")
    public ResponseEntity<String> put(
            @PathVariable(value="idPedido", required=true) Long idPedido,
            @RequestBody OrderDTO order
    ) {
        repository.update(idPedido, order);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand(idPedido).toUri();
        return ResponseEntity.created(location).build();
    }
}
