package br.com.fiap.orderservice.controller;

import br.com.fiap.orderservice.dto.OrderDTO;
import br.com.fiap.orderservice.exception.EntityNotFoundException;
import br.com.fiap.orderservice.exception.ServerException;
import br.com.fiap.orderservice.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/order-service")
public class OrderServiceController {

    @Autowired
    private OrderRepository repository;

    @GetMapping("/{idPedido}")
    public ResponseEntity<OrderDTO> findById(
            @PathVariable(value="idPedido", required = true) Long idPedido) throws EntityNotFoundException {
        OrderDTO order = repository.get(idPedido);
        if (order == null) {
            String[] params = {"idPedido", idPedido.toString()};
            throw new EntityNotFoundException(OrderDTO.class, params);
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Object> post(@RequestBody OrderDTO order) {
        repository.add(order);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{idPedido}")
                .buildAndExpand(order.getIdPedido()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{idPedido}")
    public ResponseEntity<String> patch(
            @PathVariable(value="idPedido", required=true) Long idPedido,
            @RequestBody OrderDTO order
    ) throws EntityNotFoundException, ServerException {
        try {
            repository.update(idPedido, order);
        } catch (EntityNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new ServerException();
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand(idPedido).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{idPedido}")
    public ResponseEntity<?> delete(
            @PathVariable(value="idPedido", required=true) Long idPedido) {
        repository.delete(idPedido);

        return new ResponseEntity<>("Pedido excluído com sucesso!", HttpStatus.OK);
    }
}
