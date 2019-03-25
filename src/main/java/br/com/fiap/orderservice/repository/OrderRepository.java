package br.com.fiap.orderservice.repository;

import br.com.fiap.orderservice.dto.ItemDTO;
import br.com.fiap.orderservice.dto.OrderDTO;
import br.com.fiap.orderservice.dto.TransacaoDTO;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderRepository {

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
                                        1l,
                                        "Notebook",
                                        "2",
                                        "2000"
                                ),
                                new ItemDTO(
                                        2l,
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
        OrderDTO orderUpdated = orders.get(idPedido);

        //Campos da Order
        if (order.getShippingAddress() != null)
            orderUpdated.setShippingAddress(order.getShippingAddress());

        if (order.getPrecoTotalPagamento() != null)
            orderUpdated.setPrecoTotalPagamento(order.getPrecoTotalPagamento());

        if (order.getFormaPagamento() != null)
            orderUpdated.setFormaPagamento(order.getFormaPagamento());

        if (order.getShippingAddress() != null)
            orderUpdated.setDataPedido(order.getDataPedido());

        //Itens
        order.getItens().forEach( item -> {
            this.itemValidatorAndSetter(orderUpdated, item);
        });

        //Campos da Transação
        if (order.getTransacao().getIdTransacao() != null)
            orderUpdated.getTransacao().setIdTransacao(order.getTransacao().getIdTransacao());

        if (order.getTransacao().getNumeroCartao() != null)
            orderUpdated.getTransacao().setNumeroCartao(order.getTransacao().getNumeroCartao());

        if (order.getTransacao().getValidadeCartao() != null)
            orderUpdated.getTransacao().setValidadeCartao(order.getTransacao().getValidadeCartao());

        if (order.getTransacao().getBandeira() != null)
            orderUpdated.getTransacao().setBandeira(order.getTransacao().getBandeira());
    }

    private void itemValidatorAndSetter(OrderDTO orderUpdated, ItemDTO item){
        orderUpdated.getItens().forEach(itemUpdated -> {

            if (itemUpdated.getIdItem().equals(item.getIdItem())) {

                if (item.getDescricaoItemPedido() != null)
                    itemUpdated.setDescricaoItemPedido(item.getDescricaoItemPedido());

                if (item.getPrecoUnitItem() != null)
                    itemUpdated.setPrecoUnitItem(item.getPrecoUnitItem());

                if (item.getQuantidadeItensPedido() != null)
                    itemUpdated.setQuantidadeItensPedido(item.getQuantidadeItensPedido());
            }

        });
    }

    public OrderDTO delete(Long idPedido) {
        return orders.remove(idPedido);
    }
}
