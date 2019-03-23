package br.com.fiap.orderservice;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    public Long idPedido;
    public String email;
    public String nomeCompleto;
    public String shippingAddress;
    public String descricaoItemPedido;
    public String quantidadeItensPedido;
    public String precoUnitItem;
    public String precoTotalPagamento;
    public String formaPagamento;
    public String dataPedido;
    public String statusPedido;

    public String idTransacao;
    public String numeroCartao;
    public String validadeCartao;
    public String bandeira;
}
