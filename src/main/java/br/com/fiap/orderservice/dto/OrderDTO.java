package br.com.fiap.orderservice.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    public Long idPedido;
    public String email;
    public String nomeCompleto;
    public String shippingAddress;
    public List<ItemDTO> itens;
    public String precoTotalPagamento;
    public String formaPagamento;
    public String dataPedido;
    public String statusPedido;
    public TransacaoDTO transacao;
}
