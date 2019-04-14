package br.com.fiap.orderservice.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

    @ApiModelProperty(notes = "The Item ID")
    private Long idItem;

    @ApiModelProperty(notes = "Descrição do Item")
    private String descricaoItemPedido;

    @ApiModelProperty(notes = "Quantidade de itens")
    private Integer quantidadeItensPedido;

    @ApiModelProperty(notes = "Valor Unitário")
    private BigDecimal precoUnitItem;
}
