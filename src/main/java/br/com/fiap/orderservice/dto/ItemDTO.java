package br.com.fiap.orderservice.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private Long idItem;
    private String descricaoItemPedido;
    private String quantidadeItensPedido;
    private String precoUnitItem;
}
