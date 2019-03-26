package br.com.fiap.orderservice.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private Long idItem;
    private String descricaoItemPedido;
    private Integer quantidadeItensPedido;
    private BigDecimal precoUnitItem;
}
