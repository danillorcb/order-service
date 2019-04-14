package br.com.fiap.orderservice.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    @ApiModelProperty(notes = "The database generated Order ID")
    private Long idPedido;

    @ApiModelProperty(notes = "User E-mail", required = true)
    private String email;

    @ApiModelProperty(notes = "User Name")
    private String nomeCompleto;

    @ApiModelProperty(notes = "The order shipping address", required = true)
    private String shippingAddress;

    @ApiModelProperty(notes = "ItemDTO List")
    private List<ItemDTO> itens;

    @ApiModelProperty(notes = "Total amount")
    private BigDecimal precoTotalPagamento;

    @ApiModelProperty(notes = "Payment type")
    private String formaPagamento;

    @ApiModelProperty(notes = "Order date")
    private String dataPedido;

    @ApiModelProperty(notes = "Order Status")
    private String statusPedido;

    @ApiModelProperty(notes = "TransacaoDTO")
    private TransacaoDTO transacao;
}
