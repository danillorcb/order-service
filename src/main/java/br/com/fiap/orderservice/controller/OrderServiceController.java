package br.com.fiap.orderservice.controller;

import br.com.fiap.orderservice.dto.OrderDTO;
import br.com.fiap.orderservice.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/order-service")
public class OrderServiceController {

    @Autowired
    OrderRepository repository;

    @GetMapping("/findById/{idPedido}")
    public ResponseEntity<OrderDTO> findById(
            @PathVariable(value="idPedido", required=true) Long idPedido) {

        OrderDTO order = repository.get(idPedido);
        System.out.println(order);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> post(@RequestBody OrderDTO order) {
        repository.add(order);

        String urlChamada = "http://localhost:8080/exercicio-1/order-service/findById/" + order.getIdPedido();
        return new ResponseEntity<>(urlChamada, HttpStatus.OK);
    }

    @PutMapping("/update/{idPedido}")
    public ResponseEntity<String> put(
            @PathVariable(value="idPedido", required=true) Long idPedido,
            @RequestBody OrderDTO order
    ) {
        repository.update(idPedido, order);

        String urlChamada = "http://localhost:8080/exercicio-1/order-service/findById/" + idPedido;
        return new ResponseEntity<>(urlChamada, HttpStatus.OK);
    }
}
