package br.com.fiap.orderservice.repository;

import br.com.fiap.orderservice.dto.ItemDTO;
import br.com.fiap.orderservice.dto.OrderDTO;
import br.com.fiap.orderservice.dto.TransacaoDTO;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderRepository {

    private OrderDTO orderUpdated;

    private static Map<Long, OrderDTO> orders = new HashMap<>();
    static {
        orders.put(1l, new OrderDTO(
                1l,
                "email@teste.com",
                "Nome do Comprador Número 1",
                "Av. Lins de Vasconcelos 1222",
                 new ArrayList<ItemDTO> (
                        Arrays.asList(
                                new ItemDTO(
                                        "Notebook",
                                        "2",
                                        "2000"
                                ),
                                new ItemDTO(
                                        "Smartphone",
                                        "1",
                                        "1000"
                                )
                        )
                 ),
                "5000",
                "A Vista",
                "23/03/2019",
                "Aprovado",
                 new TransacaoDTO(
                        1l,
                        "1234-1234-1234-1234",
                        "12/2020",
                        "VISA"
                 )
        ));
    }

    public OrderDTO get(Long idPedido) {
        return orders.get(idPedido);
    }

    public void add(OrderDTO order) {
        orders.put(order.getIdPedido(), order);
    }
    
    public void update(Long idPedido, OrderDTO order) {
        orderUpdated = orders.get(idPedido);

        if (!order.getShippingAddress().isEmpty())
            orderUpdated.setShippingAddress(order.getShippingAddress());

        order.getItens().forEach( item -> {
           this.validatorAndSetter(item);
        });
    }

    private void validatorAndSetter(ItemDTO item){
        if (!item.descricaoItemPedido.isEmpty())
            orderUpdated.getItens();
    }
}
