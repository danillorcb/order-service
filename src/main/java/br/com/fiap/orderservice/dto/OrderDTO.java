package br.com.fiap.orderservice.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long idPedido;
    private String email;
    private String nomeCompleto;
    private String shippingAddress;
    private List<ItemDTO> itens;
    private BigDecimal precoTotalPagamento;
    private String formaPagamento;
    private String dataPedido;
    private String statusPedido;
    private TransacaoDTO transacao;
}
