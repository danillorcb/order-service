package br.com.fiap.orderservice.controller;

import br.com.fiap.orderservice.dto.OrderDTO;
import br.com.fiap.orderservice.exception.EntityNotFoundException;
import br.com.fiap.orderservice.exception.ServerException;
import br.com.fiap.orderservice.repository.OrderRepository;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springfox.documentation.spring.web.json.Json;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/order-service")
@Api(value = "Order", description = "Order Service REST API")
public class OrderServiceController {

    @Autowired
    private OrderRepository repository;

    @ApiOperation(httpMethod = "GET", value = "Método get para buscar pedido filtrando por id")
    @ApiResponses(value = {
        @ApiResponse(
                code = 200,
                message = "Retorna um OrderDTO com uma mensagem de sucesso",
                response = OrderDTO.class)
    })
    @GetMapping("/{idPedido}")
    public ResponseEntity<OrderDTO> findById(
            @ApiParam(value = "Order Id", required = true)
            @PathVariable(value="idPedido", required = true) Long idPedido) throws EntityNotFoundException {
        OrderDTO order = repository.get(idPedido);
        if (order == null) {
            String[] params = {"idPedido", idPedido.toString()};
            throw new EntityNotFoundException(OrderDTO.class, params);
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @ApiOperation(httpMethod = "POST", value = "Método post para inserir um pedido")
    @ApiResponses(value = {
            @ApiResponse(
                    code = 201,
                    message = "Retorna a URL do OrderDTO criado",
                    response = Object.class)
    })
    @PostMapping("/")
    public ResponseEntity<Object> post(
            @ApiParam(format = "Json", name = "OrderDTO")
            @RequestBody OrderDTO order) {
        repository.add(order);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{idPedido}")
                .buildAndExpand(order.getIdPedido()).toUri();
        return ResponseEntity.created(location).build();
    }

    @ApiOperation(httpMethod = "PATCH", value = "Método patch para atualizar um pedido")
    @ApiResponses(value = {
            @ApiResponse(
                    code = 201,
                    message = "Retorna a URL do OrderDTO alterado",
                    response = String.class)
    })
    @PatchMapping("/{idPedido}")
    public ResponseEntity<String> patch(
            @ApiParam(value = "Order Id", required = true)
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

    @ApiOperation(httpMethod = "DELETE", value = "Método delete para excluir um pedido")
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Retorna uma string confirmando a exclusão",
                    response = String.class)
    })
    @DeleteMapping("/{idPedido}")
    public ResponseEntity<?> delete(
            @ApiParam(value = "Order Id", required = true)
            @PathVariable(value="idPedido", required=true) Long idPedido) {
        repository.delete(idPedido);

        return new ResponseEntity<>("Pedido excluído com sucesso!", HttpStatus.OK);
    }
}
