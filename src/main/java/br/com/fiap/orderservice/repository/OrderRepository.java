package br.com.fiap.orderservice.repository;

import br.com.fiap.orderservice.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderRepository {

    private static final Map<Long, Order> orders = new HashMap<>();
    static {
        orders.put(1l, new Order(
                 1l
                ,"email@teste.com"
                ,"Nome do Comprador Número 1"
                ,"Av. Lins de Vasconcelos, 1222"
                ,"Notebook"
                ,"2"
                ,"2000"
                ,"4000"
                ,"A Vista"
                ,"23/03/2019"
                ,"Aprovado"
                ,"1"
                ,"1234-1234-1234-1234"
                ,"12/2020"
                ,"VISA"
        ));
    }

    public Order get(Long idPedido) {
        return orders.get(idPedido);
    }

    public void add(Order order) {
        orders.put(order.getIdPedido(), order);
    }
}
